<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/11
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/selfblog.css">
</head>
<body>
<div class="head_line"></div>

<div class="container">


    <div class="row c_center">
        <div class="col-md-3" id="left_content">

            <div id="title">
                <h2><a href="/cl/firstpage">MyBlog</a></h2>
                <h5 class="text-muted">Winner Winner Chicken Dinner!</h5>
            </div>

            <div class="c_center" id="person_info">
                <img src="${pageContext.request.contextPath}/img/zbdxxh.png"
                     height="130" width="130"
                     alt="丢失了我的头像?" class="img-circle">
                <h4 class="text-muted">${sessionScope.User.nickname}</h4>
                <h5 class="text-muted">${UserBelongs[0].category.name}</h5>
            </div>
            <div id="list">
                <table class="table table-hover c_center">
                    <tr class="active">
                        <td><a href="/cl/selfBlog" class="shouye_btn"><span class="glyphicon glyphicon-home"></span>
                            &nbsp;&nbsp;我的文章</a></td>
                    </tr>
                    <%--<tr>
                        <td><a class="fenlei_btn"><span class="glyphicon glyphicon-list"></span>
                            &nbsp;&nbsp;分类</a></td>
                    </tr>--%>
                    <tr>
                        <td><a class="guanli_btn"><span class="glyphicon glyphicon-tags"></span>
                            &nbsp;管理</a></td>
                    </tr>
                   <%-- <tr>
                        <td><a class="team_btn"><span class="glyphicon glyphicon-book"></span>
                            &nbsp;&nbsp;我的团队</a></td>
                    </tr>--%>

                </table>
            </div>
            <!-- list -->
            <br/>

            <div class="sort">
                <div class="list-group">
                    <span class="list-group-item active">我的团队</span>
                    <!-- 这里初始化分类 -->
                    <c:forEach var="userBelongs" items="${UserBelongs}">
                        <a href="/cl/selfBlogCategory?catid=${userBelongs.category.catid}" class="list-group-item">${userBelongs.category.name}&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </c:forEach>
                    <!-- 初始化结束 -->
                </div>
            </div><!-- sort -->
            <a href="/cl/writeArticle">
                <span class="glyphicon glyphicon-plus">&nbsp;&nbsp;写新文章&nbsp;&nbsp;</span>
            </a>

            <!-- admin here -->
            <%-- <c:if test="${sessionScope.user!=null}">
                 <a href="../admin/add.jsp">
                     <span class="glyphicon glyphicon-plus">&nbsp;&nbsp;写新文章&nbsp;&nbsp;</span>
                 </a>

             </c:if>--%>
            <!--  -->

        </div>
        <div class="col-md-2" id="center_content">
        </div>
        <div class="col-md-7 " id="right_Content">
            <!--我的文章简写列表-->
            <div class="right_shouye">
                <br/>
                <br/>
                <div class="list-group">
                    <a href="#" class="list-group-item active">文章</a>
                    <!-- 这里初始化文章列表 -->
                    <c:forEach var="article" items="${Articles}" varStatus="status">
                        <div class="list-group-item">
                            <h4><a href="/cl/findArticle?aid=${article.aid}">${article.title}</a></h4>
                            <br/>
                            <span>${article.date}&nbsp;&nbsp;|</span>
                            <a href="/cl/findArticle?aid=${article.aid}">${article.summary}</a>&nbsp;&nbsp;|
                            <br/><br/>
                            <span>  <div id="mdView${status.count}" class="mdView"
                                         style="text-decoration: none;width: 550px;color: black;word-wrap: break-word; ">
                                        <textarea id="article_content">${article.content} </textarea>
                                    </div>
                            </span>
                            <br/><br/><br/>
                            <a href="/cl/findArticle?aid=${article.aid}" style="display: inline-block">阅读全文</a>
                            <div class="r_div" style="text-align: right;display: inline-block;margin-left: 400px">
                                <span>${aritcle.date}</span>

                                <a href="/cl/updateArticle?aid=${article.aid}">
                                    <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil"
                                                                                style="color:#5bc0de">编辑</span>&nbsp;
                                    </button>
                                </a>
                                <input type="hidden" value="${article.aid}" id="readytodeleteid">
                                <a href="/cl/deleteArticle?aid=${article.aid}">
                                    <button onclick="deleteArticle()" class="btn btn-default" id="deleteArticle">&nbsp;
                                        <span class="glyphicon glyphicon-ban-circle" style="color:#d9534f">删除</span>&nbsp;
                                    </button>
                                </a>
                            </div>
                            <br/>
                        </div>
                    </c:forEach>
                    <c:if test="${pagenums>0}">
                        <nav aria-label="Page navigation" style="text-align: center">
                            <ul class="pagination">
                                <li>
                                    <a href="/cl/selfBlog?pagenum=${pagenum-1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <c:if test="${pagenums>5}">
                                    <c:forEach begin="${pagenum}" end="${pagenum+4}" var="num">
                                        <c:if test="${num<pagenums}">
                                            <li><a href="/cl/selfBlog?pagenum=${num}">${num+1}</a></li>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pagenums<=5}">
                                    <c:forEach begin="0" end="${pagenums-1}" var="num">
                                        <li><a href="/cl/selfBlog?pagenum=${num}">${num+1}</a></li>
                                    </c:forEach>
                                </c:if>
                                <li>
                                    <c:if test="${pagenum+1>pagenums-1}">
                                        <a href="/cl/selfBlog?pagenum=${pagenums-1}"
                                           aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </c:if>
                                    <c:if test="${pagenum+1<=pagenums-1}">
                                        <a href="/cl/selfBlog?pagenum=${pagenum+1}"
                                           aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </c:if>
                                </li>
                            </ul>
                        </nav>
                    </c:if>
                    <!-- 初始化文章列表完成 -->
                </div>
            </div>
            <!--按分类显示我的文章-->
            <!--管理自己的博文-->
            <div class="right_guanli">
                <div class="head_line"></div>
                <div class="container" id="main">

                    <div id="header">
                        <div>
                            <h2><a href="/Blog/login.html">我的admin</a></h2>
                            <h5 class="text-muted">以吾为鉴</h5>
                        </div>
                    </div>

                    <div class="admin_div">

                        <h4 class="btn btn-default">个人信息修改</h4>

                        <div class="list-group-item">
                            <label for="nickname">昵称</label>
                            <input type="text" class="form-control" placeholder="昵称" id="nickname"
                                   value="${sessionScope.User.nickname}">
                            <br>
                            <!--<label for="username">用户名</label>-->
                            <!--<input type="text" class="form-control" placeholder="用户名" id="username">-->
                            <!--<br>-->
                            <label for="originpassword">原密码</label>
                            <input type="password" class="form-control" placeholder="若要修改密码请填入" id="originpassword">
                            <input type="hidden" id="uid" value="${sessionScope.User.uid}"/>
                            <br>
                            <label for="inputpassword">新密码</label>
                            <input type="password" class="form-control" placeholder="新密码" id="inputpassword">
                            <br>
                            <label for="checkpassword">确认输入密码</label>
                            <input type="password" class="form-control" placeholder="请确认" id="checkpassword">
                            <span id="error" style="color: red"></span>
                            <br>
                            <button class="btn btn-default" id="changeself">&nbsp;<span
                                    class="glyphicon glyphicon-pencil"
                                    style="color:#5bc0de">编辑</span>&nbsp;
                            </button>


                            <button class="btn btn-default">&nbsp;
                                <span class="glyphicon glyphicon-trash" style="color:#d9534f"> 取消</span>&nbsp;
                            </button>
                        </div>
                    </div>


                </div>
            </div>
            <!--管理自己的团队-->
            <div class="right_team">
                <div class="list-group">
                    <a href="#" class="list-group-item active">我们是一个团队</a>
                    <div class="admin_div">



                        <c:forEach var="userbelong" items="${UserBelongs}" varStatus="x">
                            <h4 class="btn btn-default">团队${x.count}</h4>

                            <!--<label for="username">用户名</label>-->
                            <!--<input type="text" class="form-control" placeholder="用户名" id="username">-->
                            <!--<br>-->

                            <ul class="list-group">
                                <li class="list-group-item">
                                        <div>
                                            <div>
                                                <a>${userbelong.category.name}</a>
                                            </div>
                                        </div>
                                    </li>

                            </ul>
                        </c:forEach>
                    </div>

                </div>
            </div>
            <%--foot--%>
            <div class="foot_line"></div>
        </div><!-- container -->


    </div>
</div>
</div>
<div class="foot_line"></div>
</div><!-- container -->

<div class="totop">
    ^
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/selfblog.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editormd.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/marked.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/prettify.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/underscore.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/sequence-diagram.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/flowchart.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/jquery.flowchart.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editormd.js"></script>



</body>
</html>
