package com.aowin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.model.User;

public class AccounUserFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		HttpSession session = req.getSession();
		User username =  (User) session.getAttribute("quanxian");
		if (username==null) {
			session.setAttribute("quanxianerror", "���¼");
			System.out.println("���¼��");
			resp.sendRedirect("/scm/login.jsp");
			
			
		}else if("5".equals(username.getModelCode())||"1".equals(username.getModelCode())){
			
			//�������
			arg2.doFilter(req, resp);
		}else{
			//���ܼ������󣬷�����ʾҳ��
			session.setAttribute("quanxianerror", "û��Ȩ�ޣ����¼��ӦȨ�޵��˺ţ�");
			System.out.println("û��Ȩ�ޣ�");
			resp.sendRedirect("/scm/login.jsp");
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
