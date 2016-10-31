package com.ppp.grade.select.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SelectService")
public class SelectServiceImpl implements SelectService {
	@Autowired
	private SelectDAO selectDAO;

	public void insertUser(SelectVO vo){
		
		//여기에 학과코드랑 학번을 넘겨야 하는군;
		selectDAO.insertSelect(vo);
	}
}