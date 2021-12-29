package com.pickfl.products.controller;

import java.io.IOException;

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
			resp.sendRedirect("manage-product-detail?no=" + product_no);
		}
	}

}
