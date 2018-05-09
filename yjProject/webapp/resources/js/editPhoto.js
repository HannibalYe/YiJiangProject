$(document).ready(function() {
	$('#queryBtn').click(function() {
		var photoName = $('#photoName').val();
		var photoDescribe = $('#photoDescribe').val();
		if (photoName.length > 8 && photoName != '') {
			showAlert("请检查照片名称！");
		}
		if (photoDescribe.length > 50 && photoDescribe != '') {
			showAlert("请检查照片描述！");
		} else {
			showConfirm("您确定修改吗?", function() {
				formSubmit();
			});
		}
	});
});
function formSubmit() {
	var photoid = "";
	var photoName = "";
	var photoDescribe = "";
	var phototype = "";
	var albumid = $('#albumid').val();
	var params = {};
	params.photoid = photoid;
	params.photoName = photoName;
	params.photoDescribe = photoDescribe;
	params.phototype = phototype;
	$('#comment-form').ajaxSubmit(
			{
				type : "POST",
				data : params,
				url : getContextPath() + "/photo/update",
				dataType : "json",
				success : function(data) {
					showAlert("修改成功！");
					window.location.href = getContextPath()
							+ "/home/photo?albumid=" + albumid;
				}
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