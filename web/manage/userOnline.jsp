<%--
  Created by IntelliJ IDEA.
  User: ZHENZHENG
  Date: 2021/11/26
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线用户列表</title>
    <link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li>在线用户列表</li>
    </ul>
</div>
<div class="rightinfo">
    <table class="imgtable">
        <thead>
        <tr>
            <th>用户登录名</th>
            <th>用户真实姓名</th>
            <th>用户角色</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${applicationScope.ONLINE_USER}" var="usermap">
            <tr height="50px">
                <td>${usermap.key}</td>
                <td>${usermap.value.userRealname}</td>
                <td><c:if test="${usermap.value.userRole==3}">普通用户</c:if>
                    <c:if test="${usermap.value.userRole==2}"> 企业管理员</c:if>
                    <c:if test="${usermap.value.userRole==1}">系统管理员</c:if></td>
                <td><a
                        href="#"
                        class="tablelink">强制下线</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
</html>

