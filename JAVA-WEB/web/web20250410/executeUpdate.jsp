<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>executeUpdate(): insert, update, delete</h2>
<%
	JDBConnect jdbc = new JDBConnect();
	//jdbc.conn.createStatement();
	String id="test2";
	String pwd = "asdf";
	String name = "HongGilDong";
	String sql = "insert into member values(?,?,?,sysdate)";
	PreparedStatement pstmt = jdbc.getConnection().prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pwd);
	pstmt.setString(3, name);
	int count = pstmt.executeUpdate();
	out.println(count + "행이 입력되었습니다!");
	jdbc.close();
%>
    
    