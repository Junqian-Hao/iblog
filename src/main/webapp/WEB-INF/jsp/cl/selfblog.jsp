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

<div class="container" id="main">

    <div id="header"></div>

    <div class="row c_center">
        <div class="col-md-3" id="left_content">

            <div id="title">
                <h2><a href="/Blog/login.html">MyBlog</a></h2>
                <h5 class="text-muted">Winner Winner Chicken Dinner!</h5>
            </div>

            <div class="c_center" id="person_info">
                <img src="${pageContext.request.contextPath}/img/962bd40735fae6cd962b68f40fb30f2443a70f8c.png" height="130" width="130"
                     alt="丢失了我的头像?" class="img-circle">
                <h4 class="text-muted">Lemonreds</h4>
                <h5 class="text-muted">星星和浮云.</h5>
            </div>
            <div id="list">
                <table class="table table-hover c_center">
                    <tr class="active">
                        <td><a class="shouye_btn"><span class="glyphicon glyphicon-home"></span>
                            &nbsp;&nbsp;我的文章</a></td>
                    </tr>
                    <tr>
                        <td><a class="fenlei_btn"><span class="glyphicon glyphicon-list"></span>
                            &nbsp;&nbsp;分类</a></td>
                    </tr>
                    <tr>
                        <td><a class="guanli_btn"><span class="glyphicon glyphicon-tags"></span>
                            &nbsp;管理</a></td>
                    </tr>
                    <tr>
                        <td><a href="/Blog/AxisServlet"><span class="glyphicon glyphicon-book"></span>
                            &nbsp;&nbsp;时间轴</a></td>
                    </tr>

                </table>
            </div>
            <!-- list -->
            <br/>

            <div class="sort">
                <div class="list-group">
                    <span class="list-group-item active">分类</span>
                    <!-- 这里初始化分类 -->
                    <c:forEach var="entity" items="">
                        <a href="" class="list-group-item">${entity.key}&nbsp;&nbsp;&nbsp;&nbsp;
                            ()</a>
                    </c:forEach>
                    <!-- 初始化结束 -->
                </div>
            </div><!-- sort -->





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
                    <c:forEach var="article" items="${Articles}">
                        <div class="list-group-item">
                            <h4><a href="/cl/findArticle?aid=${article.aid}">${article.title}</a></h4>
                            <br/>
                            <span>${article.date}&nbsp;&nbsp;|</span>
                            <a href="/cl/findArticle?aid=${article.aid}">${article.summary}</a>&nbsp;&nbsp;|
                            <br/><br/>
                            <span>${article.content}</span>
                            <br/><br/><br/>
                            <a href="/cl/findArticle?aid=${article.aid}">阅读全文</a>
                            <br/>
                        </div>
                    </c:forEach>
                    <!-- 初始化文章列表完成 -->
                </div>
            </div>
            <!--按分类显示我的文章-->
            <div class="right_fenlei">
                <br/> <br/>
                <div class="list-group">
                    <a href="#" class="list-group-item active">分类</a>
                    <!-- 这里初始化列表 -->
                    <c:forEach var="map" items="">
                        <div class="sort_name">
                            <!-- 分类名字 -->
                            <span class="glyphicon glyphicon-triangle-bottom"></span> &nbsp; &nbsp;${map.key}
                        </div>
                        <div>
                            <!-- 分类信息 -->
                            <ul class="list-group">

                                <c:forEach var="list" items="">
                                    <li class="list-group-item">
                                        <div>
                                            <div>
                                                <a href="/Blog/ArticleServlet?id="></a>
                                            </div>
                                            <div class="c_right">
                                                <img src="/Blog/img/time.png">
                                                    &nbsp;&nbsp;
                                                <span class="visit"><img src="/Blog/img/visit.png">
										</span>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                    <!-- 初始化列表完成 -->

                </div>
            </div>
            <!--管理自己的博文-->
            <div class="right_guanli">
                <div class="head_line"></div>
                <div class="container" id="main">

                    <div id="header">
                        <div>
                            <h2><a href="/Blog/login.html">我的admin</a></h2>
                            <h5 class="text-muted">有点粗糙 但能用就行</h5>
                        </div>
                    </div>

                    <div class="admin_div">
                        <h4 class="btn btn-default">统计</h4>
                        <h5> 被访问了 ${visited } 次</h5>
                        <h5> 一共有 ${member}个访问者</h5>

                    </div>
                    <div class="admin_div">
                        <h4 class="btn btn-default">管理日志</h4>

                        <c:forEach var="a" items="${articles}">
                            <div class="list-group-item">
                                <span>${a.title}</span>
                                <div class="r_div">
                                    <span>${a.time}</span>

                                    <a href="/Blog/AdminDataServlet?op=edit_article&&article_id=${a.id}">
                                        <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil"
                                                                                    style="color:#5bc0de">编辑</span>&nbsp;
                                        </button>
                                    </a>

                                    <button class="btn btn-default">&nbsp;
                                        <span class="glyphicon glyphicon-trash" style="color:#d9534f"
                                              onclick="delete_article(this,'${a.id}')"> 删除</span>&nbsp;
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="admin_div">
                        <h4 class="btn btn-default">管理分类</h4><h5 style="color:#d9534f">删除分类会删除所有的文章</h5>
                        <c:forEach var="s" items="${sort}">
                            <div class="list-group-item">
                                <input type="text" class="sort" value="${s}" disabled="disabled" style="border:0px;">
                                <div class="r_div">
                                    <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil"
                                                                                style="color:#5bc0de"
                                                                                onclick="edit_sort(this,'${s}')">编辑</span>&nbsp;
                                    </button>
                                    <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-trash"
                                                                                style="color:#d9534f"
                                                                                onclick="delet_sort(this,'${s}')">删除</span>&nbsp;
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>


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

<script>
    $(function () {
        $("#btn_getdata").on("click", function () {
            $(".note_img").empty();
            var id = $("").css("", "");
        })
    })
</script>
</body>
</html>
