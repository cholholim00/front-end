<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int status = response.getStatus();
	if(status == 404){
		out.println("잘못 요청했습니다!<br>");
		out.println("경로를 확인해 주세요!!");		
	}else if(status == 500){
		out.println("서버 에러 발생!");
		out.println("조치를 취하고 있습니다!");
	}
%>