<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>제품 등록</h2>
<form action="proproc.jsp">
  <table>
    <tr>
      <td>제품 번호</td>
      <td><input type="text" name="prodId"></td>
    </tr>

    <tr>
      <td>제품 유형</td>
      <td>
        <select name="prodType">
          <option selected value="키보드">키보드</option>
          <option value="모니터">모니터</option>
          <option value="마우스">마우스</option>
        </select>
      </td>
    </tr>

    <tr>
      <td>제조사</td>
      <td>
        <input type="text" name="company" />
        </td>
    </tr>

    <tr>
      <td colspan= 2>
        <input type="submit" name="제품등록" />
        <input type="reset" name="다시등록" />
      </td>
    </tr>
  </table>
  </form>
</body>
</html>
