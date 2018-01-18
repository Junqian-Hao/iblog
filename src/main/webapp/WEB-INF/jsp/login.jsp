<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/html5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/respond.min.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet"
          type="text/css"/>

    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <title>后台登录 - H-ui.admin.page v3.0</title>
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
    <style type="text/css">
        .right {
            background-color: #c5fbd0;
            border-color: #99c698;
            color: #04cc3e
        }
    </style>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value=""/>
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="${pageContext.request.contextPath}/ms/doLogin" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text" placeholder="账户" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input id="kaptha" class="input-text size-L " type="text" placeholder="验证码"
                           onblur="if(this.value==''){this.value='验证码:'}"
                           onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
                    <img id="defaultKaptcha" src="${pageContext.request.contextPath}/ms/defaultKaptcha">
                    <a id="kanbuq" href="javascript:kanbug();">看不清，换一张</a>
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <%--<label for="online">--%>
                    <%--<input type="checkbox" name="online" id="online" value="">--%>
                    <%--使我保持登录状态</label>--%>
                    <div id="errorMessage" style="color: red;display: none">验证码错误</div>
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input name="" type="button" class="btn btn-success radius size-L" onclick="login()"
                           value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L"
                           value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright iblog by H-ui.admin.page.v3.0</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.js"></script>
<script>
    <%--点击切换验证码图片--%>
    var kanbug = function () {
        $("#defaultKaptcha").attr("src", "${pageContext.request.contextPath}/ms/defaultKaptcha?time=" + new Date().getTime());
    };

    //验证码动态验证
    $(function () {
        $("#kaptha").bind("input propertychange", function () {
            var val = $("#kaptha").val();
            console.log(val);
            if (val.length > 3) {

                var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "${pageContext.request.contextPath}/ms/imgvrifyControllerDefaultKaptcha",
                    "method": "POST",
                    "headers": {
                        "Content-Type": "application/json",
                        "Cache-Control": "no-cache"
                    },
                    "processData": false,
                    "data": "{\"kap\":\"" + val + "\"}"
                };

                $.ajax(settings).done(function (response) {
                    console.log(response);
                    if (response.code == 1) {
                        //清除错误提示
                        $("#errorMessage").css({
                            "display": "none"
                        });
                        $("#kaptha").removeClass("error").addClass("right");

                    } else {
                        //显示错误提示
                        $("#errorMessage").html("验证码错误").css({
                            "display": "block"
                        });
                        $("#kaptha").removeClass("rigth").addClass("error");
                    }
                });

            } else {
                //文本框内字符小于4清除错误提示
                $("#kaptha").removeClass("error");
                $("#kaptha").removeClass("right");
                $("#errorMessage").css({
                    "display": "none"
                });

            }
        });
    });

    function login() {
        if ($("#kaptha").hasClass("right")) {
            var data = $("form").serialize();
            $.ajax({
                type: 'post',
                async:"false",
                url: "${pageContext.request.contextPath}/ms/doLogin",
                cache: false,
                data: data,
                success: function (data) {
                    console.log(data);
                    if (data.code == 1) {
                        $(location).attr("href", "${pageContext.request.contextPath}/ms/index");
                    } else {
                        $("#errorMessage").html("账号或密码错误！！").css("display", "block");
                    }
                },
                error: function () {
                    alert("请求失败");
                }
            });
        }else {
            //未填写验证码
            //显示错误提示
            $("#errorMessage").html("验证码错误").css({
                "display": "block"
            });
            $("#kaptha").removeClass("rigth").addClass("error");
        }
    }

</script>
</body>
</html>