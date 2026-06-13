<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="guguProc.jsp">
		<table>
			<tr>
				<td>출력할 단</td>
				<td>
					<input type="radio" name="dan" value="2" />2단
					<input type="radio" name="dan" value="3" />3단
					<input type="radio" name="dan" value="4" />4단
					<input type="radio" checked name="dan" value="5" />5단
					<input type="radio" name="dan" value="6" />6단
					<input type="radio" name="dan" value="7" />7단
					<input type="radio" name="dan" value="8" />8단
					<input type="radio" name="dan" value="9" />9단
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="출력하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>