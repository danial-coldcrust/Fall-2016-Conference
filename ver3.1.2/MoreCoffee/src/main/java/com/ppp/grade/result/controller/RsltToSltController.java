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
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		String done = "result";
		SubjectVO subject = new SubjectVO();
		SubjectDAO subjectDAO = new SubjectDAO();
		SelectVO select = new SelectVO();
		SelectDAO selectDAO = new SelectDAO();
		
		List<SelectVO> tmp = selectDAO.getSubjectList(LoginController.getStu_아이디());
		String[] selected = new String[tmp.size()];
		for (int i = 0; i < tmp.size(); i++){
			String str =(String) tmp.get(i).get과목코드();
			selected[i] = str;
			System.out.println("reltToCon  " + str);
		}
		List<SubjectVO> subjectList = subjectDAO.getSubjectList(subject);
		List<SubjectVO> selectedList = subjectDAO.getSubjectWithSubjectNum(selected);
		List<SubjectVO> 학초 = new ArrayList<SubjectVO> ();
		List<SubjectVO> 전공 = new ArrayList<SubjectVO> ();
		List<SubjectVO> 일교 = new ArrayList<SubjectVO> ();
		List<SubjectVO> 필교 = new ArrayList<SubjectVO> ();
		List<SubjectVO> 복전 = new ArrayList<SubjectVO> ();
		System.out.println(LoginController.getStu_전공());
		for (SubjectVO obj : subjectList) {
			if (obj.get구분().equals("학과기초") && obj.get학과코드().equals(LoginController.getStu_전공())) {
				학초.add(obj);
			} else if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_전공())) {
				전공.add(obj);
			} else if (obj.get구분().equals("일반교양") && obj.get과목코드().equals("99")) {
				일교.add(obj);
			} else if (obj.get구분().equals("필수교양") && obj.get과목코드().equals("99")) {
				필교.add(obj);
			} else if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_복수전공())) {
				복전.add(obj);
			} else{
				continue;// 복전전공 + 학과기초는 ?? 왜 설계안함 ?
			}
		}
		for (SubjectVO obj : selectedList) {
			subjectList.remove(obj);
		}
		
		mav.addObject("done", done);
		mav.addObject("전체학초", 학초);
		mav.addObject("전체전공", 전공);
		mav.addObject("전체일교", 일교);
		mav.addObject("전체필교", 필교);
		mav.addObject("전체복전", 복전);
		mav.addObject("mysubjectList", selectedList);
		mav.addObject("unselectedList", subjectList);
		mav.setViewName("select.jsp");

		return mav;
	}
}
