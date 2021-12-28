package com.pickfl.inquery.model.service;

import java.sql.Connection;
import java.util.List;

import com.pickfl.inquery.model.dao.InqueryDao;
import com.pickfl.inquery.model.vo.InqueryVo;
import static com.pickfl.common.JDBCTemplate.*;

public class InqueryService {

	public List<InqueryVo> search(String type, String value, String currentPage) {
		
		return null;
	}

	public int maxcount() {
		Connection conn = getConnection();
		int result= AllPage(conn);
		close(conn);
		
		return result;
	}

	private int AllPage(Connection conn) {
		return new InqueryDao().Allpage(conn);
	}

}
