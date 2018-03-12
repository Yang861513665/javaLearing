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
  
  
  </style>
    
	<link rel="stylesheet" href="<%=basePath%>js/layui/css/layui.css">
  </head>
  
  <body>
     <div id="divSave" style=" padding: 15px;">
    	<form class="layui-form" action="">
    	<div style="display: none;"><input type="text" name="tid" value="${teacher.tid }"></div>
    		<div class="layui-form-item">
			    <label class="layui-form-label">用户名</label>
			    <div class="layui-input-block">
			      <input type="text" name="tname" required  lay-verify="required" placeholder="请输入用户名" value="${teacher.tname }" autocomplete="off" class="layui-input">
			    </div>
		  	</div>
		  	<div class="layui-form-item">
			    <label class="layui-form-label">密码</label>
			    <div class="layui-input-block">
			      <input type="password" name="tpassword" required  lay-verify="required" placeholder="请输入密码" value="${teacher.tpassword }" autocomplete="off" class="layui-input">
			    </div>
		  	</div>
		  	
		  	
		  	<div class="layui-form-item">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="tsex"  value="男" title="男" checked <c:if test="${teacher.tsex== '男'}">checked="checked"</c:if>>
			      <input type="radio" name="tsex"  value="女" title="女" <c:if test="${teacher.tsex== '女'}">checked="checked"</c:if>>
			    </div>
			 </div>
    		<div class="layui-form-item">
			    <label class="layui-form-label">手机号码</label>
			    <div class="layui-input-block">
			      <input type="text" name="ttelephone" required  lay-verify="required|phone" value="${teacher.ttelephone }" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
			    </div>
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
    layui.use(['layer','element','form'], function(item){
  	  	layer = layui.layer;
	  	form=layui.form;
	  	
	  	
	  	//表单提交
	  	form.on('submit(formuser)', function(data){
			  $.ajax({
				  url:'<%=basePath%>teacher/update',
				  dataType:'JSON',
				  type:'POST',
				  data:data.field,
				  success:function(d){
					  
					  if(d.code=="10000"){
						  //layer.msg(d.msg);
						  layer.alert('修改成功',function(){
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
  </body>
</html>
