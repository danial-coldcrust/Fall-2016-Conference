package com.ppp.grade.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserCreateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CREATE실행");
		String 학번 = request.getParameter("c학번");
		String 이름 = request.getParameter("c이름");
		String 패스워드 = request.getParameter("c패스워드");
		String 주전공 = request.getParameter("c주전공");
		String 복수전공 = request.getParameter("c복수전공");
		
		UserVO vo = new UserVO();
		vo.set학번(학번);
		vo.set이름(이름);
		vo.set패스워드(패스워드);
		vo.set주전공(주전공);
		vo.set복수전공(복수전공);

		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(vo);
		
		ModelAndView mav = new ModelAndView();
		List<UserVO> userList = userDAO.getUserList(vo);
		mav.addObject("userList",userList);
		mav.setViewName("user.jsp");
		return mav;
	}
}
