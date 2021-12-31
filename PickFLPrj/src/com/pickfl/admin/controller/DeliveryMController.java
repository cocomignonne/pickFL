package com.pickfl.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pickfl.deliveryM.model.service.DeliveryMService;
import com.pickfl.deliveryM.model.vo.DeliveryMVo;

@WebServlet("/deliveryM")
public class DeliveryMController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 배송상태 변경를 위한 데이터를 조회한다
		List<DeliveryMVo> deliveryList = new DeliveryMService().selectDeliveryList();
		// 조회한 데이터를 view로 보냄
		req.setAttribute("data", deliveryList);
		req.getRequestDispatcher("/WEB-INF/views/admin/deliveryM.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession(); 
		 String deliveryStateChange = (String)req.getSession().getAttribute("delivery-status-change"); 
		 int orderNo = (int)req.getSession().getAttribute("orderNo"); 
		 int memberNo = (int)req.getSession().getAttribute("memberNo");
		 
//		 System.out.println(deliveryState);
		
//		 String deliveryStateChange = req.getParameter("delivery-status-change"); 
//		 int orderNo = Integer.parseInt(req.getParameter("orderNo")); 
//		 int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		 
		 System.out.println(deliveryStateChange);
		
		DeliveryMVo ds = new DeliveryMVo();
		
		ds.setMemberNo(memberNo);
		ds.setOrderNo(orderNo);
		ds.setDeliveryState(deliveryStateChange);
		
		
		int result = new DeliveryMService().updateDS(ds);
		
		if(result > 0) {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('배송상태가 변경되었습니다.'); location.href='deliveryM';</script>");
			 
			out.flush();
			session.invalidate();
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('배송상태가 변경되지 않았습니다.'); location.href='deliveryM';</script>");
			 
			out.flush();
			session.invalidate();
		}
		
	}
	
}












