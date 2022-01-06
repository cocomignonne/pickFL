package com.pickfl.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import com.pickfl.deliveryM.model.service.DeliveryMService;
import com.pickfl.deliveryM.model.vo.DeliveryMVo;
import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

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
		
		String orderNo = req.getParameter("orderNoVal");
		String memberNo = req.getParameter("memberNoVal");
		String deliveryStatusChange = req.getParameter("deliveryStatusChangeVal");
		
		System.out.println(orderNo);
		System.out.println(memberNo);
		System.out.println(deliveryStatusChange);
		
		DeliveryMVo ds = new DeliveryMVo();
		
		ds.setMemberNo(Integer.parseInt(memberNo));
		ds.setOrderNo(Integer.parseInt(orderNo));
		ds.setDeliveryState(deliveryStatusChange);
		
		
		int result = new DeliveryMService().updateDS(ds);
		
		if(result > 0) {
			
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('배송상태가 변경되었습니다.'); location.href='deliveryM';</script>");
			 
			out.flush();
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('배송상태가 변경되지 않았습니다.'); location.href='deliveryM';</script>");
			 
			out.flush();
		}
		
	}
	
}












