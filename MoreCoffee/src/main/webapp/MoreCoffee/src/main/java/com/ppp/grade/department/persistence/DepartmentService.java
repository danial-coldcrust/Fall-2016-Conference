package com.ppp.grade.department.persistence;

import java.util.List;

import com.ppp.grade.department.persistence.DepartmentVO;

public interface DepartmentService {
	public DepartmentVO getDepartment(DepartmentVO vo);
	public List<DepartmentVO> getDepartmentList(DepartmentVO vo);
}
