$(document).ready(function() {
	dateInit();
	init();
	$("#chooseDate").bind('change',function(){
		var selectedYear = $(this).val();
		var params = {};
		params.selectedYear= selectedYear;
		$('#non-date-graph').empty();
		$.ajax({
			type : "POST",
			url : getContextPath() + "/photo/counter",
			data : params,
			async : true,
			success :function(data){
				Morris.Line({
					element : 'non-date-graph',
					data : data.dataList,
					xkey : 'month',
					ykeys : ['count'],
					labels : ['数量'],
					parseTime : false
				});
			}
		});
	});
})
//时间控件 初始化 【1、依赖的js包，jquery和css样式 2、初始化方法 3、如何初始化	 4、参数】
function dateInit(){
	var myDate = new Date();
	var currentYear = myDate.getFullYear();     
	var minYear = currentYear-10;
	var yearArray="";
	for(var i=currentYear;i>minYear;i--){
		yearArray = yearArray+'<option value="'+i+'">'+i+'</option>';
	}
	$("#chooseDate").html(yearArray);
	$("#chooseDate").select2({
		  maximumSelectionLength: 1 //最多能够选择的个数
	 });
}
function init(){
	if ($('#non-date-graph').length) {	
		var resources=new Array();
		var selectedYear =$("#chooseDate").val();
		var parmas = {};
		parmas.selectedYear=selectedYear;
		$.ajax({
			type: "POST",
			url : getContextPath() + "/photo/counter",
			data : parmas,
			async : true,	
			success:function(data){
				for(key in data.dataList){
					resources.push(data.dataList[key]);					
				}
				Morris.Line({
					element : 'non-date-graph',
					data : resources,
					xkey : 'month',
					ykeys : ['count'],
					labels : ['数量'],
					parseTime : false
				});
			}
		});
		day_data = resources;
	}
}
