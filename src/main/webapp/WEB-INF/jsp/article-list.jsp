<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/html5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>管理员列表 - 管理员列表 - H-ui.admin v3.0</title>
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<!--_header 作为公共模版分离出去-->
<%@include file="header.jsp" %>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<%@include file="menu.jsp" %>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 博客系统 <span
            class="c-gray en">&gt;</span> 博客管理<a class="btn btn-success radius r"
                                                 style="line-height:1.6em;margin-top:3px"
                                                 href="javascript:location.replace(location.href);" title="刷新"><i
            class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <div class="text-c">
                <form method="post" action="/ms/article-list">
                    <input type="text" class="input-text" style="width:250px" placeholder="输入博客标题、内容、作者、分类" name="key">
                    <button type="submit" class="btn btn-success radius"><i
                            class="Hui-iconfont">&#xe665;</i>
                        搜博客
                    </button>
                </form>
            </div>
            <div class="cl pd-5 bg-1 bk-gray mt-20"> <span
                    class="r">共有数据：<strong>${size}</strong> 条</span>
            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr class="text-c">
                        <%--<th width="25"><input type="checkbox" name="" value=""></th>--%>
                        <th width="50">ID</th>
                        <th width="70">标题</th>
                        <th width="70">分类</th>
                        <th width="70">作者</th>
                        <th width="70">时间</th>
                        <th width="100">简介</th>
                        <th width="70">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${articles}" var="article" varStatus="vs">
                        <tr class="text-c">
                            <%--<td><input type="checkbox" value="${user.uid}" name=""></td>--%>
                            <td id="uid">${article.aid}</td>
                            <td>${article.title}</td>
                            <td>${article.category.name}</td>
                            <td>${article.user.username}</td>
                            <td>${article.date}</td>
                            <td>${article.summary}</td>
                                <td class="td-manage">
                                    <a
                                            title="查看" href="javascript:;" onclick="member_show('${article.title}','${pageContext.request.contextPath}/ms/article-show?aid=${article.aid}','10001','500','500')" class="ml-5"
                                            style="text-decoration:none"><i class="Hui-iconfont">&#xe725;</i></a>
                                    <a
                                            title="删除" href="javascript:;" onclick="member_del(this,'1')" class="ml-5"
                                            style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </article>
    </div>
</section>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(function () {
        $('.table-sort').dataTable({
            "aaSorting": [[0, "asc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [5, 6]}// 制定列不参与排序
            ]
        });
        $('.table-sort tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                $('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });


    /*用户-查看*/
    function member_show(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }



    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            var uid = $(obj).parents("tr").find("#uid").html();
            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/ms/deleteArticle",
                cache: false,
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache"
                },
                "data": "{\"aid\":\"" + uid + "\"}",
                success: function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                },
                error: function () {
                    layer.msg('删除失败!', {icon: 5, time: 1000});
                }
            });

        });
    }

    //设置左侧菜单栏被选中状态
    $(function () {
        $("#menu-admin").find("dt").addClass("selected");
        $("#menu-admin").find("dd").css("display", "block");
        $("#menu-admin").find("dd li:first-child").addClass("current");
    })

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>