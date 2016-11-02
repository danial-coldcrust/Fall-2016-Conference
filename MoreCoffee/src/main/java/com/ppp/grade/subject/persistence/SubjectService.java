package com.ppp.grade.subject.persistence;

import java.util.List;

import com.ppp.grade.user.persistence.UserVO;

public interface SubjectService {

   public void insertSubject(SubjectVO vo);

	public SubjectVO getSubject(SubjectVO vo);

	public void updateSubject(SubjectVO vo);

	public void deleteSubject(SubjectVO vo);

	public List<SubjectVO> getSubjectList(SubjectVO vo);

   public  List<SubjectVO> getSubjectWithMajorNum(String MajorNum);
   public  List<SubjectVO> getSubjectWithMinorNum(String MinorNum);
   public  List<SubjectVO> getSubjectWithSubjectNum(String[] SubjectNum);
      
}