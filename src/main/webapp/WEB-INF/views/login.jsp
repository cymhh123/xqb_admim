<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>学前邦管理后台 - 登录</title>
    <meta name="keywords" content="学前邦管理后台">
    <meta name="description" content="学前邦管理后台">
    <link href="${ctxStatic}/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctxStatic}/hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctxStatic}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/hplus/css/style.min.css" rel="stylesheet">
    <link href="${ctxStatic}/hplus/css/login.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/hplus/css/plugins/toastr/toastr.min.css">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>学前邦</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>学前邦后台管理系统</strong></h4>
                </div>
            </div>
            <div class="col-sm-5">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到学前邦后台管理系统</p>
                    <input type="text" class="form-control uname" id="account" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" id="password" placeholder="密码" />
                    <button class="btn btn-success btn-block" id="login_btn">登录</button>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2015 All Rights Reserved. 明道致远信息科技有限公司
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="${ctxStatic}/hplus/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/hplus/js/plugins/toastr/toastr.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/xqb_box.js"></script>
<script>
    $(function () {
        $("#login_btn").click(function(){
            var param = {};
            var account = $("#account").val();
            var password = $("#password").val();
            if(account == "" || account == null || account == undefined){
                var toast = new Toast({
                    onHidden:function () {}
                }).waring("请输入用户名");
                return;
            }
            if(password == "" || password == null || password == undefined){
                var toast = new Toast({
                    onHidden:function () {}
                }).waring("请输入密码");
                return;
            }
            param.account = account;
            param.password = password;
            $.ajax({
                type:"POST",
                url:"${ctx}/login",
                data:param,
                success:function (res) {
                    if(res.code=="200"){
                        window.location.href="${ctx}/main";
                    }else{
                        var toast = new Toast({
                            onHidden:function () {}
                        }).waring(res.msg);
                    }
                }
            })
        });
    })
</script>
</html>
