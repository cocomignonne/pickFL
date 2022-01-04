package com.pickfl.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pickfl.common.JDBCTemplate.*;

import com.pickfl.review.model.vo.ReviewVo;

public class ReviewDao {

	public List<ReviewVo> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM REVIEW WHERE REVIEW_DELETED = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> list = new ArrayList<ReviewVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int reviewNo = rs.getInt("REVIEW_NO");
				String memberId = rs.getString("MEMBER_ID");
				String bouquetName = rs.getString("BOUQUET_NAME");
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String reviewImage = rs.getString("REVIEW_IMAGE");
				Date reviewDate = rs.getDate("REVIEW_DATE");
				int stars = rs.getInt("STARS");
				
				list.add(new ReviewVo(reviewNo, bouquetName, memberId, reviewTitle, reviewImage, reviewDate, stars));
				
			}
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public ReviewVo selectByNo(Connection conn, int no) throws SQLException {
		String sql = "SELECT * FROM REVIEW WHERE REVIEW_NO = ? AND REVIEW_DELETED = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVo r = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int reviewNo = rs.getInt("REVIEW_NO");
				String memberId = rs.getString("MEMBER_ID");
				String bouquetName = rs.getString("BOUQUET_NAME");
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String reviewImage = rs.getString("REVIEW_IMAGE");
				String reviewContent = rs.getString("REVIEW_CONTENT");
				Date reviewDate = rs.getDate("REVIEW_DATE");
				int stars = rs.getInt("STARS");
				
				r = new ReviewVo(reviewNo, bouquetName, memberId, reviewTitle, reviewImage, reviewContent, reviewDate, stars);
			}
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return r;
	}

	public List<Integer> getBqNoByMemberNo(Connection conn, int memberNo) throws SQLException {
		String sql = "SELECT BOUQUET_NO FROM CART WHERE CART_NO = "
				+ "( SELECT CART_NO FROM ORDER WHERE MEMBER_NO = ? AND DELIVERY_STATE = '배송완료' ) "
				+ "MINUS SELECT BOUQUET_NO FROM REVIEW WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("BOUQUET_NO"));
			}
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public Map<Integer, String> getBqMap(Connection conn, List<Integer> bqNo) throws SQLException {
		String sql = "SELECT BOUQUET_NAME FROM BOUQUET WHERE BOUQUET_NO = ?";
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Integer no : bqNo) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				while(rs.next()) {
					rs = pstmt.executeQuery();
					String bouquetName = rs.getString("BOUQUET_NAME");
					map.put(no, bouquetName);
				}
			} finally {
				close(pstmt);
				close(rs);
			}
		}
		return map;
	}

	public int add(Connection conn, ReviewVo r) throws SQLException {
		String sql = "INSERT INTO REVIEW VALUES(SEQ_REVIEW.NEXTVAL,?,?,?,?,?,?,SYSDATE,?,'N')";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



}
