<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>forwardProc2 입니다...</h2>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	String department = request.getParameter("department");
	out.println("ID: " + userId + ", PWD: " + passwd + ", 학과:" + department);
%>
