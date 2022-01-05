package com.pickfl.order.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.commit;
import static com.pickfl.common.JDBCTemplate.getConnection;
import static com.pickfl.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pickfl.cart.model.vo.CartVo;
import com.pickfl.order.model.dao.OrderDao;
import com.pickfl.order.model.vo.OrderVo;

public class OrderService {

	public int insertOrder(OrderVo orderVo, int memNo) {
		Connection conn = getConnection();
		int result1 = 0;
		
		result1 = insertOrderDB(conn, orderVo, memNo);
		
		if (result1 > 0) {
			commit(conn);
		} else {	
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}
	
	private int insertOrderDB(Connection conn, OrderVo orderVo, int memNo) {
		return new OrderDao().insertOrderDB(conn, orderVo, memNo);
	}
	
	public int insertOrderDetail(CartVo cartVo, int memNo) {
		Connection conn = getConnection();
		int result2 = 0;
//		내가 지금 주문한 주문번호 받아오기
		int orderNo = new OrderDao().selectOrderNo(conn,cartVo, memNo);
		
		
		result2 = insertOrderDetailDB(conn, cartVo, memNo, orderNo);
		
		if (result2 > 0) {
			commit(conn);
		} else {	
			rollback(conn);
		}
			
			close(conn);
			
		return result2;
		
	}

	private int insertOrderDetailDB(Connection conn, CartVo cartVo, int memNo, int orderNo) {
		return new OrderDao().insertOrderDetailDB(conn, cartVo, memNo, orderNo);
	}


}
