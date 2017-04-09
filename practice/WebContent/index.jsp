<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="ShowHello">点我显示所有学生</a>
    <table>
    	<thead>
    		<tr>
    			<td>id</td>
    			<td>姓名</td>
    			<td>年龄</td>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${stuList }" var="stu">
    			<tr>
    				<td>${stu.id }</td>
    				<td>${stu.name }</td>
    				<td>${stu.age }</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    
    </table>
    
  </body>
</html>
