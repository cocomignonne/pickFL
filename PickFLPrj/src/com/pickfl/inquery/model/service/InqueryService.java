package com.pickfl.inquery.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pickfl.inquery.model.dao.InqueryDao;
import com.pickfl.inquery.model.vo.InqueryVo;
import static com.pickfl.common.JDBCTemplate.*;

public class InqueryService {

	public void InqueryWrite(InqueryVo vo) {
		Connection conn = getConnection();
		inqueryInsert(conn, vo);
		close(conn);
	}

	private void inqueryInsert(Connection conn, InqueryVo vo) {
		new InqueryDao().insertInquery(conn, vo);
	}
}
