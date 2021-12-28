package com.pickfl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fileName = req.getParameter("fileName");
		
		resp.setContentType("image/jpg");
		ServletOutputStream os = resp.getOutputStream();
		String filePath = req.getServletContext().getRealPath("/upload") + File.separator + fileName;
		FileInputStream fis = new FileInputStream(filePath);
		int length;
	    byte[] buffer = new byte[10];
	    while((length=fis.read(buffer)) != -1){
	    	os.write(buffer,0,length);
	    }
	    
	    os.close();
	    fis.close();
	}
}
