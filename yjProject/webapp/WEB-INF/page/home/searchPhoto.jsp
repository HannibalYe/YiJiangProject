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
				<li>照片管理</li>
				<li>搜索照片</li>
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
							<h2>搜索照片</h2>
						</header>

						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form method="post" id="comment-form" class="smart-form"
									name="MyForm" ng-submit="submitForm(MyForm.$valid)" novalidate>
									<!-- fieldset -->
									<fieldset>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">照片名称</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9"
												ng-class="{ 'has-error' : MyForm.photoName.$invalid && !MyForm.photoName.$pristine }">
												<label class="input"> <input type="text"
													name="photoName" id="photoName" placeholder="请输入查询照片的名称"
													ng-model="photo.photoName" ng-maxlength="8">
												</label>
												<div class="form-error"
													ng-show="MyForm.photoName.$invalid && !MyForm.photoName.$pristine">
													<p ng-show="MyForm.photoName.$error.maxlength"
														class="help-block" style="color: red">搜索的照片名称过长!(最长8位字符)</p>
												</div>
											</section>

											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">所属相册</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9"
												ng-class="{ 'has-error' : MyForm.albumName.$invalid && !MyForm.albumName.$pristine }">
												<label class="input"> <input type="text"
													name="albumName" id="albumName"
													placeholder="请输入查询照片所属的相册名称" ng-model="photo.albumName"
													ng-maxlength="8">
												</label>
												<div class="form-error"
													ng-show="MyForm.albumName.$invalid && !MyForm.albumName.$pristine">
													<p ng-show="MyForm.albumName.$error.maxlength"
														class="help-block" style="color: red">搜索的相册名称长度过长!(最长8位字符)</p>
												</div>
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">照片描述</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9"
												ng-class="{ 'has-error' : MyForm.photoDescribe.$invalid && !MyForm.photoDescribe.$pristine }">
												<label class="input"> <input type="text"
													name="photoDescribe" id="photoDescribe"
													placeholder="请输入查询照片的描述" ng-model="photo.photoDescribe"
													ng-maxlength="10">
												</label>
												<div class="form-error"
													ng-show="MyForm.photoDescribe.$invalid && !MyForm.photoDescribe.$pristine">
													<p ng-show="MyForm.photoDescribe.$error.maxlength"
														class="help-block" style="color: red">搜索的照片描述长度过长!(最长8位字符)</p>
												</div>
											</section>
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">上传时间</label>
											</section>
											<section class="col col-lg-2 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> <i
													class="icon-append fa fa-calendar"></i> <input type="text"
													name="startdate" id="startdate">
												</label>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									<footer>
										<button type="submit" name="queryBtn" id="queryBtn"
											class="btn btn-primary search">查询</button>
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
			<div class="row">
				<!-- article -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0"
						data-widget-editbutton="true" data-widget-togglebutton="true"
						data-widget-collapsed="false" data-widget-custombutton="true"
						data-widget-deletebutton="true"
						data-widget-fullscreenbutton="true">

						<header>
							<span class="widget-icon"> <i class="fa  fa-list"></i>
							</span>
							<h2>搜索结果</h2>
						</header>

						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<div class="row" style="margin-bottom: 20px;">
								<section class="col col-lg-10 col-md-10 col-sm-10 col-sm-10">
								</section>
								<section class="col col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<div align="right">
										<button type="button" name="delBtn" id="delBtn"
											class="btn btn-danger">批量删除</button>
									</div>
								</section>
							</div>
							<!-- widget content -->
							<div class="widget-body no-padding" id="photoListTplDiv">
								<table id="photoTable"
									class="table table-striped table-bordered table-hover text-center">
									<thead>
										<tr>
											<th class="text-center" data-field="photoname">名称</th>
											<th class="text-center" data-field="description">描述</th>
											<th class="text-center" data-field="screendate">上传时间</th>
											<th class="text-center" data-formatter="operateFormatter"
												data-events="operateEvents"><i
												class="fa fa-fw fa-cog txt-color-blue hidden-md hidden-sm hidden-xs"></i>
												操作</th>
											<th class="text-center" data-checkbox="true">
												<!-- <div id="jqgh_jqgrid_cb">
											        <input role="checkbox" id="cb_jqgrid" class="cbox" type="checkbox">
											        	<span class="s-ico" style="display:none">
											        		<span sort="asc" class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span>
											        		<span sort="desc" class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span>
											        	</span>
									      		</div> -->
											</th>
										</tr>
									</thead>
								</table>
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
		src="${resourcesUrl}/common/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
	<script src="${resourcesUrl}/common/js/plugin/select2/select2.min.js"></script>
	<script
		src="${resourcesUrl}/common/js/plugin/jqgrid/jquery.jqGrid.min.js"></script>
	<script
		src="${resourcesUrl}/common/js/plugin/jqgrid/grid.locale-en.min.js"></script>
	<script
		src="${resourcesUrl}/common/components/angularjs/angular.min.js"></script>
	<!-- 自定义JS -->
	<script src="${resourcesUrl}/js/searchPhoto.js"></script>
	<script
		src="${resourcesUrl}/common/components/angularjs/angular.min.js"></script>
</body>
</html>
