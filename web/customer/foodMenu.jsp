<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javabean.Food" %>
<%@ page import="java.util.List,javabean.Food" %>
<%
    String basePath =
            request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<%
    List<Food> list  = (List<Food>)request.getAttribute("list");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>菜单</title>
    <base href="<%=basePath%>">
    <link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">点餐页面</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png" /></span><a href="./companyAdd.html">添加</a></li>
            <li><span><img src="../images/t03.png" /></span><a href="#">删除</a></li>
        </ul>
    </div>
<table class="imgtable">
    <thead>
    <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>炸鸡名称</th>
        <th>图片</th>
        <th>单价</th>
        <th>描述</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(list != null) {
            for(Food c : list){
    %>
    <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td><%=c.getName() %></td>
        <td><%=c.getPic() %></td>
        <td><%=c.getPrice() %></td>
        <td><%=c.getDescribe() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>

