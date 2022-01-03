package com.pickfl.cart.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.cart.model.dao.CartDao;
import com.pickfl.cart.model.vo.CartVo;
import com.pickfl.deliveryM.model.dao.DeliveryMDao;
import static com.pickfl.common.JDBCTemplate.*;

public class CartService {

	public List<CartVo> selectCartList(int currentUserMemNo) {
		Connection conn = getConnection();
		
		List<CartVo> cartInfoList = CartService.selectCartInfo(conn, currentUserMemNo);
		
		
		close(conn);
		
		
		return cartInfoList;
	}

	private static List<CartVo> selectCartInfo(Connection conn, int currentUserMemNo) {
		
		return new CartDao().selectCartInfo(conn, currentUserMemNo);
	}
	
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
