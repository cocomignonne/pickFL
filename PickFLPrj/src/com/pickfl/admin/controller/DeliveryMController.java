package com.pickfl.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.deliveryM.model.service.DeliveryMService;
import com.pickfl.deliveryM.model.vo.DeliveryMVo;

@WebServlet("/deliveryM")
public class DeliveryMController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<DeliveryMVo> deliveryList = new DeliveryMService().selectDeliveryList();
		
		req.setAttribute("data", deliveryList);
		req.getRequestDispatcher("/WEB-INF/views/admin/deliveryM.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deliveryStateChange = req.getParameter("delivery-status-change");
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		
		DeliveryMVo ds = new DeliveryMVo();
		
		ds.setDeliveryState(deliveryStateChange);
		ds.setOrderNo(orderNo);
		
		
		int result = new DeliveryMService().updateDS(ds);
		
		if(result > 0) {
			req.setAttribute("msg", "배송상태가 변경되었습니다.");
			req.getRequestDispatcher("WEB-INF/views/common/successPageM.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "배송상태가 변경되지 않았습니다");
			req.getRequestDispatcher("WEB-INF/views/common/errorPageM.jsp").forward(req, resp);
		}
		
	}
	
}












