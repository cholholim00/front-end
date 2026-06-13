<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");

// 폼값 받기
	String content = request.getParameter("content");
	String title = request.getParameter("title");

// 폼값을 DTO 객체에 저장
	BoardDTO board = new BoardDTO();
	board.setTitle(title);
	board.setContent(content);
	board.setId("musthave");

// DAO 객체를 통해 DB에 DTO 저장
	int iResult = 0;
	BoardDAO dao = new BoardDAO(application);
	iResult = dao.insertWrite(board);
	dao.close();


// 성공 or 실패? 
if (iResult == 1) {
    response.sendRedirect("List.jsp");
} else {
    
}
%>