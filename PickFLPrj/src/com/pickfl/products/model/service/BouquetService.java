package com.pickfl.products.model.service;

import static com.pickfl.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;

import com.pickfl.products.model.dao.BouquetDao;
import com.pickfl.products.model.vo.BouquetVo;

public class BouquetService {

	public int add(Connection conn, BouquetVo b) throws SQLException {
		int result = 0;
		result = new BouquetDao().add(conn, b);
		System.out.println("add result : " + result);
		return result;
	}

	public int getCurrBqNo(BouquetVo b) {
		int bouquetNo = 0;
		Connection conn = getConnection();
		
		try {
			if(add(conn, b) > 0) {
				bouquetNo = new BouquetDao().getCurrBqNo(conn);
			}else {
				rollback(conn);
			}
			
			if(bouquetNo > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return bouquetNo;
	}

	public String getName(int bouquetNo) {
		Connection conn = getConnection();
		String name = "";
		
		try {
			name = new BouquetDao().getName(conn, bouquetNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return name;
	}

}
