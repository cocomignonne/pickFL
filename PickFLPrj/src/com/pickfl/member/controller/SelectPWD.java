package com.pickfl.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;

@WebServlet("/selectPwd")
public class SelectPWD extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/selectPwd.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		MemberVo selectPwdInfo = new MemberVo();
		
		selectPwdInfo.setName(name);
		selectPwdInfo.setId(id);
		selectPwdInfo.setEmail(email);
		
		
		MemberVo selectUser = new MemberService().selectPWD(selectPwdInfo);
		
		
		if(selectUser != null) {
			req.setAttribute("msg", "고객님의 임시 비밀번호는 ' " + selectUser.getPwd() + " ' 입니다.");
			req.setAttribute("msg2", "로그인 후 반드시 비밀번호를 변경하세요.");
			req.getRequestDispatcher("/WEB-INF/views/common/successPage.jsp").forward(req, resp);
		} else {
			
		}
	}
}
