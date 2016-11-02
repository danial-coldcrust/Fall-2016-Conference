package com.ppp.grade.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.subject.persistence.SubjectDAO;
import com.ppp.grade.subject.persistence.SubjectVO;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

public class LoginController implements Controller {
	static String stu_name;
	static String stu_password;
	static String stu_id;
	static String stu_major;
	static String stu_submajor;
			
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("username");
		String password = request.getParameter("password");
		UserVO vo = new UserVO();
		vo.set학번(num);
		vo.set패스워드(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			//값 저장 해보는 부분
			stu_name = user.get이름();
			stu_password = user.get패스워드();
			stu_id = user.get학번();
			stu_major = user.get주전공();
			stu_submajor = user.get복수전공();
			System.out.println(stu_name);
			//여기까지
			
			SubjectDAO subjectDAO = new SubjectDAO();
			//전공
			List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
			subjectList = subjectDAO.getSubjectWithMajorNum(user.get주전공());
			mav.addObject("subjectList", subjectList);
			
			//교양
			List<SubjectVO> subjectList2 = new ArrayList<SubjectVO>();
			subjectList2 = subjectDAO.getSubjectWithMajorNum("0");
			mav.addObject("subjectList2", subjectList2);
			
			//학번
			mav.addObject("num",num);
			
			if(user.get학번().equals("0")){
				mav.setViewName("admin.do");
			}
			else {
				mav.setViewName("select.jsp");
			}
		}
		else{
			mav.setViewName("login.jsp");
		}
		return mav;
	}


	public static String getStu_name() {
		return stu_name;
	}

	public static String getStu_id() {
		return stu_id;
	}

	public static String getStu_major() {
		return stu_major;
	}

	public static String getStu_submajor() {
		return stu_submajor;
	}

	public static String getStu_password() {
		// TODO Auto-generated method stub
		return stu_password;
	}

}