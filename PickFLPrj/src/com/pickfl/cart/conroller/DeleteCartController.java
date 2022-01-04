package com.pickfl.cart.conroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.cart.model.service.CartService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/deleteCart")
public class DeleteCartController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bqDetail = req.getParameter("bqDetail");
		String bqName = req.getParameter("bqName");
		MemberVo user = (MemberVo) req.getSession().getAttribute("loginUser");
		
		int memNo = user.getMemberNo();
		
		int result = new CartService().deleteCartBQ(bqDetail, memNo, bqName);
		
		if(result > 0) {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('상품이 삭제되었습니다.'); location.href='cart';</script>");
			 
			out.flush();
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = resp.getWriter();
			 
			out.println("<script>alert('상품이 삭제되지 않았습니다.'); location.href='cart';</script>");
			 
			out.flush();
		}
	}
}
