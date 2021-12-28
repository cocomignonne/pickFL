package com.pickfl.inquery.model.dao;

import static com.pickfl.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InqueryDao {

	public int Allpage(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS C FROM QUESTION";
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = Integer.parseInt(rs.getString("C"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
}
