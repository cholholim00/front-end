<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="example.Member"/>
<jsp:setProperty property="*" name="member"/>
<font size=5>
아이디 : <jsp:getProperty property="userId" name="member"/><br>
비밀번호 : <jsp:getProperty property="passwd" name="member"/><br>
이름 : <jsp:getProperty property="userName" name="member"/><br>
성별 : <jsp:getProperty property="gender" name="member"/><br>
취미 : <jsp:getProperty property="hobby" name="member"/><br>
학과 : <jsp:getProperty property="department" name="member"/><br>
</font>