package com.pickfl.inquery.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.pickfl.inquery.model.dao.InqueryResponseMDao;
import com.pickfl.inquery.model.vo.InqueryResponseVo;

public class InqueryResponseMService {

	public static void inqueryResponse(InqueryResponseVo vo) {
		Connection conn = getConnection();
		insertResponse(conn, vo);
		close(conn);
	}

	private static void insertResponse(Connection conn, InqueryResponseVo vo) {
		new InqueryResponseMDao().insertResponse(conn, vo);
	}

}
