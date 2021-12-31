package com.pickfl.inquery.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.pickfl.inquery.model.dao.InqueryDao;
import com.pickfl.inquery.model.dao.InquerySearchDao;
import com.pickfl.inquery.model.dao.InquerySearchMDao;
import com.pickfl.inquery.model.vo.InquerySearchVo;
import com.pickfl.inquery.model.vo.InqueryVo;



public class InquerySearchMService {
	public List<InqueryVo> search(InquerySearchVo vo) {
		Connection conn = getConnection();
		List<InqueryVo> list;
		list = selectInqueryMSearch(conn, vo);
		close(conn);
		
		return list;
	}

	private List<InqueryVo> selectInqueryMSearch(Connection conn, InquerySearchVo vo) {
		return new InquerySearchMDao().selectInqueryMList(conn,vo);
	}

	public int memberCountPage(String user, String type) {
		Connection conn = getConnection();
		int result= allMemberPage(conn, user, type);
		close(conn);
		
		return result;
	}

	private int allMemberPage(Connection conn, String user, String type) {
		return new InquerySearchDao().allMemberPage(conn, user, type);
	}

	public int maxCountPage(String type) {
		Connection conn = getConnection();
		int result= allInfoPage(conn, type);
		close(conn);
		
		return result;
	}
	

	private int allInfoPage(Connection conn, String type) {
		return new InquerySearchDao().allInfoPage(conn, type);
	}

}
