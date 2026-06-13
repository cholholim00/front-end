<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" class="com.hoseo.product.Product"></jsp:useBean>
<jsp:setProperty name="product" property="*" />

제품번호 : <jsp:getProperty name="product" property="prodId"/>
제품유형 : <jsp:setProperty name="product" property="prodType"/>
제조사 : <jsp:setProperty name="product" property="company"/>
