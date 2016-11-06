package com.ppp.grade.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.history.persistence.HistoryDAO;
import com.ppp.grade.history.persistence.HistoryVO;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserDeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("delete실행");
		String 학번 = request.getParameter("d학번");
		
		HistoryVO history = new HistoryVO();
		history.set학번(학번);
		
		HistoryDAO historyDAO = new HistoryDAO();
		historyDAO.deleteHistory(history);	// 수강이력을 삭제해야  유저가 삭제가능
		
		UserVO vo = new UserVO();
		vo.set학번(학번);

		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(vo);			// 해당 유저 삭제 
		ModelAndView mav = new ModelAndView();
		List<UserVO> userList = userDAO.getUserList(vo);
		mav.addObject("userList", userList);
		mav.setViewName("user.jsp");
		return mav;
	}
}
