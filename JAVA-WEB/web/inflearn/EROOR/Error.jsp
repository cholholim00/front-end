<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 3. 29.
  Time: 오후 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 - 페이지를 찾을 수 없음</title>
</head>
<body>
<!-- HTTP 상태 404 : 요청한 페이지가 없을때  발생하는 에러 -->
<div class="nav">
<h2>404 EROOR</h2>
<h2>에러 페이지 : 요청하신 페이지를 찾을 수 없습니다. 관리자에게 문의 하세요.</h2>
<p>이 페이지는 현재 공사 중입니다. <br>조금만 기다려 주세요, 더 나은 모습으로 돌아올게요! 🏗️</p>
</div>

<img src="image.png" alt="공사 중 이미지" />

<div class="buttons">
    <a class="btn" href="pageDirective.jsp">🏠 홈으로 돌아가기</a>
    <button class="btn" onclick="history.back()">🔙 이전 페이지로 가기</button>-
    <button class="btn" onclick="location.reload()">🔄 다시 시도하기</button>
</div>

</body>
</html>

