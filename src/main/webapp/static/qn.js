/**
 * Created by Administrator on 2016/9/1.
 */

var Qn = function (config) {
    this.init(config)
}
Qn.prototype.defaults={
    runtimes: 'html5,flash,html4',    //上传模式,依次退化
    browse_button :'upBtn',//上传选择的点选按钮，**必需**
    get_new_uptoken: false,//设置上传文件的时候是否每次都重新获取新的token
    container: 'container',//上传区域DOM ID，默认是browser_button的父元素，
    max_file_size: '500mb',           //最大文件体积限制
    flash_swf_url: '../lib/qiniu/Moxie.swf',  //引入flash,相对路径
    max_retries: 3,                   //上传失败最大重试次数
    dragdrop: true,                   //开启可拖曳上传
    drop_element: 'container',        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                //分块上传时，每片的体积
    auto_start: true              //选择文件后自动上传，若关闭需要自己绑定事件触发上传

}
Qn.prototype.init = function(config){
    var browse_button = this.defaults.browse_button;
    var opt = {
        init: {
            'FilesAdded': function(up, files) {
                $('table').show();
                $('#success').hide();
                plupload.each(files, function(file) {
                    // 文件添加进队列后,处理相关的事情
                    var progress = new FileProgress(file, 'fsUploadProgress');
                    progress.setStatus("等待...");
                    progress.bindUploadCancel(up);
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                if (up.runtime === 'html5' && chunk_size) {
                    progress.setChunkProgess(chunk_size);
                }
            },
            'UploadProgress': function(up, file) {
                // 每个文件上传时,处理相关的事情
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                progress.setProgress(file.percent + "%", file.speed, chunk_size);
            },
            'FileUploaded': function(up, file, info) {
                var progress = new FileProgress(file, 'fsUploadProgress');
                progress.setComplete(up, info);
                var domain = up.getOption('domain');
                var res = JSON.parse(info);
                var sourceLink = "http://"+domain + "/"+res.key; //获取上传成功后的文件的Url
                console.log("link:"+sourceLink);
                //$("#fileUrl").val(sourceLink);
                config.$fileUrl.val(sourceLink);
                if(config.browse_button != undefined){
                    $("#"+config.browse_button).attr("disabled","disabled");
                }else{
                    $("#"+browse_button).attr("disabled","disabled");
                }

            },
            'Error': function(up, err, errTip) {
                //上传出错时,处理相关的事情
                $('table').show();
                var progress = new FileProgress(err.file, 'fsUploadProgress');
                progress.setError();
                progress.setStatus(errTip);
                console.log("err:"+errTip);
            },
            'UploadComplete': function() {
                $('#success').show();
                //显示图片固定大小
                $(".imgWrapper img").css("width","100px");
                $(".imgWrapper img").css("height","80px");
            },
            'Key': function(up, file) {
                // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
                // 该配置必须要在 unique_names: false , save_key: false 时才生效
                var key = new Date().getTime();
                // do something with key here
                return key
            }
        }
    }
    var settings = $.extend({},this.defaults,config,opt);
    var qiniu = new QiniuJsSDK();
    var uploader3 = qiniu.uploader(settings);
}

