package com.pickfl.products.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.pickfl.common.JDBCTemplate.*;
import com.pickfl.products.model.vo.CurrentFlowerVo;

public class CurrentFlowerDao {

	public int add(Connection conn, CurrentFlowerVo cf) throws SQLException {
		
		String sql = "INSERT INTO CURRENT_FLOWER VALUES(SEQ_CF.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cf.getMemberNo());
			pstmt.setInt(2, cf.getProductNo());
			pstmt.setString(3, cf.getProductName());
			pstmt.setInt(4, cf.getOrderNum());
			pstmt.setInt(5, cf.getProductPrice());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<CurrentFlowerVo> selectAll(Connection conn, int memberNo) throws SQLException {
		String sql = "SELECT * FROM CURRENT_FLOWER WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CurrentFlowerVo> list = new ArrayList<CurrentFlowerVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int orderNum = rs.getInt("ORDER_NUM");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				
				list.add(new CurrentFlowerVo(productNo,productName, orderNum, productPrice));
			}
			
			
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int deleteByNo(Connection conn, int productNo) throws SQLException {

		String sql = "DELETE FROM CURRENT_FLOWER WHERE PRODUCT_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteAll(Connection conn, int memberNo) throws SQLException {

		String sql = "DELETE FROM CURRENT_FLOWER WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
