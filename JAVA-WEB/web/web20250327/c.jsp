<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	String type = "";
	if (age < 8){
		type = "유치원생";
	}else{
		type = "학생";
	}
%>    
c.jsp 입니다. 당신은 <%=type%>입니다.