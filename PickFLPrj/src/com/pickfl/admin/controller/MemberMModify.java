package com.pickfl.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/adminModify")
public class MemberMModify extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNum = req.getParameter("mNum");
		
		MemberVo vo = new MemberVo();
		vo.setMemberNo(Integer.parseInt(memberNum));
		
		vo = new MemberService().modifyMember(vo);
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberModify.jsp").forward(req, resp);
	}
}
