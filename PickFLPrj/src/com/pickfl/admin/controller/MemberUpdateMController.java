package com.pickfl.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/adminMUpdate")
public class MemberUpdateMController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mNum = req.getParameter("mNum");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String birth = req.getParameter("birth");
		String email = req.getParameter("mail");
		String pwd = req.getParameter("password");
		String quit = req.getParameter("quitYN");
		
		MemberVo vo = new MemberVo();
		vo.setMemberNo(Integer.parseInt(mNum));
		vo.setName(name);
		vo.setId(id);
		vo.setBirth(birth);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setQuitYN(quit);
		
		new MemberService().updateMember(vo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberInfo.jsp").forward(req, resp);
	}
}
