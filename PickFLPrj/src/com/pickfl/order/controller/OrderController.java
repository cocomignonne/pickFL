package com.pickfl.order.controller;

import static com.pickfl.common.JDBCTemplate.commit;
import static com.pickfl.common.JDBCTemplate.rollback;

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
import com.pickfl.deliveryM.model.vo.DeliveryMVo;
import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.order.model.service.OrderService;
import com.pickfl.order.model.vo.OrderVo;

@WebServlet("/order")
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		MemberVo currentUser = (MemberVo) req.getSession().getAttribute("loginUser");
		CartVo cartVo = new CartVo();
		int totalPrice = (int) req.getSession().getAttribute("totalCartPrice");
		
		int point = currentUser.getPoint();
		int addPoint = 0;
		
		if(currentUser.getGradeNo() == 100) {
			addPoint = (int) (totalPrice * 0.01);
		} else if(currentUser.getGradeNo() == 200) {
			addPoint = (int) (totalPrice * 0.05);
		}
		req.getSession().setAttribute("totalPrice", totalPrice);
		req.getSession().setAttribute("addPoint", addPoint);
		System.out.println("order"+totalPrice);
		System.out.println("order"+addPoint);
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
		
		if(result1 > 0 && result2 > 0) {
			
//			현재 포인트
			int currPoint = currentUser.getPoint();
//			이번 주문의 포인트
			int addPoint = 0;
//			적립된 포인트
//			int totalPoint = currPoint + addPoint;
//			현재 누적금액
			int orderSumPrice = currentUser.getOrderPriceSum();
//			이번 주문금액
//			int totalCartPrice;
//			주문 후 누적구매금액
//			int totalOderSumPrice = orderSumPrice + totalCartPrice;
			
			
			
			if(currentUser.getGradeNo() == 100) {
				addPoint = (int) (totalCartPrice * 0.01);
				int totalPoint = currPoint + addPoint;
				int totalOderSumPrice = orderSumPrice + totalCartPrice;
				int result = 0;
				result = new MemberService().updatePoint(totalPoint, totalOderSumPrice, memNo);
				if(result > 0) {
					System.out.println("적립성공");

					if(currentUser.getOrderPriceSum() >= 200000) {
						int resultgrade = 0;
						resultgrade = new MemberService().updateGradeNo(memNo);
					}
				} else {
					System.out.println("적립실패");
				}
			} else if(currentUser.getGradeNo() == 200) {
				addPoint = (int) (totalCartPrice * 0.05);
				int totalPoint = currPoint + addPoint;
				int totalOderSumPrice = orderSumPrice + totalCartPrice;
				int result = 0;
				result = new MemberService().updatePoint(totalPoint, totalOderSumPrice, memNo);
				if(result > 0) {
					System.out.println("적립성공");					
				} else {
					System.out.println("적립실패");
				}
				
			}
			
			
			
			req.setAttribute("addPoint", addPoint);
			req.setAttribute("totalCartPrice", totalCartPrice);
			req.setAttribute("msg", "주문완료");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
//		카트비우기
			result3 =  new CartService().deleteAllCart();
		} else {
			req.setAttribute("msg", "주문실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
}
