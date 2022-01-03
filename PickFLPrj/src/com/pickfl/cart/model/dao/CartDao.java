package com.pickfl.cart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.cart.model.vo.CartVo;
import static com.pickfl.common.JDBCTemplate.*;

public class CartDao {

	public int add(Connection conn, CartVo c) throws SQLException {
		String sql = "INSERT INTO CART(CART_NO, MEMBER_NO, BOUQUET_NO, BOUQUET_DETAIL) "
				+ "VALUES (SEQ_CART.NEXTVAL, ?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getMemberNo());
			pstmt.setInt(2, c.getBouquetNo());
			pstmt.setString(3, c.getBouquetDetail());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
