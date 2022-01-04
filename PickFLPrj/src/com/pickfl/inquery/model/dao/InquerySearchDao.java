package com.pickfl.inquery.model.dao;

import static com.pickfl.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pickfl.inquery.model.vo.InquerySearchVo;
import com.pickfl.inquery.model.vo.InqueryVo;

public class InquerySearchDao {
	public int allMemberPage(Connection conn, String user, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS C FROM QUESTION WHERE M_NO = ? AND Q_DELETED = 'N'";
		String sql2 = "SELECT COUNT(*) AS C FROM QUESTION WHERE M_NO = ? AND Q_RESPONSE = ? AND Q_DELETED = 'N'";
		int result = 0;
		
		try {
			if(type.equals("all")) {
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1,user);
				rs = pstmt.executeQuery();
				
				rs.next();
				result = Integer.parseInt(rs.getString("C"));
			}else {
				pstmt= conn.prepareStatement(sql2);
				pstmt.setString(1,user);
				pstmt.setString(2,type);
				rs = pstmt.executeQuery();
				
				rs.next();
				result = Integer.parseInt(rs.getString("C"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public int allInfoPage(Connection conn, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS C FROM QUESTION";
		String sql2 = "SELECT COUNT(*) AS C FROM QUESTION WHERE Q_RESPONSE = ?";
		int result = 0;
		
		try {
			if(type.equals("all")) {
				pstmt= conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				rs.next();
				result = Integer.parseInt(rs.getString("C"));
			}else {
				pstmt= conn.prepareStatement(sql2);
				pstmt.setString(1,type);
				rs = pstmt.executeQuery();
				
				rs.next();
				result = Integer.parseInt(rs.getString("C"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public List<InqueryVo> selectInqueryList(Connection conn, InquerySearchVo vo) {
		int endNo = vo.getCurrentPage() * 7;
		int startNo = endNo - 6;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, Q.* FROM QUESTION Q WHERE M_NO = ? AND Q_DELETED = 'N')"
				+ "WHERE RNUM BETWEEN ? AND ?";
		String sql2 = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, Q.* FROM QUESTION Q WHERE M_NO = ? AND Q_RESPONSE = ? AND Q_DELETED = 'N')"
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		List<InqueryVo> list = new ArrayList<InqueryVo>();
		InqueryVo vo2;
		
		try {
			if(vo.getType().equals("all")) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,vo.getUser());
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					vo2 = new InqueryVo();
					vo2.setqNum(rs.getInt("Q_NO"));
					vo2.setqTitle(rs.getString("Q_TITLE"));
					vo2.setqContent(rs.getString("Q_CONTENT"));
					vo2.setCreateDate(rs.getTimestamp("Q_CREATE"));
					vo2.setqResponse(rs.getString("Q_RESPONSE"));
					
					list.add(vo2);
				}
			}
			else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1,vo.getUser());
				pstmt.setString(2,vo.getType());
				pstmt.setInt(3, startNo);
				pstmt.setInt(4, endNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo2 = new InqueryVo();
					vo2.setqNum(rs.getInt("Q_NO"));
					vo2.setqTitle(rs.getString("Q_TITLE"));
					vo2.setqContent(rs.getString("Q_CONTENT"));
					vo2.setCreateDate(rs.getTimestamp("Q_CREATE"));
					vo2.setqResponse(rs.getString("Q_RESPONSE"));
					
					list.add(vo2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
}
