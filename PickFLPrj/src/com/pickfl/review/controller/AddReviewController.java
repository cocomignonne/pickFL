package com.pickfl.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.review.model.service.ReviewService;

@WebServlet("/add-review")
public class AddReviewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getSession().getAttribute("memberId");
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		
		boolean valid = checkValidate(memberId, orderNo);
		if(valid) {
			req.getRequestDispatcher("/WEB-INF/views/review/add-review.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/");
		}
	}

	private boolean checkValidate(String memberId, int orderNo) {
		
		boolean result = false;
		String s = new ReviewService().getMemberId(orderNo);
		boolean c = new ReviewService().checkCompleted(orderNo);
		if(memberId.equals(s) && c) result = true;
		
		return result;
	}
}
