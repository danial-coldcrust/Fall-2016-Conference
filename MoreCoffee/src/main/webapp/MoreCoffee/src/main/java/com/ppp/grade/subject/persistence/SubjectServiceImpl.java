package com.ppp.grade.subject.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SubjectService")
public class SubjectServiceImpl implements SubjectService {
   @Autowired
   private SubjectDAO SubjectDAO;
   
   public void setSubjectDAO(SubjectDAO subjectDAO){
      this.SubjectDAO = subjectDAO;
   }
   
   public  List<SubjectVO> getSubjectWithMajorNum(String MajorNum){
	   return SubjectDAO.getSubjectWithMajorNum(MajorNum);
   }
   
   public  List<SubjectVO> getSubjectWithSubjectNum(String[] SubjectNum){
	   return SubjectDAO.getSubjectWithSubjectNum(SubjectNum);
   }
   
   public  List<SubjectVO> getSubjectWithMinorNum(String MinorNum){
	   return SubjectDAO.getSubjectWithMinorNum(MinorNum);
   }
public void insertSubject(SubjectVO vo) {
		SubjectDAO.insertSubject(vo);
	}
	public SubjectVO getSubject(SubjectVO vo){
		return SubjectDAO.getSubject(vo);
	}
	public void updateSubject(SubjectVO vo) {
		SubjectDAO.updateSubject(vo);
	}

	public void deleteSubject(SubjectVO vo) {
		SubjectDAO.deleteSubject(vo);
	}

	public List<SubjectVO> getSubjectList(SubjectVO vo) {
		return SubjectDAO.getSubjectList(vo);
	}
}