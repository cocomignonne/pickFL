package com.pickfl.review.model.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.pickfl.common.JDBCTemplate.*;

import com.pickfl.member.model.vo.MemberVo;
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

	public Map<Integer, String> getBqMap(int memberNo, String memberId) {
		Connection conn = getConnection();
		Map<Integer, String> map = null;
		
		try {
			List<Integer> bqNo = getBqNoByMemberNo(conn, memberNo, memberId);
			System.out.println("bqNo = " + bqNo.size());
				
			if(bqNo.size() != 0) {
				
				map = new ReviewDao().getBqMap(conn, bqNo);
				
			}else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	private List<Integer> getBqNoByMemberNo(Connection conn, int memberNo, String memberId) throws SQLException {
		return new ReviewDao().getBqNoByMemberNo(conn, memberNo, memberId);
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

	public int delete(int reviewNo) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new ReviewDao().delete(conn, reviewNo);
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

	public int update(ReviewVo r) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new ReviewDao().update(conn,r);
			if(result > 0 ) commit(conn);
			else rollback(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	public List<ReviewVo> selectAll(MemberVo user) {
		List<ReviewVo> list = null;
		
		Connection conn = getConnection();
		try {
			list = new ReviewDao().selectAll(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(conn);
		}
		
		return list;
	}

	public ReviewVo selectByNo(int no, MemberVo user) {
		ReviewVo r = null;
		Connection conn = getConnection();
		
		try {
			r = new ReviewDao().selectByNo(conn, no, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return r;
	}

	

}
