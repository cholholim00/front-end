<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//response.sendRedirect("guguForm2.jsp");
	int dan = Integer.parseInt(request.getParameter("dan"));
	for(int i=1; i<=9; i++){
		out.println(dan + " x " + i + " = " + dan*i + "<br>");
	}
	response.sendRedirect("guguForm2.jsp");
%>