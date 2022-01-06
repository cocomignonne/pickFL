package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.PaylistVo;

@WebServlet("/detailPaylist")
public class PaylistDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderNo = req.getParameter("orderNo");
		PaylistVo vo = new PaylistVo();
		vo.setOrderNo(Integer.parseInt(orderNo));
		
		vo = new MemberService().paylistDetail(vo);
		req.setAttribute("orderDetailVo", vo);
		req.getRequestDispatcher("/WEB-INF/views/member/detailPaylist.jsp").forward(req, resp);
	}
}
