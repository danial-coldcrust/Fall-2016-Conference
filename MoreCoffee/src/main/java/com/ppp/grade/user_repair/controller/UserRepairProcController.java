package com.ppp.grade.user_repair.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;


public class UserRepairProcController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String 학번 = request.getParameter("학번");
		String 이름 = request.getParameter("이름");
		String 패스워드 = request.getParameter("비밀번호");
		String 주전공 = request.getParameter("주전공");
		String 복수전공 = request.getParameter("복수전공");
		if(복수전공.equals("null")){
			복수전공 = null;
		}
		UserDAO userDAO = new UserDAO();
		UserVO userVO = new UserVO();
		
		userVO.set이름(이름);
		userVO.set패스워드(패스워드);
		userVO.set학번(학번);
		userVO.set주전공(주전공);
		userVO.set복수전공(복수전공);
		
		userDAO.updateUser(userVO);
		
		System.out.println("as");
		mav.setViewName("login.jsp");
		return mav;
	}
}
