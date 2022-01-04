package com.pickfl.products.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.products.model.service.ProductService;

@WebServlet("/productDupCheck")
public class ProductDupCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productName = req.getParameter("product_name");
		
		int result = new ProductService().dupCheck(productName);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("{\"result\": " + result + "}");
	}
}
