<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>职位申请查询列表</title>
    <base href="<%=basePath%>"/>
    <link href="css/manageadmin.css" rel="stylesheet" type="text/css"/>
    <!-- 日期控件js -->
    <script src="js/Calendar6.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript">
        var xhr = false;

        function loadCompanyData() {
            xhr = new XMLHttpRequest();
            var url = "JobApplyServlet";
            var content = "type=companyNameList";
            xhr.open("POST", url, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var list = eval("(" + xhr.responseText + ")");
                    for (var i = 0; i < list.length; i++) {
                        var item = new Option(list[i].companyName, list[i].companyId);
                        document.getElementById("companyId").options.add(item);
                    }
                }
            };
            xhr.setRequestHeader("Content-Length", content.length);
            xhr.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
            xhr.send(content);
        }

        function queryJob(companyElem) {
            var companyId = companyElem.value;
            $.getJSON("JobApplyServlet", {"type": "jobNameList", "companyId": companyId},
                function (json) {
                    var opts = document.getElementById("jobId").options;
                    for (var i = 1; i < opts.length; i++)
                        opts.remove(i);
                    for (var i = 0; i < json.length; i++) {
                        var item = new Option(json[i].jobName, json[i].jobId);
                        opts.add(item);
                    }
                });
        }

        function query() {
            var companyId = document.getElementById("companyId").value;
            var jobId = document.getElementById("jobId").value;
            var startDate = document.getElementById("startDate").value;
            var endDate = document.getElementById("endDate").value
            console.log("yes")
            $.getJSON("JobApplyServlet", {
                "type": "query",
                "companyId": companyId,
                "jobId": jobId,
                "startDate": startDate,
                "endDate": endDate
            }, function (json) {
                var str = "";
                if (json.length == 0)
                    str += "<tr height='50px'> <td colspan=7>没有匹配查询的数据</td></tr>";
                for (var i = 0; i < json.length; i++) {
                    str += " <tr> <td>" + json[i].applicant.resume.realName + "</td>";
                    str += "<td>" + json[i].job.jobName + "</td>";
                    if (json[i].applyState == 1)
                        str += "<td>申请</td>";
                    if (json[i].applyState == 2)
                        str += "<td>审核</td>";
                    if (json[i].applyState == 3)
                        str += "<td>通知</td>";
                    str += "<td>" + (new Date(json[i].applyDate)).toLocaleString()
                        + "</td>";
                    str += "<td><a href='#' class='tablelink'>申请审核</a> &nbsp;&nbsp; " +
                        "<a href = '#' class = 'tablelink' > 面试通知 </a></td > </tr>";
                }
                $("#viewData").html(str);
            });
        }
    </script>
</head>
<body onload="loadCompanyData()">
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li>职位申请查询列表</li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="seachform">
            <li>
                <div class="vocation">
                    所属企业：<select class="select3" name="companyId" id="companyId"
                                 onchange="queryJob(this)">
                    <option value="0">全部企业</option>
                </select>
                </div>
            </li>
            <li>
                <div class="vocation">
                    所属职位：<select class="select3" name="jobId" id="jobId">
                    <option value="0">全部职位</option>
                </select>
                </div>
            </li>
            <li>申请日期：<input type="text" id="startDate" name="startDate"
                            onclick="SelectDate(this)" readonly="readonly" class="scinput"/>--
                <input type="text" name="endDate" id="endDate"
                       onclick="SelectDate(this)" readonly="readonly" class="scinput"/>
            </li>
            <li><input type="button" class="scbtn" value="查询" onclick="query()"/>
            </li>
        </ul>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th>姓名</th>
            <th>申请职位</th>
            <th>申请状态</th>
            <th>申请日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="viewData"></tbody>
    </table>
</div>
</body>
</html>
