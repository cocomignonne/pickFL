package com.pickfl.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String reviewNo = req.getParameter("reviewNo");
			
			if(reviewNo == null) {				
				req.getRequestDispatcher("/WEB-INF/views/review/review-list.jsp").forward(req, resp);
			}else {
				int no = Integer.parseInt(reviewNo);
				req.setAttribute("no", no);
				
				req.getRequestDispatcher("/WEB-INF/views/review/review.jsp").forward(req, resp);
			}
		}
}
