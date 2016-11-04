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
	private final String SUBJECT_INSERT = "insert into 과목(과목코드, 과목명, 구분, 학점, 학년, 학기, 학과코드) values(?,?,?,?,?,?,?)";
	private final String SUBJECT_GET = "select * from 과목 where 과목코드=?";
	private final String SUBJECT_DELETE = "delete 과목 where 과목코드=?";
	private final String SUBJECT_UPDATE = "update 과목 set 과목명=?,구분=?,학점 =?,학년=?,학기=?,학과코드=? where 과목코드 = ?";
	private final String SUBJECT_LIST = "select * from 과목 order by 과목코드 desc";

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
public void insertSubject(SubjectVO vo) {
		System.out.println("===> JEBC insertSubject()");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUBJECT_INSERT);
			stmt.setString(1, vo.get과목코드());
			stmt.setString(2, vo.get과목명());
			stmt.setString(3, vo.get구분());
			stmt.setString(4, vo.get학점());
			stmt.setString(5, vo.get학년());
			stmt.setString(6, vo.get학기());
			stmt.setString(7, vo.get학과코드());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public SubjectVO getSubject(SubjectVO vo) {
		SubjectVO subject = null;
		try {
			System.out.println("===> JDBC getSubject()");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUBJECT_GET);
			stmt.setString(1, vo.get학과코드());
			rs = stmt.executeQuery();
			if (rs.next()) {
				subject = new SubjectVO();
				subject.set과목코드(rs.getString("과목코드"));
				subject.set과목명(rs.getString("과목명"));
				subject.set구분(rs.getString("구분"));
				subject.set학점(rs.getString("학점"));
				subject.set학년(rs.getString("학년"));
				subject.set학기(rs.getString("학기"));
				subject.set학과코드(rs.getString("학과코드"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return subject;
	}

	public void updateSubject(SubjectVO vo) {
		System.out.println("===> JEBC updateSubject()");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUBJECT_UPDATE);
			stmt.setString(1, vo.get과목코드());
			stmt.setString(2, vo.get과목명());
			stmt.setString(3, vo.get구분());
			stmt.setString(4, vo.get학점());
			stmt.setString(5, vo.get학년());
			stmt.setString(6, vo.get학기());
			stmt.setString(7, vo.get학과코드());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteSubject(SubjectVO vo) {
		System.out.println("===> JEBC deleteSUBJECT()");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUBJECT_DELETE);
			stmt.setString(1, vo.get과목코드());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public List<SubjectVO> getSubjectList(SubjectVO vo) {
		System.out.println("===> JEBC getSubjectList()");
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SUBJECT_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SubjectVO subject = new SubjectVO();
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
			JDBCUtil.close(stmt, conn);
		}
		return subjectList;
	}
}