<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html>
<html id="html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
  <style>
  .layui-form-label{
  	    padding: 9px 5px;
  		
  }
  .layui-upload-img{
  
  		width:100px;
  		height:100px;
  		margin:5px 10px 10px 5px;
  		
  }
  
  
  </style>
    
	<link rel="stylesheet" href="<%=basePath%>js/layui/css/layui.css">
  </head>
  
  <body>
     <div id="divSave" style=" padding: 15px;">
     
     	<!-- 文件和图片上传时的enctype要设置为 multipart/form-data   但是如果使用layui和自动设置-->
    	<form class="layui-form" action="">
    	<div style="display: none;"><input type="text" name="aid" value="${requestScope.admin.aid }"></div>
    		<div class="layui-form-item" style="width: 330px;float:left;">
    			<div class="layui-inline">
			    	<label class="layui-form-label">用户名</label>
			   
			    <div class="layui-input-inline">
			      <input type="text" name="aname" required  lay-verify="required" placeholder="请输入用户名" value="${requestScope.admin.aname }" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		  	</div>
		  	<div class="layui-form-item" style="width: 330px;float:left;">
			  	<div class="layui-inline">
				    <label class="layui-form-label">密码</label>
				    <div class="layui-input-inline">
				      <input type="password" name="apassword" required  lay-verify="required" placeholder="请输入密码" value="${requestScope.admin.apassword }" autocomplete="off" class="layui-input">
				    </div>
				</div>
		  	</div>
		  	
		  	
		  	<div class="layui-form-item" style="width: 330px;float:left;">
			  	<div class="layui-inline">
				    <label class="layui-form-label">性别</label>
				    <div class="layui-input-inline">
				      <input type="radio" name="asex"  value="男" title="男" checked <c:if test="${requestScope.admin.asex== '男'}">checked="checked"</c:if>>
				      <input type="radio" name="asex"  value="女" title="女" <c:if test="${requestScope.admin.asex== '女'}">checked="checked"</c:if>>
				    </div>
			    </div>
			 </div>
    		<div class="layui-form-item" style="width: 330px;float:left;">
	    		<div class="layui-inline">
				    <label class="layui-form-label">手机号码</label>
				    <div class="layui-input-inline">
				      <input type="text" name="atelephone" required  lay-verify="required|phone" value="${requestScope.admin.atelephone }" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
				    </div>
			    </div>
		  	</div>
		  	<div class="layui-upload">
			  <div class="layui-upload-list">
			    <img class="layui-upload-img" id="head_img" src="<%=basePath%>adminimg/${requestScope.admin.images}">
			    <p id="txtmsg"></p>
			  </div>
			  <button type="button" class="layui-btn" id="btn_upload" style="margin-left: 10px">上传头像</button>
			  <input type="text" name="images" id="images" style="display: none;" value="${requestScope.admin.images}" >
			</div>  


		  	<br><br>
		  	<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formuser">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
		  	</div>
    	
    	</form>
    
    </div>
    <script src="<%=basePath %>js/layui/layui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
    <script>
    layui.use(['layer','element','form','upload'], function(item){
  	  	layer = layui.layer;
	  	form=layui.form;
	  	var $ = layui.jquery
	    ,upload = layui.upload;
	    
	    //普通图片上传
	    var uploadInst = upload.render({
	      elem: '#btn_upload'
	      ,url: '<%=basePath%>admin/imgupload'
	      ,before: function(obj){
	        //预读本地文件示例，不支持ie8
	        obj.preview(function(index, file, result){
	          $('#head_img').attr('src', result); //图片链接（base64）
	        });
	      }
	      ,done: function(res){
	        //如果上传失败
	        if(res.code=="10000"){
	        	$("#images").val(res.obj);
	          	layer.msg('上传成功');
	        }else{
	        	layer.msg(res.msg);
	        }
	        //上传成功
	      }
	      ,error: function(){
	        //演示失败状态，并实现重传
	        var demoText = $('#txtmsg');
	        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
	        demoText.find('.demo-reload').on('click', function(){
	        	uploadInst.upload();
	        });
	      }
	    });
	  	
	  	//表单提交
	  	form.on('submit(formuser)', function(data){
			  $.ajax({
				  url:'<%=basePath%>admin/update',
				  dataType:'JSON',
				  type:'POST',
				  data:data.field,
				  success:function(d){
					  
					  if(d.code=="10000"){
						  //layer.msg(d.msg);
						  layer.alert('修改成功',function(){
							  window.parent.location.reload();//刷新父页面
							  var index=parent.layer.getFrameIndex(window.name);
							  parent.layer.close(index);
						  });
					  }else{
						  layer.msg(d.msg);
					  }
				  },
			  });
			  
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
	  	  
    });
    
    
    </script>
  </body>
</html>
