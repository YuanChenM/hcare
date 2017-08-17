
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/comm/common.css" rel="stylesheet">
    <script src="../plugins/jquery/jquery-1.12.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.js"></script>
    <title>运行版本编辑</title>
</head>
<body>
<div class="page-header" style="text-align: center;margin-top:20px;">
    <h2>运行版本编辑</h2>
</div>
<div style="margin-left: 20%;margin-top: 20px;margin-right: 20%;">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="sysEnvId" class="col-sm-2 control-label">环境ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvId" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="sysEnvName" class="col-sm-2 control-label">环境名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sysEnvName" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="projectVersion" class="col-sm-2 control-label">工程版本</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="projectVersion" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="svnVersion" class="col-sm-2 control-label">SVN版本</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="svnVersion" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="runing" class="col-sm-2 control-label">是否运行中</label>
            <div class="col-sm-10" id="runing">
                <label class="checkbox-inline">
                    <input type="radio" name="isRuning" id="isYRuning"
                           value="1" disabled> 运行中
                </label>
                <label class="checkbox-inline">
                    <input type="radio" name="isRuning" id="isNRuning"
                           value="0" disabled> 不在运行
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="steady" class="col-sm-2 control-label">是否稳定版本</label>
            <div class="col-sm-10" id="steady">
                <label class="checkbox-inline">
                    <input type="radio" name="isSteady" id="isYSteady"
                           value="1"> 稳定版本
                </label>
                <label class="checkbox-inline">
                    <input type="radio" name="isSteady" id="isNSteady"
                           value="0"> 不稳定版本
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="saveModuleEdit()" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="../js/SysEnvEdit.js"></script>
<script src="../js/comm/common.js"></script>
</html>
