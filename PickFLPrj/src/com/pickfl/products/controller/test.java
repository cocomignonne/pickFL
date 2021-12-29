package com.pickfl.products.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class test extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int product_no = Integer.parseInt(req.getParameter("no"));
		String product_name = req.getParameter("pname");
		int product_price = Integer.parseInt(req.getParameter("price"));
		int product_stock = Integer.parseInt(req.getParameter("stock"));
		String flower_lang = req.getParameter("flang");
		String product_simple = req.getParameter("simple");
		String product_detail = req.getParameter("detail");
		String product_color = req.getParameter("color");
		String product_size = req.getParameter("size");
		
		System.out.println("no : " + product_no);
		System.out.println("name : " + product_name);
		System.out.println("price : " + product_price);
		System.out.println("stock : " + product_stock);
		System.out.println("lang : " + flower_lang);
		System.out.println("simple : " + product_simple);
		System.out.println("detail : " + product_detail);
		System.out.println("color : " + product_color);
		System.out.println("size : " + product_size);
    }
}
