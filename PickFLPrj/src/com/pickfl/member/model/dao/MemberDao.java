package com.pickfl.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.pickfl.common.JDBCTemplate.*;
import com.pickfl.member.model.vo.MemberVo;

public class MemberDao {

// 회원가입쿼리
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		
		String sql = "INSERT INTO MEMBER(MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_JOIN_DATE) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getBirth());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

//	아이디 중복확인
	public int selectMemberId(Connection conn, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
			
		return result;
	}

//	로그인
	public MemberVo selectMember(Connection conn, MemberVo m) {
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 
		MemberVo selectedMember = null; 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("MEMBER_ID");
				String pwd = rs.getString("MEMBER_PWD");
				String name = rs.getString("MEMBER_NAME");
				String email = rs.getString("MEMBER_EMAIL");
				String birth = rs.getString("MEMBER_BIRTH");
				Timestamp joinDate = rs.getTimestamp("MEMBER_JOIN_DATE");
				String role = rs.getString("MEMBER_ROLE");
				
				selectedMember = new MemberVo();
				
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setEmail(email);
				selectedMember.setBirth(birth);
				selectedMember.setJoinDate(joinDate);
				selectedMember.setRole(role);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return selectedMember;
	}
	
	
}
