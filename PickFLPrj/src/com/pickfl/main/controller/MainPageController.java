package com.pickfl.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.products.model.service.ProductService;
import com.pickfl.products.model.vo.ProductVo;

@WebServlet("/main")
public class MainPageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductVo> list = new ProductService().selectNewest();
		
		req.setAttribute("newList", list);
		
		req.getRequestDispatcher("/WEB-INF/views/mainPage.jsp").forward(req, resp);
	}
}
