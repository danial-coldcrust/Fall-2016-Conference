package com.ppp.grade.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserGetListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("getlist실행");
		UserVO vo = new UserVO();
		UserDAO userDAO = new UserDAO();
		List<UserVO> userList = userDAO.getUserList(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userList);
		mav.setViewName("user.jsp");
		return mav;
	}
}
