<%@ page import="javabean.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2021/12/28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.work}
<%
    List<Order> list  = (List<Order>)request.getAttribute("work");
%>
<%
    while (list!=null){
    for (Order order :
            list) {
        %>
<td><%--=--%>%></td>
<td></td>
<td></td>
<td></td>
<td></td>


<%
        }
    }
%>
</body>
</html>
