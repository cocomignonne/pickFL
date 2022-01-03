package com.pickfl.cart.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.cart.model.dao.CartDao;
import com.pickfl.cart.model.vo.CartVo;
import static com.pickfl.common.JDBCTemplate.*;

public class CartService {

	public int add(CartVo c) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = new CartDao().add(conn, c);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

}
