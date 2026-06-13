<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.GugudanBean_2024201019" %>
<%@ page import="com.example.RandomUtils" %>
<%@ page import="java.util.Arrays" %>
<jsp:useBean id="gugudan" class="com.example.GugudanBean_2024201019" scope="page" />
<!DOCTYPE html>
<html>
<head>
    <title>구구단 결과</title>
</head>
<body>
<%
    // 폼 데이터 가져오기
    String[] dans = request.getParameterValues("dan");
    String[] fontColors = request.getParameterValues("fontColor");
    String[] fontSizes = request.getParameterValues("fontSize");

    if (dans != null) {
        for (String danStr : dans) {
            int dan = Integer.parseInt(danStr);
            gugudan.setDan(dan);

            // 폰트 색상 처리
            String color = (fontColors != null && Arrays.asList(fontColors).contains("random"))
                    ? RandomUtils.generateRandomColor()
                    : (fontColors != null ? fontColors[0] : RandomUtils.generateRandomColor());

            // 폰트 크기 처리
            String size = (fontSizes != null && Arrays.asList(fontSizes).contains("random"))
                    ? RandomUtils.generateRandomFontSize()
                    : (fontSizes != null ? fontSizes[0] : RandomUtils.generateRandomFontSize());

            gugudan.setFontColor(color);
            gugudan.setFontSize(size);
%>
<div style="color: <%= gugudan.getFontColor() %>; font-size: <%= gugudan.getFontSize() %>px;">
    <h3><%= dan %>단</h3>
    <p><%= gugudan.generateGugudan() %></p>
</div>
<%
    }
} else {
%>
<p>선택된 구구단이 없습니다.</p>
<%
    }
%>
</body>
</html>