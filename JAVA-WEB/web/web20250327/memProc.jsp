<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	String userName = request.getParameter("userName");
	String gender = request.getParameter("gender");
	String [] arrHobby = request.getParameterValues("hobby");
	String hobby = "";
	for (String s : arrHobby){
		hobby += s + " ";
	}
	String department = request.getParameter("department");	
%>
<font size=5>
아이디 : <%=userId %><br>
비밀번호 : <%=passwd %><br>
이름 : <%=userName %><br>
성별 : <%=gender %><br>
취미 : <%=hobby %><br>
학과 : <%=department %><br>
</font>