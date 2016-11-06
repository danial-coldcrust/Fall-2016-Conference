package com.ppp.grade.department.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDAO departmentDAO;

	public DepartmentVO getDepartment(DepartmentVO vo) {
		return departmentDAO.getDepartment(vo);
	}

	public List<DepartmentVO> getDepartmentList(DepartmentVO vo) {
		return departmentDAO.getDepartmentList(vo);
	}
}
