package com.pickfl.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.inquery.model.service.InqueryService;
import com.pickfl.inquery.model.vo.InqueryVo;

@WebServlet("/inqueryresponseM")
public class inqueryResponseM extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("qNum");
		
		InqueryVo vo = new InqueryVo();
		vo.setqNum(Integer.parseInt(num));
		
		vo = new InqueryService().searchContent(vo);
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/inqueryResponseM.jsp").forward(req, resp);
	}
}
