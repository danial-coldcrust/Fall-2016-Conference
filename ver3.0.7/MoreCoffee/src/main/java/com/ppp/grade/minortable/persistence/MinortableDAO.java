package com.ppp.grade.minortable.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;

@Repository("MinortableDAO")
public class MinortableDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String GRADUATION_GET_MINOR_NUM = "select * from 복수전공 where 학과코드=?";
	
	public MinortableVO getMinortableWithMinorNum(String MinorNum) {
		
		MinortableVO minortable = new MinortableVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GRADUATION_GET_MINOR_NUM);
			stmt.setString(1, MinorNum);

			rs = stmt.executeQuery();
			while (rs.next()) {
				
				minortable.set학과코드(rs.getString("학과코드"));
				minortable.set연도(rs.getString("연도"));
				minortable.set복수전공학점(rs.getString("복수전공학점"));
				minortable.set전공학점(rs.getString("전공학점"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return minortable;
	}
}
