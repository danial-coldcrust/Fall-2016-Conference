package com.ppp.grade.subject.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;
import com.ppp.grade.user.persistence.UserVO;




@Repository("SubjectDAO")
public class SubjectDAO {

   private Connection conn = null;
   private PreparedStatement stmt = null;
   private ResultSet rs = null;
   private final String USER_GET = "select * from SUBJECT where 학과코드=?";
   
  
   public SubjectVO getSubject(UserVO uvo){
      SubjectVO subject = null;
     
      try{
         System.out.println("===> JDBC getUser()");
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(USER_GET);
         System.out.println("===> sdadasdas");
         stmt.setString(1,  uvo.get주전공());
         
         rs = stmt.executeQuery();
         if ( rs.next()){
            subject = new SubjectVO();
            subject.set과목코드(rs.getString("과목코드"));
            subject.set과목명(rs.getString("과목명"));
            subject.set구분(rs.getString("구분"));
            subject.set학점(rs.getString("학점"));
            subject.set학년(rs.getString("학년"));
            subject.set학기(rs.getString("학기"));
            subject.set학과코드(rs.getString("학과코드"));
         }
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         JDBCUtil.close(rs, stmt, conn);
      }
      return subject;
   }
}