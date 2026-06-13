<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>구구단 입력</title>

</head>
<body>
<h1>구구단 출력 설정 프로그램</h1>
<form action="gugudan_main.jsp" method="post">
    <div>
        <h3>출력할 구구단:</h3>
        <% for (int i = 2; i <= 9; i++) { %>
        <label>
            <input type="checkbox" name="dan" value="<%= i %>"><%= i %>단
        </label>
        <% } %>
    </div>
    <br><br>
    <label for="fontColor">폰트 색상:</label>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#000000">블랙</div>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#FF0000">레드</div>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#00FF00">그린</div>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#0000FF">블루</div>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#FFFF00">옐로우</div>
    <div><input type="checkbox" name="fontColor" id="fontColor" value="#FF00FF">핑크</div>


    <br><br>
    <label for="fontSize">폰트 크기:</label>
    <div><input type="checkbox" name="fontSize" id="fontSize" value="10" onclick="handleSizeCheckbox()"> 10px</div>
    <div><input type="checkbox" name="fontSize" id="fontSize" value="12" onclick="handleSizeCheckbox()"> 12px</div>
    <div><input type="checkbox" name="fontSize" id="fontSize" value="15" onclick="handleSizeCheckbox()"> 15px</div>
    <div><input type="checkbox" name="fontSize" id="fontSize" value="17" onclick="handleSizeCheckbox()"> 17px</div>
    <div><input type="checkbox" name="fontSize" id="fontSize" value="20" onclick="handleSizeCheckbox()"> 20px</div>


    <br><br>
    <button type="submit">출력</button>
</form>
</body>
</html><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.GugudanBean_2024201019" %>
<%@ page import="java.util.Random" %>
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

    // 랜덤 생성기
    Random random = new Random();

    // 랜덤 색상 생성 함수
    String generateRandomColor() {
        return String.format("#%06x", random.nextInt(0xFFFFFF + 1));
    }

    // 랜덤 폰트 크기 생성 함수
    String generateRandomFontSize() {
        return String.valueOf(10 + random.nextInt(31)); // 10px ~ 40px
    }

    if (dans != null) {
        for (String danStr : dans) {
            int dan = Integer.parseInt(danStr);
            gugudan.setDan(dan);

            // 폰트 색상 처리
            String color = (fontColors != null && java.util.Arrays.asList(fontColors).contains("random"))
                ? generateRandomColor()
                : (fontColors != null ? fontColors[0] : generateRandomColor());

            // 폰트 크기 처리
            String size = (fontSizes != null && java.util.Arrays.asList(fontSizes).contains("random"))
                ? generateRandomFontSize()
                : (fontSizes != null ? fontSizes[0] : generateRandomFontSize());

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