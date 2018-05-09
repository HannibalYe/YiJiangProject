<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/commonPage.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
<meta charset="utf-8" />
<title></title>
<!--Page Related styles-->
</head>
<!-- /Head -->
<!-- Body -->
<body ng-app="myApp" ng-controller="myCtrl">
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
				<li>相册管理</li>
				<li>照片管理</li>
				<li>添加照片</li>
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
							<h2>添加新照片</h2>
						</header>
						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form id="comment-form" class="smart-form"
									enctype="multipart/form-data" name="MyForm"
									ng-submit="submitForm(MyForm.$valid)" novalidate method="post">
									<!-- fieldset -->
									<fieldset>
										<div class="row"
											ng-class="{'has-error':MyForm.photoName.$invalid&&!MyForm.photoName.$pristine && !MyForm.photoName.$focused || (MyForm.photoName.$invalid && submitted)}">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">照片名称</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> <input type="text"
													name="photoName" id="photoName" placeholder="请输入照片名称"
													ng-model="photo.photoName" required ng-maxlength="8"
													ng-focus />
												</label>
												<div class="form-error"
													ng-show="MyForm.photoName.$invalid && !MyForm.photoName.$pristine && !MyForm.photoName.$focused || (MyForm.photoName.$invalid && submitted)">
													<p ng-show="MyForm.photoName.$error.required"
														class="help-block" style="color: red">请填写照片名称!</p>
													<p ng-show="MyForm.photoName.$error.maxlength"
														class="help-block" style="color: red">照片名称过长!</p>
												</div>
											</section>
										</div>
										<div class="row"
											ng-class="{'has-error':!MyForm.photoDescribe.$pristine && MyForm.photoDescribe.$invalid && !MyForm.photoDescribe.$focused || (MyForm.photoDescribe.$invalid && submitted)}">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">照片描述</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="textarea"> <textarea
														ng-model="message" rows="3" name="photoDescribe"
														id="photoDescribe" placeholder="请输入照片描述" ng-maxlength="50"
														required ng-focus></textarea>
												</label>
												<div class="form-error"
													ng-show="!MyForm.photoDescribe.$pristine && MyForm.photoDescribe.$invalid && !MyForm.photoDescribe.$focused || (MyForm.photoDescribe.$invalid && submitted)">
													<p ng-show="MyForm.photoDescribe.$error.required"
														class="help-block" style="color: red">请完善照片描述!</p>
													<p ng-show="MyForm.photoDescribe.$error.maxlength"
														class="help-block" style="color: red">照片描述过长!</p>
												</div>
												<p class=" txt-color-blue ">
													剩余字数: <span class="txt-color-blue" ng-bind="left()">100</span>
												</p>
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">选择相册</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="select"> <select id="chooseAlbum"
													name="chooseAlbum" style="width: 100%;">
														<option value="">请选择相册</option>
														<c:forEach items="${albumvo}" var="item">
															<option value="${item.albumname}">${item.albumname}</option>
														</c:forEach>
												</select>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">选择照片</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<div class="input input-file">
													<span class="button"><input type="file"
														id="coverlinkFile" name="coverlinkFile"
														onchange="this.parentNode.nextSibling.value = this.value,PreviewImage(this)">浏览</span><input
														type="text" id="coverLink" name="coverLink"
														placeholder="请选择上传照片" readonly="readonly" />
													<div class="remark-tip">
														上传图片大小控制在100M以内，允许类型为.jpg|.jpeg|.png|.gif。(若不选则为默认照片)</div>
												</div>
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<div style="display: block;" id="imgPreview">
													<img id="img1" src="${resourcesUrl}/img/photo1.jpg"
														class="superbox-current-img"
														style="border: 5px solid #333;">
												</div>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									<footer>
										<%
											String albumid = request.getParameter("albumid");
										%>
										<input type="hidden" name="chooseAlbumname"
											id="chooseAlbumname"> <input type="hidden"
											id="albumid" name="albumid" value="<%=albumid%>" />
										<button type="button" name="backBtn" id="backBtn"
											onclick="window.history.back()" class="btn btn-primary">返回</button>
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
	<script
		src="${resourcesUrl}/common/components/angularjs/angular.min.js"></script>
	<!-- JQUERY SELECT2 INPUT  多选JS -->
	<script src="${resourcesUrl}/common/js/plugin/select2/select2.min.js"></script>
	<script src="${resourcesUrl}/js/addPhoto.js"></script>
</body>
</html>
