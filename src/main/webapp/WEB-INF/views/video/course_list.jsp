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
                    <h2>课程列表</h2>
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
                                        <span data-toggle="tooltip" v-bind:title="item.profiles">{{item.profiles | substring 16}}</span>
                                    </td>
                                    <td>
                                        <i class="fa fa-user"></i> {{item.teacherName}}
                                    </td>
                                    <td>
                                        <i class="fa fa-youtube-play"></i> <span data-toggle="tooltip" v-bind:title="item.playUrl">{{item.playUrl | substring 16}}</span>
                                    </td>
                                    <td class="project-actions">
                                        <a class="btn btn-outline btn-danger btn-sm" @click="deleteData($index)"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
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
                list:[]
            },
            ready:function () {
                this.getData();
            },
            methods: {
                getData: function () {//提交数据
                    var self = this;
                    $.getJSON("${ctx}/course/list", function (res) {
                        self.list = res.extra;
                    });
                },
                deleteData: function (index) {//删除元素
                    var self = this;
                    var id = this.list[index].id;
                    $.post('${ctx}/course/delete', {id: id}, function (res) {
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
