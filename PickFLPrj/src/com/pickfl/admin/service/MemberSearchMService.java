package com.pickfl.admin.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.pickfl.admin.dao.MemberSearchMDao;

public class MemberSearchMService {

	public int maxCountPage() {
		Connection conn = getConnection();
		int result= allMemberCount(conn);
		close(conn);
		
		return result;
	}

	private int allMemberCount(Connection conn) {
		return new MemberSearchMDao().allMemberCount(conn);
	}

	public int maxCountPage(String id) {
		Connection conn = getConnection();
		int result= allMemberCount(conn, id);
		close(conn);
		
		return result;
	}

	private int allMemberCount(Connection conn, String id) {
		return new MemberSearchMDao().allMemberCount(conn, id);
	}

}
