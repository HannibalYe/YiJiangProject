<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/commonPage.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
<meta charset="utf-8" />
<title>Neusoft-${websiteName}-修改密码</title>
<!--Page Related styles-->
</head>
<!-- /Head -->
<!-- Body -->
<body>
	<!-- 公共header start-->
	<%@ include file="/WEB-INF/page/common/header.jsp"%>	
	<!-- 公共header end-->
	<!-- 公共left bar start -->
	<%@ include file="/WEB-INF/page/common/leftSideBar.jsp"%>	
	<!-- 公共left bar end -->
	<div id="main" role="main">
		<!-- 路径导航开始 -->
		<div id="ribbon">
			<ol class="breadcrumb">
				<li>账号管理</li>
			</ol>
		</div>
		<!-- 路径导航结束 -->
		<!-- 主题内容 开始-->
		<div id="content">
			<div class="row">
				<!-- article -->
				<article class="col-sm-12 col-md-12 col-lg-12">
					<!-- Widget -->
					<div class="jarviswidget" id="wid-id-6"
						data-widget-editbutton="false" data-widget-custombutton="false">
						<header>
							<span class="widget-icon"> <i class="fa fa-edit"></i>
							</span>
							<h2>修改登录密码</h2>
						</header>

						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form action="" method="post" id="editPassword" class="smart-form">
									<input type="hidden" value="${userRank}" name="userRank" id="userRank">
									<!-- fieldset -->
									<fieldset>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">旧密码</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="password" name="oldPassword" id="oldPassword" placeholder="请输入旧密码">
												</label>
											</section>
										</div>
										<div class="row">
										    <section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">新密码</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="password" name="newPassword" id="newPassword" placeholder="请输入新密码">
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">确认密码</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="password" name="newPassword2" id="newPassword2" placeholder="请再次输入新密码">
												</label>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									<footer>
										<button type="submit" name="queryBtn" id="queryBtn"
											class="btn btn-primary">提交</button>
									</footer>
								</form>
								<!-- end form -->
							</div>
							<!-- end widget content -->

						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->
				</article>
				<!-- end article -->
			</div>
		</div>
		<!-- 主体内容结束 -->
	</div>
	<%@ include file="/WEB-INF/page/common/footer.jsp"%>
	
	<!-- 引入bootstrap datatable脚本 -->
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/tableExport.js"></script>
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/jquery.base64.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/bootstrap-table-all.min.js"></script>
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/colResizable-1.5.min.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/lodash.min.js"></script>

	<script type="text/javascript">
		
	$().ready(function(){
		// 登录验证
		$("#editPassword").validate({
			// Rules for form validation
			submitHandler:function(form){
				$("#editPassword").ajaxSubmit({
					type:"post",
					url:getContextPath()+"/user/editPasswordAjax",
					success:function(data){
						if(data.RET_CODE=="success"){
							showAlert2(data.RET_OBJ,function(){
								window.location.href = getContextPath()+"/login/logout";
							});
						}else if(data.RET_CODE=="error"){
							showAlert(data.RET_OBJ);
						}
					},
					error:function(){
						alert("AJAX ERROR");
					}
				})
			},
			rules : {
				
				oldPassword : {
					required : true,
					minlength : 6,
					maxlength : 20
				},
				newPassword:{
					required : true,
					minlength : 6,
					maxlength : 20
				},
				newPassword2:{
					required : true,
					minlength : 6,
					maxlength : 20,
					equalTo:"#newPassword"
				},
			},

			// Messages for form validation
			messages : {
				
				oldPassword : {
					required : '请输入您的密码',
					minlength : $.validator.format("请输入最少 {0} 字符."),
					maxlength : $.validator.format("请输入最多 {0} 字符.")
				},
				newPassword : {
					required : '请输入您的密码',
					minlength : $.validator.format("请输入最少 {0} 字符."),
					maxlength : $.validator.format("请输入最多 {0} 字符.")
				},
				newPassword2 : {
					required : '两次密码不一致,请重新输入',
					minlength : $.validator.format(""),
					maxlength : $.validator.format(""),
					equalTo : "两次密码不一致,请重新输入"	
				},
			},
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});
	})
		</script>
</body>
</html>
