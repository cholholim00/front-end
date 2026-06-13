<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	for(int dan=2; dan<=9; dan++){
		for(int i=1; i<=9; i++){
			out.println(dan + " x " + i + " = " + dan*i + "<br>"); 
		}
		out.println("<br>");
	}
%>