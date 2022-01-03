package com.pickfl.cart.conroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.cart.model.service.CartService;
import com.pickfl.cart.model.vo.CartVo;
import com.pickfl.member.model.vo.MemberVo;



@WebServlet("/cart")
public class CartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo currentUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int currentUserMemNo = currentUser.getMemberNo();
		
		List<CartVo> deliveryList = new CartService().selectCartList(currentUserMemNo);
		req.setAttribute("cart", deliveryList);
		req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
	}
	
	
	
	
	
	
	
	
	
}
