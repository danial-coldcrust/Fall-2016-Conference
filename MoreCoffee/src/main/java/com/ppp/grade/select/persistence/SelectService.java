package com.ppp.grade.select.persistence;

import java.util.List;

public interface SelectService {
	
	public void insertUser(SelectVO vo);
	
	public List<SelectVO> getSubjectList(String studentNum);
}