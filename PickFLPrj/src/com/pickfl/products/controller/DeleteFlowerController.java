package com.pickfl.products.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.products.model.service.CurrentFlowerService;

@WebServlet("/delete-flower")
public class DeleteFlowerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int productNo = Integer.parseInt(req.getParameter("no"));
		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		int result = new CurrentFlowerService().deleteByNo(productNo);
		
		if(result > 0) {
			resp.sendRedirect("own-flower");
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "own-flower";
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('삭제하는데 문제가 발생했습니다.'); location.href='"+url+"';</script>");
			writer.close();
		}
		
	}
}
