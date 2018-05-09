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
				<li>创建相册</li>
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
							<h2>创建新相册</h2>
						</header>

						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form action="${base}/home/index" method="post" id="commentAdd"
									class="smart-form">
									<input type="hidden" value="${userRank}" name="userRank" id="userRank">
									<!-- fieldset -->
									<fieldset>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">相册名称</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="text" name="albumName" id="albumName" placeholder="请输入相册名称">
												</label>
											</section>
										</div>
										<div class="row">
										    <section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">相册描述</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="text" name="albumDescribe" id="albumDescribe" placeholder="请输入相册描述">
												</label>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									<footer>
									    <button type="button" name="backBtn" id="backBtn" onclick="window.location.href='${base}/home/index';"
											class="btn btn-primary">返回</button>
										<button type="submit" 
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
		
<!-- 		自定义js -->
	     <script
		src="${resourcesUrl}/js/addcolumn.js">
		</script>  
		
		
	

</body>
</html>
