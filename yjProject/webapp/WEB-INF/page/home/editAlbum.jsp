<%@page import="java.util.Map"%>
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
				<li>编辑相册</li>
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
							<h2>修改相册信息</h2>
						</header>
                            <%
							    Map<String, Object> map = (Map<String, Object>) request	.getAttribute("queryIdAlbum");
								String albumid = (String) map.get("albumid");								
								String albumName = (String) map.get("albumName");
						  		String description = (String) map.get("description");
						     %>
                            
                            
						<!-- widget div-->
						<div>
							<!-- widget edit box -->
							<div class="jarviswidget-editbox"></div>
							<!-- end widget edit box -->
							<!-- widget content -->
							<div class="widget-body no-padding">
								<!-- form -->
								<form action="commit" method="post" id="commit"
									class="smart-form">
									
									<input type="hidden" value="${userRank}" name="userRank" id="userRank">
									<!-- fieldset -->
									<fieldset>
										<div class="row">
											<section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">修改相册名称</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="text" name="albumName" id="albumName" value=<%=albumName%>           placeholder="请输入新的相册名称">
												</label>
											</section>
										</div>
										<div class="row">
										    <section class="col col-lg-1 col-md-1 col-sm-1 col-xs-3">
												<label class="label text-right">修改相册描述</label>
											</section>
											<section class="col col-lg-5 col-md-5 col-sm-5 col-xs-9">
												<label class="input"> 
													<input type="text" name="albumDescription" id="albumDescription" value=<%=description%> placeholder="请输入新的相册描述">
												</label>
											</section>
										</div>
									</fieldset>
									<!-- fieldset -->
									
											<input type="hidden" name="albumid" id="albumid"
											value="<%=albumid%>">
											
									
									<footer>
									    <button type="button" name="queryBtn" id="queryBtn" onclick="window.location.href='${base}/home/index';"
											class="btn btn-primary">返回</button>
										<button type="button" name="queryBtn" id="queryBtn"
											class="btn btn-primary" onclick="formSub()">提交</button>
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
	function formSub() {
		var albumid = "";
		var albumName = "";
		var albumDescription = ""; 
		var params = {};
		params.albumid = albumid;
		params.albumName = albumName;
		params.albumDescription = albumDescription;
		$('#commit').ajaxSubmit({
			type : "POST",
			data : params,
			url : getContextPath()+"/home/updateAlbum",
			dataType : "json",
			success : function(data) 
			{  
				  if(data.RET_OBJ=="")
					{   
					   showAlert("更新失败");
						console.log(data.RET_OBJ.albumname);					
					}
				  else
					  {
					   showAlert("更新成功");
					 /*   window.location.href = getContextPath() 
						+ "/home/index"; */
					  }
			}
		});
	}
</script> 
</body>
</html>
