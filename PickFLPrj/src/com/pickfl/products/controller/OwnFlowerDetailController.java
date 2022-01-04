package com.pickfl.products.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.products.model.service.ProductService;
import com.pickfl.products.model.vo.ProductVo;

@WebServlet("/own-flower-detail")
public class OwnFlowerDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int product_no = Integer.parseInt(req.getParameter("no"));
		ProductVo p =  new ProductService().selectProductByNo(product_no);
		
		String filePath = req.getServletContext().getRealPath("/upload") + File.separator;
		
		req.setAttribute("filePath", filePath);
		req.setAttribute("p", p);
		
		req.getRequestDispatcher("/WEB-INF/views/products/own-flower-detail.jsp").forward(req, resp);
	}
}
  