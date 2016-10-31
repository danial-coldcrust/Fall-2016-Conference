package com.ppp.grade.user.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;




@Repository("userDAO")
public class UserDAO {

   private Connection conn = null;
   private PreparedStatement stmt = null;
   private ResultSet rs = null;
   private final String USER_INSERT = "insert into STUDENT(학번, 이름, 패스워드, 주전공, 복수전공, 입학년도) values(?,?,?,?,?,?)";
   private final String USER_GET = "select * from STUDENT where 학번=? and 패스워드=?";
   private final String USER_DELETE = "delete STUDENT where 학번 = ?";
   private final String USER_UPDATE = "update STUDENT set 이름 = ?, 패스워드 =?, 주전공 =?, 복수전공=?, 입학년도 =? where 학번 = ?";
   private final String USER_LIST = "select * from STUDENT order by 학번 desc";
   private final String CheckID = "select * from STUDENT where 학번=?";
   
   public void insertUser(UserVO vo){
      System.out.println("===> JEBC insertUser()");
      try{
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(USER_INSERT);
         stmt.setString(1, vo.get학번());
         stmt.setString(2, vo.get이름());
         stmt.setString(3, vo.get패스워드());
         stmt.setString(4, vo.get주전공());
         stmt.setString(5, null);
         stmt.setString(6, vo.get학번().substring(0, 4));
         stmt.executeUpdate();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         JDBCUtil.close(stmt, conn);
      }
   }
   public UserVO getUser(UserVO vo){
      UserVO user = null;
      try{
         System.out.println("===> JDBC getUser()");
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(USER_GET);
         stmt.setString(1,  vo.get학번());
         stmt.setString(2, vo.get패스워드());
         rs = stmt.executeQuery();
         if ( rs.next()){
            user = new UserVO();
            user.set학번(rs.getString("학번"));
            user.set이름(rs.getString("이름"));
            user.set패스워드(rs.getString("패스워드"));
            user.set주전공(rs.getString("주전공"));
            user.set복수전공(rs.getString("복수전공"));
            user.set입학년도(rs.getString("입학년도"));
         }
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         JDBCUtil.close(rs, stmt, conn);
      }
      return user;
   }
   public void updateUser(UserVO vo){
	   System.out.println("===> JEBC updateUser()");
	   try{
		   conn = JDBCUtil.getConnection();
		   stmt = conn.prepareStatement(USER_UPDATE);
		   stmt.setString(1, vo.get이름());
		   stmt.setString(2, vo.get패스워드());
		   stmt.setString(3, vo.get주전공());
		   stmt.setString(4, vo.get복수전공());
		   stmt.setString(5, vo.get입학년도());
		   stmt.setString(6, vo.get학번());
		   stmt.executeUpdate();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   JDBCUtil.close(stmt, conn);
	   }
   }
   public void deleteUser(UserVO vo){
	   System.out.println("===> JEBC deleteUser()");
	      try{
	         conn = JDBCUtil.getConnection();
	         stmt = conn.prepareStatement(USER_DELETE);
	         stmt.setString(1, vo.get학번());
	         stmt.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         JDBCUtil.close(stmt, conn);
	      }
   }
   public List<UserVO> getUserList(UserVO vo){
	   System.out.println("===> JEBC getUserList()");
	   List<UserVO> userList = new ArrayList<UserVO>();
	   try{
		   conn = JDBCUtil.getConnection();
		   stmt = conn.prepareStatement(USER_LIST);
		   rs = stmt.executeQuery();
		   while(rs.next()){
			   UserVO user = new UserVO();
			   user.set학번(rs.getString("학번"));
			   user.set이름(rs.getString("이름"));
			   user.set패스워드(rs.getString("패스워드"));
			   user.set주전공(rs.getString("주전공"));
			   user.set복수전공(rs.getString("복수전공"));
			   user.set입학년도(rs.getString("입학년도"));
			   userList.add(user);
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   JDBCUtil.close(stmt, conn);
	   }
	   return userList;
   }
   public UserVO CheckID(UserVO vo){
	      UserVO user = null;
	      try{
	         System.out.println("===> JDBC CheckID()");
	         conn = JDBCUtil.getConnection();
	         stmt = conn.prepareStatement(CheckID);
	         stmt.setString(1,  vo.get학번());
	         rs = stmt.executeQuery();
	         if ( rs.next()){
	            user = new UserVO();
	            user.set학번(rs.getString("학번"));
	            user.set이름(rs.getString("이름"));
	            user.set패스워드(rs.getString("패스워드"));
	            user.set주전공(rs.getString("주전공"));
	            user.set복수전공(rs.getString("복수전공"));
	            user.set입학년도(rs.getString("입학년도"));
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         JDBCUtil.close(rs, stmt, conn);
	      }
	      return user;
	   }
}