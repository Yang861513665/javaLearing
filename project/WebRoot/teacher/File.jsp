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
   		<input type="text" name="paramname" id="paramname" placeholder="请输入您要查询的姓名" class="layui-input" style="float: left; width:180px;margin-bottom: 5px" >
  		
	    <label style="float: left;margin-top: 10px;margin-left: 50px;margin-right: 10px; font-size: 15px">班级</label>
	    <div style="float: left;margin-top: 5px;">
	    	<select name="sclass" id="paramsclass" style="font-size: 16px;height: 30px;"> 
	    		<option value="" selected="true">选择班级查询</option>
	   			<option value="软件1班">软件1班</option>
		   		<option value="软件2班">软件2班</option>
		   		<option value="软件3班">软件3班</option>
		   		<option value="软件4班">软件4班</option>
	   		</select>
	    </div>
   </div>
    <div id="jsGrid"></div>
  	<div id="divSave" style="display: none; padding: 15px;">
  		<div class="layui-form-item">
  			<form action="<%=basePath%>filedownload" method="post">
			  	<div class="layui-inline" style="width: 100%;">
			  	    <input id="filename" name="filename" style="display: none;">
				    <label class="layui-form-label">文件下载</label>
				    <div class="layui-input-inline">
				     <button type="button" class="layui-btn layui-btn-primary" id="btn_filename"></button>
				    </div>
				     <button type="submit" class="layui-btn"  style="float:right;" id="btn_download">下载</button>
				</div>
  			</form>
		 </div>
  
  	</div>
    
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/jsgrid.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/i18n/zh-cn.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layui/layui.js"></script>
    <script>
    var filter={};
    layui.use(['layer','element','form','jquery'], function(){
		  element = layui.element;
		  form=layui.form;
		  $=layui.jquery;
		  $('#paramname').keyup(function(){
		  		 filter.paramname=$('#paramname').val();
		  		 $("#jsGrid").jsGrid('loadData');
		  		 
		  	 });
		  	$('#paramsclass').change(function(){
		  		 filter.paramsclass=$('#paramsclass').val();
		  		 $("#jsGrid").jsGrid('loadData');
		  		 
		  	 });
		 
    
		 
	});

   
    $(function() {
        jsGrid.locale("zh-cn");
        $("#jsGrid").jsGrid({
            height: "80%",
            width: "100%",
            paging:true,
            autoload: true,
            pageLoading:true,
            sorting:true,
            pageIndex:1,
            pageSize:8,
            editing:true,
            deleteConfirm: "您没有删除的权限？",
            controller:{

                loadData:function(f){
                	
                	if(filter){
                		filter.pageIndex=f.pageIndex;
                		filter.pageSize=f.pageSize;
                		filter.sortField=f.sortField;
                		filter.sortOrder=f.sortOrder;
                	}else{
                		filter=f;
                	}
                	
                	
                    return $.ajax({
                        url:'<%=basePath%>teacher/filelist',
                        type:'POST',
                        dataType:'JSON',
                        data:filter

                    });
                },
            	
                
                
            },
            fields: [
               
                { name: "student.sname",       title: "上传者",   width: 100},
                { name: "mfilename",        title: "文件名",  width: 150},
                { name: "mtime",  title: "上传时间",     width: 100},
                { name: "mcomment",  title: "备注",     width: 100},
                { type: "control",editButton:false }
            ],
            onItemEditing:function(args){
            	
            	loadLayer('update',args.item);
            }
           
          
            
        });

    });
    
  //弹出层的代码复用方法
	function loadLayer(flag,item){
    
		if(item.mfilename.length>10){
   			$('#btn_filename').text(item.mfilename.substring(0,10)+'...');
    	}else{
    		$('#btn_filename').text(item.mfilename);
    	}
   		$('#filename').val(item.mfilepath);
   		//$('#path').attr('href',"<%=basePath%>excel/"+item.mfilename);
   		
    		
    
		//页面层
        layerSave=layer.open({
            type: 1,
            title:'文件下载',
            skin: 'layui-layer-rim', //加上边框
            area: ['400px', '150px'], //宽高
            content: $('#divSave'),
            end:function()
	  		{
	  			 $("#jsGrid").jsGrid('render');
	  		 }
        });
        
	}
  
    
    
    
    
    </script>
  </body>
</html>
