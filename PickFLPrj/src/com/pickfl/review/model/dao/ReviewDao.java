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

import com.pickfl.member.model.vo.MemberVo;
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

	public List<Integer> getBqNoByMemberNo(Connection conn, int memberNo, String memberId) throws SQLException {
		String sql = "SELECT BOUQUET_NO FROM ORDERDETAIL WHERE ORDER_NO IN "
				+ "( SELECT ORDER_NO FROM ORDERLIST WHERE MEMBER_NO = ? AND DELIVERY_STATE = '배송완료' )"
				+ " MINUS SELECT BOUQUET_NO FROM REVIEW WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberId);
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
				rs = pstmt.executeQuery();
				while(rs.next()) {
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
			pstmt.setInt(1, r.getBouquetNo());
			pstmt.setString(2, r.getMemberId());
			pstmt.setString(3, r.getBouquetName());
			pstmt.setString(4, r.getReviewTitle());
			pstmt.setString(5, r.getReviewImage());
			pstmt.setString(6, r.getReviewContent());
			pstmt.setInt(7, r.getStars());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, int reviewNo) throws SQLException {
		String sql = "DELETE FROM REVIEW WHERE REVIEW_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int update(Connection conn, ReviewVo r) throws SQLException {
		String sql = "";
		PreparedStatement pstmt = null;
		int result = 0;
		
		if("".equals(r.getReviewImage())) {
			sql = "UPDATE REVIEW SET REVIEW_TITLE = ?, REVIEW_CONTENT = ?, STARS = ? WHERE REVIEW_NO = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, r.getReviewTitle());
				pstmt.setString(2, r.getReviewContent());
				pstmt.setInt(3, r.getStars());
				pstmt.setInt(4, r.getReviewNo());
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
		}
		else {
			sql = "UPDATE REVIEW SET REVIEW_TITLE = ?, REVIEW_IMAGE = ?, REVIEW_CONTENT = ?, STARS = ? WHERE REVIEW_NO = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, r.getReviewTitle());
				pstmt.setString(2, r.getReviewImage());
				pstmt.setString(3, r.getReviewContent());
				pstmt.setInt(4, r.getStars());
				pstmt.setInt(5, r.getReviewNo());
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			
		}
		return result;
	}

	public List<ReviewVo> selectAll(Connection conn, MemberVo user) throws SQLException  {
		String sql = "SELECT * FROM REVIEW WHERE MEMBER_ID = ? AND REVIEW_DELETED = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> list = new ArrayList<ReviewVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
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

	public ReviewVo selectByNo(Connection conn, int no, MemberVo user) throws SQLException {
		String sql = "SELECT * FROM REVIEW WHERE MEMBER_ID = ? AND REVIEW_NO = ? AND REVIEW_DELETED = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVo r = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setInt(2, no);
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



}
