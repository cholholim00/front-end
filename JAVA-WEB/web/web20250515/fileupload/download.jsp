<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String savedFileName = request.getParameter("sName");
	String oriFileName = request.getParameter("oName");
	String saveDirectory = application.getRealPath("/uploads");
	
	//System.out.println(saveDirectory + File.separator + savedFileName + ",  " + oriFileName );
	
	// 입력 스트림 생성
	File file = new File(saveDirectory + File.separator + savedFileName);
	InputStream inStream = new FileInputStream(file);
	
	// (한글) 파일 깨짐명 방지
	String client = request.getHeader("User-Agent");
	if (client.indexOf("WOW64") == -1){
		oriFileName = new String(oriFileName.getBytes("UTF-8"),"ISO-8859-1");
	}else{
		oriFileName = new String(oriFileName.getBytes("KSC5601"),"ISO-8859-1");
	}
	
	// 파일 다운로드용 응답 헤더 설정
	response.reset();
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", 
			"attachment; filename=\""+ oriFileName +"\"");
	response.setHeader("Content-Length", "" + file.length());
	
	// 출력 스트림 초기화
	out.clear();
	
	// 출력 스트림을 설정
	OutputStream outStream = response.getOutputStream();
	
	// 출력 스트림에 파일의 내용을 출력
	byte b [] = new byte[(int)file.length()];
	int readBuffer;
	while((readBuffer = inStream.read(b)) > 0) {
		outStream.write(b, 0, readBuffer);
	}
	
	// 스트림 닫음
	inStream.close();
	outStream.close();
		
%>