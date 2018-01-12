<%--
  Created by IntelliJ IDEA.
  User: hao
  Date: 2018/1/10
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="Hui-aside">

    <div class="menu_dropdown bk_2">
        <dl id="menu-admin">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 博客系统<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
            </dt>
            <dd>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/ms/article-list" title="博客管理">博客管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/ms/category-list" title="分类管理">分类管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/ms/admin-list" title="用户中心">用户中心</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/ms/database-firewall" title="数据库防火墙">数据库防火墙</a></li>
                    <li><a href="system-shielding" title="屏蔽词">屏蔽词</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>

