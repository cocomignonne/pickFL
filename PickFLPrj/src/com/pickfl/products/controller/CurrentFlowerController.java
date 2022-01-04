package com.pickfl.products.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.pickfl.products.model.service.BouquetService;
import com.pickfl.products.model.service.CurrentFlowerService;
import com.pickfl.products.model.vo.BouquetVo;
import com.pickfl.products.model.vo.CurrentFlowerVo;

@WebServlet("/current-flower")
public class CurrentFlowerController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int productNo = Integer.parseInt(req.getParameter("pno"));
		if(loginUser != null) {			
			int memberNo = loginUser.getMemberNo();
			
			String productName = req.getParameter("pname");
			int productPrice = Integer.parseInt(req.getParameter("price"));
			int orderNum = Integer.parseInt(req.getParameter("order-num"));
			
			CurrentFlowerVo cf = new CurrentFlowerVo(memberNo, productNo, productName, orderNum, productPrice);
			int result = new CurrentFlowerService().add(cf);
			
			if(result >0) {
				
				resp.sendRedirect("own-flower");
			}else {
				resp.sendRedirect("own-flower-detail?no=" + productNo);
			}
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "own-flower-detail?no=" + productNo;
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('로그인이 필요합니다.'); location.href='"+url+"';</script>");
			writer.close();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		int row = Integer.parseInt(req.getParameter("row"));
		String bouquetName = req.getParameter("bouquet-name");
		String wrapColor = req.getParameter("wrap-color");
		int bouquetPrice = Integer.parseInt(req.getParameter("bouquet-price"));
		BouquetVo b = new BouquetVo(memberNo, bouquetName, wrapColor, bouquetPrice);
		
		int bouquetNo = new BouquetService().getCurrBqNo(b);
		
		if (bouquetNo > 0 ) {
			String detail = "";
			for(int i = 1; i <= row; i++) {
				String productName = req.getParameter("pname" + i);
				String orderNum = req.getParameter("orderNum" + i);
				detail += productName + " x " + orderNum + " ";
			}
			
			CartVo c = new CartVo(memberNo, bouquetNo, detail, bouquetName);
			
			int result = new CartService().add(c);
			
			if(result > 0) {
				int clear = new CurrentFlowerService().deleteAll(memberNo);
				if(clear > 0 ) {
					resp.setContentType("text/html; charset=UTF-8"); 
					String url = "cart";
					PrintWriter writer = resp.getWriter(); 
					writer.println("<script>location.href='"+url+"';</script>");
				}else {
					resp.setContentType("text/html; charset=UTF-8"); 
					String url = "own-flower";
					PrintWriter writer = resp.getWriter(); 
					writer.println("<script>alert('장바구니 추가중에 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
					writer.close();
				}
				
				
			}else {
				// cart add error 
				resp.setContentType("text/html; charset=UTF-8"); 
				String url = "own-flower";
				PrintWriter writer = resp.getWriter(); 
				writer.println("<script>alert('장바구니 추가중에 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
				writer.close();
			}
			
		} else {
			// bouquet add error 났을때
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "own-flower";
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('꽃다발을 만드는중에 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
			writer.close();
		}
		
	}

}
