package com.ppp.grade.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class UserController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String i학번 = request.getParameter("i학번");
		String i이름 = request.getParameter("i이름");
		String i패스워드 = request.getParameter("i패스워드");
		String i주전공 = request.getParameter("i주전공");
		String i복수전공 = request.getParameter("i복수전공");
		
		String u학번 = request.getParameter("u학번");
		String u이름 = request.getParameter("u이름");
		String u패스워드 = request.getParameter("u패스워드");
		String u주전공 = request.getParameter("u주전공");
		String u복수전공 = request.getParameter("u복수전공");
		
		String s학번 = request.getParameter("s학번");
		
		String d학번 = request.getParameter("d학번");
		
		UserVO insert = new UserVO();
		insert.set학번(i학번);
		insert.set이름(i이름);
		insert.set패스워드(i패스워드);
		insert.set주전공(i주전공);
		insert.set복수전공(i복수전공);
		
		UserVO update = new UserVO();
		update.set학번(u학번);
		update.set이름(u이름);
		update.set패스워드(u패스워드);
		update.set주전공(u주전공);
		update.set복수전공(u복수전공);
		
		UserVO select = new UserVO();
		select.set학번(s학번);
		
		UserVO delete = new UserVO();
		delete.set학번(d학번);
		
		UserDAO insertDAO = new UserDAO();
		insertDAO.insertUser(insert);
		
		UserDAO updateDAO = new UserDAO();
		updateDAO.updateUser(update);
		
		UserDAO selectDAO = new UserDAO();
		selectDAO.CheckID(select);
		
		UserDAO deleteDAO = new UserDAO();
		deleteDAO.deleteUser(delete);
				
		UserVO vo = new UserVO();
		vo.set학번("0");
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		List<UserVO> userList = userDAO.getUserList(user);
		
		SubjectDAO subjectDAO = new SubjectDAO();
		List<SubjectVO> subjectList = subjectDAO.getSubjectWithMajorNum("10");
		//System.out.println(user.toString());
		/*if((select.get학번()).equals(null)){
			System.out.println("Hhhh");
		}
		else{
			//userList = new ArrayList<UserVO>();
			userList.clear();
			userList.add(selectDAO.CheckID(select));
		}*/
		/*for (UserVO tmp : userList){
			System.out.println(tmp.toString());
		}*/
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList",userList);
		mav.addObject("subjectList",subjectList);
		mav.setViewName("admin.jsp");
		return mav;
	}
}
