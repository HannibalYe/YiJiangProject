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
				<li>相册管理</li>
				<li>照片管理</li>
			</ol>
		</div>
		<!-- 路径导航结束 -->
		<!-- 主题内容 开始-->
		<div id="content">
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
							<h2>照片列表信息</h2>
						</header>
						<input type="hidden" id="albumid" name="albumid"
							value="${albumid}" />
						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<div class="row" style="margin-bottom: 20px;">
								<section class="col col-lg-1 col-md-2 col-sm-2 col-xs-2">
									<button type="button" name="updBtn" id="updBtn"
										class="btn btn-info">批量移动</button>
								</section>
								<section class="col col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<label class="select" style="width: 100%;"> <select
										id="chooseAlbum" name="chooseAlbum"
										style="height: 32px; width: 100%;">
											<option value="">请选择相册</option>
											<c:forEach items="${albumvo}" var="item">
												<option value="${item.albumname}">${item.albumname}</option>
											</c:forEach>
									</select>
									</label>
								</section>
								<section class="col col-lg-5 col-md-1 col-sm-1 col-sm-1"></section>
								<section class="col col-lg-1 col-md-2 col-sm-2 col-xs-2">
									<div align="right">
										<button type="button" name="backBtn" id="backBtn"
											onclick="window.location.href='${base}/home/index';"
											class="btn btn-primary">返回</button>
									</div>
								</section>
								<section class="col col-lg-1 col-md-2 col-sm-2 col-xs-2">
									<div align="right">
										<button type="button" name="queryBtn" id="addBtn"
											onclick="window.location.href='${base}/home/addPhoto?albumid=${albumid}';"
											class="btn btn-info">添加照片</button>
									</div>
								</section>
								<section class="col col-lg-1 col-md-2 col-sm-2 col-xs-2">
									<div align="right">
										<button type="button" name="delBtn" id="delBtn"
											class="btn btn-danger">批量删除</button>
									</div>
								</section>
							</div>
						</div>
						<!-- widget content -->
						<div class="widget-body no-padding" id="photoListTplDiv">
							<table id="photoTable"
								class="table table-striped table-bordered table-hover text-center">
								<thead>
									<tr>
										<th class="text-center" data-field=photoname>名称</th>
										<th class="text-center" data-field="description">描述</th>
										<th class="text-center" data-field="screendate">上传时间</th>
										<th class="text-center" data-formatter="operateFormatter"
											data-events="operateEvents"><i
											class="fa fa-fw fa-cog txt-color-blue hidden-md hidden-sm hidden-xs"></i>
											操作</th>
										<th class="text-center" data-checkbox="true"></th>
									</tr>
								</thead>
							</table>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</article>
				<!-- end article -->
			</div>
		</div>
	</div>
	<!-- 主体内容结束 -->

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

	<!-- 自定义JS -->
	<script src="${resourcesUrl}/js/photoList.js"></script>
</body>
</html>
