package com.ppp.grade.history.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;

@Repository("historyDAO")
public class HistoryDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String HISTORY_DELETE = "delete 수강이력 where 학번=?";

	public void deleteHistory(HistoryVO vo) {
		System.out.println("===> JEBC deleteHistory()");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HISTORY_DELETE);
			stmt.setString(1, vo.get학번());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

}
