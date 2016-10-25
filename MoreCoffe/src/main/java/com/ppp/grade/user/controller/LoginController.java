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
		System.out.println(num);
		System.out.println(password);
		UserVO vo = new UserVO();
		vo.set학번(num);
		vo.set패스워드(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			/*//MVC_2 response.sendRedirect("sub.jsp");
			System.out.println("sub.jsp����");
			//return "sub";
			if(user.get().isEmpty() && user.getGeneric().isEmpty() && user.getNecessaries().isEmpty() && user.getLiberal().isEmpty() ){
				mav.setViewName("sub.jsp");
			}
			else{
				if (!user.getMajor().isEmpty()) {
					int score = 0;
					String subject = ""; 
					String[] str = user.getMajor().split(",");
					for(String subject_num : str){
						MajorVO obj = new MajorVO();
						obj.setNum(subject_num);
						MajorDAO majorDAO = new MajorDAO();
						MajorVO grade = majorDAO.getMajor(obj);
						//System.out.println(grade.getName() + grade.getGrade());
						score += Integer.parseInt(grade.getGrade());
						subject += ", " + grade.getName();
					}
					System.out.println(score);
					System.out.println(subject);
				}
				mav.setViewName("getMajorList.do");
				//System.out.println("�ϳ��� ������");
			}*/
			System.out.println("ㅁㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ");
		}
		else{
			//MVC_2 response.sendRedirect("login.jsp");
			System.out.println("login.jsp");
			//return "login";
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}