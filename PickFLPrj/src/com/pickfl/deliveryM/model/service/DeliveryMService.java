package com.pickfl.deliveryM.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pickfl.deliveryM.model.dao.DeliveryMDao;
import com.pickfl.deliveryM.model.vo.DeliveryMVo;
import static com.pickfl.common.JDBCTemplate.*;

public class DeliveryMService {

	public List<DeliveryMVo> selectDeliveryList() {
//		데이터 조회를 위해 커넥션 가져오기
		Connection conn = getConnection();
		
		List<DeliveryMVo> deliveryList = new DeliveryMDao().selectDeliveryInfo(conn);
		
		close(conn);
		
		return deliveryList;
	}

	public int updateDS(DeliveryMVo ds) {
		Connection conn = getConnection();
		int result = 0;
		List<DeliveryMVo> selectInfoList = new DeliveryMDao().selectInfo(conn);  // db에 저장된 목록들

		for(DeliveryMVo orderNoDB : selectInfoList) {
			if(ds.getOrderNo() == orderNoDB.getOrderNo()) {
				result = new DeliveryMService().updateDSQuery(conn, ds, selectInfoList);
			} 
		}
		close(conn);

		return result;
		
	}

	private int updateDSQuery(Connection conn, DeliveryMVo ds, List<DeliveryMVo> selectInfoList) {
		return new DeliveryMDao().updateDSQuery(conn, ds, selectInfoList);
	}

}
