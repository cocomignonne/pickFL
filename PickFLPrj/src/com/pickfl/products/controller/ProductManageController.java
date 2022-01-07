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

@WebServlet("/manage-product")
public class ProductManageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchName = req.getParameter("searchName");
		
		List<ProductVo> productList = new ProductService().search(searchName);
		
		String filePath = req.getServletContext().getRealPath("/upload") + File.separator;
		req.setAttribute("filePath", filePath);
		req.setAttribute("productList", productList);
		
		req.getRequestDispatcher("/WEB-INF/views/products/product-manage.jsp").forward(req, resp);
	}
}
