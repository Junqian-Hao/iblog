<%--
  Created by IntelliJ IDEA.
  User: tyran
  Date: 2018/1/11
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Clcss/fistpage.css">
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div class="nav">
    <div class="nav_log"><img src="${pageContext.request.contextPath}/img/iblog_tm.png"></div>
    <div class="nav_right">
        <div class="write_btn"><a id="write_btn">写文章</a></div>
        <div class="nav_sec">
            <div class="headpic"><a href="/cl/selfBlog"><img src="${pageContext.request.contextPath}/img/962bd40735fae6cd962b68f40fb30f2443a70f8c.png"></a></div>
            <div class="nav_list">
                <ul>
                    <li>我的资料</li>
                    <li>我的博文</li>
                    <li>我的评论</li>
                    <li>我的点赞</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="nav_left">
        <div class="flex-item" id="flex-item1">
            <a href="#">发现</a>
        </div>
        <div class="flex-item"><a href="#">关注</a></div>
        <div class="flex-item"><a href="#">消息</a>
            <div class="nav_list">
                <ul>
                    <li>我的资料</li>
                    <li>我的博文</li>
                    <li>我的评论</li>
                    <li>我的点赞</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="test"></div>
<div class="content">
    <div class="banner"></div>
    <!--内容-->
    <c:forEach items="${Articles}" var="article">
    <div class="note_list_widthLimit">

        <ul class="note_list">
            <li>
                <div class="note_img">
                    <div class="card">
                        <div class="header">
                            <h1>1</h1>
                        </div>
                        <div class="containerimg">
                            <p>${article.date}</p>
                        </div>
                    </div>
                </div>
                <div class="note_Content_left">
                    <div class="note_author">
                        <div class="note_nickname">${article.user.username}</div>
                        <div class="note_data">${article.date}</div>
                    </div>
                    <div class="note_title" id="note_title1"><a href="/cl/findArticle?aid=${article.aid}">${article.title}</a></div>
                    <div class="abstract" id="note_content1">
                        <a href="/cl/findArticle?aid=${article.aid}">${article.content}</a>
                    </div>
                    <ul>
                        <li>
                            <div class="note_category">李小璐</div>
                        </li>
                        <li>
                            <div class="note_category">李小璐</div>
                        </li>

                    </ul>
                </div>
            </li>
        </ul>
    </div>
    </c:forEach>
    <!--foot-->
    <div class="footer_logo"></div>
    <div class="footer" align="center">
        <div class="totop"></div>
        <div class="footer_link">
            <ul>
                <li><a href="#">关于我们</a></li>
                <li><a href="#">人才招聘</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">友情链接</a></li>
                <li><a href="#">版权声明</a></li>
                <li><a href="#">客服中心</a></li>
            </ul>
        </div>

        <div class="footer_copy">
            <a href="http://sq.ccm.gov.cn:80/ccnt/sczr/service/business/emark/toDetail/4028c08b5414482e015417e9da8803e3"
               target="_blank"><img src="http://s.yytcdn.com/v2/images/topbar/culture.png"
                                    style="vertical-align: top;width:25px;height:25px;margin-right:3px;"></a>
            广播电视节目制作经营 &nbsp;许可证编号(京)字第1891号 &nbsp;&nbsp;| &nbsp;&nbsp;京网文[2014]2037-287号 &nbsp;&nbsp;| &nbsp;&nbsp;网络视听许可证0110413号<br>
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010502014900" target="_blank"><img
                    src="http://s.yytcdn.com/v2/images/topbar/ghs.png">
                京公网安备11010502014900号</a>&nbsp;&nbsp;| &nbsp;&nbsp;京ICP备11024134号-1 &nbsp;&nbsp;| &nbsp;&nbsp;京ICP证060716号
            &nbsp;&nbsp;|&nbsp;&nbsp; 出版物经营许可证 &nbsp;&nbsp;| &nbsp;&nbsp;新出发京批字第直160022号 &nbsp;&nbsp;| &nbsp;&nbsp;增值电信业务经营许可证
        </div>
    </div>
</div>
<div class="totop">
    ^
</div>


<!--写文章-->
<div class="md">
    <strong><span
            style="font-size: 20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目：</span></strong>
    <input type="text" placeholder="" class="input-text"/>
    <div class="md_category">
        <strong><span
                style="font-size: 20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型：</span></strong>
        <input type="text" placeholder="" class="input-text2"/>
    </div>
    <img src="${pageContext.request.contextPath}/img/EEFA1408-F23F-4C98-8021-193DAB289B64.png" style="width: 100%">
    <br>
    <!--markdown-->
    <div id="layout">
        <div id="test-editormd"></div>
    </div>
    <div class="md_btn"></div>

</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {

        $.get('../editor.md-master/examples/test.md', function () {
            testEditor = editormd("test-editormd", {
                width: "90%",
                height: 700,
                path: '../editor.md-master/lib/',
                theme: "white",
                previewTheme: "white",
                editorTheme: "pastel-on-dark",
                markdown: "新的博客，新的心情，以手书写，用心感受",
                codeFold: true,
                //syncScrolling : false,
                saveHTMLToTextarea: true,    // 保存 HTML 到 Textarea
                searchReplace: true,
                //watch : false,                // 关闭实时预览
                htmlDecode: "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
                //toolbar  : false,             //关闭工具栏
                //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                emoji: true,
                taskList: true,
                tocm: true,         // Using [TOCM]
                tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                flowChart: true,             // 开启流程图支持，默认关闭
                sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
                //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff

                onload: function () {
                    console.log('onload', this);
                    //this.fullscreen();
                    //this.unwatch();
                    //this.watch().fullscreen();

                    //this.setMarkdown("#PHP");
                    //this.width("100%");
                    //this.height(480);
                    //this.resize("100%", 640);
                }
            });
        });

    });

</script>
<!--超过字数截取-->
<script>

    $(function () {
        var text = document.getElementById("note_title1").innerHTML;
        if (text.length > 40) {
            document.getElementById("note_title1").innerHTML = text.substring(0, 40) + "...";
        }

        var text = document.getElementById("note_content1").innerHTML;
        if (text.length > 110) {
            document.getElementById("note_content1").innerHTML = text.substring(0, 110) + "...";

        }
        var text = document.getElementById("note_title2").innerHTML;
        if (text.length > 40) {
            document.getElementById("note_title2").innerHTML = text.substring(0, 40) + "...";
        }

        var text = document.getElementById("note_content3").innerHTML;
        if (text.length > 110) {
            document.getElementById("note_content3").innerHTML = text.substring(0, 110) + "...";
        }
        var text = document.getElementById("note_title4").innerHTML;
        if (text.length > 40) {
            document.getElementById("note_title4").innerHTML = text.substring(0, 40) + "...";
        }

        var text = document.getElementById("note_content5").innerHTML;
        if (text.length > 110) {
            document.getElementById("note_content5").innerHTML = text.substring(0, 110) + "...";
        }
    });

</script>
<!--返回头部-->
<script>
    $(".totop").click(function () {
        $("html,body").animate({scrollTop: 0});
    })


    $("#write_btn").on("click", function () {
        $(".content").css("display", "none");
        $(".md").css("display", "block");
        $(".md").css("background-color", "rgba(255,228,200,0.6)");

    });
    $("#flex-item1").on("click", function () {
        $(".content").css("display", "block");
        $(".md").css("display", "none");
    })

</script>


</body>
</html>
