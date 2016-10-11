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
                    <h2>帖子列表</h2>
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-sm-1">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm" @click="getData(1)"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getData(1)" placeholder="请输入昵称" v-model="search.nick">
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getData(1)" placeholder="请输入内容" v-model="search.content">
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control input-sm" v-model="search.circleId" v-on:change="getData(1)">
                                <option value selected>请选择圈子</option>
                                <option v-for="topic in topics" v-bind:value="topic.id">{{topic.title}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <tbody>
                                <tr v-for="item in list" @click="getDetail($index)">
                                    <td><img alt="image" style="width:30px" class="img-circle" v-for="img in item.imgUrls" v-bind:src="img"> </td>
                                    <td>
                                        <span data-toggle="tooltip" v-bind:title="item.content">{{item.content | substring 16}}</span>
                                    </td>
                                    <td>
                                        <span class="badge badge-primary">圈子</span><span data-toggle="tooltip" v-bind:title="item.title">{{item.title | substring 16}}</span>
                                    </td>
                                    <td>
                                        {{item.nick}}
                                    </td>
                                    <td>{{item.createDate}}</td>
                                    <td class="project-actions">
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
        <div class="col-sm-6">
            <div class="social-feed-box">
                <div class="social-avatar">
                    <a href="" class="pull-left">
                        <img alt="image" v-bind:src="posts.avatar">
                    </a>
                    <div class="media-body">
                        <a href="#">
                            {{posts.nick}}
                        </a>
                        <small class="text-muted">{{posts.createDate}}</small>
                    </div>
                </div>
                <div class="social-body">
                    <p>
                        {{posts.content}}
                    </p>
                    <img v-bind:src="img" v-for="img in posts.imgUrls">
                </div>
                <div class="social-footer">
                    <div class="social-comment" v-for="reply in replys">
                        <a href="" class="pull-left">
                            <img alt="image" v-bind:src="reply.avatar">
                        </a>
                        <div class="media-body">
                            <a href="#">
                                {{reply.nick}}
                            </a>
                            <a href="#" v-if="reply.toNick != undefined">
                                回复：{{reply.toNick}}
                            </a>{{reply.content}}
                            <div class="pull-right">
                                <button class="btn btn-outline btn-danger btn-sm" @click="delteReply($index)">删除</button>
                            </div>
                            <br>
                            <small class="text-muted">{{reply.createDate}}</small>
                        </div>
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
                list:[],//帖子列表
                search: {},//查询条件对象
                topics:[],//圈子列表
                posts:{},//帖子
                replys:[]//帖子评论列表
            },
            ready:function () {
                this.getTopics();
                this.getData(1);

            },
            methods: {
                getData: function (curr) {//提交数据
                    var self = this;
                    if(curr != null && curr != undefined){
                        this.search.page = curr;
                    }
                    console.log("search:"+JSON.stringify(this.search));
                    $.getJSON("${ctx}/posts/list", this.search, function (res) {
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
                        if(self.list.length > 0){
                            self.getDetail(0);//获取第一条帖子详情
                        }
                    });
                },
                getTopics:function () {
                    var self = this;
                    $.getJSON("${ctx}/topic/list", function (res) {
                        self.topics = res.extra;
                    });
                },
                deleteData: function (index) {//删除元素
                    var self = this;
                    var id = this.list[index].id;
                    $.post('${ctx}/posts/delete', {id: id}, function (res) {
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
                delteReply:function (index) {
                    var self = this;
                    var id = this.replys[index].id;
                    $.post('${ctx}/reply/delete', {id: id}, function (res) {
                        if (res.code == '200') {
                            //更新列表
                            var toast = new Toast({onHidden:function () {
                                self.replys.splice(index,1);
                            }}).success("删除成功");
                        }else{
                            var toast = new Toast().waring("服务器异常");
                        }
                    })
                },
                getDetail:function (index) {//帖子详情
                    this.posts = this.list[index];
                    this.getReply(index);

                },
                getReply:function (index) {//帖子评论
                    var self = this;
                    var postsId = this.list[index].id;
                    $.getJSON('${ctx}/reply/list', {circleId: postsId}, function (res) {
                        self.replys = res.extra;
                    })
                }
            }
        });
    })

</script>
</html>
