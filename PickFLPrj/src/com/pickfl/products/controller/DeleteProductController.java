package com.pickfl.products.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.products.model.service.ProductService;

@WebServlet("/delete-product")
public class DeleteProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int product_no = Integer.parseInt(req.getParameter("no"));
		int result = new ProductService().deleteProduct(product_no);
		
		if( result > 0) {
			resp.sendRedirect("manage-product");
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "manage-product-detail?no=" + product_no;
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('상품 삭제 중 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
			writer.close();
		}
	}

}
