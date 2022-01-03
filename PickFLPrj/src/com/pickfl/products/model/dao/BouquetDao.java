package com.pickfl.products.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.pickfl.common.JDBCTemplate.*;
import com.pickfl.products.model.vo.BouquetVo;

public class BouquetDao {

	public int add(Connection conn, BouquetVo b) throws SQLException {
		String sql = "INSERT INTO BOUQUET VALUES(SEQ_BOUQUET.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getMemberNo());
			pstmt.setString(2, b.getBouquetName());
			pstmt.setString(3, b.getWrapColor());
			pstmt.setInt(4, b.getBouquetPrice());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getCurrBqNo(Connection conn) throws SQLException {
		String sql = "SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_BOUQUET'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int bouquetNo = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				bouquetNo = rs.getInt("LAST_NUMBER");
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return bouquetNo;
	}

}
