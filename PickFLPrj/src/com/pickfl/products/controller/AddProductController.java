package com.pickfl.products.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pickfl.products.model.service.ProductService;
import com.pickfl.products.model.vo.ProductVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
)
@WebServlet("/add-flower")
public class AddProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/products/add-flower.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String product_name = req.getParameter("pname");
		String price = req.getParameter("price");
		int product_price = Integer.parseInt(req.getParameter("price"));
		int product_stock = Integer.parseInt(req.getParameter("stock"));
		String flower_lang = req.getParameter("flang");
		String product_simple = req.getParameter("simple");
		String product_detail = req.getParameter("detail");
		String product_color = req.getParameter("color");
		String product_size = req.getParameter("size");
		String filePath = "";
		
		
		Part part = req.getPart("image");
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			String changedName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			String realPath = req.getServletContext().getRealPath("/upload");
			filePath = realPath + File.separator + changedName + ext;
			
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
		
		ProductVo p = new ProductVo(product_name, product_price, product_stock, flower_lang, product_simple, product_detail, product_color, product_size, filePath);
		
		int result = new ProductService().add(p);
		
		if(result > 0) {
			System.out.println("등록 완료");
		}else {
			System.out.println("등록 실패");
			
		}
		
	}
}
