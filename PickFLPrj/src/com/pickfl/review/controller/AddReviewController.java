package com.pickfl.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.review.model.service.ReviewService;

@WebServlet("/add-review")
public class AddReviewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginUser = (MemberVo)req.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		Map<Integer, String> bouquetMap = new ReviewService().getBqMap(memberNo);
		
		if(bouquetMap != null) {
			req.setAttribute("bouquetMap", bouquetMap);
			req.getRequestDispatcher("/WEB-INF/views/review/add-review.jsp").forward(req, resp);
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('작성할 수 있는 상품이 없습니다.'); location.href='';</script>");
			writer.close();
		}
	}


}
