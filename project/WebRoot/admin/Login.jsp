<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
  	var url=parent.window.location.href;
  		if(url.indexOf("Login.jsp")==-1){
  			parent.window.location.href='<%=basePath%>admin/Login.jsp';
  		}
  	
  	</script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin/login.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/check.js"></script>
	
  </head>
  
  <body style="background-size: 100% 432px;">
	  <!-- /header -->
	<header id="header">
	    <a href="#" class="logo"></a>
	    <i class="icons">beta</i>
	</header>
	<!-- 页面主体START -->
	<section id="main">
	    <h1>管理员</h1>
	    <form action="<%=basePath %>login" accept-charset="utf-8" data-view="loginView" method="post">
		<div style="display: none;">
	          	<input type="text" id="type" value="admin">	
	          </div>
	        <div class="clearfix" id="phone" data-propertyname="username" data-controltype="Phone" style="display: block;">
	            <input type="text" id="user_name" name="username" placeholder="输入用户名" data-required="required" autocomplete="off"><br>
	        </div>
	
	        <div class="clearfix" id="pwd" data-propertyname="password" data-controltype="Password" style="display: block;">
	            <input type="password" id="password" name="password" placeholder="输入密码" data-required="required" autocomplete="off"><br>
	        </div>
			<div class="code_prefix clearfix" id="codes">
                   <input type="text" class="input input_white" id="code" name="code"  placeholder="请输入验证码"/>
                   <img id="imgs" alt="验证码" src="<%=basePath%>code"><br>
            </div>
	
	
	        <div class="clearfix btn_login" data-propertyname="submit" data-controltype="Botton" style="display: block;">
	            <input type="button" value="登录" id="btnsubmit">
	        </div>
	
	
	        <input type="hidden" value="" id="isVisiable_request_form_verifyCode">
	
	    </form>
	</section>
	
	<script type="text/javascript">
		document.getElementById("imgs").addEventListener('click',function(){
			this.src='<%=basePath%>code?v='+new Date();
		});
		
		$('#btnsubmit').click(function(){
			$('#imgs')[0].src='<%=basePath%>code?v='+new Date();
			if(!login()){
				return false;//阻止登录
			}
			//如果数据没有问题则用ajax验证用户
			var phone=$.trim($('#user_name').val());
			var password=$.trim($('#password').val());
			var type=$('#type').val();
			var code = $('#code').val();
			$.ajax({
			
				url:'<%=basePath%>login',
				data:{'username':phone,'password':password,'type':type,'code':code},
				type:'POST',
				success:function(data){
					if(data=="ok"){
						window.location.href="<%=basePath%>admin/main.jsp";
					}else if(data=="codeerror"){
						alert("验证码错误");
					}else{
						alert("用户名或密码错误!");
					}
				},
				error:function(){
					alert("网络错误");
				}
			});
			
			
		});
		function login(){
			var phone=document.getElementById("user_name").value;
			var password=document.getElementById("password").value;
			if(phone.length==0){
				alert('请输入用户名');
				return false;
			}else if(password.length<6){
				alert('密码位数不能小于6位');
				return false;
			}
			return true;
		}
	
	
	</script>
	  
  </body>
</html>
