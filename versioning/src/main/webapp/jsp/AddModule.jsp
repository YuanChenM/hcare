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
    <title>新增模块</title>
</head>
<body>
<div class="page-header" style="text-align: center;margin-top:20px;">
    <h2>新增模块</h2>
</div>
<div style="margin-left: 20%;margin-top: 20px;margin-right: 20%;">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="moduleId" class="col-sm-2 control-label">模块ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="moduleId" placeholder="请输入模块ID">
            </div>
        </div>
        <div class="form-group">
            <label for="sysEnvId" class="col-sm-2 control-label">选择系统环境</label>
            <div class="col-sm-10">
                <select id="sysEnvId" class="form-control">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="moduleName" class="col-sm-2 control-label">模块名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="moduleName" placeholder="请输入模块名称">
            </div>
        </div>
        <div class="form-group">
            <label for="moduleShort" class="col-sm-2 control-label">模块英文简称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="moduleShort" placeholder="请输入模块英文简称">
            </div>
        </div>
        <div class="form-group">
            <label for="interfaceId" class="col-sm-2 control-label">接口ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="interfaceId" placeholder="请输入接口ID">
            </div>
        </div>
        <div class="form-group">
            <label for="interfaceURL" class="col-sm-2 control-label">接口访问路径</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="interfaceURL" placeholder="请输入接口访问路径">
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
                <button type="button" onclick="moduleAdd()" class="btn btn-default">新增</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="../js/AddModule.js"></script>
<script src="../js/comm/common.js"></script>
</html>
