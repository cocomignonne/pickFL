package com.pickfl.inquery.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pickfl.inquery.model.vo.*;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.inquery.model.dao.*;
import com.pickfl.inquery.model.service.*;

@WebServlet("/inquerysearch")
public class InquerySearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = (MemberVo) req.getSession().getAttribute("loginUser");
		String user = member.getId();
		String type = req.getParameter("searchType");
		String page = req.getParameter("currentPage");
		
		InquerySearchVo vo = new InquerySearchVo(user, type, page);
		
		req.setAttribute("InquerySearchVo", vo);
		
		List<InqueryVo> inqueryList = new InquerySearchService().search(vo);

		req.setAttribute("inqueryList", inqueryList);
		
		if(user.equals("admin3"))
			req.getRequestDispatcher("/WEB-INF/views/admin/inqueryM.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/WEB-INF/views/inquery/inquery.jsp").forward(req, resp);
	}
}
