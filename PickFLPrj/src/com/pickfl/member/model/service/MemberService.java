package com.pickfl.member.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.commit;
import static com.pickfl.common.JDBCTemplate.getConnection;
import static com.pickfl.common.JDBCTemplate.rollback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.member.model.dao.MemberDao;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.member.model.vo.PaylistVo;

public class MemberService {
	
	private String encrypt(String pwd) {
		// 패스워드 암호화
			
//			암호화된 패스워드 = pwd.암호화;
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
	
//	회원가입
	public int join(MemberVo m) {
		m.setPwd(encrypt(m.getPwd()));
		// DB Connection 가져오기 (DB에 접근은 dao)
		Connection conn = getConnection();
		int result = 0;
		
		//  insert쿼리 날리기
		try {
			result = insertMember(conn, m);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
			
		return result;
	}

	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		int result = new MemberDao().insertMember(conn, m);
		
		return result;
	}


// 아이디 중복확인
	public int dupCheck(String id) {
		Connection conn = getConnection();
		
		int result = selectMemberById(conn, id);
		
		close(conn);
		
		return result;
	}

	private int selectMemberById(Connection conn, String id) {
		return new MemberDao().selectMemberId(conn, id);
	}

	
//	이메일 중복학인
	public int dupEmailCheck(String email) {
		Connection conn = getConnection();
		
		int result = selectMemberByEmail(conn, email);
		
		close(conn);
		
		return result;
	}

	private int selectMemberByEmail(Connection conn, String email) {
		return new MemberDao().selectMemberEmail(conn, email);
	}

//		id를가지고 비번 조회
	public MemberVo login(MemberVo loginMem) {
		Connection conn = getConnection();
		
		MemberVo DBMember = selectDBMember(conn, loginMem);
		
		close(conn);
		if(DBMember.getId().equals("admin1") || DBMember.getId().equals("admin2") || DBMember.getId().equals("admin3")) {
			if(DBMember.getPwd().equals(loginMem.getPwd())) {
				return DBMember;
			} else {
				return null;
			}
		} else {
			if(DBMember.getPwd().equals(encrypt(loginMem.getPwd()))) {
				return DBMember;
			} else {
				return null;
			}
		}
	}

	private MemberVo selectDBMember(Connection conn, MemberVo loginMem) {
		return new MemberDao().selectDBMember(conn, loginMem);
	}

	
	
//	이메일과 이름을 가지고 아이디찾기
	public MemberVo selectID(MemberVo selectIdInfo) {
		Connection conn = getConnection();
		
		MemberVo dbInfo = selectdbInfo(conn, selectIdInfo);
		
		close(conn);
		
		if(selectIdInfo.getName().equals(dbInfo.getName()) && selectIdInfo.getEmail().equals(dbInfo.getEmail())) {
			return dbInfo;
		} else {
			return null;
		}
	}

	private MemberVo selectdbInfo(Connection conn, MemberVo selectIdInfo) {
		return new MemberDao().selectdbInfo(conn, selectIdInfo);
	}

//	이메일과 이름, 아이디를 가지고 비밀번호찾기
	public MemberVo selectPWD(MemberVo selectPwdInfo) {
		Connection conn = getConnection();
		
		MemberVo dbInfo = selectdbPwdInfo(conn, selectPwdInfo);
		MemberDao md = new MemberDao();
		
		
		
		if(selectPwdInfo.getName().equals(dbInfo.getName()) && selectPwdInfo.getId().equals(dbInfo.getId()) && selectPwdInfo.getEmail().equals(dbInfo.getEmail())) {
			md.updatePWD(conn, dbInfo);
			close(conn);
			return dbInfo;
		} else {
			return null;
		}
	}

	private MemberVo selectdbPwdInfo(Connection conn, MemberVo selectPwdInfo) {
		return new MemberDao().selectdbPwdInfo(conn, selectPwdInfo);
	}

}


















