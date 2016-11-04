package com.ppp.grade.select.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ppp.grade.common.JDBCUtil;
import com.ppp.grade.subject.persistence.SubjectVO;



@Repository("SelectDAO")
public class SelectDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String SELECT_PUT2 = "INSERT INTO 수강이력 VALUES(?, ?, NULL)";
	private final String SELECT_GET = "SELECT 학번 FROM 수강이력";
	private final String SELECT_GET_ALL = "SELECT * FROM 수강이력";

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
	
	// 수강이력의 학번을 리스트로 반환
	public List<SelectVO> getStudentNum() {
		SelectVO select = null;
		List<SelectVO> selectList = new ArrayList<SelectVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SELECT_GET);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				select = new SelectVO();
				select .set학번(rs.getString("학번"));
				selectList.add(select);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return selectList;
	}
	
	// 학번으로 수강이력테이블에서 내가 선택한 과목코드를 리스트르 반환
		public List<SelectVO> getSubjectList(String studentNum) {
			SelectVO select = null;
			List<SelectVO> selectList = new ArrayList<SelectVO>();
			try {

				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(SELECT_GET_ALL);
				
				rs = stmt.executeQuery();
				while (rs.next()) {
					select = new SelectVO();
					select.set학번(rs.getString("학번"));
					select.set과목코드(rs.getString("과목코드"));
					if(select.get학번().equals(studentNum) ){
						selectList.add(select);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return selectList;
		}
	
}