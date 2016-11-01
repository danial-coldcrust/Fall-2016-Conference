package com.ppp.grade.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class SignupController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String ID = request.getParameter("snum");
		String PWD = request.getParameter("password");
		String NAME = request.getParameter("name");
		String MAJOR = request.getParameter("major");
		String MINOR = request.getParameter("minor");
		
		UserVO vo = new UserVO();
		vo.set학번(ID);
		vo.set패스워드(PWD);
		vo.set이름(NAME);
		vo.set주전공(MAJOR);		//나중에 예외처리필요
		vo.set복수전공(MINOR);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.CheckID(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			mav.setViewName("signup.jsp");
		}
		else{
			userDAO.insertUser(vo);
			
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}
