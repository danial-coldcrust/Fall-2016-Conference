package com.ppp.grade.result.controller;

import java.io.UnsupportedEncodingException;
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
import com.ppp.grade.user.controller.LoginController;
import com.ppp.grade.user.persistence.UserVO;

public class RsltToSltController implements Controller {
	ModelAndView mav = new ModelAndView();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		SelectDAO selectDAO = new SelectDAO();
		List<SelectVO> MatchingSelectList = new ArrayList<SelectVO>();

		// 현재 로그인 한 사람 static 으로 가져옴
		String studentNum = LoginController.getStu_아이디();

		// 내가 선택한 과목들 목록 다 가져옴
		MatchingSelectList = selectDAO.getSubjectList(studentNum);

		mav.addObject("num", studentNum);
		mav.addObject("mysubjectList", MatchingSelectList);

		SubjectDAO subjectDAO = new SubjectDAO();

		// 전공
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		subjectList = subjectDAO.getSubjectWithMajorNum(LoginController.getStu_전공());
		mav.addObject("subjectList", subjectList);
		/*
		 * // 내가 선택한 과목, 전공과목 테스트 for (SelectVO s : MatchingSelectList) {
		 * System.out.println("내가 선택한 과목코드 출력");
		 * System.out.println(s.get과목코드()); } for (SubjectVO s : subjectList) {
		 * System.out.println("전공과목 과목코드 출력"); System.out.println(s.get과목코드());
		 * }
		 */

		// 교양
		List<SubjectVO> subjectList2 = new ArrayList<SubjectVO>();
		subjectList2 = subjectDAO.getSubjectWithMajorNum("99");
		mav.addObject("subjectList2", subjectList2);

		// 복수전공
		List<SubjectVO> subjectList3 = new ArrayList<SubjectVO>();
		
		System.out.println(LoginController.getStu_복수전공());
		// 복수전공 있을 때
		if (LoginController.getStu_복수전공() != null) {
			System.out.println("1");
			subjectList3 = subjectDAO.getSubjectWithMinorNum(LoginController.getStu_복수전공());
			mav.addObject("subjectList3", subjectList3);
		}
		// 복수전공 없을 때
		else {
			System.out.println("2");

			mav.addObject("subjectList3", subjectList3);
			mav.setViewName("select.jsp");
			return mav;
		}
		System.out.println("3");
		mav.setViewName("select.jsp");
		return mav;
	}
}
