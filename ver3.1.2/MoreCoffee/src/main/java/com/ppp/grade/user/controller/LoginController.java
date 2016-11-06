package com.ppp.grade.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ppp.grade.select.persistence.SelectDAO;
import com.ppp.grade.select.persistence.SelectVO;
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
	static int allpoint;
	
	public static int getAllpoint() {
		return allpoint;
	}

	public static void setAllpoint(int allpoint) {
		LoginController.allpoint = allpoint;
	}

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

	public static void setStu_이름(String stu_이름) {
		LoginController.stu_이름 = stu_이름;
	}

	public static void setStu_패스워드(String stu_패스워드) {
		LoginController.stu_패스워드 = stu_패스워드;
	}

	public static void setStu_아이디(String stu_아이디) {
		LoginController.stu_아이디 = stu_아이디;
	}

	public static void setStu_전공(String stu_전공) {
		LoginController.stu_전공 = stu_전공;
	}

	public static void setStu_복수전공(String stu_복수전공) {
		LoginController.stu_복수전공 = stu_복수전공;
	}

	public Boolean StringEqualList(String studentNum, List<SelectVO> selectList) {
	      for (SelectVO object : selectList) {
	         if (object == selectList.get(0)) {
	        	 System.out.println(object);
	        	 System.out.println(selectList.get(0));
	            return true;
	         }
	      }
	      return false;
	   }

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String done = "login";
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
			stu_이름 = null;
			stu_패스워드 = null;
			stu_아이디 = null;
			stu_전공 = null;
			stu_복수전공 = null;
			
			stu_이름 = user.get이름();
			stu_패스워드 = user.get패스워드();
			stu_아이디 = user.get학번();
			stu_전공 = user.get주전공();
			stu_복수전공 = user.get복수전공();
			
			allpoint = 140;
			
			SubjectDAO subjectDAO = new SubjectDAO();
			//전공
			List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
			subjectList = subjectDAO.getSubjectWithMajorNum(user.get주전공());
			mav.addObject("subjectList", subjectList);
			
			//교양
			List<SubjectVO> subjectList2 = new ArrayList<SubjectVO>();
			subjectList2 = subjectDAO.getSubjectWithMajorNum("99");
			mav.addObject("subjectList2", subjectList2);
			
			//복수전공
			if(user.get복수전공() != null){
				List<SubjectVO> subjectList3 = new ArrayList<SubjectVO>();
				subjectList3 = subjectDAO.getSubjectWithMinorNum(user.get복수전공());
				mav.addObject("subjectList3", subjectList3);
			}
			mav.addObject("done", done);
			//학번
			mav.addObject("num",num);
			
			//회원일 때 수강이력테이블에서 학번들 가져옴(비교하기위해)
			LoginController loginController = new LoginController();
			SelectDAO selectDAO = new SelectDAO();  //사실 DAO를 new 하는 것은 옳은 방식은 아님(이제부터라도)
			List<SelectVO> selectList = selectDAO.getSubjectList(num);

			mav.addObject("MatchingSelectList", selectList);
			
			// 관리자
			if(user.get학번().equals("0")){
				mav.setViewName("admin.do");
			}
			// 회원
			else if (loginController.StringEqualList(user.get학번(),selectList)) {
				System.out.println("오류난당");
				mav.setViewName("subjectside.do"); 
				}
			// 정보 x 회원
			else {
				mav.setViewName("select.jsp");
			}
		}else{
			mav.setViewName("login.jsp");
		}
		
		return mav;
	}
}