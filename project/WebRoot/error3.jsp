<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实训管理系统</title>
<link href="<%=basePath %>css/404.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var h = $(window).height();
		$('body').height(h);
		$('.mianBox').height(h);
		centerWindow(".tipInfo");
	});

	//2.将盒子方法放入这个方，方便法统一调用
	function centerWindow(a) {
		center(a);
		//自适应窗口
		$(window).bind('scroll resize',
				function() {
					center(a);
				});
	}

	//1.居中方法，传入需要剧中的标签
	function center(a) {
		var wWidth = $(window).width();
		var wHeight = $(window).height();
		var boxWidth = $(a).width();
		var boxHeight = $(a).height();
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		var top = scrollTop + (wHeight - boxHeight) / 2;
		var left = scrollLeft + (wWidth - boxWidth) / 2;
		$(a).css({
			"top": top,
			"left": left
		});
	}
</script>
</head>
<body>
<div class="mianBox">
	<img src="<%=basePath %>images/error_img/yun0.png" alt="" class="yun yun0" />
	<img src="<%=basePath %>images/error_img/yun1.png" alt="" class="yun yun1" />
	<img src="<%=basePath %>images/error_img/yun2.png" alt="" class="yun yun2" />
	<img src="<%=basePath %>images/error_img/bird.png" alt="" class="bird" />
	<img src="<%=basePath %>images/error_img/san.png" alt=""  class="san" />
	<div class="tipInfo">
		<div class="in">
			<div class="textThis">
				<h2>出错啦400！请重新登录</h2>
				<p><span>页面自动</span><span>等待<b id="wait">6</b>秒</span></p>
				<script type="text/javascript">                            (function() {
						/* var wait = document.getElementById('wait'), href = document.getElementById('href').href; */
						var interval = setInterval(function() {
							var time = --wait.innerHTML;
							if (time <= 0) {
								
								clearInterval(interval);
								window.history.go(-1);
								//alert("开始跳转提示");
							}
							;
						}, 1000);
					})();
				</script>
			</div>
		</div>
	</div>
</div>

</body>
</html>
