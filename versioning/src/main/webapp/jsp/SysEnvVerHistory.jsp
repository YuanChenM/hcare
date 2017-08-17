
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/comm/common.css" rel="stylesheet">
    <script src="../plugins/jquery/jquery-1.12.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.js"></script>
    <title>历史版本</title>
</head>
<body>
<div class="page-header" style="text-align: center;margin-top:20px;">
    <h2>历史版本</h2>
</div>
<div class="panel-group" style="margin-left: 10px;margin-top: 10px;margin-right: 10px;">
    <table class="table-condensed">
        <tr>
            <td width="5%" align="right">运行环境</td>
            <td width="10%" align="left"><input type="text" id="sysEnvName"/></td>
            <td width="5%" align="right">系统版本</td>
            <td width="10%" align="left"><input type="text" id="svnVersion"/></td>
            <td width="5%" align="right">是否稳定版</td>
            <td width="10%" align="left">
                <select id="isSteady" style="width:80%">
                    <option value="0">不稳定版本</option>
                    <option value="1">稳定版本</option>
                </select>
            </td>
            <td width="5%" align="right">是否运行中</td>
            <td width="10%" align="left">
                <select id="isRuning" style="width:80%">
                    <option value="0">不在运行</option>
                    <option value="1">运行中</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="5%" align="right">
                <button type="button" class="btn btn-default btn-sm" id="searchVer">
                    <span class="glyphicon glyphicon-search"></span> 检索
                </button>
            </td>
        </tr>
    </table>
</div>
<div style="margin-left: 10px;margin-top: 20px;margin-right: 10px;">
    <div class="panel-group">
        <table class="table table-bordered" id="historyTable">
            <tr>
                <td align="center" style="font-weight: bold" width="10%">运行环境</td>
                <td align="center" style="font-weight: bold" width="10%">运行工程版本</td>
                <td align="center" style="font-weight: bold" width="10%">系统版本</td>
                <td align="center" style="font-weight: bold" width="10%">是否稳定版</td>
                <td align="center" style="font-weight: bold" width="10%">是否运行中</td>
                <td align="center" style="font-weight: bold" width="10%">发布时间</td>
            </tr>
        </table>
    </div>
</div>
</body>
<script src="../js/SysEnvVerHistory.js"></script>
<script src="../js/comm/common.js"></script>
</html>
