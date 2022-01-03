package com.pickfl.products.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.products.model.dao.CurrentFlowerDao;
import com.pickfl.products.model.vo.CurrentFlowerVo;

import static com.pickfl.common.JDBCTemplate.*;

public class CurrentFlowerService {

	public int add(CurrentFlowerVo cf) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new CurrentFlowerDao().add(conn, cf);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	public List<CurrentFlowerVo> selectAll(int memberNo) {
		Connection conn = getConnection();
		List<CurrentFlowerVo> list = null;
		
		try {
			list = new CurrentFlowerDao().selectAll(conn, memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return list;
	}

	public int deleteByNo(int productNo) {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new CurrentFlowerDao().deleteByNo(conn, productNo);
			if(result >0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}

	public int deleteAll(int memberNo) {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = new CurrentFlowerDao().deleteAll(conn, memberNo);
			if(result >0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}

}
