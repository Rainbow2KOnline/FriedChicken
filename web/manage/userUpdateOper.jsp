<%--
  Created by IntelliJ IDEA.
  User: ZHENZHENG
  Date: 2021/10/22
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.dao.UserDAO" %>
<%--<%@ page import="com.dao.UserDAO" %>--%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user"
             class="com.javabean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
    UserDAO dao = new UserDAO();
    dao.update(user);
    response.sendRedirect("userList.jsp");
%>

