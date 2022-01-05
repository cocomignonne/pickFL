package com.pickfl.cart.conroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.cart.model.service.CartService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/deleteAllCart")
public class DeleteAllCartController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int result = new CartService().deleteAllCart();
		
		if(result > 0) {
			req.setAttribute("msg", "장바구니가 비었습니다.");
				
			req.getRequestDispatcher("/WEB-INF/views/common/successPage.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "장바구니 비우기를 실패했습니다.");
			
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
