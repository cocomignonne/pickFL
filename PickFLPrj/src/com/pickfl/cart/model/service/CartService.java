package com.pickfl.cart.model.service;

import static com.pickfl.common.JDBCTemplate.close;
import static com.pickfl.common.JDBCTemplate.getConnection;

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

	
	public int updateCartBQNum(int changedNum, int memNo, String bqName) {
		Connection conn = getConnection();
		
		int result = updateCartBQNum(conn, changedNum, memNo, bqName);
		
		close(conn);

		return result;
		
	}

	private int updateCartBQNum(Connection conn, int changedNum, int memNo, String bqName) {
		return new CartDao().updateCartBQNum(conn, changedNum, memNo, bqName);
	}

	public int deleteCartBQ(String bqDetail, int memNo, String bqName) {
		Connection conn = getConnection();
		
		int result = deleteBQ(conn, bqDetail, memNo, bqName);
		
		close(conn);

		return result;
	}

	private int deleteBQ(Connection conn, String bqDetail, int memNo, String bqName) {
		return new CartDao().deleteBQ(conn, bqDetail, memNo, bqName);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
