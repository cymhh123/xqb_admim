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
        <div class="col-sm-6">
            <div class="ibox">
                <div class="ibox-content">
                    <h2>选择用户</h2>
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-sm-1">
                            <button type="button" class="btn btn-white btn-sm" @click="getUserData(1)"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getUserData(1)" placeholder="请输入账号" v-model="userSearch.account">
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getUserData(1)" placeholder="请输入昵称" v-model="userSearch.nick">
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getUserData(1)" placeholder="请输入绑定手机号" v-model="userSearch.phone">
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="userSearch.type" v-on:change="getUserData(1)">
                                <option value selected>请选择类别</option>
                                <c:forEach items="${fns:getDictList('user_type')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <tbody>
                                <tr v-for="item in userList">
                                    <td>
                                        <input type="checkbox" v-model="entity.userAccounts" v-bind:value="item.account">
                                    </td>
                                    <td class="client-avatar"><img alt="image" v-bind:src="item.imgUrl"> </td>
                                    <td>
                                        {{item.nick}}
                                    </td>
                                    <td>
                                        {{item.account}}
                                    </td>
                                    <td>
                                        {{item.sexL}}
                                    </td>
                                    <td>
                                        {{item.phone}}
                                    </td>
                                    <td>
                                        <span class="badge badge-primary">{{item.userTypeL}}</span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="text-r mt-5">
                        <div id="page1"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="ibox">
                <div class="ibox-content">
                    <h2>选择消息</h2>
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-sm-1">
                            <button type="button" class="btn btn-white btn-sm" @click="getNoticeData(1)"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getNoticeData(1)" placeholder="请输入标题" v-model="noticeSearch.title">
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="noticeSearch.category" v-on:change="getNoticeData(1)">
                                <option value selected>请选择类别</option>
                                <c:forEach items="${fns:getDictList('notice_category')}" var="item">
                                    <option value="${item.value}">${item.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <tbody>
                                <tr v-for="item in noticeList">
                                    <td>
                                        <input type="checkbox" class="i-checks" v-model="entity.noticeIds" v-bind:value="item.id">
                                    </td>
                                    <td>
                                        <span data-toggle="tooltip" v-bind:title="item.title">{{item.title | substring 16}}</span>
                                    </td>
                                    <td>
                                        <span data-toggle="tooltip" v-bind:title="item.profiles">{{item.profile | substring 16}}</span>
                                    </td>
                                    <td>
                                        <a href="${ctx}/notice/info?id={{item.id}}" target="_blank"><span class="badge badge-primary">{{item.categoryL}}</span></a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="text-r mt-5">
                        <div id="page2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <button class="btn btn-primary" @click="commitData()">发送</button>
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
                userList:[],
                userSearch: {},//查询条件对象
                noticeList:[],
                noticeSearch: {},//查询条件对象
                entity:{
                    userAccounts:[],
                    noticeIds:[]
                }
            },
            ready:function () {
                this.getUserData(1);
                this.getNoticeData(1);
            },
            methods: {
                getUserData: function (curr) {//提交数据
                    var self = this;
                    if(curr != null && curr != undefined){
                        this.userSearch.page = curr;
                    }
                    console.log("search:"+JSON.stringify(this.userSearch));
                    $.getJSON("${ctx}/user/list", this.userSearch, function (res) {
                        self.userList = res.extra;
                        console.log("list:"+JSON.stringify(self.userList));
                        //此页没有数据时，显示上一页信息
                        if(self.userList.length==0 && self.userSearch.page != 1){
                            self.getUserData(self.userSearch.page-1)
                            return;
                        }
                        //显示分页
                        laypage({
                            cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                            pages: res.pageTotal, //通过后台拿到的总页数
                            curr: self.userSearch.page, //当前页
                            jump: function(obj, first){ //触发分页后的回调
                                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                    self.getUserData(obj.curr);
                                }
                            }
                        });
                    });
                },
                getNoticeData: function (curr) {//
                    var self = this;
                    if(curr != null && curr != undefined){
                        this.noticeSearch.page = curr;
                    }
                    console.log("search:"+JSON.stringify(this.noticeSearch));
                    $.getJSON("${ctx}/notice/list", this.noticeSearch, function (res) {
                        self.noticeList = res.extra;
                        console.log("list:"+JSON.stringify(self.noticeList));
                        //此页没有数据时，显示上一页信息
                        if(self.noticeList.length==0 && self.noticeSearch.page != 1){
                            self.getNoticeData(self.noticeSearch.page-1)
                            return;
                        }
                        //显示分页
                        laypage({
                            cont: 'page2', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                            pages: res.pageTotal, //通过后台拿到的总页数
                            curr: self.noticeSearch.page, //当前页
                            jump: function(obj, first){ //触发分页后的回调
                                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                    self.getNoticeData(obj.curr);
                                }
                            }
                        });
                    });
                },
                commitData:function(){
                    var userAccounts = this.entity.userAccounts.join(",");
                    var noticeIds = this.entity.noticeIds.join(",");
                    $.ajax({
                        type: "GET",
                        url: '${ctx}/user/notice/send',
                        data: {userAccounts:userAccounts,noticeIds:noticeIds},
                        success: function(res){
                            if(res.code == "200"){
                                //更新列表数据
                                var toast = new Toast().success("发送成功");
                            }else{
                                var toast = new Toast().waring(res.msg);
                            }
                            //清空保留的新增数据
                            self.entity = {};
                        },
                        error: function(XMLHttpRequest){
                            console.log("Error: " + XMLHttpRequest.responseText)
                        }
                    })
                }
            }
        });
    })

</script>
</html>
