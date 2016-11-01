package com.ppp.grade.graduation.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;



@Repository("GraduationDAO")
public class GraduationDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String GRADUATION_GET_MAJOR_NUM = "select * from 졸업학점 where 학과코드=?";
	public GraduationVO getGraduationWithMajorNum(String MajorNum) {
		
		GraduationVO graduation = new GraduationVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GRADUATION_GET_MAJOR_NUM);
			stmt.setString(1, MajorNum);

			rs = stmt.executeQuery();
			while (rs.next()) {
				
				graduation.set학과코드(rs.getString("학과코드"));
				graduation.set연도(rs.getString("연도"));
				graduation.set전공심화(rs.getString("전공심화"));
				//graduation.set전공학점(rs.getString("전공학점"));
				graduation.set학과기초(rs.getString("학과기초"));
				graduation.set일반교양(rs.getString("일반교양"));
				graduation.set필수교양(rs.getString("필수교양"));
				//graduation.set복수전공학점(rs.getString("복수전공학점"));
				graduation.set봉사시간(rs.getString("봉사시간"));
				graduation.set봉사교육(rs.getString("봉사교육"));
				graduation.set심폐교육(rs.getString("심폐교육"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return graduation;
	}
	
}