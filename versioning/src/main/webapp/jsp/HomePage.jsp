<%--
  Created by IntelliJ IDEA.
  User: yuan_chen1
  Date: 2016/5/10
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="./plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/comm/common.css" rel="stylesheet">
    <script src="./plugins/jquery/jquery-1.12.3.min.js"></script>
    <script src="./plugins/bootstrap/js/bootstrap.js"></script>
    <script src="./js/comm/common.js"></script>
    <title>Home</title>
</head>
<body>
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                <li>
                    <a href="#" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        首页
                    </a>
                </li>
                <li>
                    <a href="#versionControl" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        版本管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="versionControl" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="#" onclick="pageGo(3)"><i class="glyphicon glyphicon-asterisk"></i>运行版本</a></li>
                        <li><a href="#" onclick="pageGo(5)"><i class="glyphicon glyphicon-asterisk"></i>历史版本</a></li>
                        <li><a href="#" onclick="pageGo(4)"><i class="glyphicon glyphicon-asterisk"></i>自动调度</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        系统配置
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="#" onclick="pageGo(1)"><i class="glyphicon glyphicon-plus-sign"></i>环境配置</a></li>
                        <li><a href="#" onclick="pageGo(2)"><i class="glyphicon glyphicon-plus-sign"></i>模块配置</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="mainContent" class="col-md-10">
            <iframe id="demo" style="width: 100%;height: 100%">
                <div><h3>HopeRun版本管理系统</h3></div>
            </iframe>
        </div>
    </div>
</div>
</body>
</html>
