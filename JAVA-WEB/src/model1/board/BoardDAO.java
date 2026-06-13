package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {
    public BoardDAO(ServletContext application) {
        super(application);
    }

    // 검색 조건에 맞는 게시물의 개수를 반환합니다.
    public int selectCount(Map<String, Object> map) {
        return 0; 
    }
    
    // 검색 조건에 맞는 게시물 목록을 반환합니다.
    public List<BoardDTO> selectList(Map<String, Object> map) { 
    	List<BoardDTO> bbs = new Vector<BoardDTO>();
    	
    	String query = "SELECT * FROM board";
    	try {
    		pstmt = getConnection().prepareStatement(query);
    		rs = pstmt.executeQuery();
    		while(rs.next()) {
    			BoardDTO board = new BoardDTO();
    			board.setNum(rs.getString("num"));
    			board.setTitle(rs.getString("title"));
    			board.setContent(rs.getString("content"));
    			board.setId(rs.getString("id"));;
    			board.setPostdate(rs.getDate("postdate"));
    			board.setVisitCount(rs.getInt("visitCount"));
//    			board.setName(rs.getString("name"));
    			bbs.add(board);
    		}
    	}catch(Exception e) {
    		System.out.println("Exception[selectList]:"+e.getMessage());
    	}    	
        return bbs;
    }
    
    // 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
    public List<BoardDTO> selectListPage(Map<String, Object> map) {
        
        return null;
    }

    // 게시글 데이터를 받아 DB에 추가합니다. 
    public int insertWrite(BoardDTO dto) {
    	int count = 0;
        
        try {
        	String query = "INSERT INTO board(num,title,content,id,visitcount) VALUES ";
	        query += "(seq_board_num.NEXTVAL, ?, ?, ?, 0)";  
	        pstmt = getConnection().prepareStatement(query);
	        pstmt.setString(1, dto.getTitle());
	        pstmt.setString(2, dto.getContent());
	        pstmt.setString(3, dto.getId());
	        count = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertWrite]:"+ e.getMessage());
        }        
        return count;
    }


    // 지정한 게시물을 찾아 내용을 반환합니다.
    public BoardDTO selectView(String num) { 
        BoardDTO board = null;
        try {
        	String query = "SELECT * FROM board WHERE num = ?";
        	pstmt = getConnection().prepareStatement(query);
        	pstmt.setString(1, num);
        	rs = pstmt.executeQuery();
        	if (rs.next()) {
        		board = new BoardDTO();
        		board.setNum(rs.getString("num"));
        		board.setTitle(rs.getNString("title"));
        		board.setContent(rs.getNString("content"));
        		board.setPostdate(rs.getDate("postdate"));
        		board.setId(rs.getNString(	"id"));
        		board.setVisitCount(rs.getInt("visitcount"));
        	}
        }catch(Exception e) {
        	System.out.println("Exception[View]: " + e.getMessage());
        }
        return board; 
    }

    // 지정한 게시물의 조회수를 1 증가시킵니다.
    public void updateVisitCount(String num) { 
                
    }
    
    // 지정한 게시물을 수정합니다.
    public int updateEdit(BoardDTO dto) {
    	int rowCount = 0;
    	try {
	    	String query = "UPDATE board SET title=?, content=? WHERE num=?";
	        pstmt = getConnection().prepareStatement(query);
	        pstmt.setString(1, dto.getTitle());
	        pstmt.setString(2, dto.getContent());
	        pstmt.setString(3, dto.getNum());
	        rowCount = pstmt.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("Exception[update]: " + e.getMessage());
    	}
        return rowCount;  
    }

    // 지정한 게시물을 삭제합니다.
    public int deletePost(BoardDTO dto) { 
        int rowCount = 0;
    	try {
        	String query = "DELETE FROM board WHERE num=?";
        	pstmt = getConnection().prepareStatement(query);
        	pstmt.setNString(1, dto.getNum());
        	rowCount = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[delete]: " + e.getMessage());
        }
        return rowCount; 
    }
}










