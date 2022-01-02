package com.pickfl.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/memberInfo")
public class MemberInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVo> list;
		
		list = new MemberService().allMemberList();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberInfo.jsp").forward(req, resp);
	}
}
