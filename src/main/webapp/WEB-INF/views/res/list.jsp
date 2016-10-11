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
                    <h2>资源列表</h2>
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-sm-1">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm" @click="getData(1)"><i class="fa fa-refresh"></i> 刷新</button>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" class="input-sm form-control" v-on:keyup="getData(1)" placeholder="请输入标题" v-model="search.title">
                        </div>
                        <div class="col-sm-2">
                            <select class="form-control input-sm" v-model="search.sorts" v-on:change="getData(1)">
                                <option value selected>请选择类别</option>
                                <c:forEach items="${fns:getDictList('sorts')}" var="item">
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
                                    <td class="client-avatar"><img alt="image" v-bind:src="item.thumbUrl"> </td>
                                    <td>
                                        <span data-toggle="tooltip" v-bind:title="item.title">{{item.title | substring 16}}</span>
                                    </td>
                                    <td>
                                        <span data-toggle="tooltip" v-bind:title="item.profiles">{{item.profiles | substring 16}}</span>
                                    </td>
                                    <td>
                                        <span class="badge badge-primary">{{item.sortsL}}</span>
                                    </td>
                                    <td>
                                        <span class="badge badge-warning">{{item.resTypeL}}</span>
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
                    $.getJSON("${ctx}/res/list", this.search, function (res) {
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
                    $.post('${ctx}/res/delete', {id: id}, function (res) {
                        if (res.code == '200') {
                            //更新列表
                            var toast = new Toast({onHidden:function () {
                                self.getData();
                            }}).success("删除成功");
                        }else{
                            var toast = new Toast().waring("服务器异常");
                        }
                    })
                }


            }
        });
    })

</script>
</html>
