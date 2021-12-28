package com.pickfl.inquery.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pickfl.inquery.model.vo.*;
import com.pickfl.inquery.model.dao.*;
import com.pickfl.inquery.model.service.*;

@WebServlet("/inquerysearch")
public class InquerySearchController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("searchType");
		String value = req.getParameter("searchValue");
		
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null)
			currentPage = "1";
		
		int maxPage = 0;
		int maxcount = new InqueryService().maxcount();
		if(maxcount % 7 == 0) {
			maxPage = maxcount/7;
		}
		if(maxcount %7 !=0){
			maxPage = maxcount/7 +1;
		}
		
		req.setAttribute("maxPage", maxPage);
		int startPage = Integer.parseInt(currentPage) -2;
		if(startPage<=0) startPage = 1;
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", startPage +7);
		
		List<InqueryVo> memberList = new InqueryService().search(type, value, currentPage);
		
		req.setAttribute("memberList", memberList);
		
		req.getRequestDispatcher("/WEB-INF/views/inquery/inquery.jsp").forward(req, resp);
	}
}
