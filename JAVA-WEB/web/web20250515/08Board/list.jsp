<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="model1.board.BoardDAO"%> 
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DAO를 생성해 DB에 연결
	BoardDAO dao = new BoardDAO(application);
	
	// 사용자가 입력한 검색 조건을 Map에 저장
	Map<String, Object> param = new HashMap<String, Object>();
	String searchField = request.getParameter("searchField");
	String searchWord = request.getParameter("searchWord");
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
			
	// 게시물 물록 받기
	List<BoardDTO> boardLists = dao.selectList(param);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
</head>
<body>
	
    <h2>목록 보기(List)</h2>
    <!-- 검색폼 --> 
    <form method="get">  
    <table border="1" width="90%">
    <tr>
        <td align="center">
            <select name="searchField"> 
                <option value="title">제목</option> 
                <option value="content">내용</option>
            </select>
            <input type="text" name="searchWord" />
            <input type="submit" value="검색하기" />
        </td>
    </tr>   
    </table>
    </form>
    <!-- 게시물 목록 테이블(표) --> 
    <table border="1" width="90%">
        <!-- 각 칼럼의 이름 --> 
        <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="15%">작성자</th>
            <th width="10%">조회수</th>
            <th width="15%">작성일</th>
        </tr>
        
        <!-- 목록의 내용 --> 
        <!-- 게시물이 없을 때 -->
<% 
	if (boardLists.isEmpty()) {
%>
		<tr>
            <td colspan="5" align="center">
                등록된 게시물이 없습니다^^*
            </td>
        </tr>
<%		
	}else{
%>
		<!-- 게시물이 있을 때 -->
        <% //for(int i=0; i<boardLists.size(); i++){ %>
        <% for(BoardDTO board: boardLists){ %>
        <tr align="center">
            <td><%=board.getNum() %></td>
            <td align="left">
            	<a href="view.jsp?num=<%=board.getNum()%>"><%=board.getTitle() %></a>            
            </td>
            <td align="center"><%=board.getId() %></td>
            <td align="center"><%=board.getVisitCount() %></td>
            <td align="center"><%=board.getPostdate() %></td>
        </tr>
        <%} %>
<%		
	}
%>      
    </table>
    <!--목록 하단의 [글쓰기] 버튼-->
    <table border="1" width="90%">
        <tr align="right">
            <td><button type="button" onclick="location.href='Write.jsp';">글쓰기
                </button></td>
        </tr>
    </table>
</body>
</html>
