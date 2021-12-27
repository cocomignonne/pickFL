package com.pickfl.products.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import static com.pickfl.common.JDBCTemplate.*;

import com.pickfl.products.model.dao.ProductDao;
import com.pickfl.products.model.vo.ProductVo;

public class ProductService {

	public int add(ProductVo p) {
		
		Connection conn = getConnection();
		
		int result = -1;
		
		try {
			result = new ProductDao().addProduct(conn, p);
			if(result > 0 ) commit(conn);
			else rollback(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		
		close(conn);
		return result;
	}

	public int dupCheck(String product_name) {
		
		Connection conn = getConnection();
		int result = 0;
		try {
			result = selectProductByName(conn, product_name);
		} catch (SQLException e) {
			close(conn);
		}
		
		return result;
	}

	private int selectProductByName(Connection conn, String product_name) throws SQLException {
		return new ProductDao().selectByName(conn, product_name);
	}

}