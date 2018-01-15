<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/11
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/article.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/comment.css">
</head>
<body>
<div class="head_line"></div>
<div class="container" id="main">

    <div class="head">
        <div id="title">
            <h2>
                <a href="/Blog/index.jsp">IBlog</a>
            </h2>
        </div>
    </div>

    <div id="article">

        <div id="a_head ">
            <h3>${ArticleMap.Article.title}</h3>
            <br/>
            <div>
                <h5>
                    <span>${ArticleMap.Article.date}</span>
                    ${ArticleMap.Article.user.username}
                </h5>
            </div>
            <div class="r_div">
                <h5>
                    <span class="glyphicon glyphicon-eye-open">&nbsp;${article.visit}&nbsp;</span>
                    <span class="glyphicon glyphicon-heart" id="love">&nbsp;${article.star}&nbsp;</span>
                    <span class="glyphicon glyphicon-comment">&nbsp;${article.comment}&nbsp; </span>
                </h5>
            </div>
            <div id="tag">
                <c:forEach var="t" items="${article_tags}">
                    <a href="/Blog/TagsServlet?get=${t.tag}">${t.tag}&nbsp;</a>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="line"></div>


    <div id="a_content">
        <!-- 引入 show.jsp 显示文章内容 ${ArticleMap.Article.content}-->
        <jsp:include page="show.jsp"/>
    </div>


    <div>
        <div class="f_div">
            <span class="glyphicon glyphicon-chevron-left"></span>


            <c:choose>
                <c:when test="${article_pre!=null}">
                    <a href="/Blog/ArticleServlet?id=${article_pre.id}">&nbsp;上一篇:${article_pre.title}</a>
                </c:when>
                <c:otherwise>
                    &nbsp;没有更早的文章了
                </c:otherwise>
            </c:choose>

        </div>
        <div class="r_div">

            <c:choose>
                <c:when test="${article_next!=null}">
                    <a href="/Blog/ArticleServlet?id=${article_next.id}">下一篇:&nbsp;${article_next.title}</a>
                </c:when>
                <c:otherwise>
                    &nbsp;没有更多的文章了
                </c:otherwise>
            </c:choose>

            <span class="glyphicon glyphicon-chevron-right"></span>
        </div>

        <div>
            <span class="btn btn-default" style="color:#d9534f;" onclick="love_article(${article.id})">点赞</span>
        </div>
        <br/>
    </div>

    <div class="line"></div>

    <!-- 评论 -->
    <div class="comment">

        <div class="r_div">
            <a href="#comment"><span class="glyphicon glyphicon-pencil">&nbsp;写评论....</span></a>
        </div>

        <!-- 加载文章评论 -->
        <h1 class="comment-title">评论列表</h1>
        <ul class="commentList">
            <c:forEach items="${ArticleMap.Comments}" var="comment" varStatus="x">
                <c:if test="${x.count%2==0}">
                    <li class="item cl"><a href="#"><i class="avatar size-L radius"><img alt=""
                                                                                         src="${pageContext.request.contextPath}/img/962bd40735fae6cd962b68f40fb30f2443a70f8c.png"></i></a>
                        <div class="comment-main" style="text-align: left">
                            <header class="comment-head">
                                <c:if test="${comment.user.uid==User.uid}">
                                    <a href="/cl/deleteComment?cid=${comment.cid}&aid=${ArticleMap.Article.aid}" style="float: right;font-size:10px;margin-left: 30px">删除</a>
                                </c:if>
                                <div class="comment-meta"><a class="comment-author" style="text-align: right"
                                                             href="#">${comment.user.username}</a>评论
                                </div>
                            </header>
                            <div class="comment-body" style="text-align: left">
                                <p>${comment.comment}</p>
                            </div>
                        </div>
                    </li>
                </c:if>
                <c:if test="${x.count%2==1}">
                    <li class="item cl comment-flip" style="text-align: right"><a href="#"><i
                            class="avatar size-L radius"><img alt=""
                                                              src="${pageContext.request.contextPath}/img/962bd40735fae6cd962b68f40fb30f2443a70f8c.png"></i></a>
                        <div class="comment-main" style="text-align: right">
                            <header class="comment-head">
                                <c:if test="${comment.user.uid==User.uid}">
                                    <a href="/cl/deleteComment?cid=${comment.cid}&aid=${ArticleMap.Article.aid}" style="float: left;font-size:10px;margin-right: 30px">删除</a>
                                </c:if>
                                <div class="comment-meta"><a class="comment-author" style="text-align: left"
                                                             href="#">${comment.user.username}</a>评论
                                </div>
                            </header>
                            <div class="comment-body" style="text-align: right">
                                <p>${comment.comment}</p>
                            </div>
                        </div>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
        <!-- 这里可以扩展子评论 -->
        <br>

        <!-- 写评论 -->
        <div id="comment">
            <form action="/cl/writeComment?aid=${ArticleMap.Article.aid}" method="post">
                <input style="width:30%" class="form-control" name="w_nickname" value="${sessionScope.User.username}">
                <br/>
                <textarea style="resize:none; width:100%; height:180px;" name="comment"></textarea>
                <br/>
                <br/>
                <input class="btn btn-default" type="submit" value="评论" onclick="onclick"/>
                <br/>
            </form>
        </div>
        <!--  -->
        <div class="line"></div>

    </div>
    <div id="footer">
        <a href="/cl/firstPage">MyBlog首页&nbsp;&nbsp;</a>|
        <a href="#" id="totop">&nbsp;&nbsp;返回顶部</a>
    </div>
</div>
<script>
    $(".totop").click(function () {
        $("html,body").animate({scrollTop: 0});
    })
</script>
</body>
</html>
