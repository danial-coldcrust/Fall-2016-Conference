package com.ppp.grade.subject.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppp.grade.user.persistence.UserVO;

@Service("SubjectService")
public class SubjectServiceImpl implements SubjectService {
   @Autowired
   private SubjectDAO SubjectDAO;
   
   public void setSubjectDAO(SubjectDAO subjectDAO){
      this.SubjectDAO = subjectDAO;
   }
   
   public SubjectVO getSubject(UserVO uvo) {
      return SubjectDAO.getSubject(uvo);
   }
}