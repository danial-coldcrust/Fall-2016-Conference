package com.ppp.grade.subject.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.graduation.persistence.GraduationDAO;
import com.ppp.grade.graduation.persistence.GraduationVO;
import com.ppp.grade.history.persistence.HistoryDAO;
import com.ppp.grade.history.persistence.HistoryVO;
import com.ppp.grade.minortable.persistence.MinortableDAO;
import com.ppp.grade.minortable.persistence.MinortableVO;
import com.ppp.grade.select.persistence.SelectDAO;
import com.ppp.grade.select.persistence.SelectVO;
import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;
import com.ppp.grade.user.controller.LoginController;

public class SubjectModiController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		ModelAndView mav = new ModelAndView();

		HistoryVO history = new HistoryVO();
		history.set학번(LoginController.getStu_아이디());

		HistoryDAO historyDAO = new HistoryDAO();
		historyDAO.deleteHistory(history);

		

		String[] str = request.getParameterValues("subject[]");
		HashSet<String> hs1 = new HashSet<String>(); 
		for(String i : str){
			hs1.add(i);
		}
		for (String obj : hs1) {
			System.out.println("modi   " + obj);
		}
		
		List<String> str1 = new ArrayList<String>(hs1);
		String[] selected = str1.toArray(new String[str1.size()]);
		SubjectVO subject = new SubjectVO();
		SubjectDAO subjectDAO = new SubjectDAO();
		List<SubjectVO> selectedList = subjectDAO.getSubjectWithSubjectNum(selected);
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(subject);

		SelectVO vo = new SelectVO();
		SelectDAO selectDAO = new SelectDAO();

		/* subject number and student number inserting */
		for (int i = 0; i < selected.length; i++) {

			vo.set과목코드(selected[i]);
			vo.set학번(LoginController.getStu_아이디());
			selectDAO.insertSelect(vo);
		}
		// 전공 변수
		int majorSum = 0;
		// 학과기초 변수
		int majorbaseSum = 0;
		// 일반교양 변수
		int generalSum1 = 0;
		// 필수교양 변수
		int generalSum2 = 0;
		// 부전공용 계산 변수
		int minorSum = 0;
		// 2. GRADUATION 정보가져오기(학과코드로)
				String MinorNum = LoginController.getStu_복수전공();
				String MajorNum = LoginController.getStu_전공();
				
		for (SubjectVO obj : selectedList) {
			if (obj.get구분().equals("학과기초") && obj.get학과코드().equals(LoginController.getStu_전공())) {
				majorbaseSum += Integer.parseInt(obj.get학점());
			} else if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_전공())) {
				majorSum += Integer.parseInt(obj.get학점());
			} else if (obj.get구분().equals("일반교양") && obj.get과목코드().equals("99")) {
				generalSum1 += Integer.parseInt(obj.get학점());
			} else if (obj.get구분().equals("필수교양") && obj.get과목코드().equals("99")) {
				generalSum2 += Integer.parseInt(obj.get학점());
			} else if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_복수전공())) {
				minorSum += Integer.parseInt(obj.get학점());
			} else
				continue;// 복전전공 + 학과기초는 ?? 왜 설계안함 ?
		}
		
		// 복수전공이 없으면 즉, 전공만 듣는 학생 계산
		if (MinorNum == null && MajorNum != null) {
			GraduationDAO graduationDAO = new GraduationDAO();
			GraduationVO graduation = new GraduationVO();
			graduation = graduationDAO.getGraduationWithMajorNum(LoginController.getStu_전공());
			// 3. 연산( 부족한 학점계산)
			mav.addObject("Majorresult", (Integer.parseInt(graduation.get전공심화()) - majorSum) + "");
			mav.addObject("Generalresult1", (Integer.parseInt(graduation.get일반교양()) - generalSum1) + "");
			mav.addObject("Generalresult2", (Integer.parseInt(graduation.get필수교양()) - generalSum2) + "");
			mav.addObject("Majorbaseresult", (Integer.parseInt(graduation.get학과기초()) - majorbaseSum) + "");
			// 현재까지 들은 학점을 보여주기위한 값들........
			mav.addObject("MatchingSelectList", selectedList); // 내가 들은 과목
			mav.addObject("MajorSum", majorSum + ""); // 전공
			mav.addObject("GeneralSum1", generalSum1 + ""); // 일교
			mav.addObject("GeneralSum2", generalSum2 + ""); // 필교
			mav.addObject("MajorbaseSum", majorbaseSum + ""); // 학초
			mav.setViewName("result.jsp");

			return mav;
		} else if (MajorNum != null && MinorNum != null) {
			GraduationDAO graduationDAO = new GraduationDAO();
			MinortableDAO minortableDAO = new MinortableDAO();

			GraduationVO graduation = new GraduationVO();
			MinortableVO minortable = new MinortableVO();
			graduation = graduationDAO.getGraduationWithMajorNum(LoginController.getStu_전공());
			minortable = minortableDAO.getMinortableWithMinorNum(LoginController.getStu_복수전공());

			// 3. 연산
			mav.addObject("Majorresult", (Integer.parseInt(minortable.get전공학점()) - majorSum) + "");
			mav.addObject("Majorbaseresult", (Integer.parseInt(graduation.get학과기초()) - majorbaseSum) + "");
			mav.addObject("Minorresult", (Integer.parseInt(minortable.get복수전공학점()) - minorSum) + "");
			mav.addObject("Generalresult1", (Integer.parseInt(graduation.get일반교양()) - generalSum1) + "");
			mav.addObject("Generalresult2", (Integer.parseInt(graduation.get필수교양()) - generalSum2) + "");
			mav.addObject("MatchingSelectList", subjectList);
			// 현재까지 들은 학점을 보여주기위한 값들........
			mav.addObject("MajorSum", majorSum + "");
			mav.addObject("MinorSum", minorSum + "");
			mav.addObject("GeneralSum1", generalSum1 + "");
			mav.addObject("GeneralSum2", generalSum2 + "");
			mav.addObject("MajorbaseSum", majorbaseSum + "");

			mav.setViewName("result.jsp");

			return mav;
		}
		else{
			mav.setViewName("login.jsp");
			return mav;
		}
	}
}
