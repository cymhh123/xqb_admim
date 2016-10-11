/**
 * Created by Administrator on 2016/8/16.
 */
var vue = function (listUrl,editUrl,delUrl) {
    new Vue({
        el: '#app',
        data:{
            list:[], //数据集合
            entity:{},//单个数据对象
            valid:{},//表单验证对象
            search:{}//查询条件对象
        },
        ready: function() {
            //获取数据
            this.getData(1);
            //初始化表单验证
            this.valid = $("#dataform").Validform({
                tiptype:2
            });
        },
        methods:{
            getData:function (curr) { //获取数据
                var self = this;
                this.search.page = curr;
                $.getJSON(listUrl, this.search, function(res){
                    self.list = res.extra;
                    //显示分页
                    laypage({
                        cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                        pages: res.pageTotal, //通过后台拿到的总页数
                        curr: curr || 1, //当前页
                        jump: function(obj, first){ //触发分页后的回调
                            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                self.getData(obj.curr);
                            }
                        }
                    });
                });
            },
            searchData:function(){//条件搜索
                this.getData(1);
            },
            editData:function(index){//编辑页面
                if(this.list != null && this.list.length > 0){
                    var b = {};
                    $.extend(b,this.list[index]);
                    this.entity = b;
                    console.log(JSON.stringify(this.entity));
                    //重置表单验证
                    this.valid.resetForm();
                    //重置后，文字消失不掉（bug）
                    $(".Validform_checktip").html("");
                    $("#modal").modal("toggle");
                }
            },
            addData:function () {//添加页面
                this.entity = {};//清空单个对象
                //重置表单验证
                this.valid.resetForm();
                //重置后，文字消失不掉（bug）
                $(".Validform_checktip").html("");
                $("#modal").modal("toggle");
            },
            commitData:function(){//提交数据
                console.log(JSON.stringify(this.entity));
                //表单验证
                var flag = this.valid.check();
                if(flag){
                    if(this.entity != null){
                        $.post(editUrl,this.entity,function (data) {

                        });
                    }
                }
            },
            deleteData:function(index){//删除元素
                var self = this;
                var id = this.list[index].id;
                $.post(delUrl,{id:id},function (data) {
                    if(data.code == '200'){
                        self.getData(self.search.page)
                    }
                })
            },
            concalData:function () {//取消事件
                this.entity = {};
            }
        }
    });
}