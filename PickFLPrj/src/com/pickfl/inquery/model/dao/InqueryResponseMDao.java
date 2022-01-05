package com.pickfl.inquery.model.dao;

import static com.pickfl.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pickfl.inquery.model.vo.InqueryResponseVo;

public class InqueryResponseMDao {

	public void insertResponse(Connection conn, InqueryResponseVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO QUESTION_RESPONSE VALUES(?, ?, ?, ?, ?, SYSDATE, 'N')";
		String sql2 = "UPDATE QUESTION SET Q_RESPONSE = 'Y' WHERE Q_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getqNum());
			pstmt.setInt(2, vo.getrNum());
			pstmt.setInt(3, vo.getmNum());
			pstmt.setString(4, vo.getAdmin_id());
			pstmt.setString(5, vo.getrContent());
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getqNum());
			pstmt.executeQuery();
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
	}

}
