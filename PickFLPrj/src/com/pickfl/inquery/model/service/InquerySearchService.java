package com.pickfl.inquery.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import java.util.List;

import com.pickfl.inquery.model.dao.InquerySearchDao;
import com.pickfl.inquery.model.vo.InquerySearchVo;
import com.pickfl.inquery.model.vo.InqueryVo;


public class InquerySearchService {
	public List<InqueryVo> search(InquerySearchVo vo) {
		Connection conn = getConnection();
		List<InqueryVo> list;
		list = selectInquerySearch(conn, vo);
		close(conn);
		
		return list;
	}

	private List<InqueryVo> selectInquerySearch(Connection conn, InquerySearchVo vo) {
		return new InquerySearchDao().selectInqueryList(conn,vo);
	}

	public int memberCountPage(int memberNo, String type) {
		Connection conn = getConnection();
		int result= allMemberPage(conn, memberNo, type);
		close(conn);
		
		return result;
	}

	private int allMemberPage(Connection conn, int memberNo, String type) {
		return new InquerySearchDao().allMemberPage(conn, memberNo, type);
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
