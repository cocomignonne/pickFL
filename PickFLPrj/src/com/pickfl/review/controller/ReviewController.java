package com.pickfl.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.review.model.service.ReviewService;
import com.pickfl.review.model.vo.ReviewVo;

@WebServlet("/review")
public class ReviewController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String reviewNo = req.getParameter("reviewNo");
			
			if(reviewNo == null) {
				
				List<ReviewVo> list = new ReviewService().selectAll();
				req.setAttribute("reviewList", list);
				
				req.getRequestDispatcher("/WEB-INF/views/review/review-list.jsp").forward(req, resp);
			}else {
				int no = Integer.parseInt(reviewNo);
				System.out.println(no);
				req.setAttribute("no", no);
				
				ReviewVo review = new ReviewService().selectByNo(no);
				
				req.setAttribute("r", review);
				
				req.getRequestDispatcher("/WEB-INF/views/review/review.jsp").forward(req, resp);
			}
		}
}
