<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	String userName = request.getParameter("userName");
	String gender = request.getParameter("gender");
	String [] arrHobby = request.getParameterValues("hobby");
	String hobby = "";
	for(String s : arrHobby){
		hobby += s + " ";
	}
	String department = request.getParameter("department");
	
	out.println("<font size='1'>");
	out.println("userId :" + userId +"<br>");
	out.println("passwd : " + passwd +"<br>");
	out.println("userName : " + userName +"<br>");
	out.println("gender : " + gender +"<br>");
	out.println("hobby : " + hobby +"<br>");
	out.println("department : " + department +"<br>");
	out.println("</font>");
%>
<hr />
<font size=5 color="red">
UserID : <%=userId %><br>
Password : <%=passwd %><br>
userName : <%=userName %><br>
gender : <%=gender %><br>
hobby : <%=hobby %><br>
department : <%=department %><br>
</font>





