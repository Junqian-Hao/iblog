<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/13
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.css"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/zbdxxh.png" type="image/x-icon"/>
</head>
<body>
<article class="page-404 minWP text-c">
    <p class="error-title"><img src="${pageContext.request.contextPath}/img/sadface.png">
        <span class="va-m"> 404</span>
    </p>
    <p class="error-description">不好意思，您访问的页面不存在~</p>
    <p class="error-info">您可以：
        <a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a>
        <span class="ml-20">|</span>
        <a href="/cl/firstpage" class="c-primary ml-20">去首页 &gt;</a>
    </p>
</article>
</body>
</html>
