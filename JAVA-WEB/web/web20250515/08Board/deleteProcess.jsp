<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 게시글 얻기
 	String num = request.getParameter("num");
	BoardDAO dao = new BoardDAO(application);
	BoardDTO dto = dao.selectView(num);
	
	// 로그인된 사용자 ID 얻기
 	String sessionId = (String)session.getAttribute("id");

	int delResult = 0;

	// 작성자가 본인인지 확인하기
	//if(dto.getId().equals(sessionId)) {
	if(true) {
	  	// 작성자가 본인이면...
	    dto.setNum(num);
	    delResult = dao.deletePost(dto);  // 삭제!!! 
	    dao.close();
	
	    // 성공/실패 처리
	    if (delResult == 1) { 
	        // 성공 시 목록 페이지로 이동
	        response.sendRedirect("list.jsp");        
	    } else {
%>
			<script>
				history.back();
			</script>
<%
    	} 
	}
%>