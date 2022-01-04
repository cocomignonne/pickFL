package com.pickfl.inquery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/inquery")
public class InqueryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = new MemberVo();

		member = (MemberVo) req.getSession().getAttribute("loginUser");
		if(member != null) {
			if(member.getId().equals("admin3")) {
				req.getRequestDispatcher("/WEB-INF/views/admin/inqueryM.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/inquery/inquery.jsp").forward(req, resp);
			}
		}
		
	}
}
