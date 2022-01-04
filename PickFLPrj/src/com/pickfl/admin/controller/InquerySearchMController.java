package com.pickfl.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.inquery.model.service.InquerySearchMService;
import com.pickfl.inquery.model.vo.InqueryVo;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.inquery.model.vo.InquerySearchVo;


@WebServlet("/inquerysearchM")
public class InquerySearchMController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo user = (MemberVo) req.getSession().getAttribute("loginUser");
		
		String type = req.getParameter("searchType");
		String page = req.getParameter("currentPage");
		
		InquerySearchVo vo = new InquerySearchVo(user.getId(), type, page);
		
		req.setAttribute("InquerySearchVo", vo);
		
		List<InqueryVo> inqueryList = new InquerySearchMService().search(vo);

		req.setAttribute("inqueryList", inqueryList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/inqueryM.jsp").forward(req, resp);
	}
}
