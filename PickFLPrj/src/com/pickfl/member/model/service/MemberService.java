package com.pickfl.member.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.commit;
import static com.pickfl.common.JDBCTemplate.getConnection;
import static com.pickfl.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import com.pickfl.member.model.dao.MemberDao;
import com.pickfl.member.model.vo.MemberVo;

public class MemberService {
	
//	회원가입
	public int join(MemberVo m) {

		
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
	public MemberVo login(MemberVo m) {
		Connection conn = getConnection();
		
		MemberVo selectedMember = selectMember(conn, m);
		
		close(conn);
		
		if(selectedMember.getPwd().equals(m.getPwd())) {
			return selectedMember;
		} else {
			return null;
		}
	}

	private MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn, m);
	}

}
