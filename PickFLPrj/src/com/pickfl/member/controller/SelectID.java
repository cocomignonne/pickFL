package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/selectId")
public class SelectID extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/selectId.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVo selectIdInfo = new MemberVo();
		
		selectIdInfo.setName(name);
		selectIdInfo.setEmail(email);
		
		
		MemberVo selectUser = new MemberService().selectID(selectIdInfo);
		
		
		if(selectUser != null) {
			req.setAttribute("msg", "고객님이 찾는 아이디는 ' " + selectUser.getId() + " ' 입니다.");
			req.getRequestDispatcher("/WEB-INF/views/common/successPage.jsp").forward(req, resp);
		} else {
			resp.getWriter().print("올바른 정보가 아닙니다");
			req.getRequestDispatcher("/WEB-INF/views/member/selectId.jsp").forward(req, resp);
		}
		
		
		
	}
	
	
	
	
}
