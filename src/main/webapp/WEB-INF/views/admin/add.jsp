<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/include/head.jsp" %>
</head>
<body id="app" class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>创建管理员</h5>
            </div>
            <div class="ibox-content">
                <form role="form" id="dataform" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>账号：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入账号" v-model="entity.account"  class="form-control" datatype="*1-100" nullmsg="请输入账号！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>密码：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入密码" v-model="entity.password"  class="form-control" datatype="*6-10" nullmsg="请输入密码！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                </form>
                <div class="col-sm-4 col-sm-offset-2">
                    <button class="btn btn-primary" @click="commitData();">保存</button>
                    <button class="btn btn-white">取消</button>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    new Vue({
        el:"#app",
        data:{
            valid: {},//表单验证对象
            entity:{
            }
        },
        ready:function () {
            //校验
            this.valid = $("#dataform").Validform({
                tiptype: 4
            });
        },
        methods: {
            commitData: function () {//提交数据
                var self = this;
                //表单验证
                var flag = this.valid.check();
                if (flag) {
                    $.ajax({
                        type: "POST",
                        url: '${ctx}/admin/save',
                        data: this.entity,
                        success: function(res){
                            if(res.code == "200"){
                                var toast = new Toast().success("保存成功");
                            }else{
                                var toast = new Toast().warning(res.msg);
                            }
                            //清空保留的新增数据
                            self.entity = {};
                        },
                        error: function(XMLHttpRequest){
                            console.log("Error: " + XMLHttpRequest.responseText)
                        }
                    });
                }
            }
        }
    });
</script>
</html>
