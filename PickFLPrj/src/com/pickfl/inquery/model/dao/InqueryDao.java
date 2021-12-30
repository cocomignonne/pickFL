package com.pickfl.inquery.model.dao;

import static com.pickfl.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pickfl.inquery.model.vo.InqueryVo;

public class InqueryDao {

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

}
