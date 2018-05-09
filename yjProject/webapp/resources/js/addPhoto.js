$(document).ready(function() {
	init();
});

// 表格初始化
function init() {
	$("#chooseAlbum").select2({
		maximumSelectionLength : 1
	// 最多能够选择的个数
	});
}

function PreviewImage(imgFile) {
	var filextension = imgFile.value.substring(imgFile.value.lastIndexOf("."),
			imgFile.value.length);
	filextension = filextension.toLowerCase();
	if ((filextension != '.jpg') && (filextension != '.gif')
			&& (filextension != '.jpeg') && (filextension != '.png')
			&& (filextension != '.bmp')) {
		alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 !");
		imgFile.focus();
	} else {
		var path;
		if (document.all)// IE
		{
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById("imgPreview").innerHTML = "";
			document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
					+ path + "\")";// 使用滤镜效果
		} else {
			path = window.URL.createObjectURL(imgFile.files[0]);
			document.getElementById("imgPreview").innerHTML = "<img id='img1' style='min-width:100px;max-width:800px;height:auto;' src='"
					+ path + "'/>";
		}
	}
}

var app = angular.module("myApp", []);
app.controller("myCtrl", function($scope) {
	$scope.submitted = false
	$scope.left = function() {
		return 50 - $scope.message.length;
	};
	$scope.submitForm = function(isValid) {
		if (isValid) {
			var obj = document.getElementById("chooseAlbum");
			var index = obj.selectedIndex;
			var value = obj.options[index].value;
			if (value != null && value != "") {
				document.getElementById("chooseAlbumname").value = value;
				var albumid = $('#albumid').val();
				var photoName = "";
				var photoDescribe = "";
				var chooseAlbumname = "";
				var params = {};
				params.photoName = photoName;
				params.photoDescribe = photoDescribe;
				params.chooseAlbumname = chooseAlbumname;
				$('#comment-form').ajaxSubmit(
						{
							type : "POST",
							data : params,
							url : getContextPath() + "/photo/add",
							dataType : "json",
							success : function(data) {
								if (data) {
									window.location.href = getContextPath()
											+ "/home/photo?albumid=" + albumid;
								}
							}
						});
			} else {
				showAlert("请选择相册！");
			}
		} else
			$scope.submitted = true;
	};
});