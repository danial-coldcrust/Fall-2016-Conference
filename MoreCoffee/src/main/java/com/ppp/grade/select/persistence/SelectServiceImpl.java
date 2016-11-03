package com.ppp.grade.select.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SelectService")
public class SelectServiceImpl implements SelectService {
	@Autowired
	private SelectDAO selectDAO;

	public void insertUser(SelectVO vo){
		
		selectDAO.insertSelect(vo);	
	}
	
	public List<SelectVO> getSubjectList(String studentNum){
		
		return selectDAO.getSubjectList(studentNum);
	}
	

	
	
	
}