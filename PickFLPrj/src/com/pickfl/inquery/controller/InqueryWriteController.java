package com.pickfl.inquery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.inquery.model.service.InqueryService;
import com.pickfl.inquery.model.vo.InqueryVo;

@WebServlet("/inqueryWrite")
public class InqueryWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/inquery/inqueryWrite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = "asdasd";
		String qTitle = req.getParameter("title");
		String qContent = req.getParameter("text");
		
		InqueryVo vo = new InqueryVo();
		vo.setUser(id);
		vo.setqTitle(qTitle);
		vo.setqContent(qContent);
		
		new InqueryService().InqueryWrite(vo);
	}
}
