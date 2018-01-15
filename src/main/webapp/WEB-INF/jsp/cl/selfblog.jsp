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
                <img src="${pageContext.request.contextPath}/img/962bd40735fae6cd962b68f40fb30f2443a70f8c.png"
                     height="130" width="130"
                     alt="丢失了我的头像?" class="img-circle">
                <h4 class="text-muted">Lemonreds</h4>
                <h5 class="text-muted">星星和浮云.</h5>
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
                    <c:forEach var="category" items="${Categories}">
                        <a href="/cl/selfBlogCategory?catid=${category.catid}" class="list-group-item">${category.name}&nbsp;&nbsp;&nbsp;&nbsp;</a>
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
                                    <a href="/cl/selfBlog?pagenum=${pagenum-1}>"
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
                                    <a href="/cl/selfBlog?pagenum=${pagenum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </c:if>
                    <!-- 初始化文章列表完成 -->
                </div>
            </div>
            <!--按分类显示我的文章-->
            <%-- <div class="right_fenlei">
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
                                 <c:forEach var="category" items="${Categories}">
                                     <li class="list-group-item">
                                         <div>
                                             <div>
                                                 <a href="/Blog/ArticleServlet?id=">${category.name}</a>
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
             </div>--%>
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
                    <%-- <div class="admin_div">
                         <h4 class="btn btn-default">管理日志</h4>

                         <c:forEach var="aritcle" items="${Articles}">
                             <div class="list-group-item">
                                 <span>${aritcle.title}</span>
                                 <div class="r_div">
                                     <span>${aritcle.date}</span>

                                     <a href="/cl/updateArticle?aid=${aritcle.aid}">
                                         <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil"
                                                                                     style="color:#5bc0de">编辑</span>&nbsp;
                                         </button>
                                     </a>
                                     <input type="hidden" value="${article.aid}" id="readytodeleteid1">
                                     <button class="btn btn-default" id="deleteArticlel">&nbsp;
                                         <span  class="glyphicon glyphicon-trash" style="color:#d9534f" >删除</span>&nbsp;
                                     </button>
                                 </div>
                             </div>
                         </c:forEach>
                     </div>--%>

                    <%--<div class="admin_div">
                        <h4 class="btn btn-default">管理分类</h4><h5 style="color:#d9534f">删除分类会删除所有的文章</h5>
                        <c:forEach var="category" items="${Categories}">
                            <div class="list-group-item">
                                <input type="text" class="sort" value="${category.name}" disabled="disabled"
                                       style="border:0px;">
                                <div class="r_div">
                                    <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil"
                                                                                style="color:#5bc0de"
                                                                                onclick="edit_sort(this,'${category.name}')">编辑</span>&nbsp;
                                    </button>
                                    <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-trash"
                                                                                style="color:#d9534f"
                                                                                onclick="delet_sort(this,'${category.name}')">删除</span>&nbsp;
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>--%>


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
<script src="${pageContext.request.contextPath}/js/admin.js"></script>


<script>
    var numb = 1;
    $(function mdToHtml() {
        for (var i = 0; i < 3; i++) {
            var id = "mdView" + numb;
            //获取要显示的内容
            numb = numb + 1;
            numb = numb % 4;
            console.log(id);
            //var content = $("#article_content").text();
            editormd.markdownToHTML(id, {
                htmlDecode: "style,script,iframe",
                emoji: true,
                taskList: true,
                tex: true, // 默认不解析
                flowChart: true, // 默认不解析
                sequenceDiagram: true, // 默认不解析
            });
        }
    });

    $(function () {
        var numb = 1;
        for (var i = 0; i < 3; i++) {
            var id = "mdView" + numb
            numb++
            numb = numb % 4
            var text = document.getElementById(id).innerHTML;
            if (text.length > 400) {
                document.getElementById(id).innerHTML = text.substring(0, 400) + "...";
            }
        }
    });
    $(".totop").click(function () {
        $("html,body").animate({scrollTop: 0});
    })

</script>
</body>
</html>
