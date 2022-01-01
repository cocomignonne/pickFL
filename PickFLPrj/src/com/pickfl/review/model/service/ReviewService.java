package com.pickfl.review.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	public boolean checkCompleted(int orderNo) {
		
		
		
		return false;
	}

}
