package com.pickfl.products.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pickfl.products.model.service.ProductService;
import com.pickfl.products.model.vo.ProductVo;

@WebServlet("/update-product")
public class UpdateProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int product_no = Integer.parseInt(req.getParameter("no"));
		ProductVo p =  new ProductService().selectProductByNo(product_no);
		
		String filePath = req.getServletContext().getRealPath("/upload") + File.separator;
		
		req.setAttribute("no", product_no);
		req.setAttribute("filePath", filePath);
		req.setAttribute("p", p);

		req.getRequestDispatcher("/WEB-INF/views/products/update-flower.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getParameter("no"));
		
//		int product_no = Integer.parseInt(req.getParameter("no"));
		String product_name = req.getParameter("pname");
		int product_price = Integer.parseInt(req.getParameter("price"));
		int product_stock = Integer.parseInt(req.getParameter("stock"));
		String flower_lang = req.getParameter("flang");
		String product_simple = req.getParameter("simple");
		String product_detail = req.getParameter("detail");
		String product_color = req.getParameter("color");
		String product_size = req.getParameter("size");
		String product_image="";
		
		
		Part part = req.getPart("image");
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			String changedName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			String realPath = req.getServletContext().getRealPath("/upload");
			product_image = changedName + ext;
			String filePath = realPath + File.separator + product_image;
			
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
		
//		ProductVo p = new ProductVo(product_no, product_name, product_price, product_stock, flower_lang, product_simple, product_detail, product_color, product_size, product_image);
//		System.out.println(p);
		
	}

}
