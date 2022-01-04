package com.pickfl.cart.conroller;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		if (currentUser != null) {
			int currentUserMemNo = currentUser.getMemberNo();
			
			List<CartVo> cartList = new CartService().selectCartList(currentUserMemNo);
			
			int totalCartPrice = 0;
			int totalPNum = 0;
			
			for (CartVo cartVo : cartList) {
				totalCartPrice += cartVo.getBouquetTotalPrice();
			}

			for (CartVo cartVo : cartList) {
				totalPNum += cartVo.getBuyNumBQ();
			}
			
			
			CartVo cartVo = new CartVo();
			cartVo.setTotalCartPrice(totalCartPrice);
			cartVo.setTotalPNum(totalPNum);
			
			
			req.setAttribute("totalPNum", totalPNum);
			req.setAttribute("totalCartPrice", totalCartPrice);
			
			req.setAttribute("cart", cartList);
			
			req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "로그인 먼저 해주세요.");
			
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
	}
	
	
	
	
	
	
	
	
	
}
