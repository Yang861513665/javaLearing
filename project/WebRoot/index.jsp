<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>实训管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/user/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
  	var url = parent.window.location.href;
  	if(url.indexOf("index.jsp")==-1){
  		parent.window.location.href="<%=basePath%>index.jsp";
  	}
  </script>
  </head>
  
  <body>
   <header class="sso_header">
    <span class="logo">实训管理系统</span>
</header>
<div class="content_box cleafix">
    <div class="left">
        <div class="form_head">
            <ul class="form_head clearfix">
                <li class="active" id="a">学生登录</li>
                <li id="b" class="">老师登录</li>
            </ul>
            <span class="tab_active"></span>
        </div>
        <div class="form_body" id="c">
            <form action="" class="active" id="form1">
            	<div style="display: none;">
	          		<input type="text" id="type1" value="学生登录">	
	          	</div>
                <div class="input_item clearfix">
                    <input type="text" class="input input_white" id="username1" name="username"  placeholder="请输入您的用户名"/>
                </div>
                <div class="input_item clearfix">
                    <input type="password" class="input input_white" id="password1" name="password"  placeholder="请输入密码"/>
                </div>
                <div class="code_prefix clearfix">
                    <input type="text" class="input input_white" id="code1" name="code"  placeholder="请输入验证码"/>
                    <img id="imgs" alt="验证码" src="<%=basePath%>code">
                </div>
 
                <div class="input_item btn_group clearfix">
                    <input type="button" id="btn1" class="btn btn_green btn_active btn_block btn_lg" value="登&nbsp;&nbsp;录"/>

                </div>


            </form>

        </div>
        <div class="form_body" id="d" style="display: none">
          <form action="" class="active" id="form2">
	          <div style="display: none;">
	          	<input type="text" id="type2" value="老师登录">	
	          </div>
          	
                <div class="input_item clearfix">
                    <input type="text" class="input input_white" id="username2" name="username"  placeholder="请输入您的用户名"/>
                </div>
                <div class="input_item clearfix">
                    <input type="password" class="input input_white" id="password2" name="password"  placeholder="请输入密码"/>
                </div>
				<div class="code_prefix clearfix">
                    <input type="text" class="input input_white" id="code2" name="code"  placeholder="请输入验证码"/>
                    <img id="imgss" alt="验证码" src="<%=basePath%>code"><br>
                </div>

                <div class="input_item btn_group clearfix">
                    <input type="button" id="btn2" class="btn btn_green btn_active btn_block btn_lg" value="登&nbsp;&nbsp;录"/>

                </div>


            </form>

        </div>

    </div>
    <div class="divider">

    </div>
    <div class="right">
        <h5>还没有帐号:</h5>
        <a href="#" class="register_now">立即注册</a>
        <h5>使用以下帐号直接登录:</h5>
        <ul class="vender_login clearfix">
            <li>
                <a href="#" title="使用新浪微博帐号登录" class="vender_icon icon_sina"></a>
            </li>
            <li>
                <a href="#" class="vender_icon icon_wechat" title="使用微信帐号登录"></a>
            </li>
            <li>
                <a href="#" title="使用腾讯QQ帐号登录" class="vender_icon icon_tencent"></a>
            </li>
            <li>
                <a href="#" title="使用百度帐号登录" class="vender_icon icon_baidu"></a>
            </li>
        </ul>
    </div>


</div>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	document.getElementById("imgs").addEventListener('click',function(){
		this.src='<%=basePath%>code?v='+new Date();
	});
	document.getElementById("imgss").addEventListener('click',function(){
		this.src='<%=basePath%>code?v='+new Date();
	});

    $('#a').click(function(){
        $(this).addClass('active');
        $(this).css('color','#00b38a');
        $('#b').css('color','#000');
        $('#a').removeClass('active');
        $('.tab_active').animate({left:0},500);
        $('#d').fadeOut(2);
        $('#c').fadeIn(2);

    });
    $('#b').click(function(){
        $(this).addClass('active');
        $(this).css('color','#00b38a');
        $('#a').css('color','#000');
        $('.active').removeClass('active');
        $('.tab_active').animate({left:140},500);
        $('#c').fadeOut(2);
        $('#d').fadeIn(2);

    });
    
    $('#btn1').click(function(){
    	$('#imgs')[0].src='<%=basePath%>code?v='+new Date();
    	if(!login1()){
    		return false;//阻止登录
    	}
    	var type = $('#type1').val();
    	var username=$('#username1').val();
		var password=$('#password1').val();
		var code = $('#code1').val();
		$.ajax({
			url:'<%=basePath%>login',
			data:{'type':type,'username':username,'password':password,'code':code},
			type:'POST',
			success:function(data){
				
				if(data=="ok"){
					window.location.href="<%=basePath%>student/main.jsp";
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
    $('#btn2').click(function(){
    	$('#imgss')[0].src='<%=basePath%>code?v='+new Date();
    	if(!login2()){
    		return false;//阻止登录
    	}
    	var type = $('#type2').val();
    	var username=$('#username2').val();
		var password=$('#password2').val();
		var code = $('#code2').val();
		$.ajax({
			url:'<%=basePath%>login',
			data:{'type':type,'username':username,'password':password,'code':code},
			type:'POST',
			success:function(data){
				
				if(data=="ok"){
					window.location.href="<%=basePath%>teacher/main.jsp";
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
    
    
    function login1(){
		var username=$('#username1').val();
		var password=$('#password1').val();
		var code = $('#code1').val();
		var p=password.length;
		if(username.length==0){
			alert('用户名不能为空');
			return false;
		}else if(p==0){
			alert('密码不能为空');
			return false;
		}else if(p<6){
			alert('密码位数不能小于6位');
			return false;
		}else if(code.length==0){
			alert('验证码不能为空');
			return false;
		}else if(code.length!=4){
			alert('验证码位数错误');
			return false;
		}
		return true;
	}
    function login2(){
		var username=$('#username2').val();
		var password=$('#password2').val();
		var code = $('#code2').val();
		
		if(username.length==0){
			alert('用户名不能为空');
			return false;
		}else if(password.length==0){
			alert('密码不能为空');
			return false;
		}else if(password.length<6){
			alert('密码位数不能小于6位');
			return false;
		}else if(code.length==0){
			alert('验证码不能为空');
			return false;
		}else if(code.length!=4){
			alert('验证码位数错误');
			return false;
		}
		return true;
	}
    
    

});



</script>
  </body>
</html>
