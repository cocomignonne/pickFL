package com.pickfl.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.products.model.service.BouquetService;
import com.pickfl.review.model.service.ReviewService;
import com.pickfl.review.model.vo.ReviewVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
)
@WebServlet("/update-review")
public class UpdateReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(req.getParameter("no"));
		ReviewVo r = new ReviewService().selectByNo(reviewNo);
		req.setAttribute("r", r);
		req.getRequestDispatcher("/WEB-INF/views/review/update-review.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		req.setCharacterEncoding("UTF-8");
		
		int reviewNo = Integer.parseInt(req.getParameter("no"));
		String rtitle = req.getParameter("rtitle");
		String rimage = "";
		String rcontent = req.getParameter("rcontent");
		int stars = Integer.parseInt(req.getParameter("stars"));
		
		Part part = req.getPart("rimage");
		if(part != null) {
			if(part.getSize() != 0) {				
				String originName = part.getSubmittedFileName();
				InputStream fis = part.getInputStream();
				
				String changedName = "" + UUID.randomUUID();
				String ext = originName.substring(originName.lastIndexOf("."), originName.length());
				String realPath = req.getServletContext().getRealPath("/upload");
				rimage = changedName + ext;
				String filePath = realPath + File.separator + rimage;
				
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				
				fis.close();
				fos.close();
			}
		}
		
		ReviewVo r = new ReviewVo(reviewNo, rtitle, rimage, rcontent, stars);
		int result = new ReviewService().update(r);
		
		if(result > 0) {
			resp.sendRedirect(resp.encodeRedirectURL("http://localhost:8989/PickFL/review?reviewNo="+reviewNo));
		}else {
			resp.setContentType("text/html; charset=UTF-8"); 
			String url = "update-review?reviewNo=" + reviewNo;
			PrintWriter writer = resp.getWriter(); 
			writer.println("<script>alert('리뷰 수정 중 문제가 발생했습니다. 다시 시도해주세요.'); location.href='"+url+"';</script>");
			writer.close();
		}
		
	}
}
