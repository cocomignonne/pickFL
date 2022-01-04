package com.pickfl.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
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
@WebServlet("/add-review")
public class AddReviewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginUser = (MemberVo)req.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		Map<Integer, String> bouquetMap = new ReviewService().getBqMap(memberNo);
		req.setAttribute("bouquetMap", bouquetMap);
		req.getRequestDispatcher("/WEB-INF/views/review/add-review.jsp").forward(req, resp);
		
//		if(bouquetMap != null) {
//			req.setAttribute("bouquetMap", bouquetMap);
//			req.getRequestDispatcher("/WEB-INF/views/review/add-review.jsp").forward(req, resp);
//		}else {
//			resp.setContentType("text/html; charset=UTF-8"); 
//			PrintWriter writer = resp.getWriter(); 
//			String url = "review";
//			writer.println("<script>alert('작성할 수 있는 상품이 없습니다.'); location.href='"+url+"';</script>");
//			writer.close();
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		req.setCharacterEncoding("UTF-8");
		
		int bouquetNo = Integer.parseInt(req.getParameter("bouquetNo"));
		String memberId = loginUser.getId();
		String bouquetName = new BouquetService().getName(bouquetNo);
		String rtitle = req.getParameter("rtitle");
		String rimage = "";
		String rcontent = req.getParameter("rcontent");
		int stars = Integer.parseInt(req.getParameter("stars"));
		
		Part part = req.getPart("rimage");
		if(part != null) {
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
		
		ReviewVo r = new ReviewVo(bouquetNo, memberId, bouquetName, rtitle, rimage, rcontent, stars);
		int result = new ReviewService().add(r);
		
		if(result > 0) {
			resp.sendRedirect("review");
		} else {
			
			resp.sendRedirect("add-review");
		}
		
		
	}


}
