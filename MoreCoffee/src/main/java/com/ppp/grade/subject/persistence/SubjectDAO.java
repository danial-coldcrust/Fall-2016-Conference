package com.ppp.grade.subject.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.ppp.grade.common.JDBCUtil;

@Repository("SubjectDAO")
public class SubjectDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String SUB_GET_MAJOR_NUM = "select * from 과목 where 학과코드=?";
	private final String SUB_GET_MINOR_NUM = "select * from 과목 where 학과코드=?";
	private final String SUB_GET_SUBJECT_NUM = "select * from 과목 where 과목코드=?";

	/* 학과코드로 과목 조회 */
	public List<SubjectVO> getSubjectWithMajorNum(String MajorNum) {
		SubjectVO subject = null;
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUB_GET_MAJOR_NUM);
			stmt.setString(1, MajorNum);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				subject = new SubjectVO();
				subject.set과목코드(rs.getString("과목코드"));
				subject.set과목명(rs.getString("과목명"));
				subject.set구분(rs.getString("구분"));
				subject.set학점(rs.getString("학점"));
				subject.set학년(rs.getString("학년"));
				subject.set학기(rs.getString("학기"));
				subject.set학과코드(rs.getString("학과코드"));
				subjectList.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return subjectList;
	}
	
	/* 부전공 전용 */
	public List<SubjectVO> getSubjectWithMinorNum(String MinorNum) {
		SubjectVO subject = null;
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUB_GET_MINOR_NUM);
			stmt.setString(1, MinorNum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				subject = new SubjectVO();
				subject.set과목코드(rs.getString("과목코드"));
				subject.set과목명(rs.getString("과목명"));
				subject.set구분(rs.getString("구분"));
				subject.set학점(rs.getString("학점"));
				subject.set학년(rs.getString("학년"));
				subject.set학기(rs.getString("학기"));
				subject.set학과코드(rs.getString("학과코드"));
				subjectList.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return subjectList;
	}

	/* 과목코드로 과목 조회 */
	public List<SubjectVO> getSubjectWithSubjectNum(String[] SubjectNum) { // 인자도
																			// 배열
		SubjectVO subject = null;
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUB_GET_SUBJECT_NUM);
			for (int i = 0; i < SubjectNum.length; i++) {
				stmt.setString(1, SubjectNum[i]);

				rs = stmt.executeQuery();
				if (rs.next()) { // 과목명 중복안되니 걍 if로 함
					subject = new SubjectVO();
					subject.set과목코드(rs.getString("과목코드"));
					subject.set과목명(rs.getString("과목명"));
					subject.set구분(rs.getString("구분"));
					subject.set학점(rs.getString("학점"));
					subject.set학년(rs.getString("학년"));
					subject.set학기(rs.getString("학기"));
					subject.set학과코드(rs.getString("학과코드"));
					subjectList.add(subject);
					//System.out.println(subjectList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return subjectList;
	}
}
