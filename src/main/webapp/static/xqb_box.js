toastr.options = {

};
var Toast = function (config) {
	this.init(config);
}
Toast.prototype.default={
	"closeButton": false,
	"debug": false,
	"progressBar": false,
	"positionClass": "toast-top-right",
	"showDuration": "400",
	"hideDuration": "1000",
	"timeOut": "1500",
	"extendedTimeOut": "1000",
	"showEasing": "swing",
	"hideEasing": "linear",
	"showMethod": "fadeIn",
	"hideMethod": "fadeOut",
	onHidden: function() {
		location.reload();
	}
};
Toast.prototype.init=function(config){
	var settings = $.extend({},this.default,config);
	toastr.options =settings;
};
Toast.prototype.success=function (title) {
	toastr.success(title);
}
Toast.prototype.waring = function (title) {
	toastr.warning(title);
}
var box = {};
box.warning=function (text) {
		if(text != null && text != ''){
			swal(
				{
					title: "提示",
					text: text,
					type: "warning",
					showCancelButton: false,
					showConfirmButton:true,
					closeOnConfirm: false
				}
			);
		}
}
box.success=function(text){
	swal({
		title:"提示",
		text:text,
		type:"success",
		timer:2000,
		showCancelButton:false
	},function () {
		location.reload();
	})
}
box.confirm_d=function (url) {
	swal(
		{
			title: "提示",
			text: "您确定要删除吗？",
			type: "warning",
			showCancelButton: true,
			showConfirmButton:true,
			closeOnConfirm: false,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "删除",
			cancelButtonText: "取消"
		},function (isConfirm) {
			if(isConfirm){
				$.post(url,function (result) {
					if(result==1){
						swal({
							title:"提示",
							text:"删除成功",
							type:"success",
							timer:2000,
							showCancelButton:false
						},function () {
							location.reload();
						});
					}else{
						swal({
							title:"提示",
							text:"删除失败",
							type:"warning",
							timer:2000,
							showCancelButton:false
						});
					}
				})
				//window.location.href = url;
			}
		}
	);
}
box.confirm_o=function (url) {
	swal(
		{
			title: "提示",
			text: "您确定要离园吗？",
			type: "warning",
			showCancelButton: true,
			showConfirmButton:true,
			closeOnConfirm: false,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "确定",
			cancelButtonText: "取消"
		},function (isConfirm) {
			if(isConfirm){
				$.post(url,function (result) {
					if(result==1){
						swal({
							title:"提示",
							text:"离园操作成功",
							type:"success",
							timer:2000,
							showCancelButton:false
						},function () {
							location.reload();
						});
					}else{
						swal({
							title:"提示",
							text:"离园操作失败",
							type:"warning",
							timer:2000,
							showCancelButton:false
						});
					}
				});
				// window.location.href = url;
			}
		}
	);
}

box.confirm_up=function (url) {
	swal(
		{
			title: "提示",
			text: "您确定要上架吗？",
			type: "warning",
			showCancelButton: true,
			showConfirmButton:true,
			closeOnConfirm: false,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "上架",
			cancelButtonText: "取消"
		},function (isConfirm) {
			if(isConfirm){
				$.post(url,function (result) {
					if(result==1){
						swal({
							title:"提示",
							text:"上架成功",
							type:"success",
							timer:2000,
							showCancelButton:false
						},function () {
							location.reload();
						});
					}else{
						swal({
							title:"提示",
							text:"上架失败",
							type:"warning",
							timer:2000,
							showCancelButton:false
						});
					}
				})
				//window.location.href = url;
			}
		}
	);
}

box.confirm_down=function (url) {
	swal(
		{
			title: "提示",
			text: "您确定要下架吗？",
			type: "warning",
			showCancelButton: true,
			showConfirmButton:true,
			closeOnConfirm: false,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "下架",
			cancelButtonText: "取消"
		},function (isConfirm) {
			if(isConfirm){
				$.post(url,function (result) {
					if(result==1){
						swal({
							title:"提示",
							text:"下架成功",
							type:"success",
							timer:2000,
							showCancelButton:false
						},function () {
							location.reload();
						});
					}else{
						swal({
							title:"提示",
							text:"下架失败",
							type:"warning",
							timer:2000,
							showCancelButton:false
						});
					}
				})
				//window.location.href = url;
			}
		}
	);
}
