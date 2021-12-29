package com.pickfl.products.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	public List<ProductVo> search(String searchName) {

		Connection conn = getConnection();
		
		List<ProductVo> productList = null;
		if(searchName == null) {
			try {
				productList = selectProductAll(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
		}else {
			try {
				productList = selectProduct(conn, searchName);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
		}
		
		return productList;
	}

	private List<ProductVo> selectProduct(Connection conn, String searchName) throws SQLException {
		return new ProductDao().searchByName(conn, searchName);
	}

	private List<ProductVo> selectProductAll(Connection conn) throws SQLException {
		return new ProductDao().selectProductAll(conn);
	}

	public ProductVo selectProductByNo(int product_no) {
		
		Connection conn = getConnection();
		ProductVo p = null;
		try {
			p = new ProductDao().selectByNo(conn, product_no);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(conn);
		}
		return p;
	}

	public int deleteProduct(int product_no) {
		
		Connection conn = getConnection();
		int result = 0;
		try {
			result = new ProductDao().deleteProduct(conn, product_no);
			if(result > 0 ) commit(conn);
			else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {			
			close(conn);
		}
		
		return result;
	}

	public List<ProductVo> searchByColor(String product_color) {
		
		Connection conn = getConnection();
		
		List<ProductVo> productList = null;

		try {
			productList = new ProductDao().selectByColor(conn, product_color);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		return productList;

	}

}