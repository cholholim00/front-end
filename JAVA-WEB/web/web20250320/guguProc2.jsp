<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String arrDan [] = request.getParameterValues("dan");
	for(int i=0; i<arrDan.length; i++){
		int dan = Integer.parseInt(arrDan[i]);
		for(int j=1; j<=9; j++){
			out.println(dan + " x " + j + " = " + dan*j + "<br>");
		}
		out.println("<br>");
	}

%>