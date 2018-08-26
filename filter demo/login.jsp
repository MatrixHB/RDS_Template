<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aowin.model.*,com.aowin.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>login</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
	 <style type="text/css">
		.error{
			color:red;
			font-size:15px;
		}
	</style>
	<script type="text/javascript">
	function denglu(){
		
		document.form1.submit();
		//window.close();
	
	}
	
	</script>
</head>
<body bgcolor="#ffffff" >

<form action="servlet/Servlet_index_1" method="POST" name="form1" id="form1">
<table width="100%"  border="0"  >
	<tr>
		<td class="title1">&nbsp;</td>
	</tr>
 
  
  
 <c:if test="${empty username }">
  <tr>
    <td width="50%" align="right">用户名&nbsp;&nbsp;</td>
    <td width="50%"><input name="username" id="username" type="text"/></td>
  </tr>
  <tr>
    <td align="right">密码&nbsp;&nbsp;&nbsp;</td>
    <td><input name="password" id="password" type="password"/></td>
  </tr>
  	
  <tr>
  	<td class="title1"><div align="right"><input type="submit" value="登录" onclick="denglu()"/></div></td>
	<td class="title1"><div align="left"><input type="reset" value="重置"/></div></td>
  </tr>
   </c:if>
 
 	 <c:if test="${!empty username }">
 	 <td class="toolbar">
  		<p align="center">你好,${username},你没有权限进入! 请注销后重试</p>
  		</td>
 	
   </c:if>
   
   
</table>	
</form>
	<% if(session.getAttribute("loginerror")!=null){%>
	<p class="error">
	<%=session.getAttribute("loginerror")%>	
	</p>
	<% }%>
	
	<% if(session.getAttribute("quanxianError")!=null){%>
	<p class="error">
	<%=session.getAttribute("quanxianError")%>	
	</p>
	<% }%>
	
	<%session.setAttribute("loginerror",null); 
session.setAttribute("quanxianError",null); %>
</body>
</html>