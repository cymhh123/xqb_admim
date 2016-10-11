<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/include/head.jsp" %>
</head>
<body id="app" class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>创建圈子</h5>
            </div>
            <div class="ibox-content">
                <form role="form" id="dataform" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>圈子名称：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入圈子名称" v-model="entity.title"  class="form-control" datatype="*1-100" nullmsg="请输入圈子名称！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>圈子简介：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入圈子简介" v-model="entity.des"  class="form-control" datatype="*1-200" nullmsg="请输入圈子简介！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">上传：</label>
                        <div class="col-sm-10">
                            <div class="col-sm-1" style="padding-left:0px;">
                                <div id="container2">
                                    <input class="btn btn-primary radius" type="button" id="upBtn2" value="选择缩略图">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="display:none;margin-top:5px;" id="success" class="col-md-10 col-sm-offset-2">
                        <div class="alert-success">
                            队列全部文件处理完毕
                        </div>
                    </div>
                    <div class="col-sm-10 col-sm-offset-2">
                        <table class="table table-border table-bordered table-bg"   style="margin-top:10px;display:none">
                            <thead>
                            <tr>
                                <th>文件名</th>
                                <th>文件大小</th>
                                <th>文件详情</th>
                            </tr>
                            </thead>
                            <tbody id="fsUploadProgress">
                            </tbody>
                        </table>
                    </div>
                    <input type="hidden" id="imgUrl" />
                    <div class="clearfix"></div>
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
<script src="${ctxStatic}/lib/qiniu/js/plupload.full.min.js"></script>
<script src="${ctxStatic}/lib/qiniu/js/qiniu.js"></script>
<script src="${ctxStatic}/lib/qiniu/js/ui.js"></script>
<script src="${ctxStatic}/qn.js"></script>

<script>
    new Vue({
        el:"#app",
        data:{
            valid: {},//表单验证对象
            entity:{}
        },
        ready:function () {
            //校验
            this.valid = $("#dataform").Validform({
                tiptype: 4
            });
            //七牛上传资源
            var opt2 = {
                uptoken : '${fns:getUpToken()}',
                domain: '${fns:getBucketDomain()}',
                browse_button :'upBtn2',
                container: 'container2',
                drop_element: 'container2',
                $fileUrl:$("#imgUrl")
            };
            var qiniuload2 = new Qn(opt2);
        },
        methods: {
            commitData: function () {//提交数据
                var self = this;
                var imgUrl = $("#imgUrl").val();
                this.entity.imgUrl = imgUrl;
                console.log("commitData:"+JSON.stringify(this.entity));
                //表单验证
                var flag = this.valid.check();
                if (flag) {
                    $.ajax({
                        type: "POST",
                        url: '${ctx}/topic/save',
                        data: this.entity,
                        success: function(res){
                            if(res.code == "200"){
                                //更新列表数据
                                var toast = new Toast().success("保存成功");
                            }else{
                                var toast = new Toast().waring(res.msg);
                            }
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
