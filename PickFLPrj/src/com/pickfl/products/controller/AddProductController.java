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
		
		String productName = req.getParameter("pname");
		String price = req.getParameter("price");
		int productPrice = Integer.parseInt(req.getParameter("price"));
		int productStock = Integer.parseInt(req.getParameter("stock"));
		String flowerLang= req.getParameter("flang");
		String productSimple = req.getParameter("simple");
		String productDetail = req.getParameter("detail");
		String productColor = req.getParameter("color");
		String productSize = req.getParameter("size");
		String productImage="";
		
		
		Part part = req.getPart("image");
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			String changedName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			String realPath = req.getServletContext().getRealPath("/upload");
			productImage = changedName + ext;
			String filePath = realPath + File.separator + productImage;
			
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
		
		ProductVo p = new ProductVo(productName, productPrice, productStock, flowerLang, productSimple, productDetail, productColor, productSize, productImage);
		
		int result = new ProductService().add(p);
		
		if ( result > 0) {
			resp.sendRedirect("manage-product");
		} else {
			resp.sendRedirect("add-flower");
		}
		
		
		
	}
}
