package com.pickfl.inquery.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.pickfl.inquery.model.dao.InqueryMDao;
import com.pickfl.inquery.model.vo.InqueryVo;

public class InqueryMService {
	public void InqueryWrite(InqueryVo vo) {
		Connection conn = getConnection();
		inqueryMInsert(conn, vo);
		close(conn);
	}

	private void inqueryMInsert(Connection conn, InqueryVo vo) {
		new InqueryMDao().insertInquery(conn, vo);
	}

	public InqueryVo searchMContent(InqueryVo vo) {
		Connection conn = getConnection();
		vo = inqueryMContent(conn,vo);
		close(conn);
		return vo;
	}

	private InqueryVo inqueryMContent(Connection conn, InqueryVo vo) {
		return new InqueryMDao().searchInquery(conn, vo);
	}
}
