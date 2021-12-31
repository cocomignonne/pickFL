package com.pickfl.inquery.model.dao;

import static com.pickfl.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pickfl.inquery.model.vo.InqueryVo;

public class InqueryMDao {
	public void insertInquery(Connection conn, InqueryVo vo) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO QUESTION VALUES(SEQ_QUESTION.NEXTVAL, ?, ?, ?, SYSDATE, 'N', 'N')";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser());
			pstmt.setString(2, vo.getqTitle());
			pstmt.setString(3, vo.getqContent());
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	}

	public InqueryVo searchInquery(Connection conn, InqueryVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM QUESTION"
				+ " WHERE Q_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,vo.getqNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setqTitle(rs.getString("Q_TITLE"));
				vo.setqContent(rs.getString("Q_CONTENT"));
				vo.setCreateDate(rs.getTimestamp("Q_CREATE"));
				vo.setqResponse(rs.getString("Q_RESPONSE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return vo;
	}
}
