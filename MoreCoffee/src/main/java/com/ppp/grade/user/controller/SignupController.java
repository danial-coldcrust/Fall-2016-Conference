package com.ppp.grade.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

import com.ppp.grade.department.persistence.DepartmentDAO;
import com.ppp.grade.department.persistence.DepartmentVO;

public class SignupController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String ID = request.getParameter("snum");
		String PWD = request.getParameter("password");
		String NAME = request.getParameter("name");
		String MAJOR = request.getParameter("major");
		String MINOR = request.getParameter("minor");
		
		UserVO vo = new UserVO();
		vo.set학번(ID);
		vo.set패스워드(PWD);
		vo.set이름(NAME);
		vo.set주전공(MAJOR);		//나중에 예외처리필요
		vo.set복수전공(MINOR);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.CheckID(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			mav.setViewName("signup.jsp");
		}
		else{
			// 승탁이가 추가(주석좀달아줘용)
			List<DepartmentVO> departmentList = new ArrayList<DepartmentVO>();
			DepartmentVO d_vo = new DepartmentVO();
			DepartmentDAO d_dao = new DepartmentDAO();
			departmentList = d_dao.getDepartmentList(d_vo);
			//departmentList.get(0).get학과코드();
			for(int i=0; i<departmentList.size(); i++){
				if(departmentList.get(i).get학과명().equals(MAJOR)){
					vo.set주전공(departmentList.get(i).get학과코드());
				}
				else if(departmentList.get(i).get학과명().equals(MINOR)){
					vo.set복수전공(departmentList.get(i).get학과코드());
				}
			}
			userDAO.insertUser(vo);
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}
