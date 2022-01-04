package com.pickfl.review.model.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.pickfl.common.JDBCTemplate.*;

import com.pickfl.order.model.dao.OrderDao;
import com.pickfl.review.model.dao.ReviewDao;
import com.pickfl.review.model.vo.ReviewVo;

public class ReviewService {

	public List<ReviewVo> selectAll() {
		List<ReviewVo> list = null;
		
		Connection conn = getConnection();
		try {
			list = new ReviewDao().selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(conn);
		}
		
		return list;
	}

	public ReviewVo selectByNo(int no) {
		ReviewVo r = null;
		Connection conn = getConnection();
		
		try {
			r = new ReviewDao().selectByNo(conn, no);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return r;
	}

	public String getMemberId(int orderNo) {
		String result = "";
		Connection conn = getConnection();
		
		try {
			result = new OrderDao().getMemberId(conn, orderNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	public Map<Integer, String> getBqMap(int memberNo) {
		Connection conn = getConnection();
		Map<Integer, String> map = null;
		
		try {
			List<Integer> bqNo = getBqNoByMemberNo(conn, memberNo);
			if(bqNo != null) {
				
				map = new ReviewDao().getBqMap(conn, bqNo);
				
			}else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private List<Integer> getBqNoByMemberNo(Connection conn, int memberNo) throws SQLException {
		return new ReviewDao().getBqNoByMemberNo(conn, memberNo);
	}

	public int add(ReviewVo r) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new ReviewDao().add(conn, r);
			if(result > 0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	

}
