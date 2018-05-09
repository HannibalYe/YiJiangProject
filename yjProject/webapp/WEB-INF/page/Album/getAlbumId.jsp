<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/commonPage.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="${resourcesUrl}/common/components/artDialog/ui-dialog.css">
	</head>
<body>
	<div class="text-center">
             <ul class="pagination"  id="pagination">      
             </ul>
	</div>
	<!--  引入footer的头部 -->
	<%@ include file="/WEB-INF/page/common/header.jsp"%>
	<!--  引入footer的尾部 -->
	<%@ include file="/WEB-INF/page/common/footer.jsp"%>
	<!--Page Related styles-->
	<%@ include file="/resources/tpl/pager3.tpl"%> 
	<!-- 分页 -->
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/paginator/bootstrap-paginator.js">
</script>
	<script type="text/javascript">
	var pageNo = 1;
 	var allPage=5 ;
	var pageSize = 5;
 	function changePage(page)
 	{
		pageNo = page;
	} 
	$(document).ready(function() 
	{
		initPage();
	});
	function initPage() 
	{
		var params = {};
		var albumId = "";
		var albumName = "";
		var description = "";
		params.albumId = albumId;
		params.albumName = albumName;
		params.description= description;
		params.pageNo = pageNo;
		params.pageSize = pageSize;
		var url =${base}"/album/pagining";
		$.ajax({
			type : "POST",
			url : url,
			data : params,
			async : true,
			dataType : "json",
			error : function(request) {

			},
			success : function(data) 
			{
				var totalNum = parseInt(data.RET_OBJ.albumNum);
				allPage = Math.ceil(totalNum/pageSize);
				var tpl = $('#demoFromu').html();
				var html = juicer(tpl, data);
				$("#content").html(html);
				 callPageShow('pagination', pageNo, allPage, initPage, changePage); 
			}
		});
	}
</script> 

		<div id="content">     	
		</div>
</body>
</html>