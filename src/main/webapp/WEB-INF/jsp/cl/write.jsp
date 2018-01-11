<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/write.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css">
</head>
<body>
<div class="head_line"></div>
<div class="container" id="main">
    <div id="title"><h2><a href="/cl/selfBlog?uid=">MyBlog</a></h2>
    </div>

    <form action="/cl/writeSubmit" method="post">

        <div class="info">
            <!-- title -->
            <span class="help">标题</span>
            <input type="text" class="form-control"  placeholder="标题" name="title" >
            <!-- time -->
            <span class="help">时间</span>
            <input type="text"  class="form-control" name="time" value="${time}" >
            <!-- author-->
            <span class="help">作者</span>
            <input type="text" class="form-control" name="author" >
            <!-- sort -->
            <span class="help">分类</span><br/>
            <c:forEach var="s"  items="${sort_count}">
                <input class="btn btn-default" type="button" value="${s.key}" onclick="sort_click(this)"> &nbsp;
            </c:forEach>
            <input type="text" class="form-control"  id="sort" name="sort">

        </div>


        <div class="foot_line"></div>
        <!-- content -->
        <div class="editormd" id="mdView">
            <textarea name="content"></textarea>
        </div>
        <br/>
        <input  class="btn btn-default"  type="submit"   value="提交" />
    </form>

    <div class="foot_line"></div>
    <!-- container -->
</div><!-- container -->

<div id="footer">
    <a href="#">&nbsp;&nbsp;MyBlog</a>

</div> <!-- footer -->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/zepto.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editormd.js"></script>
<script src="${pageContext.request.contextPath}/js/write.js"></script>
<script type="text/javascript">
    var testEditor;
    var jQuery = Zepto;
    $(function() {
        testEditor = editormd("mdView", {
            width  : "90%",
            height : 720,
//          focus： 需要改路径
            path   : "${pageContext.request.contextPath}/lib/",
            codeFold : true,
            searchReplace : true,
            saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
            htmlDecode : "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
            emoji : true,
            taskList : true,
            tocm: true,
            tex : true,
            flowChart : true,
            sequenceDiagram : true,
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/Blog/UploadPic",
            //后台只需要返回一个 JSON 数据
            onload : function() {
                //console.log("onload =>", this, this.id, this.settings);
            }
        });
        editor.setToolbarAutoFixed(false);//工具栏自动固定定位的开启与禁用
    });
</script>
</body>
</html>
