<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>회원등록</h2>
		<form action="memPoc.jsp" method="get">
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
			<input type="radio" checked name="gender" value="남" />남자
			<input type="radio" name="gender" value="여"/>여자
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="checkbox" name="hobby" value="축구" />축구
			<td><input type="checkbox" name="hobby" value="농구" />농구
			<td><input type="checkbox" name="hobby" value="야구" />야구
			</td>
		</tr>
		<tr>
			<td>학과</td>
			<td>
			<select name="department">
			<option value="반려동물학과">반려동물학과</option>
			<option value="컴퓨터공학과">컴퓨터공학과</option>
			<option value="항공우주학과">항공우주학과</option>
			<option selected value="사이버해킹보안과">사이버해킹보안과</option>
			</select>
			</td>
		</tr>
		<tr>
		    <td colspan=2>
		         <input type="submit" value="회원가입" />
		         <input type="reset" value="다시작성" />
	      </td>
		</tr>
		 </table>
		</form>
</body>
</html>