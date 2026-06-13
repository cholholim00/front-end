<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	String userName = request.getParameter("userName");
	String gender = request.getParameter("gender");
	String hobby [] = request.getParameterValues("hobby");
	String strHobby = "";
	for(String s : hobby){
		strHobby += s + " ";
	}
	String department = request.getParameter("department");
	out.println("ID: " + userId + "<br>");
	out.println("PWD: " + passwd + "<br>");
	out.println("Name: " + userName + "<br>");
	out.println("Gender: " + gender + "<br>");
	out.println("Hobby: " + strHobby + "<br>");
	out.println("Department: " + department + "<br>");
%>
<hr />
<font size=5 color=red>
ID: <%=userId %><br>
PWD: <%=passwd %><br>
Name: <%=userName %><br>
Gender: <%=gender %><br>
Hobby: <%=hobby %><br>
Department: <%=department %><br>
</font>