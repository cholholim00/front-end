<%@page import="java.sql.Connection"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 게시물 얻기
	String num = request.getParameter("num");
	BoardDAO dao = new BoardDAO(application);
	BoardDTO board = dao.selectView(num);	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "deleteProcess.jsp";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}
</script>
</head>
<body>
<h2>회원제 게시판 - 상세 보기(View)</h2>
<form name="writeFrm">
    <input type="hidden" name="num" value="<%=board.getNum() %>"/>  <!-- 공통 링크 -->

    <table border="1" width="90%">
        <tr>
            <td>번호</td>
            <td><%=board.getNum() %></td>
            <td>작성자</td>
            <td><%=board.getId() %></td>
        </tr>
        <tr>
            <td>작성일</td>
            <td><%=board.getPostdate() %></td>
            <td>조회수</td>
            <td><%=board.getVisitCount() %></td>
        </tr>
        <tr>
            <td>제목</td>
            <td colspan="3"><%=board.getTitle() %></td>
        </tr>
        <tr>
            <td>내용</td>
            <td colspan="3" height="100"><%=board.getContent() %></td> 
        </tr>
        <tr>
            <td colspan="4" align="center">
                <button type="button" onclick="location.href='edit.jsp?num=<%=board.getNum()%>';">수정하기</button>
                <button type="button" onclick="deletePost();">삭제하기</button> 
                <button type="button" onclick="location.href='list.jsp';">목록 보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
