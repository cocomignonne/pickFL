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
		
		int productNo = Integer.parseInt(req.getParameter("no"));
		String productName = req.getParameter("pname");
		int productPrice = Integer.parseInt(req.getParameter("price"));
		int productStock = Integer.parseInt(req.getParameter("stock"));
		String flowerLang = req.getParameter("flang");
		String productSimple = req.getParameter("simple");
		String productDetail = req.getParameter("detail");
		String productColor = req.getParameter("color");
		String productSize = req.getParameter("size");
		String productImage="";
		
		
		Part part = req.getPart("image");
		if(part != null) {
			if(part.getSize() != 0) {				
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
		}
		
		ProductVo p = new ProductVo(productNo, productName, productPrice, productStock, flowerLang, productSimple, productDetail, productColor, productSize, productImage);
		int result = new ProductService().updateProduct(p);
		if(result > 0) {
			resp.sendRedirect(resp.encodeRedirectURL("http://localhost:8989/PickFL/manage-product-detail?no="+productNo));
			
		} else {
			resp.sendRedirect(req.getRequestURI());
		}
	}

}
