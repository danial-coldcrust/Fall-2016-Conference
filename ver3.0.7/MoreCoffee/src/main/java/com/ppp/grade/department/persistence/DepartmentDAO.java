package com.ppp.grade.department.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;
import com.ppp.grade.department.persistence.DepartmentVO;

@Repository("departmentDAO")
public class DepartmentDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	   
	private final String DEPARTMENT_GET = "select * from 학과 where 학과코드=? and 학과명=?";
	private final String DEPARTMENT_LIST = "select * from 학과 order by 학과코드 desc";
	
	public DepartmentVO getDepartment(DepartmentVO vo){
	      DepartmentVO department = null;
	      try{
	         System.out.println("===> JDBC getUser()");
	         conn = JDBCUtil.getConnection();
	         stmt = conn.prepareStatement(DEPARTMENT_GET);
	         stmt.setString(1,  vo.get학과코드());
	         stmt.setString(2, vo.get학과명());
	         rs = stmt.executeQuery();
	         
	         if ( rs.next()){
	            department = new DepartmentVO();
	            department.set학과코드(rs.getString("학과코드"));
	            department.set학과명(rs.getString("학과명"));
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         JDBCUtil.close(rs, stmt, conn);
	      }
	      return department;
	}
	
	public List<DepartmentVO> getDepartmentList(DepartmentVO vo){
		   System.out.println("===> JEBC getUserList()");
		   List<DepartmentVO> departmentList = new ArrayList<DepartmentVO>();
		   try{
			   conn = JDBCUtil.getConnection();
			   stmt = conn.prepareStatement(DEPARTMENT_LIST);
			   rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   DepartmentVO department = new DepartmentVO();
				   department.set학과코드(rs.getString("학과코드"));
				   department.set학과명(rs.getString("학과명"));
				   departmentList.add(department);
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   JDBCUtil.close(stmt, conn);
		   }
		   return departmentList;
	   }
}
