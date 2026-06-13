<%--
  Created by IntelliJ IDEA.
  User: elwlz
  Date: 25. 5. 5.
  Time: 오후 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- RequestLogin에서 넘어온 아이디와 패스워드를 읽어드림 -->
<%
  //사용자의 정보가  정보가 저장되어있는 객체 request dml getParameter() 사용자의 정보를 추출
    String id = request.getParameter("id"); //사용자의 id값을 읽어드려서 변수 id에 저장
    String password = request.getParameter("password"); //사용자의 password값을 읽어드려서 변수 password에 저장
%>

<!-- 사용자가 입력한 id와 password를 출력 -->
<h2>아이디 : <%= id %></h2>
<h2>비밀번호 : <%= password %></h2>
</body>
</html>
