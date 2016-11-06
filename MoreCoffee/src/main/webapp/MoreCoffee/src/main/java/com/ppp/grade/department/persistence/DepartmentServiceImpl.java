package com.ppp.grade.department.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDAO departmentDAO;

	public DepartmentVO getDepartment(DepartmentVO vo) {
		// TODO Auto-generated method stub
		return departmentDAO.getDepartment(vo);
	}

	public List<DepartmentVO> getDepartmentList(DepartmentVO vo) {
		// TODO Auto-generated method stub
		return departmentDAO.getDepartmentList(vo);
	}
}
