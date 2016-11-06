package com.ppp.grade.subject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;


public class SubjectGetListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("getlist실행");
		SubjectVO vo = new SubjectVO();
		SubjectDAO subjectDAO = new SubjectDAO();
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjectList", subjectList);
		mav.setViewName("subject.jsp");
		return mav;
	}
}