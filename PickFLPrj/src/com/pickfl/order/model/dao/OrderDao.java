package com.pickfl.order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.pickfl.common.JDBCTemplate.*;

public class OrderDao {
//	리뷰작성시 현재 사용자가 주문을 한 사람이 맞는 지 확인하는 쿼리
	public String getMemberId(Connection conn, int orderNo) throws SQLException {
		String sql = "SELECT MEMBER_ID FROM ORDER_LIST WHERE ORDER_NO IS ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";
		
		try {
			pstmt.setInt(1, orderNo);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getString("MEMBER_ID");
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

}
