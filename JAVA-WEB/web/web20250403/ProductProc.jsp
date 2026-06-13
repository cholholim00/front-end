<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*" %>
<html>
<head>
    <title>제품 정보 확인</title>
</head>
<body>
<h2>입력된 제품 정보</h2>
<p><strong>일련 번호:</strong> <%= request.getParameter("serialNumber") %></p>
<p><strong>제품 유형:</strong> <%= request.getParameter("productType") %></p>
<p><strong>제조사:</strong> <%= request.getParameter("manufacturer") %></p>

<a href="ProductFrom.jsp">제품 정보 다시 입력하기</a>
</body>
</html>

