function index(){
	$("#mycontainer").empty().load("/view/"+admin.memu + "/index.html");
}

function add() {
	$("#mycontainer").empty().load("/view/"+admin.memu + "/add.html");
}

function save() {
	var url = "/"+admin.memu + "/save.do";
	$.ajax({
		url : url,
		type : "POST",
		cache : false,
		data : $("form").serialize(),
		success : function(rs) {
			index();
		}
	});
}

function edit() {
	var url =  "/view/"+admin.memu + "/edit.html";
	var $checked = $("tbody tr th input:checkbox:checked");
	var id = $checked.val();
	if ($checked.length == 1) {
		$("#mycontainer").empty().load(url);
		$.ajax({
			url : "/"+admin.memu + "/"+id+".do",
			type : "GET",
			cache : false,
			dataType : "json",
			success : function(data) {
				var template = $.templates("#theTmpl");
		    	var htmlOutput = template.render(data);
		    	$("#form").html(htmlOutput);
			}
		});
	} else {
		alert("请选择一条记录！");
	}
}

function editTemp() {
	var url =  admin.memu + "/edit.html";
	var $checked = $("tbody tr th input:checkbox:checked");
	var id = $checked.val();
	if ($checked.length == 1) {
		$("#mycontainer").empty().load(url);
		$.ajax({
			url : "/"+admin.memu + "/"+id+".htm",
			type : "GET",
			cache : false,
			dataType : "json",
			success : function(data) {
				var template = $.templates("#theTmpl");
		    	var htmlOutput = template.render(data);
		    	$("#form").html(htmlOutput);
			}
		});
	} else {
		alert("请选择一条记录！");
	}
}

function update() {
	var url = "/"+admin.memu + "/update.do";
	$.ajax({
		url : url,
		type : "POST",
		cache : false,
		data : $("form").serialize(),
		success : function() {
			index();
			//$("#mycontainer").empty().load(admin.memu + "/index.html");
		}
	});
}

function del() {
	var url = "/"+admin.memu + "/del.do";
	console.log(url);
	var data = "";
	$("tbody tr th input:checkbox:checked").each(function() {
		data = data + "&id=" + $(this).val();
	});
	if (data.length > 0) {
		confirm("确定要删除吗？")
		$.ajax({
			url : url,
			type : "POST",
			data : data.substring(1),
			cache : false,
			success : function(html) {
				$("#mycontainer").empty().load("/view/"+admin.memu + "/index.html");
			}
		});
	} else {
		alert("请选择记录");
	}

}

/**
 * http 请求模板添加参数html
 */
function addParam(){
	$(	 '<div class="row">'
					+'	<div class="col-md-6">'
					+'		<div class="input-group">'
					+'		  <span class="input-group-addon" id="basic-addon1">参数：</span>'
					+'		  <input type="text" name="name" class="form-control" id="url" name="url" placeholder="" required>'
					+'		</div>'
					+'	</div>'
					+'	<div class="col-md-6">'
					+'		<div class="input-group">'
					+'		  <span class="input-group-addon" id="basic-addon1">值</span>'
					+'		  <input type="text" name="value" class="form-control" name="headervalue" placeholder="" required>'
					+'		  <span class="input-group-addon" onclick="delRow(this)"><span class="glyphicon glyphicon-minus"></span></span>'
					+'		</div>'
					+'	</div>'
					+'</div>').appendTo("#params");
}

/**
 * 请求模板form删除按钮 删除一行元素
 */
function delRow(self){
	$(self).parent().parent().parent().remove();
}
/**
 * http 请求模板添加请求头部html
 */
function addHeader(){
	var header = $("#headers").data('header');
	if(header){
		 var li = '';
		 var data = header; 
		 for(var i in data){  
		        li += '<li><a href="#" onclick="doDropdown(this);">'+data[i].value+'</a></li>';
   		 }  
		 $('<div class="row"><div class="col-md-6">'
					+'	<div class="input-group">'
					+'        <div class="input-group-btn">'
					+'          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">请求头<span class="caret"></span></button>'
					+'          <ul class="dropdown-menu" role="menu">'
								+li
					+'          </ul>'
					+'        </div>'
					+'        <input type="text" name="name" class="form-control" required>'
					+'      </div>'
					+'</div>'
					+'<div class="col-md-6">'
					+'	<div class="input-group">'
					+'	  <span class="input-group-addon" id="basic-addon1">值</span>'
					+'	  <input type="text" class="form-control" name="value" placeholder="" required>'
					+'	  <span class="input-group-addon" onclick="delRow(this)"><span class="glyphicon glyphicon-minus"></span></span>'
					+'	</div>'
					+'</div></div>').appendTo("#headers");
	}else{
		console.error('not bind header data to id is #headers tag element');
	}
			
}

/**
 * bootstrap 下拉框选中处理
 */
function doDropdown(self){
	$(self).parent().parent().parent().parent().children("input").first().val($(self).text());
}

function page(data){
	$("ul.pagination").empty();
	var previous = data.currentPage - 1 ;
	var next = data.currentPage + 1 ;
	$('<li><a href="javascript:showPage('+previous+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>').appendTo("ul.pagination")
	
	if(data.totalPage < 4){
		for(var i = 1; i <= data.totalPage;i++){
			if(data.currentPage == i){
				$('<li class="active"><a href="javascript:showPage('+i+');">'+i+'</a></li>').appendTo("ul.pagination");
			}else{
				$('<li><a href="javascript:showPage('+i+');">'+i+'</a></li>').appendTo("ul.pagination");
			}
		}
	}
	if(data.totalPage == 4){
		for(var i = 1; i <= data.totalPage;i++){
			if(i==3){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">......</a></li>').appendTo("ul.pagination");
				}
			}else{
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}
			}
		}
	}
	if(data.totalPage == 5){
		for(var i = 1; i <= data.totalPage;i++){
			var flag = false;
			if(i == 3){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					if(!flag){
						$('<li class="active"><a href="#">......</a></li>').appendTo("ul.pagination");
						flag = true;
					}
				}
			}else if(i == 4){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					if(!flag){
						$('<li class="active"><a href="#">......</a></li>').appendTo("ul.pagination");
						flag = true;
					}
				}
			}else{
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}
			}
		}
	}
	if(data.totalPage > 5){
		for(var i = 1; i <= data.totalPage;i++){
			if(i < 3){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}
			}else if(i == 3){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">......</a></li>').appendTo("ul.pagination");
				}
			}else if(i > 3 && i < data.totalPage - 1){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}
			}else if(i == data.totalPage - 1){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">......</a></li>').appendTo("ul.pagination");
				}
			}else if(i == data.totalPage){
				if(data.currentPage == i){
					$('<li class="active"><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}else{
					$('<li><a href="#">'+i+'</a></li>').appendTo("ul.pagination");
				}
			}
		}
	}
	$('<li><a href="javascript:showPage('+ next +');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>').appendTo("ul.pagination");
}

function showPage(currentPage){
	currentPage = currentPage?currentPage:1;
	admin.currentPage = currentPage;
	$.ajax({  
	    type: "get",  
	    url: "/"+admin.memu+"/page/"+currentPage+".do",  
	    dataType:"json",  
	    success: function(data){ 
	    	var template = $.templates("#theTmpl");
	    	var htmlOutput = template.render(data.items);
	    	$("#result").html(htmlOutput);
	    	page(data);
	    },  
	    error: function(res){  
	    }  
	});  
}

