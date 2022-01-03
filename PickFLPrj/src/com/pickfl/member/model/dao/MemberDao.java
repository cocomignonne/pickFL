package com.pickfl.member.model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.pickfl.common.JDBCTemplate.*;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.member.model.vo.PaylistVo;

public class MemberDao {
	
	private String encrypt(String pwd) {
		// 패스워드 암호화
			MessageDigest md;
			StringBuilder sb = new StringBuilder();
			try {
				md = MessageDigest.getInstance("SHA-512");
				md.update(pwd.getBytes());
				byte[] digest = md.digest();
				sb = new StringBuilder();
				for(byte b : digest) {
					sb.append(String.format("%02x", b));
				}
					
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			return sb.toString();
				
	}

// 회원가입쿼리
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		
		String sql = "INSERT INTO MEMBER(MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_JOIN_DATE)"
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
	
	
//	이메일 중복확인
	public int selectMemberEmail(Connection conn, String email) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
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

//	로그인할 때 디비에 있는 횐정 조회
	public MemberVo selectDBMember(Connection conn, MemberVo m) {
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
				
				selectedMember = new MemberVo();
				
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setEmail(email);;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return selectedMember;
	}

	public MemberVo selectdbInfo(Connection conn, MemberVo selectIdInfo) {
		String sql = "SELECT MEMBER_ID, MEMBER_NAME, MEMBER_EMAIL FROM MEMBER WHERE MEMBER_NAME = ? AND MEMBER_EMAIL = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo dbInfo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectIdInfo.getName());
			pstmt.setString(2, selectIdInfo.getEmail());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("MEMBER_ID");
				String name = rs.getString("MEMBER_NAME");
				String email = rs.getString("MEMBER_EMAIL");
				
				dbInfo = new MemberVo();
				
				dbInfo.setId(id);
				dbInfo.setName(name);
				dbInfo.setEmail(email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return dbInfo;
	}

	
	
//	아이디 이름 이메일로 정보를 찾아서 임시비밀번호 전달 (회원번호 + 생년월일 + 난수2자리)
	public MemberVo selectdbPwdInfo(Connection conn, MemberVo selectPwdInfo) {
		String sql = "SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, MEMBER_EMAIL, MEMBER_BIRTH FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_NAME = ? AND MEMBER_EMAIL = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo dbInfo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectPwdInfo.getId());
			pstmt.setString(2, selectPwdInfo.getName());
			pstmt.setString(3, selectPwdInfo.getEmail());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String no = rs.getString("MEMBER_NO");
				String id = rs.getString("MEMBER_ID");
				String name = rs.getString("MEMBER_NAME");
				String email = rs.getString("MEMBER_EMAIL");
				String birth = rs.getString("MEMBER_BIRTH");
				String random = randomNum();
				String pwd = no + birth + random;
				System.out.println(pwd);
				dbInfo = new MemberVo();
				
				dbInfo.setId(id);
				dbInfo.setPwd(pwd);
				dbInfo.setName(name);
				dbInfo.setEmail(email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return dbInfo;
	}
	
	public static String randomNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i <= 2; i++) {
			int num = (int)(Math.random()*9 + 1);
			buffer.append(num);
		}
		return buffer.toString();
	}

//	생성한 임시비밀번호 db에 저장
	public void updatePWD(Connection conn, MemberVo dbInfo) {

		String sql2 = "UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ? AND MEMBER_NAME = ? AND MEMBER_EMAIL = ?";
		PreparedStatement pstmt = null;

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql2);

			pstmt.setString(1, encrypt(dbInfo.getPwd()));
			pstmt.setString(2, dbInfo.getId());
			pstmt.setString(3, dbInfo.getName());
			pstmt.setString(4, dbInfo.getEmail());

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
	}
	
	public List<MemberVo> selectAllMember(Connection conn) {
		List<MemberVo> list = new ArrayList<MemberVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("MEMBER_ID");
				int gradeNo = rs.getInt("GRADE_NO");
				String birth = rs.getString("MEMBER_BIRTH");
				Timestamp joinDate = rs.getTimestamp("MEMBER_JOIN_DATE");
				String quit_Yn = rs.getString("MEMBER_QUIT_YN");
				
				MemberVo vo = new MemberVo();

				vo.setMemberNo(memberNo);
				vo.setId(id);
				vo.setGradeNo(gradeNo);
				vo.setBirth(birth);
				vo.setJoinDate(joinDate);
				vo.setQuitYN(quit_Yn);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public MemberVo selectMember(Connection conn, MemberVo vo, String memberNum) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("MEMBER_ID");
				String pwd = rs.getString("MEMBER_PWD");
				String name = rs.getString("MEMBER_NAME");
				String email = rs.getString("MEMBER_EMAIL");
				String birth = rs.getString("MEMBER_BIRTH");
				String quit_Yn = rs.getString("MEMBER_QUIT_YN");
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setBirth(birth);
				vo.setQuitYN(quit_Yn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}

	public void updateMember(Connection conn, MemberVo vo) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET MEMBER_ID = ?, MEMBER_PWD=?, MEMBER_NAME=?,"
				+ "MEMBER_EMAIL=?, MEMBER_BIRTH =?, MEMBER_QUIT_YN=? WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getQuitYN());
			pstmt.setInt(7, vo.getMemberNo());
			
			pstmt.executeUpdate(); // 현재 업데이트 안됨;
			
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
		}
	
	}

	public List<PaylistVo> selectPaylist(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ?";
		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberNum);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				String id = rs.getString("MEMBER_ID");
//				String pwd = rs.getString("MEMBER_PWD");
//				String name = rs.getString("MEMBER_NAME");
//				String email = rs.getString("MEMBER_EMAIL");
//				String birth = rs.getString("MEMBER_BIRTH");
//				String quit_Yn = rs.getString("MEMBER_QUIT_YN");
//				
//				vo.setId(id);
//				vo.setPwd(pwd);
//				vo.setName(name);
//				vo.setEmail(email);
//				vo.setBirth(birth);
//				vo.setQuitYN(quit_Yn);
//			}
		return null;
	}
}
