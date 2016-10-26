package com.ppp.grade.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*String num = request.getParameter("num");
		UserVO vo = new UserVO();
		vo.set학번(num);*/
		
		UserDAO userDAO = new UserDAO();
		UserVO vo = userDAO.getUser(null);
		
		List<UserVO> userList = userDAO.getUserList(vo);
		for (UserVO tmp : userList){
			System.out.println(tmp);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList",userList);
		mav.setViewName("");
		return mav;
	}
}
