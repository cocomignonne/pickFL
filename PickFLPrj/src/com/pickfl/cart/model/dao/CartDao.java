package com.pickfl.cart.model.dao;

import static com.pickfl.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pickfl.cart.model.vo.CartVo;

public class CartDao {

	public List<CartVo> selectCartInfo(Connection conn, int currentUserMemNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CartVo cartVo = null;
		List<CartVo> selectCartInfo = new ArrayList<CartVo>();
		
		String sql = "SELECT C.BOUQUET_NAME, C.BOUQUET_DETAIL, B.WRAP_COLOR, C.BUY_NUM_BQ, B.BOUQUET_PRICE FROM CART C LEFT JOIN MEMBER M ON (C.MEMBER_NO = M.MEMBER_NO) LEFT JOIN BOUQUET B ON (M.MEMBER_NO = B.MEMBER_NO) WHERE B.MEMBER_NO = ? AND C.MEMBER_NO = M.MEMBER_NO AND C.BOUQUET_NO = B.BOUQUET_NO";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUserMemNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bouquetName = rs.getString("BOUQUET_NAME");
				String bouquetDetail = rs.getString("BOUQUET_DETAIL");
				String wrapColor = rs.getString("WRAP_COLOR");
				int buyNumBQ = rs.getInt("BUY_NUM_BQ");
				int bouquetPrice = rs.getInt("BOUQUET_PRICE");
				int bouquetTotalPrice = buyNumBQ *bouquetPrice;
				
				cartVo = new CartVo();
				
				cartVo.setBouquetName(bouquetName);
				cartVo.setBouquetDetail(bouquetDetail);
				cartVo.setWrapColor(wrapColor);
				cartVo.setBuyNumBQ(buyNumBQ);
				cartVo.setBouquetPrice(bouquetPrice);
				cartVo.setBouquetTotalPrice(bouquetTotalPrice);
				
				selectCartInfo.add(cartVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectCartInfo;
	}
	
	public int add(Connection conn, CartVo c) throws SQLException {
        String sql = "INSERT INTO CART(CART_NO, MEMBER_NO, BOUQUET_NAME, BOUQUET_DETAIL) "
                + "VALUES (SEQ_CART.NEXTVAL, ?,?,?)";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, c.getMemberNo());
            pstmt.setString(2, c.getBouquetName());
            pstmt.setString(3, c.getBouquetDetail());
            
            result = pstmt.executeUpdate();
            
        } finally {
            close(pstmt);
        }
        
        return result;
    }

	
//	장바구니 수량변경
	public int updateCartBQNum(Connection conn, int changedNum, int memNo, String bqName) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE CART SET BUY_NUM_BQ = ? WHERE MEMBER_NO = ? AND BOUQUET_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, changedNum);
			pstmt.setInt(2, memNo);
			pstmt.setString(3, bqName);

			result = pstmt.executeUpdate();

			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBQ(Connection conn, String bqDetail, int memNo, String bqName) {
		
		PreparedStatement pstmt = null;
		int result = 0;
	
		String sql = "DELETE FROM CART WHERE MEMBER_NO = ? AND BOUQUET_DETAIL = ? AND BOUQUET_NAME = ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setString(2, bqDetail);
			pstmt.setString(3, bqName);
		
			result = pstmt.executeUpdate();

			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
		}
		
		return result;
		}

}
