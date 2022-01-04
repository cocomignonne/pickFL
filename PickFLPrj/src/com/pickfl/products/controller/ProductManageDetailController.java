package com.pickfl.products.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.products.model.service.ProductService;
import com.pickfl.products.model.vo.ProductVo;

@WebServlet("/manage-product-detail")
public class ProductManageDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productNo = Integer.parseInt(req.getParameter("no"));
		ProductVo p =  new ProductService().selectProductByNo(productNo);
		
		String filePath = req.getServletContext().getRealPath("/upload") + File.separator;
		
		req.setAttribute("no", productNo);
		req.setAttribute("filePath", filePath);
		req.setAttribute("p", p);
		
		req.getRequestDispatcher("/WEB-INF/views/products/product-manage-detail.jsp").forward(req, resp);
	}

}
