package com.pickfl.deliveryM.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pickfl.deliveryM.model.vo.DeliveryMVo;
import com.pickfl.member.model.vo.MemberVo;

import static com.pickfl.common.JDBCTemplate.*;

public class DeliveryMDao {

	public List<DeliveryMVo> selectDeliveryInfo(Connection conn) {
		List<DeliveryMVo> deliveryList = new ArrayList<DeliveryMVo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ORDERLIST ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int orderNo = rs.getInt("ORDER_NO");
				int membrNo = rs.getInt("MEMBER_NO");
				String deliveryState = rs.getString("DELIVERY_STATE");
				
				DeliveryMVo d = new DeliveryMVo();
				
				d.setOrderNo(orderNo);
				d.setMemberNo(membrNo);;
				d.setDeliveryState(deliveryState);
				
				deliveryList.add(d);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return deliveryList;
	}
	
//	배송상태 변경

	public int updateDSQuery(Connection conn, DeliveryMVo ds) {

			String sql = "UPDATE ORDERLIST SET DELIVERY_STATE = ? WHERE ORDER_NO = ?";
			PreparedStatement pstmt = null;

			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, ds.getDeliveryState());
				pstmt.setInt(2, ds.getOrderNo());;

				result = pstmt.executeUpdate();

				if(result > 0) {
					commit(conn);
				} else {
					rollback(conn);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			}finally {
				close(pstmt);
			}
			
			return result;
		}
}

