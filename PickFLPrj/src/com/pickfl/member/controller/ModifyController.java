package com.pickfl.member.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;


@WebServlet("/modify")
public class ModifyController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = new MemberVo();
		member = (MemberVo) req.getSession().getAttribute("loginUser");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String birth = req.getParameter("birth");
		MemberVo changeMember = new MemberVo();
		changeMember.setId(id);
		changeMember.setPwd(pwd);
		changeMember.setName(name);
		changeMember.setEmail(email);
		changeMember.setBirth(birth);
		
		new MemberService().ChangeMemberInfo(member,changeMember);
	}
}
