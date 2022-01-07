package com.pickfl.order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.cart.model.vo.CartVo;
import com.pickfl.order.model.vo.OrderVo;

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
	
//	 ORDERLIST에 추가
	public int insertOrderDB(Connection conn, OrderVo orderVo, int memNo) {
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO ORDERLIST "
				+ "VALUES(SEQ_ORDERLIST.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?, ?, DEFAULT)";
		
		int result = 0;
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setString(2, orderVo.getAddress1());
			pstmt.setString(3, orderVo.getAddress2());
			pstmt.setString(4, orderVo.getAddress3());
			pstmt.setString(5, orderVo.getGotName());
			pstmt.setString(6, orderVo.getGotPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//	 ORDERDETAIL에 추가
	public int insertOrderDetailDB(Connection conn, CartVo cartVo, int memNo, int orderNo) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ORDERDETAIL VALUES( "
				+ "SEQ_ORDERDETAIL.NEXTVAL, ?, ?, ?, ?, ?)";
				
		int result = 0;
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, cartVo.getBouquetNo());
			pstmt.setInt(3, memNo);
			pstmt.setInt(4, cartVo.getBuyNumBQ());
			pstmt.setInt(5, cartVo.getBouquetPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
		}
		return result;
	}

//	orderno구하기
	public int selectOrderNo(Connection conn, CartVo cartVo, int memNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT O.ORDER_NO FROM CART C LEFT JOIN ORDERLIST O ON (O.MEMBER_NO = C.MEMBER_NO) "
				+ "LEFT JOIN BOUQUET B ON (B.BOUQUET_NO = C.BOUQUET_NO) WHERE O.MEMBER_NO = ?"; 
		int orderNo = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rs = pstmt.executeQuery();
			rs.next();
			
			orderNo = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(orderNo);
		return orderNo;
	}


}
