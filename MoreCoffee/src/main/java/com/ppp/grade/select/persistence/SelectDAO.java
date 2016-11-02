package com.ppp.grade.select.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;



@Repository("SelectDAO")
public class SelectDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String SELECT_PUT2 = "INSERT INTO 수강이력 VALUES(?, ?, NULL)";

	public void insertSelect(SelectVO vo) {

		try {
			
			 conn = JDBCUtil.getConnection();
	         stmt = conn.prepareStatement(SELECT_PUT2);
	       stmt.setString(1, vo.get과목코드());
	       stmt.setString(2, vo.get학번());
	         stmt.executeUpdate();
	         
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}