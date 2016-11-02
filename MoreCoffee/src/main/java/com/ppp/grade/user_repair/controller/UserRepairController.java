package com.ppp.grade.user_repair.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.controller.LoginController;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserRepairController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		UserVO user = new UserVO();
		user.set학번(LoginController.getStu_id());
		user.set패스워드(LoginController.getStu_password());
		user.set이름(LoginController.getStu_name());
		user.set주전공(LoginController.getStu_major());
		user.set복수전공(LoginController.getStu_submajor());
		
		mav.addObject("stu_info",user);
		mav.setViewName("user_repair.jsp");
		return mav;
	}

}
