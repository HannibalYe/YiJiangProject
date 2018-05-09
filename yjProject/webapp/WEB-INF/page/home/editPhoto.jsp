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
				<li>编辑照片</li>
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
							<h2>修改照片信息</h2>
						</header>
						<%
							Map<String, Object> map = (Map<String, Object>) request
									.getAttribute("photoInfo");
							String photoid = (String) map.get("photoid");
							String photoname = (String) map.get("photoname");
							String description = (String) map.get("description");
							String phototype = (String) map.get("phototype");
							String albumid = (String) map.get("albumid");
						%>
						<!-- widget div-->
						<div>

							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form id="comment-form" class="smart-form"
									enctype="multipart/form-data" method="post">
									<!-- fieldset -->
									<fieldset>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">修改照片名称</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> <input type="text"
													name="photoName" id="photoName" value="<%=photoname%>">
												</label>*长度不超过8个字符
											</section>
										</div>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">修改照片描述</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> <input type="text"
													name="photoDescribe" id="photoDescribe"
													value="<%=description%>">
												</label>*长度不超过50个字符
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
													<img id="img1"
														src="${resourcesUrl}/upload/uploadimg/<%=phototype%>"
														class="superbox-current-img"
														style="border: 5px solid #333;">
												</div>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									<footer>
										<input type="hidden" name="photoid" id="photoid"
											value="<%=photoid%>"> <input type="hidden"
											name="phototype" id="phototype" value="<%=phototype%>">
										<input type="hidden" name="albumid" id="albumid"
											value="<%=albumid%>">
										<button type="button" name="backBtn" id="backBtn"
											onclick="window.history.back()" class="btn btn-primary">返回</button>
										<button type="button" name="queryBtn" id="queryBtn"
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
	<script src="${resourcesUrl}/common/js/plugin/select2/select2.min.js"></script>
	<script src="${resourcesUrl}/js/editPhoto.js"></script>
</body>
</html>
