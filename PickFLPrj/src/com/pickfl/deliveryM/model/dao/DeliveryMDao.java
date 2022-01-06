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
		
		String sql = "SELECT * FROM ORDERLIST ORDER BY DECODE(DELIVERY_STATE, '결제완료', 1, '배송준비', 2, '배송중', 3, '배송완료', 4)";
		
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

	public int updateDSQuery(Connection conn, DeliveryMVo ds, List<DeliveryMVo> selectInfoList) {
			PreparedStatement pstmt = null;

			String sql = "UPDATE ORDERLIST SET DELIVERY_STATE = ? WHERE ORDER_NO = ? AND MEMBER_NO = ?";

			int result = 0;
			
			System.out.println(ds.getDeliveryState());
			System.out.println(ds.getOrderNo());
			
			try {
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, ds.getDeliveryState());
				pstmt.setInt(2, ds.getOrderNo());
				pstmt.setInt(3, ds.getMemberNo());

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

	public List<DeliveryMVo> selectInfo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DeliveryMVo mvoDs = null;
		
		List<DeliveryMVo> selectInfoList = new ArrayList<DeliveryMVo>();
		String query = "SELECT * FROM ORDERLIST";

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvoDs = new DeliveryMVo();
				int memberNo = rs.getInt("MEMBER_NO");
				int orderNo = rs.getInt("ORDER_NO");
				String deliveryState = rs.getString("DELIVERY_STATE");
				
				mvoDs.setMemberNo(memberNo);
				mvoDs.setOrderNo(orderNo);
				mvoDs.setDeliveryState(deliveryState);
				
			System.out.println(rs.getInt("ORDER_NO"));
			
				selectInfoList.add(mvoDs);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectInfoList;
	}
}

