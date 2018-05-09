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
				<li>数据统计</li>
			</ol>
		</div>
		<!-- 路径导航结束 -->
		<!-- 主题内容 开始-->
		<div id="content">
			<form action="" method="post" id="comment-form" class="smart-form">
			<div class="row">
					<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
						<label class="label text-right"><font style=" font-weight:bold;line-height:33px;">选择年份</font></label>
					</section>
					<section class="col col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label class="select"> 
                          	<select id="chooseDate" name="chooseDate" style="width:100%;">
							</select>
						</label>
					</section>
				</div>
			</form>
			<div class="row">
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
					<div class="jarviswidget jarviswidget-sortable" id="wid-id-11" data-widget-editbutton="false" role="widget" style="">
						<header role="heading">
							<div class="jarviswidget-ctrls" role="menu"></div>
							<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i></span>
							<h2>按月份统计照片数量</h2>
							<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span>
						</header>

						<!-- widget div-->
						<div role="content">
							<div class="widget-body no-padding">
								<div id="non-date-graph" class="chart no-padding"></div>
							</div>
						</div>
						
					</div>
						<!-- end widget div -->

				</article>
				<!-- WIDGET END -->

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
	<!-- Morris Chart Dependencies -->
		<script src="${resourcesUrl}/common/js/plugin/morris/raphael.min.js"></script>
		<script src="${resourcesUrl}/common/js/plugin/morris/morris.min.js"></script>
	<!-- JQUERY SELECT2 INPUT  多选JS -->
	<script src="${resourcesUrl}/common/js/plugin/select2/select2.min.js"></script>
	<!-- 自定义JS -->
	<script src="${resourcesUrl}/js/statisticsList.js"></script>
</body>
</html>
