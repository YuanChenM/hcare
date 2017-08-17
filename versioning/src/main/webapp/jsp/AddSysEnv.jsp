<%--
  Created by IntelliJ IDEA.
  User: yuan_chen1
  Date: 2016/5/10
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/comm/common.css" rel="stylesheet">
    <script src="../plugins/jquery/jquery-1.12.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.js"></script>
    <title>新增运行环境</title>
</head>
<body>
<div class="page-header" style="text-align: center;margin-top:20px;">
    <h2>新增系统运行环境</h2>
</div>
<div style="margin-left: 20%;margin-top: 20px;margin-right: 20%;">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="sysEnvId" class="col-sm-2 control-label">环境ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvId" placeholder="请输入系统环境ID">
            </div>
        </div>
        <div class="form-group">
            <label for="sysEnvName" class="col-sm-2 control-label">环境名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvName" placeholder="请输入系统环境名称">
            </div>
        </div>
        <div class="form-group">
            <label for="sysEnvIpAddr" class="col-sm-2 control-label">访问IP</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvIpAddr" placeholder="请输入系统环境访问IP">
            </div>
        </div>
        <div class="form-group">
            <label for="sysEnvURL" class="col-sm-2 control-label">war包存放路径</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvURL" placeholder="请输入系统环境war包存放路径">
            </div>
        </div>
        <div id="successMessage" class="form-group has-success" style="display: none;">
            <label class="col-sm-2 control-label" for="inputSuccess">
            </label>
            <div class="col-sm-10">
                <div class="form-control" id="inputSuccess" style="color: chartreuse"></div>
            </div>
        </div>
        <div id="errorMessage" class="form-group has-error" style="display: none;">
            <label class="col-sm-2 control-label" for="inputError">
            </label>
            <div class="col-sm-10">
                <div class="form-control" id="inputError" style="color: #FF0000"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="sysEnvAdd()" class="btn btn-default">新增</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="../js/AddSysEnv.js"></script>
<script src="../js/comm/common.js"></script>
</html>
