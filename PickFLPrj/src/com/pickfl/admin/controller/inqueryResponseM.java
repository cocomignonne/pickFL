package com.pickfl.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.inquery.model.service.InqueryResponseMService;
import com.pickfl.inquery.model.service.InqueryService;
import com.pickfl.inquery.model.vo.InqueryResponseVo;
import com.pickfl.inquery.model.vo.InqueryVo;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/inqueryresponseM")
public class inqueryResponseM extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("qNum");
		
		InqueryVo vo = new InqueryVo();
		vo.setqNum(Integer.parseInt(num));
		
		vo = new InqueryService().searchContent(vo);
		if(vo.getqResponse().equals("Y")) {
			String content = new InqueryService().ResponseContent(vo);
			vo.setResponseContent(content);
		}
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/inqueryResponseM.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = (MemberVo) req.getSession().getAttribute("loginUser");
		String adminId = member.getId();
		String qNum = req.getParameter("qNum");
		String comment = req.getParameter("comment");
		String mNum = req.getParameter("mNum");
		
		int num = Integer.parseInt(qNum);
		int memberNo = Integer.parseInt(mNum);
		
		InqueryResponseVo vo = new InqueryResponseVo(num, comment, adminId, memberNo);
		
		InqueryResponseMService.inqueryResponse(vo);
		
		
	}
}
