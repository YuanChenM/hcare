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
    <script src="./js/Login.js"></script>
    <title>Login</title>
</head>
<body>
<div class="page-header">
    <h1 align="center">版本管理系统登陆</h1>
</div>
<div style="width: 100%;">
    <form class="form-horizontal" role="form" style="width: 20%;margin-left: 40%">
        <div class="form-group">
            <label for="account" class="col-sm-2 control-label">账号</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="account"
                       placeholder="请输入账号">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>

            <div class="col-sm-10">
                <input type="password" class="form-control" id="password"
                       placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="loginFlg"> 请记住我
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="loginButton" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
