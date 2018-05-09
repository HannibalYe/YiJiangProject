var selections = [];

// 查看按钮
var btnInfo = '<a '
		+ ' class="show-info btn btn-xs btn-info"  rel="popover-hover" data-placement="top" data-content="查看"'
		+ ' href="javascript:void(0)"> '
		+ ' <span class="fa  fa-search"></span> ' + ' </a> ';
// 修改按钮
var btnEdit = '<a '
		+ ' class="edit-info btn btn-xs bg-color-blue txt-color-white" rel="popover-hover" data-placement="top" data-content="编辑" '
		+ ' href="javascript:void(0)"> ' + ' <span class="fa fa-edit"></span> '
		+ ' </a> ';
// 删除按钮
var btnDel = '<a '
		+ ' class="del btn btn-xs btn-danger" rel="popover-hover" data-placement="top" data-content="删除"'
		+ ' href="javascript:void(0)"> '
		+ ' <span class="fa fa-trash-o"></span> ' + ' </a> ';

$(document).ready(function() {
	init();
	delOptionInit();
	updateOptionInit();
	$("#chooseAlbum").select2({
		maximumSelectionLength : 1
	// 最多能够选择的个数
	});

});

// 表格初始化

/*
 * 通过id查询 查询信息由params返回
 */
function init() {
	var table = $('#photoTable').bootstrapTable({
		method : 'get',
		url : getContextPath() + '/home/getPhotoList',
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 25, 50 ],
		search : false,
		showExport : false,
		sidePagination : 'server',
		idField : 'id',
		queryParams : function(params) {
			var albumid = $('#albumid').val();
			params.albumid = albumid;
			params.photoName = $('#photoName').val();
			params.albumName = $('#albumName').val();
			params.photoDescribe = $('#photoDescribe').val();
			params.startdate = $('#startdate').val();
			params.finishdate = $('#finishdate').val();
			return params;
		},
		responseHandler : responseHandler,
		onPostBody : function() {
			$('#photoTable').bootstrapTable("resetView");
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
			});
		});
		return res;
	}

	$('#photoTable')
			.on(
					'check.bs.table check-all.bs.table '
							+ 'uncheck.bs.table uncheck-all.bs.table',
					function(e, rows) {
						var ids = $.map(!$.isArray(rows) ? [ rows ] : rows,
								function(row) {
									return row.photoid;
								}), func = $.inArray(e.type, [ 'check',
								'check-all' ]) > -1 ? 'union' : 'difference';
						selections = _[func](selections, ids);
					});

	$('#togglePagBtn').click(function() {
		$('#photoTable').bootstrapTable('togglePagination');
	});

	// 查询事件
	$('#queryBtn').click(function() {
		// 做查询业务
		$('#photoTable').bootstrapTable('selectPage', 1);
	});

	$(window).resize(function() {
		$('#photoTable').bootstrapTable('resetView');
	});

	// 操作事件
	window.operateEvents = {
		'click .del' : function(e, value, row, index) {
			modifyOutlineRes(row);
		},
		'click .edit-info' : function(e, value, row, index) {
			window.location.href = getContextPath() + '/photo/edit?photoid='
					+ row.photoid;
		},
		'click .show-info' : function(e, value, row, index) {
			window.location.href = getContextPath()
					+ '/home/viewPhoto?photoid=' + row.photoid;
		}
	};
}

function modifyOutlineRes(row) {
	showConfirm("是否删除此图片?", function() {
		$.ajax({
			url : getContextPath() + '/photo/delete',
			dataType : "json",
			async : true,
			data : {
				photoid : row.photoid,
			},
			type : "POST",
			beforeSend : function() {
			},
			error : function() {
				showAlert("网络运行错误！");
			},
			success : function(data) {
				if (data) {
					showAlert("删除成功！");
					$('#photoTable').bootstrapTable('selectPage', 1);
				}
			}
		});
	});
}

/* 批量 删除照片 */
function delOptionInit() {
	$("#delBtn").click(function() {
		var assignIds = selections.join(",");
		if (assignIds == "") {
			showAlert("请选择要删除的照片!");
			return;
		}
		showConfirm("是否删除这些图片?", function() {
			$.ajax({
				type : "POST",
				url : getContextPath() + "/photo/deletes",
				data : {
					photoids : assignIds,
				},
				async : true,
				beforeSend : function() {
				},
				error : function(request) {
					showAlert('出错了，您没有选择选项!');
				},
				success : function(data) {
					showAlert('批量删除成功！');
					$('#photoTable').bootstrapTable('selectPage', 1);
				}
			});
		});
	});
}
/* 批量更改相片 */
function updateOptionInit() {
	$("#updBtn").click(function() {
		var obj = document.getElementById("chooseAlbum");
		var index = obj.selectedIndex;
		var value = obj.options[index].value;
		var assignIds = selections.join(",");
		if (assignIds == "") {
			showAlert("请选择要移动的照片!");
			return;
		} else if (value == "") {
			showAlert("请选择要移动到的相册!");
			return;
		}
		showConfirm("是否移动这些图片?", function() {
			$.ajax({
				type : "POST",
				url : getContextPath() + "/photo/change",
				data : {
					photoids : assignIds,
					chooseAlbumname : value,
				},
				async : true,
				beforeSend : function() {
				},
				error : function(request) {
					showAlert('出错了，您没有选择选项!');
				},
				success : function(data) {
					showAlert('移动成功！');
					$('#photoTable').bootstrapTable('selectPage', 1);
				}
			});
		});
	});
}
/* 添加表格【操作】的内容 */
function operateFormatter(value, row, index) {
	var content = '';
	content = btnInfo + btnEdit + btnDel;
	return content;
}
