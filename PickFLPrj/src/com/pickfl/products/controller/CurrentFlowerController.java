package com.pickfl.products.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.products.model.service.CurrentFlowerService;
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
				
				List<CurrentFlowerVo> list = new CurrentFlowerService().selectAll(memberNo);
				req.setAttribute("list", list);
				req.getRequestDispatcher("/WEB-INF/views/products/own-flower.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("/own-flower-detail?no=" + productNo);
			}
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "own-flower-detail?no=" + productNo;
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('로그인이 필요합니다.'); location.href='"+url+"';</script>");
			writer.close();
		}
		
	}

}
