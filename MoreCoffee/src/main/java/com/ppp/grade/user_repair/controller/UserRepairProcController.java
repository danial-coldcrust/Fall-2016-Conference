
package com.ppp.grade.user_repair.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.user.controller.LoginController;
import com.ppp.grade.user.persistence.UserDAO;
import com.ppp.grade.user.persistence.UserVO;

import com.ppp.grade.department.persistence.DepartmentDAO;
import com.ppp.grade.department.persistence.DepartmentVO;
import java.util.ArrayList;
import java.util.List;

import com.ppp.grade.history.persistence.HistoryDAO;
import com.ppp.grade.history.persistence.HistoryVO;

public class UserRepairProcController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String 학번 = request.getParameter("학번");
		String 이름 = request.getParameter("이름");
		String 패스워드 = request.getParameter("패스워드");
		String 주전공 = request.getParameter("주전공");
		String 복수전공 = request.getParameter("복수전공");
		
		UserDAO userDAO = new UserDAO();
		UserVO userVO = new UserVO();
		
		DepartmentVO d_vo = new DepartmentVO();
		DepartmentDAO d_dao = new DepartmentDAO();
		List<DepartmentVO> departmentList = new ArrayList<DepartmentVO>();
		departmentList = d_dao.getDepartmentList(d_vo);
		
		for(int i = 0; i < departmentList.size(); i++){
			if(departmentList.get(i).get학과명().equals(주전공)){
				주전공 = departmentList.get(i).get학과코드();
			}
		}
		System.out.println(주전공);
		if(복수전공.equals("학과 선택")){
			복수전공 = null;
		}
		else{
			for(int i = 0; i < departmentList.size(); i++){
				if(departmentList.get(i).get학과명().equals(복수전공)){
					복수전공 = departmentList.get(i).get학과코드();
				}
			}
		}
		System.out.println(request.getParameter(복수전공));
		userVO.set이름(이름);
		userVO.set패스워드(패스워드);
		userVO.set학번(학번);
		userVO.set주전공(주전공);
		userVO.set복수전공(복수전공);
		if(!LoginController.getStu_전공().equals(주전공) || !LoginController.getStu_복수전공().equals(복수전공)){
					HistoryDAO hdao = new HistoryDAO();
					hdao.deleteHistory(학번);
		}

		userDAO.updateUser(userVO);
		
		mav.setViewName("login.jsp");
		return mav;
	}
}