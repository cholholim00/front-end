<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="test" class="example.SimpleBean"/>
<jsp:setProperty property="message" name="test" value="Smith"/>
이름 : <jsp:getProperty property="message" name="test"/>
    