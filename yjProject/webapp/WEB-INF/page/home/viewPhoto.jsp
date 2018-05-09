<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
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
				<li>查看照片</li>
			</ol>
		</div>
		<!-- 路径导航结束 -->
		<!-- 主题内容 开始-->
		<%
			String photoname = (String) request.getAttribute("photoname");
			String description = (String) request.getAttribute("description");
			String screendate = (String) request.getAttribute("screendate");
			String phototype = (String) request.getAttribute("phototype");
			String albumname = (String) request.getAttribute("albumname");
		%>
		<div id="content">
			<div class="row">
				<div
					class="col col-lg-12 col-md-12 col-sm-12 col-xs-12 superbox-show"
					style="display: block;">
					<div class="col col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<img style="max-width: 400px; height: auto;"
							src="${resourcesUrl}/upload/uploadimg/<%=phototype%>"
							class="superbox-current-img">
					</div>
					<div class="col col-lg-6  col-md-6 col-sm-12 col-xs-12 ">
						<div id="imgInfoBox" class="superbox-imageinfo inline-block">
							<h1><%=photoname%></h1>
							<span> <label> 相片路径：<em><%=phototype%></em>
							</label></span>
							<p class="superbox-img-description">
								所属相册：<%=albumname%></p>
							<p class="superbox-img-description">
								拍摄时间：<%=screendate%></p>
							<p class="superbox-img-description">
								相片描述：<%=description%></p>
						</div>
						<br>
						<button type="button" name="backBtn" id="backBtn"
							onclick="window.history.back()" class="btn btn-primary">返回</button>
					</div>
				</div>
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

</body>
</html>
