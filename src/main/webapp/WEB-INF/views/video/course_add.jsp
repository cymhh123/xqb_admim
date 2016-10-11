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
                <h5>创建点播课程</h5>
            </div>
            <div class="ibox-content">
                <form role="form" id="dataform" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>课程名称：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入课程名称" v-model="entity.title"  class="form-control" datatype="*1-100" nullmsg="请输入课程名称！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>课程简介：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入课程简介" v-model="entity.profiles"  class="form-control" datatype="*1-200" nullmsg="请输入课程简介！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>课程讲师：</label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="请输入课程讲师" v-model="entity.teacherName"  class="form-control" datatype="*1-50" nullmsg="请输入课程讲师！">
                            <span class="help-block has-error m-b-none Validform_checktip"> </span>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="from-group">
                        <label class="col-sm-2 control-label"><span class="c-red">*</span>选择所属专题：</label>
                        <div class="col-sm-10">
                            <div class="row m-b">
                                <div class="col-sm-2"style="padding-left: 5px;">
                                    <input type="text" id="subjectInput" class="input-sm form-control" v-on:keyup="getData(1)" placeholder="请输入标题" v-model="search.title">
                                </div>
                            </div>
                            <div class="row">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover">
                                        <tbody>
                                        <tr v-for="item in list" @click="getSubjectInfo($index)">
                                            <td class="client-avatar"><img alt="image" v-bind:src="item.imgUrl"> </td>
                                            <td>
                                                <span data-toggle="tooltip" v-bind:title="item.title">{{item.title | substring 16}}</span>
                                            </td>
                                            <td>
                                                <i class="fa fa-cny"></i>&nbsp;{{item.price}}
                                            </td>
                                            <td>
                                                <span v-if="item.freeFlag==0" class="badge badge-primary">{{item.freeFlagL}}</span>
                                                <span v-if="item.freeFlag==1" class="badge badge-warning">{{item.freeFlagL}}</span>
                                            </td>
                                            <td>
                                                {{item.pubStatusL}}
                                            </td>
                                            <td>
                                                <span v-if="item.type==0" class="badge badge-primary">{{item.typeL}}</span>
                                                <span v-if="item.type==1" class="badge badge-warning">{{item.typeL}}</span>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="text-r mt-5">
                                <div id="page"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">上传：</label>
                        <div class="col-sm-10">
                            <div class="col-sm-1">
                                <div id="container">
                                    <input class="btn btn-primary radius" type="button" id="upBtn" value="选择点播文件">
                                </div>
                            </div>
                            <div class="col-sm-1">
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
                    <input type="hidden" id="playUrl" />
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
<script src="${ctxStatic}/hplus/js/plugins/layer/laydate/laydate.js"></script>

<script>
    new Vue({
        el:"#app",
        data:{
            valid: {},//表单验证对象
            entity:{
                type:1
            },
            search:{},
            list:[]
        },
        ready:function () {
            //校验
            this.valid = $("#dataform").Validform({
                tiptype: 4
            });
            //七牛上传资源
            var opt = {
                uptoken : '${fns:getUpToken()}',
                domain: '${fns:getBucketDomain()}',
                $fileUrl:$("#playUrl")
            }
            var qiniuLoad = new Qn(opt);

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
            this.getData(1);

        },
        methods: {
            getData: function (curr) {//提交数据
                var self = this;
                this.search.type=this.entity.type;
                this.search.editFlag = "true";
                if(curr != null && curr != undefined){
                    this.search.page = curr;
                }
                console.log("search:"+JSON.stringify(this.search));
                $.getJSON("${ctx}/subject/list", this.search, function (res) {
                    self.list = res.extra;
                    console.log("list:"+JSON.stringify(self.list));
                    //此页没有数据时，显示上一页信息
                    if(self.list.length==0 && self.search.page != 1){
                        self.getData(self.search.page-1)
                        return;
                    }
                    //显示分页
                    laypage({
                        cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                        pages: res.pageTotal, //通过后台拿到的总页数
                        curr: self.search.page, //当前页
                        jump: function(obj, first){ //触发分页后的回调
                            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                self.getData(obj.curr);
                            }
                        }
                    });
                });
            },
            getSubjectInfo:function (index) {
                var subjectId = this.list[index].id;
                var subjectTitle = this.list[index].title;
                this.entity.subjectId = subjectId;
                $("#subjectInput").val(subjectTitle);
            },
            commitData: function () {//提交数据
                var self = this;
                var playUrl = $("#playUrl").val();
                this.entity.playUrl = playUrl;
                var imgUrl = $("#imgUrl").val();
                this.entity.imgUrl = imgUrl;
                console.log("commitData:"+JSON.stringify(this.entity));
                //表单验证
                var flag = this.valid.check();
                if (flag) {
                    $.ajax({
                        type: "POST",
                        url: '${ctx}/course/save',
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
