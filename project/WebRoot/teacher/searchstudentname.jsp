<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchstudentname.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">
	<style type="text/css">
		#studentnametable{
			cursor:pointer;
		}
	
	</style>
  </head>
  
  <body>
     <!-- 添加违规者时选择学生 -->
  <div id="divstudentname" style="padding:10px">
		<input type="text" id="studentname" class="layui-input" placeholder="请输入班级或者姓名进行检索">
		<table class="layui-table" lay-skin="row" id="studentnametable">
			
		</table>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layui/layui.js"></script>
	
	<script>
			  
	
	
	
	 layui.use(['layer','element','form'], function(){
   	  layer = layui.layer;
	  	  form=layui.form;
   		//获取学生信息
   		function coursenamelist(){
   			
   			$.ajax({
   		  		dataType:'JSON',
   		  		url:"<%=basePath%>teacher/search",
   		  		type:'POST',
   		  		data:{search:$('#studentname').val()},
   		  		success:function(d){
   		  			if(d.code=="10000"){
   		  				$("#studentnametable").empty(); 
   		  	  			$.each(d.obj,function(i,item){
   		  	  				var x=document.getElementById('studentnametable').insertRow(0);  //新加一x行
   		  	      			var y=x.insertCell(0);  //获取第一列
   		  	      			//alert(item.sname);
   		  	      			y.innerHTML=item.sclass+"——"+item.sname;
   		  	      			x.onclick= function(){
   		  	      				getColumnDetail(this,item);
   		  	      			};
   		  	      			
   		  	  			});
   		  					$('#studentnametable').append("<thead><tr><th>学生信息</th></tr></thead>");
   		  				}else{
   		  	  				layer.msg("网络错误，请重新登录！");
   		  	  			}
   		  			}
   		  			
   		  		});
   		}
   		coursenamelist();
	  //查询学生的检索监听事件
	  	$('#studentname').keyup(function(){
	  		$('#studentnametable').empty();
	  		coursenamelist();
	  	});
	  
	  	 
		 function getColumnDetail(column,data){ 
			  parent.document.getElementById("recorderid").value=data.sid;
			  parent.document.getElementById("recorder").value=data.sname;
			  var index=parent.layer.getFrameIndex(window.name);
			  parent.layer.close(index);
	  	 } 
		
	 });
	
	
	</script>
	
  </body>
</html>
