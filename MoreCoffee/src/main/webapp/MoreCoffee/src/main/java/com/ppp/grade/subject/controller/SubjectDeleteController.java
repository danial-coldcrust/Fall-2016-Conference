package com.ppp.grade.subject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;

public class SubjectDeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String 과목코드 = request.getParameter("d과목코드");

		SubjectVO vo = new SubjectVO();
		vo.set과목코드(과목코드);
		SubjectDAO subjectDAO = new SubjectDAO();
		subjectDAO.deleteSubject(vo);

		ModelAndView mav = new ModelAndView();
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(vo);
		mav.addObject("subjectList", subjectList);
		mav.setViewName("subject.jsp");
		return mav;
	}
}
