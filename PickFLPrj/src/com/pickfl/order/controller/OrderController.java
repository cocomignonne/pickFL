package com.pickfl.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.cart.model.service.CartService;
import com.pickfl.cart.model.vo.CartVo;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.order.model.service.OrderService;
import com.pickfl.order.model.vo.OrderVo;

@WebServlet("/order")
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		MemberVo currentUser = (MemberVo) req.getSession().getAttribute("loginUser");
		CartVo cartVo = new CartVo();
		int totalPrice = cartVo.getTotalCartPrice();
		
		int point = currentUser.getPoint();
		
		System.out.println(point);
		System.out.println(totalPrice);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("point", point);
		req.getRequestDispatcher("/WEB-INF/views/order/order.jsp").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo currentUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int memNo = currentUser.getMemberNo();
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		List<CartVo> cartList = new CartService().selectCartList(memNo);
		
		int totalCartPrice = 0;
		int totalPNum = 0;
		
		for (CartVo cartVo : cartList) {
			totalCartPrice += cartVo.getBouquetTotalPrice();
		}

		for (CartVo cartVo : cartList) {
			totalPNum += cartVo.getBuyNumBQ();
		}

		
		String gotName = req.getParameter("getName");
		String gotPhone = req.getParameter("phoneNum");
		String address1 = req.getParameter("postcode");
		String address2 = req.getParameter("address");
		String address3 = req.getParameter("detailAddress");
		
		
		OrderVo orderVo = new OrderVo();
		
		orderVo.setGotName(gotName);
		orderVo.setGotPhone(gotPhone);
		orderVo.setAddress1(address1);
		orderVo.setAddress2(address2);
		orderVo.setAddress3(address3);
		
//		ORDERList
		result1 = new OrderService().insertOrder(orderVo, memNo);
		
//		ORDERDetail
		for (CartVo cartVo : cartList) {
			
			result2 = new OrderService().insertOrderDetail(cartVo, memNo);
		}
		
		result3 = new OrderService().deleteCartAll();
		
		if(result1 > 0 && result2 > 0) {
			req.setAttribute("msg", "주문완료");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "주문실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
