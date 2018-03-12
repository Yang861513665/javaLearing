<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <base href="<%=basePath%>">
    
    <title>我的文件</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div style="text-align: right; padding: 10px">
   		<button class="layui-btn" id="btnSave">添加</button>
   </div>
    <div id="jsGrid"></div>
  <div id="divSave" style="display: none; padding: 15px;">
  		<div class="layui-form-item">
  			<form action="<%=basePath%>filedownload" method="post">
			  	<div class="layui-inline" style="width: 100%;" >
			  	    <input id="filename" name="filename" style="display: none;">
				    <label class="layui-form-label">文件下载</label>
				    <div class="layui-input-inline" style="width: 100px;">
				     <button type="button" class="layui-btn layui-btn-primary" id="btn_filename"></button>
				    </div>
				     <button type="submit" class="layui-btn" style="float:right;" id="btn_download">下载</button>
				</div>
  			</form>
		 </div>
  
  	</div>
    
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/jsgrid.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/i18n/zh-cn.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layui/layui.js"></script>
    <script>
    
    layui.use(['layer','element','form','jquery'], function(){
		  element = layui.element;
		  var layer = layui.layer;
		  form=layui.form;
		  $=layui.jquery;
		  $('#btnSave').click(function(){
			var url='<%=basePath%>student/Myfileupload.jsp';
			parent.layer.open({
			  type: 2,
			  title: '文件上传',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['400px', '400px'],
			  content: url, //iframe的url
			  end: function () {
	                location.reload();
	            }
			}); 
			
			
		  });
    
		 
	});

   
    $(function() {
        jsGrid.locale("zh-cn");
        $("#jsGrid").jsGrid({
            height: "60%",
            width: "100%",
            autoload: true,
            deleteConfirm: "您确定要删除吗？",
            controller:{

                loadData:function(fiter){
                    return $.ajax({
                        url:'<%=basePath%>student/myfile',
                        type:'POST',
                        dataType:'JSON',
                        data:fiter

                    });
                },
            	deleteItem:function(item){
                    return $.ajax({
                        type:'POST',
                        url:'<%=basePath%>student/myfile?flag=delete',
                        data:{id:item.mid},
                        success:function(){
                        		alert("删除成功");
                        }

                    });
                },
                
                
                
            },
            fields: [
               
                { name: "student.sname",       title: "上传者",   width: 100},
                { name: "mfilename",        title: "文件名",  width: 150},
                { name: "mtime",  title: "上传时间",     width: 80},
                { name: "mcomment",  title: "备注",     width: 100},
                {name:"mfilepath",title:"操作",width:100,
                	itemTemplate:function(value,item){
                		var btn=$('<button class="layui-btn">下载</button>');
                		btn.click(function(){
                			if(item.mfilename.length>10){
                	    		
                	   			$('#btn_filename').text(item.mfilename.substring(0,10)+'...');
                	    	}else{
                	    		$('#btn_filename').text(item.mfilename);
                	    	}
                	   		$('#filename').val(item.mfilepath);
                	   	//页面层
                	        layerSave=layer.open({
                	            type: 1,
                	            title:'文件下载',
                	            skin: 'layui-layer-rim', //加上边框
                	            area: ['500px', '150px'], //宽高
                	            content: $('#divSave'),
                	            end:function()
                		  		{
                		  			 $("#jsGrid").jsGrid('render');
                		  		 }
                	        });
                		});
                		return btn;
                	
                }},
                { type: "control",editButton:false}
            ],
           
          
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
