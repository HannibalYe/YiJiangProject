var selections = [];
// 查看按钮
var btnInfo = '<a '
		+ ' class="show-info btn btn-xs btn-info"  rel="popover-hover" data-placement="top" data-content="查看照片列表"'
		+ ' href="javascript:void(0)"> '
		+ ' <span class="fa  fa-search"></span> ' + ' </a> ';
// 修改按钮
var btnEdit = '<a '
		+ ' class="edit-info btn btn-xs bg-color-blue txt-color-white" rel="popover-hover" data-placement="top" data-content="编辑相册" '
		+ ' href="javascript:void(0)"> ' + ' <span class="fa fa-edit"></span> '
		+ ' </a> ';
// 删除按钮
var btnDel = '<a '
		+ ' class="del btn btn-xs btn-danger" rel="popover-hover" data-placement="top" data-content="删除相册"'
		+ ' href="javascript:void(0)"> '
		+ ' <span class="fa fa-trash-o"></span> ' + ' </a> ';
$(document).ready(function() {
	init();
});
// 表格初始化
function init() {
	var table = $('#albumTable').bootstrapTable({
		method : 'get',
		url : getContextPath() + '/home/getAlbumList',
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 25, 50 ],
		search : false,
		showExport : false,
		sidePagination : 'server',
		idField : 'albumid',
		queryParams : function(params) {
			params.courseName = $('#courseName').val();
			params.status = $('#status').val();
			params.checkStatus = $('#checkStatus').val();
			return params;
		},
		responseHandler : responseHandler,
		onPostBody : function() {
			$('#albumTable').bootstrapTable("resetView");
			$(".btn").popover({
				trigger : 'hover'
			});
		}
	});
	function responseHandler(res) {
		return res;
		if ("error" == res.RET_CODE) {
			showAlert(res.RET_MSG);
			return res;
		}
		$.each(res.rows, function(i, row) {
			var index = parseInt(res.pageIndex);
			$.each(res.rows, function(i, row) {
				row.index = index + i + 1;
				// row.state = $.inArray(row.quesId, selections) !== -1;
			});
		});
		return res;
	}
	$('#albumTable')
			.on(
					'check.bs.table check-all.bs.table '
							+ 'uncheck.bs.table uncheck-all.bs.table',
					function(e, rows) {
						var ids = $.map(!$.isArray(rows) ? [ rows ] : rows,
								function(row) {
									return row.albumid;
								}), func = $.inArray(e.type, [ 'check',
								'check-all' ]) > -1 ? 'union' : 'difference';
						selections = _[func](selections, ids);
					});

	$('#togglePagBtn').click(function() {
		$('#albumTable').bootstrapTable('togglePagination');
	});

	$('#queryBtn').click(function() {
		var startdate = $("#startdate").val();
		var finishdate = $("#finishdate").val();
		// alert(startdate+"--"+finishdate);
		// 做查询业务
		$('#albumTable').bootstrapTable('selectPage', 1);
	});
	$(window).resize(function() {
		$('#albumTable').bootstrapTable('resetView');
	});
	// 操作事件
	window.operateEvents = {
		'click .del' : function(e, value, row, index) {
			modifyOutlineRes(row);
		},
		'click .edit-info' : function(e, value, row, index) {
			window.location.href = getContextPath()
					+ '/home/editAlbum?albumid=' + row.albumid;
		},
		'click .show-info' : function(e, value, row, index) {
			window.location.href = getContextPath() + '/home/photo?albumid='
					+ row.albumid;
		},
	};
}
function modifyOutlineRes(row) {
	showConfirm("是否删除此相册?", function() {
		$.ajax({
			url : getContextPath() + '/home/deleteAlbum',
			dataType : "json",
			async : true,
			data : {
				albumid : row.albumid,
			},
			type : "POST",
			error : function() {
				showAlert("网络运行错误！");
			},
			success : function(data) {
				if (data.RET_CODE == "delete") {
					showAlert("删除成功！");

					$('#albumTable').bootstrapTable('selectPage', 1);
				} else {
					showAlert("删除失败！");
				}
			}
		});
	});
}

/* 添加表格【操作】的内容 */
function operateFormatter(value, row, index) {
	var content = '';
	content = btnInfo + btnEdit + btnDel;
	return content;
}