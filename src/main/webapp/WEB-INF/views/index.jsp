<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/include/head.jsp" %>
    <title>学前邦管理平台</title>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.sysAdmin.account}</strong></span>
                                <span class="text-muted text-xs block">超级管理员</span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">H+
                    </div>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-user"></i>
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/user/page?type=list" data-index="0">用户列表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-suitcase"></i>
                        <span class="nav-label">资源管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/res/page?type=list">资源列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/res/page?type=add">创建资源</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-youtube-play"></i>
                        <span class="nav-label">专题管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/subject/page?type=list">专题列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/subject/page?type=add">创建专题</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/course/page?type=live_add">创建直播课程</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/course/page?type=course_add">创建点播课程</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/order/page?type=list">订单列表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-qq"></i>
                        <span class="nav-label">圈子管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/topic/page?type=list">圈子列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/topic/page?type=add">创建圈子</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/posts/page?type=list">帖子列表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-qrcode"></i>
                        <span class="nav-label">Banner管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/banner/page?type=list">Banner列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/banner/page?type=add">创建Banner</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-wechat"></i>
                        <span class="nav-label">消息管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/notice/page?type=list">消息列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/notice/page?type=add">创建消息</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/notice/page?type=send">发送消息</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-gear"></i>
                        <span class="nav-label">系统管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/admin/page?type=list">管理员列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="${ctx}/admin/page?type=add">创建管理员</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="user_list">用户列表</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${ctx}/out" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}/user/page?type=list" frameborder="0" data-id="user_list" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2014-2015 <a href="#">明道致远科技有限公司</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
</body>
</html>
