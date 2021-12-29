package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;

@WebServlet("/emailDupCheck")
public class EmailDupController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int result = new MemberService().dupEmailCheck(email);
		
		if (result > 0) { 
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("중복된 이메일입니다.");
			
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용가능한 이메일입니다.");
			
		}
		
	}
	
}
