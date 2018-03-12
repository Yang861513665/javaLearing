<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date();
String dates = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <base href="<%=basePath%>">
    
    <title>我的文件上传</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="divSave" style=" padding: 15px;">
     
     	<!-- 文件和图片上传时的enctype要设置为 multipart/form-data   但是如果使用layui和自动设置-->
    	<form class="layui-form" action="">
    		<div class="layui-form-item">
    			<div class="layui-inline">
			    	<label class="layui-form-label">上传者</label>
			   
			    <div class="layui-input-inline">
			      <input type="text" disabled="disabled" id="muploadname" required  lay-verify="required" placeholder="请输入用户名" value="${sessionScope.student.sname }" autocomplete="off" class="layui-input">
			      <input type="text" style="display: none;" name="muploadnameid" required value="${sessionScope.student.sid }">
			    </div>
			  </div>
		  	</div>
		  	<div class="layui-form-item">
			  	<div class="layui-inline">
				    <label class="layui-form-label">班级</label>
				    <div class="layui-input-inline">
				      <input type="text" disabled="disabled" name="mclass" required  lay-verify="required" placeholder="" value="${sessionScope.student.sclass }" autocomplete="off" class="layui-input">
				    </div>
				</div>
		  	</div>
		  	<div class="layui-form-item">
			  	<div class="layui-inline">
				    <label class="layui-form-label">上传文件</label>
				    <div class="layui-input-inline">
				     <button type="button" class="layui-btn layui-btn-primary" id="test4"><i class="layui-icon"></i>只允许压缩文件</button>
				    </div>
				</div>
		  	</div>
		  	<div class="layui-form-item">
			  	<div class="layui-inline">
				    <label class="layui-form-label">备注</label>
				    <div class="layui-input-inline">
				      <input type="text" name="mcomment" required placeholder="请输入备注" autocomplete="off" class="layui-input">
				    </div>
				</div>
		  	</div>
		  

			<div style="display: none;"><input type="text" name="mtime" value="<%=dates%>"></div>
			<div style="display: none;"><input type="text" name="mfilepath" required  lay-verify="required" id="mfilepath"></div>
			<div style="display: none;"><input type="text" name="mfilename" id="mfilename"></div>
		  	<br><br>
		  	<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formuser">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
		  	</div>
    	
    	</form>
    		
    </div>
  </body>
  <script type="text/javascript" src="<%=basePath%>js/layui/layui.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
  <script>
  
  $('#muploadname').keydown(function(evt){
	  alert(1);
	  if(evt.keyCode==8){
		  alert(1);
		  return false;
	  }
  });
  
  
  layui.use(['layer','element','form','jquery','upload'], function(){
	  element = layui.element;
	  var layer = layui.layer;
	  form=layui.form;
	  $=layui.jquery;
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  upload.render({ //允许上传的文件后缀
		    elem: '#test4'
		    ,url: '<%=basePath%>student/myfileupload'
		    ,accept: 'file' //普通文件
		    ,exts: 'zip|rar|7z' //只允许上传压缩文件
		    ,before:function(){
		    	indexyas = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		    }
		    ,done: function(res){
		      if(res.code=="10000"){
		    	  layer.close(indexyas);
		    	  $('#mfilepath').val(res.obj);
		    	  $('#mfilename').val(res.msg);
		    	  $('#test4').text(res.msg);
		    	  layer.msg("上传成功");
		      }else{
		    	  layer.msg("网络异常");
		      }
		    }
		  });
	  
		form.on('submit(formuser)', function(data){
			if(data.field.mcomment==""){
				data.field.mcomment="暂无";
			}
		  $.ajax({
			  url:'<%=basePath%>student/myfile?flag=save',
			  dataType:'JSON',
			  type:'POST',
			  data:data.field,
			  success:function(d){
				  
				  if(d.code=="10000"){
					  layer.alert('添加成功',function(){
						  var index=parent.layer.getFrameIndex(window.name);

						  parent.layer.close(index);
					  });
				  }else{
					  layer.mag(d.msg);
				  }
			  },
		  });
		  
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
});
  
  
  
  
  </script>
</html>
