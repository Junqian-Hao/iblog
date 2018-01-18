<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/12
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/bootstrap.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/zbdxxh.png" type="image/x-icon"/>
</head>
<body>
<div class="header"></div>
<div class="logo" id="logo"><img src="${pageContext.request.contextPath}/img/iblog_tm.png"></div>
<div class="login_box">
    <div class="login_header" id="login_header">嗨,请登陆：</div>
    <div class="login">

            <div class="form-group">
                <label for="username">用户名：</label>
                <input name="username" type="text" class="form-control" id="username" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="inputpassword">密码:</label>
                <input name="password" type="password" class="form-control" id="inputpassword" placeholder="Password">
            </div>
            <input type="button" class="btn btn-default" id="doLogin" value="登录"/>
        <button class="btn btn-default" style="float: right" id="regist">注&nbsp;册</button>
    </div>
    <div class="regist">

        <div class="form-group">
        <label for="registusername">用户名:</label>
        <input name="registusername" type="text" class="form-control" id="registusername" placeholder="Username">
    </div>
        <div class="form-group">
            <label for="nickname">昵称:</label>
            <input name="nickname" type="text" class="form-control" id="nickname" placeholder="昵称">
        </div>
        <select class="form-control" id="academy" name="name">
            <c:forEach items="${Academys}" var="academy">
            <option value="${academy.catid}">${academy.name}</option>
            </c:forEach>
        </select>
            <div class="form-group">
                <label for="registpassword">密码:</label>
                <input name="registpassword"type="password" class="form-control" id="registpassword"  placeholder="Password">
            </div>
            <div class="form-group">
                <label for="confirm_password">确认输入密码</label>
                <input type="password" class="form-control" id="confirm_password" name="confirm_password"
                       placeholder="RPassword">
            </div>

            <input type="submit" class="btn btn-default" id="doRegist" value="注册"/>
        <input type="button" class="btn btn-default" style="float: right;" id="return" value="返回">
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/Cllogin.js"></script>

<script>
//      $.validator.setDefaults({
//         debug: true
//     })
//     $().ready(function () {
// // 在键盘按下并释放及提交后验证提交表单
//         $("#commentForm").validate({
//        rules: {
//            username: {
//                required: true,
//                minlength: 2
//            },
//            password: {
//                required: true,
//                minlength: 2
//            },
//            confirm_password: {
//                equalTo: "#password"
//            },
//
//            "topic[]": {
//                required: "#newsletter:checked",
//                minlength: 2
//            },
//            agree: "required"
//        },
//        messages: {
//            firstname: "请输入您的名字",
//            lastname: "请输入您的姓氏",
//            username: {
//                required: "请输入用户名",
//                minlength: "用户名必需由两个字母组成"
//            },
//            password: {
//                required: "请输入密码",
//
//            },
//            confirm_password: {
//                equalTo: "两次密码输入不一致"
//            },
//
//        }
//    });
//    });
//    $().ready(function () {
//
//        $("#registForm").validate({
//            rules: {
//                username: {
//                    required: true,
//                    minlength: 6
//                },
//                password: {
//                    required: true,
//                    minlength: 6
//                },
//                confirm_password: {
//                    required: true,
//                    equalTo: "#password"
//                },
//                email: {
//                    required: true,
//                    email: true
//                },
//                "topic[]": {
//                    required: "#newsletter:checked",
//                    minlength: 2
//                },
//                agree: "required"
//            },
//            messages: {
//                firstname: "请输入您的名字",
//                lastname: "请输入您的姓氏",
//                username: {
//                    required: "请输入用户名",
//                    minlength: "用户名必需由两个字母组成"
//                },
//                password: {
//                    required: "请输入密码",
//
//                },
//                confirm_password: {
//                    required: "请输入密码",
//                    equalTo: "两次密码输入不一致"
//                },
//                email: "请输入一个正确的邮箱",
//
//            }
//        });
//    });

</script>
</body>
</html>
