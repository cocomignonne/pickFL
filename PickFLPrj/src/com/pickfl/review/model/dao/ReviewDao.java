package com.pickfl.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.pickfl.common.JDBCTemplate.*;

import com.pickfl.review.model.vo.ReviewVo;

public class ReviewDao {

	public List<ReviewVo> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM REVIEW WHERE REVIEW_DELETED = 'N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> list = new ArrayList<ReviewVo>();;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int reviewNo = rs.getInt("REVIEW_NO");
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String memberId = rs.getString("MEMBER_ID");
				Date reviewDate = rs.getDate("REVIEW_DATE");
				int star = rs.getInt("STARS");
				
				list.add(new ReviewVo(reviewNo, reviewTitle,memberId, reviewDate, star));
				
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
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String memberId = rs.getString("MEMBER_ID");
				String reviewContent = rs.getString("REVIEW_CONTENT");
				Date reviewDate = rs.getDate("REVIEW_DATE");
				int star = rs.getInt("STARS");
				
				r = new ReviewVo(reviewNo, memberId, reviewTitle, reviewContent, reviewDate, star);
			}
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return r;
	}



}
