package com.ppp.grade.subject.persistence;

import com.ppp.grade.user.persistence.UserVO;

public interface SubjectService {

   public void setSubjectDAO(SubjectDAO userDAO);
   public SubjectVO getSubject(UserVO uvo);
   
}