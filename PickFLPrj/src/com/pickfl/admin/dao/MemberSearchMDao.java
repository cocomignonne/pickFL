package com.pickfl.admin.dao;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberSearchMDao {

	public int allMemberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS C FROM MEMBER";
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = Integer.parseInt(rs.getString("C"));
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}

	public int allMemberCount(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS C FROM MEMBER WHERE MEMBER_ID like ?";
		
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id  + "%");
			rs = pstmt.executeQuery();
			
			rs.next();
			result = Integer.parseInt(rs.getString("C"));
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}
}
