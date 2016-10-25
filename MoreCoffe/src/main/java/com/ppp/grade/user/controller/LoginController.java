package com.ppp.grade.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("�α���ó��");
		
		String num = request.getParameter("username");
		String password = request.getParameter("password");
		UserVO vo = new UserVO();
		vo.set학번(num);
		vo.set패스워드(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			mav.setViewName("select.jsp");
		}
		else{
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}