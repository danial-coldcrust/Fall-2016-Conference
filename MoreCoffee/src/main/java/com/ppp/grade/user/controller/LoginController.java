package com.ppp.grade.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("username");
		String password = request.getParameter("password");
		UserVO vo = new UserVO();
		vo.set학번(num);
		vo.set패스워드(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			
			SubjectDAO subjectDAO = new SubjectDAO();
			//전공
			List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
			subjectList = subjectDAO.getSubjectWithMajorNum(user.get주전공());
			mav.addObject("subjectList", subjectList);
			
			//교양
			List<SubjectVO> subjectList2 = new ArrayList<SubjectVO>();
			subjectList2 = subjectDAO.getSubjectWithMajorNum("0");
			mav.addObject("subjectList2", subjectList2);
			
			//학번
			mav.addObject("num",num);
			
			if(user.get학번().equals("0")){
				mav.setViewName("admin.do");
			}
			else {
				mav.setViewName("select.jsp");
			}
		}
		else{
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}