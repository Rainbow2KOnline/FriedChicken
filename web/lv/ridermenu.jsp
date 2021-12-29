<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2021/12/28
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javabean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="javax.xml.stream.Location" %>
<%@ page import="java.awt.*" %>
<%@ page import="sun.plugin.javascript.navig4.Window" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Order> list  = (List<Order>)request.getAttribute("list");
%>
<%
    long i = 0;
    while (list!=null){
    for (Order order :
            list) {

    %>
<form action="RiderServlet" method="post">
<tr height="50px">
    <td><input type="checkbox" value=“<%order.getId();%>” name="clean<%order.getId();%>"></td>
    <td></td>
    <td></td>
    <td></td>


</tr>
    <%
    }
    }%>

    <input type="submit"  value="接单">
    <input type="submit" onclick="javascript:window.location.reload()">

</form>
    <a href="workmenu.jsp?type=showmenu">已接单</a>
</body>
</html>
