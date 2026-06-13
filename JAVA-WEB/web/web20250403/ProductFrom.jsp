<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>제품 정보 입력 폼</title>
</head>
<body>
<h2>제품 정보 입력</h2>
<form action="ProductProc.jsp" method="post" accept-charset="utf-8">
  <label for="serialNumber">일련 번호:</label>
  <input type="text" id="serialNumber" name="serialNumber" placeholder="제품 일련번호" required><br><br>

  <label for="productType">제품 유형:</label>
  <select id="productType" name="productType" required>
    <option value="">선택하세요</option>
    <option value="모니터">모니터</option>
    <option value="키보드">키보드</option>
    <option value="마우스">마우스</option>
  </select><br><br>

  <label for="manufacturer">제조사:</label>
  <input type="text" id="manufacturer" name="manufacturer" placeholder="제조사" required><br><br>

  <input type="submit" value="제출">
</form>
</body>
</html>

