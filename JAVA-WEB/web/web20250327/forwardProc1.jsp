<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>1. forwardProc1 입니다...</h2>
<%
	String depart = "hisecure";
%>
<jsp:forward page="forwardProc2.jsp">
	<jsp:param value="KIM" name="userId"/>
	<jsp:param value="<%=depart %>" name="department"/>
</jsp:forward>
<h2>2. forwardProc1 입니다...</h2>
