<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JDBC 연결 테스트 1</h2>
	<% 
		JDBConnect jdbc = new JDBConnect();
		jdbc.close();
	%>
	<h2>JDBC 연결 테스트2</h2>
	<%
		JDBConnect jdbc2 = new JDBConnect(application);
		jdbc2.close();
	%>
	<h2>JDBC 연결 테스트3</h2>
	<%
		String driver = application.getInitParameter("oracleDriver");
		String url = application.getInitParameter("oracleUrl");
		String id = application.getInitParameter("oracleId");
		String pwd = application.getInitParameter("oraclePwd");
		JDBConnect jdbc3 = new JDBConnect(driver,url,id,pwd);
		jdbc3.close();
	%>
	<h2>Connection Pool 테스트</h2>
	<%
		DBConnPool jdbc4 = new DBConnPool();
		jdbc4.close();
	%>

</body>
</html>





