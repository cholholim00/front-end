<%--
  Created by IntelliJ IDEA.
  User: joettongkko
  Date: 25. 4. 3.
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String uName = "jene"; %>

<jsp:useBean id="member" class="com.hoseo.user.Member"></jsp:useBean>
<jsp:setProperty name="member" property="*" />
<jsp:setProperty name="member" property="sex" param="gender"/>
<jsp:setProperty name="member" property="userName"  value="<%=uName %>"/>

아이디 : <jsp:setProperty name="member" property="userId" /><br>
비밀번호 : <jsp:setProperty name="member" property="password" /><br>
이름 : <jsp:setProperty name="member" property="userName" /><br>
성별 : <jsp:setProperty name="member" property="sex" /><br>
취미 : <jsp:setProperty name="member" property="hobby" /><br>
취미 : <jsp:setProperty name="member" property="strHobby" /><br>
학과 : <jsp:setProperty name="member" property="department" /><br>
