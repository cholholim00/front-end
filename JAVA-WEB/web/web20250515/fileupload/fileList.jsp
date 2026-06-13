<%@page import="java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.util.List"%>
<%@ page import="FileUpload.MyFileDAO"%>
<%@ page import="FileUpload.MyFileDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyFileDAO dao = new MyFileDAO();
	List<MyFileDTO> myList = dao.myFileList();
%>
<html>
<head><title>FileUpload</title></head>
<body>
    <h2>DB에 등록된 파일 목록 보기</h2>
    <a href="fileUploadMain.jsp">파일 등록하기</a>
    <table border="1">
        <tr>
            <th>No</th><th>작성자</th><th>제목</th><th>카테고리</th>
            <th>원본 파일명</th><th>저장된 파일명</th><th>작성일</th>
        </tr>
<%
	for(MyFileDTO dto : myList){
%>        
        <tr>
        	<td><%=dto.getIdx() %></td>
        	<td><%=dto.getName() %></td>
        	<td>
        		<a href="download.jsp?sName=<%=dto.getSfile() %>&oName=<%=dto.getOfile() %>"><%=dto.getTitle() %></a>
        	</td>
        	<td><%=dto.getCate() %></td>
        	<td><%=dto.getOfile() %></td>
        	<td><%=dto.getSfile() %></td>
        	<td><%=dto.getPostdate() %></td>
        </tr>
<%
	}
%>        
        
    </table>    
</body>
</html>