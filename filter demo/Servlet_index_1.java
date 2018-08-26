package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.ScmuserDao;
import com.aowin.dao.UserDao;
import com.aowin.model.Scmuser;
import com.aowin.model.User;


public class Servlet_index_1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
			req.getSession().removeAttribute("account");
			req.getSession().removeAttribute("username");
		 		
			String username = req.getParameter("username");
			String password = req.getParameter("password");	
			
			
			Scmuser scmuser =null;
			User user=null;
			if(username!=null||password!=null){
			  scmuser = new ScmuserDao().getScmuser(username, password);
			  user=new UserDao().getUser(username);
			}
			
	     	if(scmuser!=null&&scmuser.getName()!=null){
	     		req.getSession().removeAttribute("loginerror");
	     		req.getSession().setAttribute("username", scmuser.getAccount());
	     		req.getSession().setAttribute("account", scmuser.getAccount());
	     		req.getSession().setAttribute("quanxian", user);
	     		System.out.println(scmuser.getName());
	     		
	     		resp.sendRedirect("../index.jsp");
	     	}else
	     		{
	     		req.getSession().setAttribute("loginerror", "”√ªß√˚√‹¬Î¥ÌŒÛ");
	     		req.getSession().removeAttribute("account");
	     		req.getSession().removeAttribute("username");
	     		req.getSession().removeAttribute("quanxian");
	     		resp.sendRedirect("../login.jsp");
	     		
	     		}
	     	
			}
			
			
			
			
		 	
	
	}


