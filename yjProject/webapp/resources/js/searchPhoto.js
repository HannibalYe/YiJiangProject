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

// 表格初始化
var app = angular.module("myApp", []);
app.controller("myCtrl", function($scope) {
	$scope.submitted = false
	$scope.submitForm = function(isValid) {
		if (isValid) {
			init();
			delOptionInit();
			dateInit();
		} else
			$scope.submitted = true;
	};
});
function init() {
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
		$("#photoTable").bootstrapTable('destroy');
		$('#photoTable').bootstrapTable({
			method : 'get',
			url : getContextPath() + '/photo/widgets',
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 25, 50 ],
			search : false,
			showExport : false,
			sidePagination : 'server',
			idField : 'id',
			queryParams : function(params) {
				var photoName = $('#photoName').val();
				var albumName = $('#albumName').val();
				var photoDescribe = $('#photoDescribe').val();
				var time = $('#startdate').val();
				params.photoName = photoName;
				params.albumName = albumName;
				params.photoDescribe = photoDescribe;
				params.time = time;
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

/* 添加表格【操作】的内容 */
function operateFormatter(value, row, index) {
	var content = '';
	content = btnInfo + btnEdit + btnDel;
	return content;
}
// 时间控件 初始化 【1、依赖的js包，jquery和css样式 2、初始化方法 3、如何初始化 4、参数】
function dateInit() {
	// START AND FINISH DATE
	$('#startdate').datepicker(
			{
				dateFormat : 'yy-mm-dd',
				prevText : '<i class="fa fa-chevron-left"></i>',
				nextText : '<i class="fa fa-chevron-right"></i>',
				monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
						'八月', '九月', '十月', '十一月', '十二月' ],
				dayNamesMin : [ '一', '二', '三', '四', '五', '六', '日' ],
				changeMonth : true,
				changeYear : true,
				onSelect : function(selectedDate) {
					$('#finishdate').datepicker('option', 'minDate',
							selectedDate);
				}
			});

	$('#finishdate').datepicker(
			{
				dateFormat : 'yy-mm-dd',
				prevText : '<i class="fa fa-chevron-left"></i>',
				nextText : '<i class="fa fa-chevron-right"></i>',
				monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
						'八月', '九月', '十月', '十一月', '十二月' ],
				dayNamesMin : [ '一', '二', '三', '四', '五', '六', '日' ],
				changeMonth : true,
				changeYear : true,
				onSelect : function(selectedDate) {
					$('#startdate').datepicker('option', 'maxDate',
							selectedDate);
				}
			});
}