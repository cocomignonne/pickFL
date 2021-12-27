package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;

@WebServlet("/idDupCheck")
public class IdDupCheckController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("아이디 : " + id);

		int result = new MemberService().dupCheck(id);
		System.out.println("아이디" + result);
		
		if (result > 0) { 
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("중복된 아이디입니다.");
			
			System.out.println("아이디 중복 : " + id);
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용가능한 아이디입니다.");
			
			System.out.println("아이디 사용가능 : " + id);
		}
		
		if("admin1".equals(id) || "admin2".equals(id) || "admin3".equals(id)) { 
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("관리자입니다."); 
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("관리자가 아닙니다."); 
		}
		
	}
	
}
