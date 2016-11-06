package com.ppp.grade.subject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;

public class SubjectUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String 과목코드 = request.getParameter("u과목코드");
		String 과목명 = request.getParameter("u과목명");
		String 구분 = request.getParameter("u구분");
		String 학점 = request.getParameter("u학점");
		String 학년 = request.getParameter("u학년");
		String 학기 = request.getParameter("u학기");
		String 학과코드 = request.getParameter("u학과코드");

		SubjectVO vo = new SubjectVO();
		vo.set과목코드(과목코드);
		vo.set과목명(과목명);
		vo.set구분(구분);
		vo.set학점(학점);
		vo.set학년(학년);
		vo.set학기(학기);
		vo.set학과코드(학과코드);

		SubjectDAO subjectDAO = new SubjectDAO();
		subjectDAO.updateSubject(vo);
		
		ModelAndView mav = new ModelAndView();
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(vo);
		mav.addObject("subjectList",subjectList);
		mav.setViewName("subject.jsp");
		return mav;
	}
}
