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
  <title>我的成绩</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">

	
  </head>
  
  <body>
  
  <div style="text-align: right; padding: 10px">
  </div>
    <div id="jsGrid"></div>
  
    
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/jsgrid.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsgrid/i18n/zh-cn.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layui/layui.js"></script>
    <script>
    
	   
    
    var myUrl='<%=basePath%>admin/querystudent?flag=save';
    layui.use(['layer','element','form'], function(){
    	  layer = layui.layer;
	  	  form=layui.form;
      
       
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
    
    
    
    $(function() {
        jsGrid.locale("zh-cn");
        $("#jsGrid").jsGrid({
            height: "60%",
            width: "100%",
            autoload: true,
            deleteConfirm: "您没有删除的权限",
            controller:{

                loadData:function(fiter){
                    return $.ajax({
                        url:'<%=basePath%>student/mygroup?sid=${sessionScope.student.sid}',
                        type:'POST',
                        dataType:'JSON',
                        data:fiter

                    });
                },
                
                
            },
            fields: [
               
                { name: "sname",       title: "姓名",   width: 100 },
                { name: "sclass",      title: "班级",    width: 100 },
                { name: "sgrade",      title: "成绩",  width: 40},
                { name: "sgroup",      title: "分组",  width: 100},
                { name: "proname",     title: "项目名称",  width: 150},
                { name: "cteacher",    title: "指导老师",  width: 100},
            ],
           
           
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
