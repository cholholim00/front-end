<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>b.jsp 입니다....</h2>
	<jsp:include page="c.jsp">
		<jsp:param value="7" name="age"/>
	</jsp:include>
	<h2>나머지 내용입니다.</h2>
</body>
</html>