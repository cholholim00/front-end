<%@page import="example.SimpleBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleBean test = new SimpleBean();
	test.setMessage("Smith");
%>
이름2 : <%=test.getMessage()%>