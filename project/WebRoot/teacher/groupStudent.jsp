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
  <title>学生列显</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">

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
	     <label style="float: left;margin-top: 10px;margin-left: 50px;margin-right: 10px; font-size: 15px">分组</label>
	    <div style="float: left;margin-top: 5px;">
    		<select name="paramsgroup" id="paramsgroup" style="font-size: 16px;height: 30px;"> 
    			<option value="" selected="true">选择小组查询</option>
	   			<option value="第1小组">第1小组</option>
		   		<option value="第2小组">第2小组</option>
		   		<option value="第3小组">第3小组</option>
		   		<option value="第4小组">第4小组</option>
	   		</select>
	    </div>
	    <input type="button" class="layui-btn" id="studentdata" value="数据导出">
  </div>
    <div id="jsGrid"></div>
  
    <div id="divSave" style="display: none; padding: 15px;">
  		<div class="layui-form-item">
  			<form action="<%=basePath%>exceldownload" method="post">
			  	<div class="layui-inline" style="width: 100%;">
			  	    <select name="sclass" id="paramsclass" style="font-size: 16px;height: 30px;"> 
			    		<option value="" selected="true">全部导出</option>
			   			<option value="软件1班">软件1班</option>
				   		<option value="软件2班">软件2班</option>
				   		<option value="软件3班">软件3班</option>
				   		<option value="软件4班">软件4班</option>
			   		</select>
				     <button type="submit" class="layui-btn"  style="float:right;" id="btn_download">开始导出</button>
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
    var myUrl='<%=basePath%>admin/querystudent?flag=save';
    layui.use(['layer','element','form'], function(){
    	  layer = layui.layer;
	  	  form=layui.form;
      
	  	 $('#paramname').keyup(function(){
	  		 filter.paramname=$('#paramname').val();
	  		 $("#jsGrid").jsGrid('loadData');
	  		 
	  	 });
	  	$('#paramsclass').change(function(){
	  		 filter.paramsclass=$('#paramsclass').val();
	  		 $("#jsGrid").jsGrid('loadData');
	  		 
	  	 });
	  	$('#paramsgroup').change(function(){
	  		 filter.paramsgroup=$('#paramsgroup').val();
	  		 $("#jsGrid").jsGrid('loadData');
	  		 
	  	 });
        //表单提交
        
      	
        form.on('submit(formuser)', function(data){
        
            $.ajax({
                url:myUrl,
                dataType:'JSON',
                type:'POST',
                data:data.field,
                success:function(d){

                    if(d.code=="10000"){
                        layer.msg(d.msg);
                        $('#jsGrid').jsGrid("loadData");
                        layer.close(layerSave);
                    }else{
                    	alert(d.code);
                        layer.msg(d.msg);
                    }
                }
            });




            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
    });
    
    //excel数据导出页面
    $('#studentdata').click(function(){
    	
    	layerSave=layer.open({
            type: 1,
            title:'数据导出',
            skin: 'layui-layer-rim', //加上边框
            area: ['300px', '150px'], //宽高
            content: $('#divSave'),
            end:function()
	   		{
	   			 $("#jsGrid").jsGrid('render');
	   		 }
	        });
    });
      
    
    
    
    
    $(function() {
        jsGrid.locale("zh-cn");
        $("#jsGrid").jsGrid({
            height: "80%",
            width: "100%",
            paging:true,
            autoload: true,
            sorting:true,
            pageLoading:true,
            pageIndex:1,
            pageSize:10,
            deleteConfirm: "您没有删除的权限",
            editing:true,
            controller:{

                loadData:function(f){
                	
                	if(filter){
                		filter.pageSize=f.pageSize;
                		filter.pageIndex=f.pageIndex;
                		filter.sortField=f.pageField;
                		filter.sortOrder=f.sortOrder;
                	}else{
                		flter=f;
                	}
                	
                    return $.ajax({
                        url:'<%=basePath%>admin/querystudent',
                        type:'POST',
                        dataType:'JSON',
                        data:filter

                    });
                },
                
                
            },
            fields: [
               
                { name: "sname",       title: "姓名",   width: 100 },
                { name: "ssex",        title: "性别",  width: 100 },
                { name: "stelephone",  title: "电话号码",     width: 150},
                { name: "sgrade",      title: "成绩",  width: 40},
                { name: "sclass",      title: "班级",    width: 100 },
                { name: "sgroup",      title: "分组",  width: 100,type:'select',items:[
                                                                                     
                                                                                     {key:'第1小组',value:'第1小组'},
                                                                                     {key:'第2小组',value:'第2小组'},
                                                                                     {key:'第3小组',value:'第3小组'},
                                                                                     {key:'第4小组',value:'第4小组'},],
                                                                                     valueField:'value',textField:'key'
                                                                                     },
                { name: "proname",     title: "项目名称",  width: 150},
                { name: "cteacher",    title: "指导老师",  width: 100},
                { type: "control" }
            ],
           
            onItemUpdating:function(args){
            	$.ajax({
            		url:'<%=basePath%>admin/querystudent?flag=update',
            		dataType:'json',
            		data:args.item,
            		type:'post',
            		success:function(d){
            			if(d.code=='10000'){
            				alert(d.msg);
            			}else{
            				alert(d.msg);
            			}
            		}
            	});
            }
           
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
