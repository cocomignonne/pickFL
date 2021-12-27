package com.pickfl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
// 오버라이딩해야하는 메소드 = 추상메소드
//@WebFilter({"/aaa", "/bbb", "/ccc"})
@WebFilter("/*")
public class EncodeFilter implements Filter {

	@Override
	public void destroy() {
		
	}
	
	@Override  // 중요
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); // 정상적으로 다음 필터 또는 서블릿으로 넘어갈 수 있다. 
		// (로그인해서 관리자 일반회원 나눌 때 쓰러나 로그인 성공 시에만 보일 수 있는 페이지가 있을 때 사용함)
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
}
