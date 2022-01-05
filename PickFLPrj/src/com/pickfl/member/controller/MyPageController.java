package com.pickfl.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pickfl.member.model.service.MemberService;
import com.pickfl.member.model.vo.MemberVo;
import com.pickfl.member.model.vo.PaylistVo;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = new MemberVo();
		member = (MemberVo) req.getSession().getAttribute("loginUser");
		
		member = new MemberService().memberGrade(member);
		
		PaylistVo vo = new PaylistVo();
		List<PaylistVo> list = null;
		vo.setMemberNo(member.getMemberNo());
		list = new MemberService().allPaylist(list, vo.getMemberNo());
		req.setAttribute("member", member);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(req, resp);
	}
}
