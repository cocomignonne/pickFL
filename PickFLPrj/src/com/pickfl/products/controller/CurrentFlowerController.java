package com.pickfl.products.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/current-flower")
public class CurrentFlowerController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo loginUser = (MemberVo) req.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		String productNo = req.getParameter("pno");
		String productName = req.getParameter("pname");
		String productPrice = req.getParameter("price");
		String orderNum = req.getParameter("order-num");
		
		System.out.println("loginUser : " + loginUser);
		
	}

}
