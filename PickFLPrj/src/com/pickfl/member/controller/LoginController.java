package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println(id);
		System.out.println(pwd);
		
		MemberVo loginMem = new MemberVo();
		loginMem.setId(id);
		loginMem.setPwd(pwd);
		
		MemberVo loginUser = new MemberService().login(loginMem);
		
		if(loginUser != null) {
			req.getSession().setAttribute("loginUser", loginUser);
			if(loginUser.getId().equals("admin1") || loginUser.getId().equals("admin2") || loginUser.getId().equals("admin3")) {
				req.getRequestDispatcher("/WEB-INF/views/admin/mainPageM.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/mainPage.jsp").forward(req, resp);
			}
			
		} else {
			// error
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

	}

	
	
	
	
}

