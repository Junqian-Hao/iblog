<%--
  Created by IntelliJ IDEA.
  User: hao
  Date: 2017/12/6
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .zhangxin {
            width: 100px;
            height: 100px;
            padding: 20px;
            border: 10px solid black;
            font-size: 10px;
            margin: 0px;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css">
    <title>hello world</title>
</head>
<body>
<div id="my-editormd">
    <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
    <!-- 注意：name属性的值-->
    <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
</div>

<div class="zhangxin"></div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd("my-editormd", {//注意1：这里的就是上面的DIV的id属性值
            width: "90%",
            height: 640,
            theme:"light",
            previewTheme : "light",
            editorTheme : "pastel-on-light",
            syncScrolling: "single",
            path: "${pageContext.request.contextPath}/lib/",//注意2：你的路径
            saveHTMLToTextarea: true//注意3：这个配置，方便post提交表单
        });
    });
    //editormd("my-editormd", {markdown:"sdsadsadsa"});
</script>
</body>
</html>
