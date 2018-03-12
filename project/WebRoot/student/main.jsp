<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>学生操作界面</title>
  <style type="text/css">
  
  	iframe{
  	
  		outline:none;
  		border: 0px;
  	}
  	.layui-tab-item{
  		height:100%;
  	}
  </style>
  
  <link rel="stylesheet" href="<%=basePath%>js/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">欢迎${student.sname }登录</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <div class="layui-logo" style="margin-left: 160px; width: 300px" id="jnkc"></div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="<%=basePath %>images/default.jpg" class="layui-nav-img">
          信息
        </a>
        <dl class="layui-nav-child">
          <dd><a id="btnSave">基本资料</a></dd>
          
        </dl>
      </li>
      <li class="layui-nav-item"><a href="<%=basePath %>index.jsp">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">我的</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:addTab('我的成绩/分组情况','<%=basePath%>student/MyGroup.jsp');">我的成绩/分组情况</a></dd>
            <dd><a href="javascript:addTab('我的违规记录','<%=basePath%>student/MyRecord.jsp');">我的违规记录</a></dd>
            
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">文件管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:addTab('我的文件','<%=basePath%>student/MyFile.jsp');">我的文件</a></dd>
          </dl>
        </li>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body" style="padding:8px">
    <!-- 内容主体区域 -->
    
    <div class="layui-tab" id="mytab" lay-filter="mytab" lay-allowClose="true" style="height: 100%">
		  <ul class="layui-tab-title">
		   
		  </ul>
		  <div class="layui-tab-content" style="height: 100%">
		  
		  </div>
	</div>
      
    
    
    <div style="padding: 15px;" id="start"></div>
    <div id="jsGrid" style="display: none; padding: 25px; margin-right: 20px"></div>
   
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
   	 马鞍山师专软件技术2班
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath %>js/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jsgrid/jsgrid.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jsgrid/i18n/zh-cn.js"></script>
<script>
//JavaScript代码区域


setInterval("jnkc.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);


	var sid='${sessionScope.student.sid}';
	layui.use(['layer','element','form','jquery'], function(){
		  element = layui.element;
		  var layer = layui.layer;
		  form=layui.form;
		  $=layui.jquery;
		  $('#btnSave').click(function(){
			var url='<%=basePath%>student/update?id='+sid;
			layer.open({
			  type: 2,
			  title: '我的信息修改',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['400px', '440px'],
			  content: url //iframe的url
			}); 
			
			
		  });
		  
		  
		form.on('submit(formuser)', function(data){
		  $.ajax({
			  url:'<%=basePath%>student/myupdate?flag=update',
			  dataType:'JSON',
			  type:'POST',
			  data:data.field,
			  success:function(d){
				  
				  if(d.code=="10000"){
					  layer.msg(d.msg);
					  $('#jsGrid').jsGrid("loadData");
					  layer.close(layerSave);
				  }else{
					  layer.mag(d.msg);
				  }
			  },
		  });
		  
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	});


	function addTab(t,url){
		
		var index = layer.load(0,{time: 1*500}, {shade: false}); //0代表加载的风格，支持0-2
		
		$('#jsGrid').jsGrid("loadData");
		var layid=$('#mytab').find('li[lay-id="'+t+'"]');
		if(layid&&layid.length>0){
			element.tabChange('mytab',t);
			
			
		}else{
			
			var iframe='<iframe src="'+url+'" width="100%" height="100%"></iframe>';
			element.tabAdd('mytab', {
				  title: t
				  ,content: iframe //支持传入html
				  ,id: t
				});  
			element.tabChange('mytab',t);
		}
		
	}
  	  
	
	
	


</script>

</body>
</html>