
var NEED_CONTEXT = true;
		// 获得地址
		function getContextPath() {
			var p = document.location.pathname;
			if (NEED_CONTEXT) {
				var index = p.substr(1).indexOf("/");
				p = p.substr(0, index + 1);
				p = window.location.host + p;
			} else {
				p = window.location.host;
			}
			return 'http://' + p;
		};		
		
		$(function() 
				{
			// 提交验证
			$("#commentAdd").validate({
				// Rules for form validation
				submitHandler:function(form){
					$("#commentAdd").ajaxSubmit
					({
						type:"post",
						url:getContextPath()+"/home/addcolumn",
						success:function(data){
						
							if(data.RET_OBJ.albumName=="")
							{
								showAlert("提交失败！");
							}
							else
							{  
	
								showAlert("提交成功！");
							/*	window.location.href=getContextPath() 
								+ "/home/index";*/
							}
						},
						error:function(){
							alert("AJAX ERROR");
						}
					})
				},
				rules : {
					albumName : {
						required : true
					},
					albumDescribe : {
						required : true,
						minlength : 3,
						maxlength : 20
					},
				},
				messages : 
				{
					albumName : 
					{
						required : '请输入您的相册名'
					},
					albumDescribe : 
					{
						required : '请输入您的相册描述',
						minlength : $.validator.format("请输入最少 {0} 字符."),
						maxlength : $.validator.format("请输入最多 {0} 字符.")
					},
				},
				errorPlacement : function(error, element) 
				{
					error.insertAfter(element.parent());
				}
			});
		});
