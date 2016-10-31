package com.ppp.grade.graduation.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GraduationService")
public class GraduationServiceImpl implements GraduationService {
	@Autowired
	private GraduationDAO graduationDAO;

	public GraduationVO getGraduationWithMajorNum(String MajorNum) {
		return graduationDAO.getGraduationWithMajorNum(MajorNum);
	}
}