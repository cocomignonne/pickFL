package com.pickfl.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.review.model.service.ReviewService;

@WebServlet("/delete-review")
public class DeleteReviewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(req.getParameter("no"));
		
		int result = new ReviewService().delete(reviewNo);
		
		if(result > 0) {
			resp.sendRedirect("review");
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "review?reviewNo=" + reviewNo;
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('리뷰 삭제 중 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
			writer.close();
		}
	}
}
