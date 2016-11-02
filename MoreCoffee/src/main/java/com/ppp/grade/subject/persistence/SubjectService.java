package com.ppp.grade.subject.persistence;

import java.util.List;

import com.ppp.grade.user.persistence.UserVO;

public interface SubjectService {

   public void setSubjectDAO(SubjectDAO userDAO);
   public  List<SubjectVO> getSubjectWithMajorNum(String MajorNum);
   public  List<SubjectVO> getSubjectWithMinorNum(String MinorNum);
   public  List<SubjectVO> getSubjectWithSubjectNum(String[] SubjectNum);
      
}