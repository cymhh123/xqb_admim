/**
 * Created by Administrator on 2016/9/28.
 */
var common = {
    getListData:function (url,paramsData,resultData,curr) {
        if(curr != null && curr != undefined){
            paramsData.page = curr;
        }
        console.log("search:"+JSON.stringify(this.search));
        $.getJSON(url, paramsData, function (res) {
            resultData = res.extra;
            console.log("list:"+JSON.stringify(resultData));
            //此页没有数据时，显示上一页信息
            if(resultData.length==0 && paramsData.page != 1){
                this.getListData(paramsData.page-1)
                return;
            }
            //显示分页
            laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: res.pageTotal, //通过后台拿到的总页数
                curr: paramsData.page, //当前页
                jump: function(obj, first){ //触发分页后的回调
                    if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                        self.getData(obj.curr);
                    }
                }
            });
        });
    }
}
