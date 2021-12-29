package com.pickfl.inquery.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import java.util.List;

import com.pickfl.inquery.model.dao.InquerySearchDao;
import com.pickfl.inquery.model.vo.InquerySearchVo;


public class InquerySearchService {
	public List<InquerySearchVo> search(InquerySearchVo vo) {
		Connection conn = getConnection();
		List<InquerySearchVo> list;
		list = selectInquerySearch(conn, vo);
		close(conn);
		
		return list;
	}

	private List<InquerySearchVo> selectInquerySearch(Connection conn, InquerySearchVo vo) {
		return new InquerySearchDao().selectInqueryList(conn,vo);
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
