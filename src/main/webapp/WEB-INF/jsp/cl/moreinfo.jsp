<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/17
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/fistpage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/academy.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/moreinfo.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/zbdxxh.png" type="image/x-icon"/>
<head>
    <title>moreinfo</title>
</head>
<body>
<%--<div class="backtolastpage">
    &nbsp;<
</div>--%>
<div class="more_back">
    <div class="content_box">

            <div class="news" style="margin-top: 50px">
                <div class="new_tit1">${Category.name}</div>
                <div class="tqkx fl">
                    <!--#begineditable name="团情快讯" viewid="179566" tagname="团情快讯" action="" layout="" contype="news" stylesysid="" template="" tplstyle="" clone="" istemp=""-->
                    <div class="tit"><span></span>
                        <h3>学院快讯</h3></div>
                    <c:forEach items="${Info}" var="info" varStatus="x">
                    <ul>
                        <li><span style="font-size: 20px;padding: 10px;color: #00a8c6;float: left;margin-left: 40px">${info.category.name}</span><p style="padding-left: 250px"><a href="/cl/findArticle?aid=${info.aid}">${info.title}</a></p><p style="padding-left: 250px">时间：${info.date}</p></li>

                    </ul>
                    </c:forEach>
                        <script>_showDynClickBatch(['dynclicks_u4_2710', 'dynclicks_u4_2769', 'dynclicks_u4_2768'], [2710, 2769, 2768], "wbnews", 1366454638)</script>
                    <!--#endeditable--></div>
            </div>

        <c:if test="${pagenums>0}">
            <nav aria-label="Page navigation" style="text-align: center;margin-top: 50px">
                <ul class="pagination">
                    <li>
                        <a href="/cl/moreinfo?pagenum=${pagenum-1}&catid=${catid}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:if test="${pagenums>5}">
                        <c:forEach begin="${pagenum}" end="${pagenum+4}" var="num">
                            <c:if test="${num<pagenums}">
                                <li><a href="/cl/moreinfo?pagenum=${num}&catid=${catid}">${num+1}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${pagenums<=5}">
                        <c:forEach begin="0" end="${pagenums-1}" var="num">
                            <li><a href="/cl/moreinfo?pagenum=${num}&catid=${catid}">${num+1}</a></li>
                        </c:forEach>
                    </c:if>
                    <li>
                        <c:if test="${pagenum+1>pagenums-1}">
                            <a href="/cl/moreinfo?pagenum=${pagenums-1}&catid=${catid}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                        <c:if test="${pagenum+1<=pagenums-1}">
                            <a href="/cl/moreinfo?pagenum=${pagenum+1}&catid=${catid}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </nav>
        </c:if>
    </div>


</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/moreinfo.js"></script>
</body>
</html>
