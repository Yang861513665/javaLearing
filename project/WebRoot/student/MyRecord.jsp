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
  <title>我的违规记录</title>
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
    
    
   
   
    $(function() {
        jsGrid.locale("zh-cn");
        $("#jsGrid").jsGrid({
            height: "60%",
            width: "100%",
            autoload: true,
            deleteConfirm: "你没有权限删除",
            controller:{

                loadData:function(fiter){
                    return $.ajax({
                        url:'<%=basePath%>student/myrecord',
                        type:'POST',
                        dataType:'JSON',
                        data:fiter

                    });
                }
                
                
                
            },
            fields: [
               
                { name: "rtype",       title: "违规类别",   width: 100},
                { name: "rtime",        title: "时间",  width: 150},
                { name: "student.sname",  title: "违规者",     width: 100},
            ],
           
          
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
