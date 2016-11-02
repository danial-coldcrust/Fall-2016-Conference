package com.ppp.grade.subject.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.graduation.persistence.GraduationDAO;
import com.ppp.grade.graduation.persistence.GraduationVO;
import com.ppp.grade.minortable.persistence.MinortableDAO;
import com.ppp.grade.minortable.persistence.MinortableVO;
import com.ppp.grade.select.persistence.SelectDAO;
import com.ppp.grade.select.persistence.SelectVO;
import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;
import com.ppp.grade.user.controller.LoginController;

public class SubjectController implements Controller {
	ModelAndView mav = new ModelAndView();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		//전공 변수
		int majorSum = 0;
		//학과기초 변수
		int majorbaseSum = 0;
		//일반교양 변수
		int generalSum1 = 0;
		//필수교양 변수
		int generalSum2 = 0;
		//부전공용 계산 변수
		int minorSum = 0;
		String str[] = request.getParameterValues("subject");
		String num = request.getParameter("num");

		SelectVO vo = new SelectVO();
		SelectDAO selectDAO = new SelectDAO();

		/* subject number and student number inserting */
		for (int i = 0; i < str.length; i++) {

			vo.set과목코드(str[i]);
			vo.set학번(num);
			selectDAO.insertSelect(vo);
		}

		// 1. 학점가져오기(과목번호로)
		SubjectDAO subjectDAO = new SubjectDAO();
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		// 과목번호로 Subject테이블 참조 (과목번호가 str[]인것들의 목록)
		subjectList = subjectDAO.getSubjectWithSubjectNum(str);
		// 이거 2에서 쓰이는 용도인 학과코드 추출
		String MajorNum = subjectList.get(0).get학과코드();

		for (SubjectVO obj : subjectList) {
			if (obj.get구분().equals("일반교양")) {
				System.out.println("교양과목");
				generalSum1 += Integer.parseInt(obj.get학점());
			}
			else if((obj.get구분().equals("필수교양"))){
				generalSum2 += Integer.parseInt(obj.get학점());
			}
			//전공학과코드가 아니면 부전공에 더해줍니다.
			else if((obj.get학과코드()==MajorNum)&&(obj.get구분() != "학과기초")){
				majorSum += Integer.parseInt(obj.get학점());
			}
			else if((obj.get구분().equals("전공")) && (obj.get학과코드() != MajorNum)){
				minorSum += Integer.parseInt(obj.get학점());
			}
			else if((obj.get구분().equals("학과기초"))&&(obj.get학과코드()==MajorNum)){
				majorbaseSum +=Integer.parseInt(obj.get학점());
			}
		}
		System.out.println("주전공 =" +majorSum);
		System.out.println("부전공 = "+minorSum);

		// 2. GRADUATION 정보가져오기(학과코드로)
		
		String MinorNum = LoginController.getStu_복수전공();
		System.out.println(MinorNum);
		
		//복수전공이 없으면 즉, 전공만 듣는 학생 계산
		if(MinorNum==null){
			GraduationDAO graduationDAO = new GraduationDAO();
	
			GraduationVO graduation = new GraduationVO();
			graduation = graduationDAO.getGraduationWithMajorNum(MajorNum);
	
			System.out.println(graduation.get전공심화());
			System.out.println(graduation.get일반교양());
	
			// 3. 연산
			mav.addObject("Majorresult", (Integer.parseInt(graduation.get전공심화()) - majorSum)+"");
			mav.addObject("Generalresult1", (Integer.parseInt(graduation.get일반교양()) - generalSum1)+"");
			mav.addObject("Generalresult2", (Integer.parseInt(graduation.get필수교양()) - generalSum2)+"");
			mav.addObject("Majorbaseresult", (Integer.parseInt(graduation.get학과기초()) - majorbaseSum)+"");
			mav.setViewName("result.jsp");
			
		
			return mav;
		}
		else{
			GraduationDAO graduationDAO = new GraduationDAO();
			MinortableDAO minortableDAO = new MinortableDAO();
			
			GraduationVO graduation = new GraduationVO();
			MinortableVO minortable = new MinortableVO();
			graduation = graduationDAO.getGraduationWithMajorNum(MajorNum);
			minortable = minortableDAO.getMinortableWithMinorNum(MinorNum);
	
			System.out.println("전공학점 = "+minortable.get전공학점());
			System.out.println("복수전공학점 = "+minortable.get복수전공학점());
			System.out.println("일반교양 = "+graduation.get일반교양());
	
			// 3. 연산
			mav.addObject("Majorresult", (Integer.parseInt(minortable.get전공학점()) - majorSum)+"");
			mav.addObject("Majorbaseresult", (Integer.parseInt(graduation.get학과기초()) - majorbaseSum)+"");
			mav.addObject("Minorresult", (Integer.parseInt(minortable.get복수전공학점()) - minorSum)+"");
			mav.addObject("Generalresult1", (Integer.parseInt(graduation.get일반교양()) - generalSum1)+"");
			mav.addObject("Generalresult2", (Integer.parseInt(graduation.get필수교양()) - generalSum2)+"");
			mav.setViewName("result.jsp");
			
		
			return mav;
		}
	}
}
