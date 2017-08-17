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
    <title>自动调度配置</title>
</head>
<body>
<div class="page-header" style="text-align: center;margin-top:20px;">
    <h2>自动调度配置</h2>
</div>
<div style="margin-left: 20%;margin-top: 20px;margin-right: 20%;">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="startTime" class="col-sm-2 control-label">作业启动时间</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="startTime" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
        <div class="form-group">
            <label for="executeInterval" class="col-sm-2 control-label">作业执行间隔</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="executeInterval" min = "0" placeholder="作业执行间隔">
            </div>
        </div>
        <div class="form-group">
            <label for="execute" class="col-sm-2 control-label">作业执行次数</label>
            <div class="col-sm-10" id="execute">
                <label class="checkbox-inline">
                    <input type="radio" name="isSteady" id="never" value="-1" onclick="countLimit()"> 不限次数
                </label>
                <label class="checkbox-inline">
                    <input type="radio" name="isSteady" id="setCount" value="" onclick="countLimit()"> 限制次数
                </label>
                <input type="number" style="padding-bottom: 5px;" min="1" id="executeCount" disabled>
            </div>
        </div>
        <div id="successMessage" class="form-group has-success" style="display: none;">
            <label class="col-sm-2 control-label" for="inputSuccess">
            </label>
            <div class="col-sm-10">
                <div class="form-control" id="inputSuccess" style="color: chartreuse"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="autoJobStart()" id="jobStart" class="btn btn-default">启动</button>
                <button type="button" onclick="autoJobStop()" class="btn btn-default" id="jobStop" disabled>停止</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="../js/AutoJobSetting.js"></script>
<script src="../js/comm/common.js"></script>
</html>
