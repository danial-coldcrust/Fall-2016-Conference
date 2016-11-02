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
	static String stu_이름;
	static String stu_패스워드;
	static String stu_아이디;
	static String stu_전공;
	static String stu_복수전공;
	
	public static String getStu_복수전공() {
		return stu_복수전공;
	}

	public static String getStu_이름() {
		return stu_이름;
	}

	public static String getStu_패스워드() {
		return stu_패스워드;
	}

	public static String getStu_아이디() {
		return stu_아이디;
	}

	public static String getStu_전공() {
		return stu_전공;
	}

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
			stu_이름 = user.get이름();
			stu_패스워드 = user.get패스워드();
			stu_아이디 = user.get학번();
			stu_전공 = user.get주전공();
			stu_복수전공 = user.get복수전공();
			
			SubjectDAO subjectDAO = new SubjectDAO();
			//전공
			List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
			subjectList = subjectDAO.getSubjectWithMajorNum(user.get주전공());
			mav.addObject("subjectList", subjectList);
			
			//부전공
			if(user.get복수전공() != null){
				List<SubjectVO> subjectList3 = new ArrayList<SubjectVO>();
				subjectList3 = subjectDAO.getSubjectWithMinorNum(user.get복수전공());
				mav.addObject("subjectList3", subjectList3);
			}
			
			//교양
			List<SubjectVO> subjectList2 = new ArrayList<SubjectVO>();
			subjectList2 = subjectDAO.getSubjectWithMajorNum("99");
			mav.addObject("subjectList2", subjectList2);
			
			//학번
			mav.addObject("num",num);
			
			if(user.get학번().equals("0")){
				mav.setViewName("admin.do");
			}
			else {
				mav.setViewName("select.jsp");
			}
		}else{
			mav.setViewName("login.jsp");
		}
		
		return mav;
	}
}