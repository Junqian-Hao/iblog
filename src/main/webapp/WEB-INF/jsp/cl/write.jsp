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
    <form method="post" action="/cl/updateSubmit">
        <br>
        <br>
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <div class="input-group-btn">
                        <c:choose>
                            <c:when test="${Article==null}">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" id="categoryBtn">${UserAcademy.name}
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false"
                                        id="categoryBtn">${Article.category.name}
                                </button>
                            </c:otherwise>
                        </c:choose>

                        <ul class="dropdown-menu">
                            <li>
                                <a onclick="selectCategory('${UserAcademy.name}');">${UserAcademy.name}</a>
                            </li>
                            <c:forEach var="userbelong" items="${UserBelongs}">
                                <li>
                                    <a onclick="selectCategory('${userbelong.category.name}');">${userbelong.category.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>

                    <c:choose>
                        <c:when test="${Article==null}">
                            <input name="catname" id="cateoryInput" type="hidden">
                            <input type="text" class="form-control" placeholder="标题" name="title">
                            <input type="textarea" name="summary" class="form-control"
                                   placeholder="To summary..........">
                        </c:when>
                        <c:otherwise>
                            <input name="catname" id="cateoryInput" type="hidden" value="${Article.category.name}">
                            <input name="aid" type="hidden" value="${Article.aid}">
                            <input type="text" class="form-control" placeholder="标题" name="title"
                                   value="${Article.title}">
                            <input type="textarea" name="summary" class="form-control" value="${Article.summary}">
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
            width: "90%",
            height: 740,
            path : '${pageContext.request.contextPath}/lib/',
            theme : "rubyblue",
            codeFold : true,
            //syncScrolling : false,
            saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
            searchReplace : true,
            //watch : false,                // 关闭实时预览
            htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
            //toolbar  : false,             //关闭工具栏
            //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
            emoji : true,
            taskList : true,
            tocm            : true,         // Using [TOCM]
            tex : true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart : true,             // 开启流程图支持，默认关闭
            sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
            //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
            //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
            //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
            //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
            //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
            imageUpload : false,
            //imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            //imageUploadURL : "/cl/blogPicUpload",
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
<div class="row" style="margin-top: 100px">
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

    //解决a标签跳转新页面的方法，性能万分垃圾
    $(function () {
        var titleEl = document.getElementsByTagName("body")[0];
        titleEl.addEventListener("DOMSubtreeModified", function (evt) {
            $("a").attr("target", "_blank");
        }, false);
    });
</script>
</body>
</html>
