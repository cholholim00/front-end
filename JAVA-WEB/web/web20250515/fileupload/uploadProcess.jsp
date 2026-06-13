<%@page import="FileUpload.MyFileDAO"%>
<%@page import="FileUpload.MyFileDTO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String saveDirectory = application.getRealPath("/uploads");
	System.out.println("saveDirectory: " + saveDirectory);
	int maxPostSize = 10 * 1024 * 1024;
	String encoding = "utf8";
	
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	
	String fileName = mr.getFilesystemName("attachedFile");
	String ext = fileName.substring(fileName.lastIndexOf("."));
	String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
	String newFileName = now + ext;
	System.out.println(newFileName);
	
	// 파일명 변경
	File oldFile = new File(saveDirectory + File.separator + fileName);
	File newFile = new File(saveDirectory + File.separator + newFileName);
	oldFile.renameTo(newFile);
	
	// 다른 폼값 받기
	String name = mr.getParameter("name");
	String title = mr.getParameter("title");
	String [] arrCate = mr.getParameterValues("cate");
	String cate = "";
	for (String s : arrCate){
		cate += s + " ";
	}
	
	// MyFileDTO 객체 생성
	MyFileDTO dto = new MyFileDTO();
	dto.setName(name);
	dto.setTitle(title);
	dto.setCate(cate);
	dto.setOfile(fileName);
	dto.setSfile(newFileName);
	
	// MyFileDAO 를 통해 글(파일정보) 저장
	MyFileDAO dao = new MyFileDAO();
	int count = dao.inserFile(dto);
	if (count == 0){
%>
		<script>
			alert("파일 업로드에 실패했습니다!");
			history.back();
		</script>
<%		
	}else{
		response.sendRedirect("fileList.jsp");
	}
	
%>




