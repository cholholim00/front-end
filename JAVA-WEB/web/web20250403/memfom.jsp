<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원등록</h2>
<form action="memfroc.jsp" method="get">
    <table border=1>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="userId" /></td>
        </tr>

        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="passwd" /></td>
        </tr>

        <tr>
            <td>이름</td>
            <td><input type="text" name="userName" /></td>
        </tr>

        <tr>
            <td>성별</td>
            <td>
                <input type="radio" name="gender" checked value="남" />남성
                <input type="radio" name="gender" value="여" />여성
            </td>
        </tr>

        <tr>
            <td>취미</td>
            <td>
                <input type="checkbox" name="hobby" value="축구" />축구
                <input type="checkbox" name="hobby" value="농구" />농구
                <input type="checkbox" name="hobby" value="야구" />야구
            </td>
        </tr>

        <tr>
            <td>학과</td>
            <td>
                <select name="department">
                    <option selected value="사이버해킹보안과">사이버해킹보안과</option>
                    <option value="경영학과">경영학과</option>
                    <option value="애완동물학과">애완동물학과</option>
                    <option value="사힉과">사학과</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan=2>
                <input type="submit" value="회원등록" />
                <input type="reset" value="다시작성" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
