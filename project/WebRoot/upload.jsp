<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
   <script type=text/javascript src="#"></script>  
    <title>Excel上传</title>  
  </head>  
  <body>  
   <h3>Excel Upload:</h3>
      请选择文件: <br />
      <form action = "upload" method = "post" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "批量插入" />
      </form>
  </body>  
</html>
