package com.pickfl.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.admin.vo.MemberSearchMVo;
import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/membersearchId")
public class SearchMemberInfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("searchId");
		String page = req.getParameter("currentPage");
		MemberVo user = new MemberVo();
		user.setId(id);
		
		List<MemberVo> list = null;
		
		MemberSearchMVo vo = new MemberSearchMVo(page, id);
		
		req.setAttribute("searchVo", vo);
		
		list = new MemberService().allMemberList(vo, id);
		
		req.setAttribute("list", list);
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/searchMemberInfo.jsp").forward(req, resp);

	}
}
