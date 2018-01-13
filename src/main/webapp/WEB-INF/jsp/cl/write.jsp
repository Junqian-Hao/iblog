<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editormd.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/Clcss/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/Clcss/bootstrap-theme.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>

<body>
<div class="container">
    <form method="post" action="/cl/writeSubmit">
        <br>
        <br>
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <div class="input-group-btn">
                        <c:choose>
                            <c:when test="${Article==null}">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" id="categoryBtn">分类
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" id="categoryBtn">${Article.category.name}
                                </button>
                            </c:otherwise>
                        </c:choose>

                        <ul class="dropdown-menu">
                            <c:forEach var="category" items="${Categories}">
                                <li>
                                    <a onclick="selectCategory('${category.name}');">${category.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <input name="catname" id="cateoryInput" type="hidden">
                    <c:choose>
                        <c:when test="${Article==null}">
                            <input type="text" class="form-control" placeholder="标题" name="title">
                        </c:when>
                        <c:otherwise>
                            <input name="id" type="hidden" value="${Article.aid}">
                            <input type="text" class="form-control" placeholder="标题" name="title"
                                   value="${Article.title}">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
</div>
<br>
<div id="layout" style="width: 100%;height: 100%">
    <div id="test-editormd">
        <c:choose>
            <c:when test="${Article==null}">
                <textarea style="display:none;" name="content"></textarea>
            </c:when>
            <c:otherwise>
                <textarea style="display:none;" name="content">${Article.content}</textarea>
            </c:otherwise>
        </c:choose>

    </div>
</div>

<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd("test-editormd", {
            width: "100%",
            height: 640,
            syncScrolling: "single",
            path: "${pageContext.request.contextPath}/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "./php/upload.php?test=dfdf"

            /*
             上传的后台只需要返回一个 JSON 数据，结构如下：
             {
             success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
             message : "提示的信息，上传成功或上传失败及错误信息等。",
             url     : "图片地址"        // 上传成功时才返回
             }
             */
        });

        /*
         // or
         testEditor = editormd({
         id      : "test-editormd",
         width   : "90%",
         height  : 640,
         path    : "../lib/"
         });
         */
    });
</script>
<div class="row">
    <div class="col-md-6 col-md-offset-6">
        <p>
            <input type="submit" class="btn btn-primary btn-lg" role="button" value="发表">
        </p>
    </div>
    </form>
</div>
<script>
    function selectCategory(name) {
        $("#categoryBtn").html(name);
        $("#cateoryInput").val(name);
    }
</script>
</body>
</html>
