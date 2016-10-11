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
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content">
                    <h2>专题列表</h2>
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-sm-1">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm" @click="getData(1)"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getData(1)" placeholder="请输入标题" v-model="search.title">
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="search.type" v-on:change="getData(1)">
                                <option value selected>请选择专题类型</option>
                                <c:forEach items="${fns:getDictList('subject_type')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="search.pubStatus" v-on:change="getData(1)">
                                <option value selected>请选择上下架状态</option>
                                <c:forEach items="${fns:getDictList('pub_status')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="search.freeFlag" v-on:change="getData(1)">
                                <option value selected>请选择收费状态</option>
                                <c:forEach items="${fns:getDictList('free_flag')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <tbody>
                                <tr v-for="item in list">
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
                                    <td>
                                        上下架时间：{{item.pubTime}}
                                    </td>
                                    <td class="project-actions">
                                        <a v-if="item.pubStatus==0 || item.pubStatus==2" class="btn btn-outline btn-primary btn-sm" @click="pubData($index,1)"><i class="fa fa-external-link"></i>&nbsp;上架</a>
                                        <a v-if="item.pubStatus==1" class="btn btn-outline btn-primary btn-sm" @click="pubData($index,2)"><i class="fa fa-external-link"></i>&nbsp;下架</a>
                                        <a class="btn btn-outline btn-success btn-sm" @click="onLayer($index)"><i class="fa fa-tasks"></i>&nbsp;课程</a>
                                        <a class="btn btn-outline btn-danger btn-sm" @click="deleteData($index)"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
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
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(function(){
        Vue.filter('substring', function (input,num) {
            return input.substring(0,num);
        });
        new Vue({
            el:"#app",
            data:{
                list:[],
                search: {}//查询条件对象
            },
            ready:function () {
                this.getData(1);
            },
            methods: {
                getData: function (curr) {//提交数据
                    var self = this;
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
                deleteData: function (index) {//删除元素
                    var self = this;
                    var id = this.list[index].id;
                    $.post('${ctx}/subject/delete', {id: id}, function (res) {
                        if (res.code == '200') {
                            //更新列表
                            var toast = new Toast({onHidden:function () {
                                self.getData();
                            }}).success("删除成功");
                        }else{
                            var toast = new Toast().waring("服务器异常");
                        }
                    })
                },
                pubData:function(index,pubStatus){
                    var self = this;
                    var id = this.list[index].id;
                    $.post('${ctx}/subject/pub', {id: id,pubStatus:pubStatus}, function (res) {
                        if (res.code == '200') {
                            //更新列表
                            var toast = new Toast({onHidden:function () {
                                self.getData();
                            }}).success("上架成功");
                        }else{
                            var toast = new Toast().waring("服务器异常");
                        }
                    })
                },
                onLayer:function (index) {
                    var id = this.list[index].id;
                    parent.layer.open({
                        type: 2,
                        title:"课程列表",
                        shadeClose: true,
                        shade: 0.8,
                        area: ['70%', '80%'],
                        content: '${ctx}/course/page?type=list' //iframe的url
                    });
                }
            }
        });
    })

</script>
</html>
