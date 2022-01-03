package com.pickfl.member.controller;

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
import com.pickfl.member.model.vo.PaylistPageVo;
import com.pickfl.member.model.vo.PaylistVo;

@WebServlet("/paylist")
public class MemberPaylist extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("currentPage");
		List<PaylistVo> list = null;
		
		PaylistPageVo pageVo  = new PaylistPageVo(page);
		
		req.setAttribute("searchVo", pageVo);
		
		list = new MemberService().allPaylist(list);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/member/paymentList.jsp").forward(req, resp);
	}
}
