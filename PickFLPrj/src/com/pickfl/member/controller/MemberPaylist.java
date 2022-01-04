package com.pickfl.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.PaylistVo;

@WebServlet("/paylist")
public class MemberPaylist extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mNum = req.getParameter("mNum");
		PaylistVo vo = new PaylistVo();
		List<PaylistVo> list = null;
		
		vo.setMemberNo(Integer.parseInt(mNum));
		
		list = new MemberService().allPaylist(list, vo.getMemberNo());
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/member/paymentList.jsp").forward(req, resp);
	}
}
