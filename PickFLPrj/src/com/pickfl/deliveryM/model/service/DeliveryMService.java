package com.pickfl.deliveryM.model.service;

import java.sql.Connection;
import java.util.List;

import com.pickfl.deliveryM.model.dao.DeliveryMDao;
import com.pickfl.deliveryM.model.vo.DeliveryMVo;
import static com.pickfl.common.JDBCTemplate.*;

public class DeliveryMService {

	public List<DeliveryMVo> selectDeliveryList() {
		Connection conn = getConnection();
		
		List<DeliveryMVo> deliveryList = new DeliveryMDao().selectDeliveryInfo(conn);
		
		close(conn);
		
		return deliveryList;
	}

	public int updateDS(DeliveryMVo ds) {
		Connection conn = getConnection();
		
		int result = new DeliveryMService().updateDSQuery(conn, ds);
		
		close(conn);

		return result;
	}

	private int updateDSQuery(Connection conn, DeliveryMVo ds) {
		return new DeliveryMDao().updateDSQuery(conn, ds);
	}

}
