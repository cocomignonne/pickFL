package com.pickfl.member.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;


@WebServlet("/modifyCheck")
public class ModifyCheckController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = new MemberVo();
		member = (MemberVo) req.getSession().getAttribute("loginUser");
		
		req.setAttribute("member", member);
		
		req.getRequestDispatcher("/WEB-INF/views/member/pwCheckModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd = req.getParameter("pw");
		MemberVo member = new MemberVo();
		member = (MemberVo) req.getSession().getAttribute("loginUser");	
		
		if(member.getPwd().equals(pwd)) {
			member = new MemberService().modifyMember(member);
			req.setAttribute("member", member);
			req.getRequestDispatcher("/WEB-INF/views/member/Modify.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "잘못된 비밀번호 입니다");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
