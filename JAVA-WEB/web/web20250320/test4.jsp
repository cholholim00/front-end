<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String color = config.getInitParameter("color");
	String size = config.getInitParameter("size");
	
	String id = application.getInitParameter("id");
	String passwd = application.getInitParameter("passwd");
%>
color : <%=color%><br>
size : <%=size%><br>
<hr />
id : <%=id%><br>
passwd : <%=passwd%>