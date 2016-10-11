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
                <h5>添加消息</h5>
            </div>
            <div class="ibox-content">
                <form role="form" id="dataform" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>标题：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入标题" v-model="entity.title"  class="form-control" datatype="*1-100" nullmsg="请输入标题！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>简介：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入简介" v-model="entity.profile"  class="form-control" datatype="*1-200" nullmsg="请输入简介！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>类别：</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" v-model="entity.category" datatype="*" nullmsg="请选择类别！">
                                <option value selected>请选择类别</option>
                                <c:forEach items="${fns:getDictList('notice_category')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">内容：</label>
                        <div class="col-sm-10">
                            <script type="text/plain" id="editor" name="content" style="width:100%;height:500px;">
                            </script>
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
<link rel="stylesheet" type="text/css" href="${ctxPath}/ueditor/themes/default/css/ueditor.css"/>
<script type="text/javascript" src="${ctxPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${ctxPath}/ueditor/ueditor.all.js"></script>


<script>
    new Vue({
        el:"#app",
        data:{
            valid: {},//表单验证对象
            entity:{},

        },
        ready:function () {
            //校验
            this.valid = $("#dataform").Validform({
                tiptype: 4
            });
            //ueditor
            var ue = new baidu.editor.ui.Editor(
                    {
                        //initialContent: "请在这里输入正文......",
                        autoClearinitialContent: false, //focus时自动清空初始化时的内容
                        //initialFrameWeight:100%,
                        initialFrameHeight:440,
                        textarea: 'editor',      //设置提交时编辑器内容的名字
                        autoFloatEnabled: false,
                        focus:false,
                        autoHeightEnabled: false,
                        sourceEditor: true,
                        wordCount: false,               //关闭字数统计
                        elementPathEnabled: false,      //关闭elementPath
                        maximumWords: 10240
                    }
            );
            ue.render("editor");
        },
        methods: {
            commitData: function () {//提交数据
                var self = this;
                var content = $("[name='content']").val();
                this.entity.content = content;
                console.log("commitData:"+JSON.stringify(this.entity));
                //表单验证
                var flag = this.valid.check();
                if (flag) {
                    $.ajax({
                        type: "POST",
                        url: '${ctx}/notice/save',
                        data: this.entity,
                        success: function(res){
                            if(res.code == "200"){
                                //更新列表数据
                                var toast = new Toast().success("保存成功");
                            }else{
                                var toast = new Toast().waring(res.msg);
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
