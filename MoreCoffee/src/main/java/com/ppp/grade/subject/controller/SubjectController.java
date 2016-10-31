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
import com.ppp.grade.select.persistence.SelectDAO;
import com.ppp.grade.select.persistence.SelectVO;
import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;

public class SubjectController implements Controller {
	ModelAndView mav = new ModelAndView();
	int majorSum = 0;
	int generalSum = 0;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

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
			if (obj.get학과코드().equals("0")) {
				System.out.println("교양과목");
				generalSum += Integer.parseInt(obj.get학점());
			} else {
				majorSum += Integer.parseInt(obj.get학점());
			}
		}
		System.out.println(majorSum);

		// 2. GRADUATION 정보가져오기(학과코드로)
		GraduationDAO graduationDAO = new GraduationDAO();

		GraduationVO graduation = new GraduationVO();
		graduation = graduationDAO.getGraduationWithMajorNum(MajorNum);

		System.out.println(graduation.get전공심화());
		System.out.println(graduation.get일반교양());

		// 3. 연산
		mav.addObject("Majorresult", (Integer.parseInt(graduation.get전공심화()) - majorSum)+"");
		mav.addObject("Generalresult", (Integer.parseInt(graduation.get일반교양()) - generalSum)+"");
		mav.setViewName("result.jsp");
		
	
		return mav;
	}
}
