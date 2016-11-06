package com.ppp.grade.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("read실행");
		String 학번 = request.getParameter("r학번");
		UserVO vo = new UserVO();
		vo.set학번(학번);

		UserDAO userDAO = new UserDAO();

		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(userDAO.CheckID(vo));

		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userList);
		mav.setViewName("user.jsp");
		return mav;
	}
}
