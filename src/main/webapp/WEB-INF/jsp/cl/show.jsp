<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.preview.css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/zbdxxh.png" type="image/x-icon"/>
<!-- 引入editormd相关 -->
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

<body style="background:#eee;">

<div class="markdown-body editormd-preview-container" id="mdView"  style="background:#eee;">
    <textarea id="article_content"  >${ArticleMap.Article.content}</textarea>
</div>
<br/>
<script type="text/javascript">
    $(function() {
        var testEditormdView2 = editormd.markdownToHTML("mdView", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });
    });
</script>
</body>
</html>