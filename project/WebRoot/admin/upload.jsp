<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
   <link rel="stylesheet" href="<%=basePath%>js/layui/css/layui.css">
    <title>Excel上传</title>  
  </head>  
  <body>  
   <div class="layui-upload">
	  <button type="button" class="layui-btn layui-btn-normal" id="testList" style="margin: 12px;">选择多文件</button> 
	  <a href="<%=basePath%>template/template.xls"><input type="button" value="模板下载" class="layui-btn" style="float: right;margin: 12px;"></a>
	  <div class="layui-upload-list">
	    <table class="layui-table">
	      <thead>
	        <tr><th>文件名</th>
	        <th>大小</th>
	        <th>状态</th>
	        <th>操作</th>
	      </tr></thead>
	      <tbody id="demoList"></tbody>
	    </table>
	  </div>
	  <button type="button" class="layui-btn" id="testListAction" style="margin: 8px;">开始插入</button>
  </div> 
  </body>  
  <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
  <script src="<%=basePath %>js/layui/layui.js"></script>
  <script>
  
  
  layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
  
		  var demoListView = $('#demoList')
		  ,uploadListIns = upload.render({
		    elem: '#testList'
		    ,url: '<%=basePath%>admin/uploadexcel'
		    ,accept: 'file'
		    ,multiple: true
		    ,auto: false
		    ,bindAction: '#testListAction'
		    ,before:function(){
		    	fengindex = layer.load(0,{shade: false}); //0代表加载的风格，支持0-2
		    }
		    ,choose: function(obj){   
		      files = obj.pushFile(); //将每次选择的文件追加到文件队列
		      //读取本地文件
		      obj.preview(function(index, file, result){
		        var tr = $(['<tr id="upload-'+ index +'">'
		          ,'<td>'+ file.name +'</td>'
		          ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
		          ,'<td>等待上传</td>'
		          ,'<td>'
		            ,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
		            ,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
		          ,'</td>'
		        ,'</tr>'].join(''));
		        
		        //单个重传
		        tr.find('.demo-reload').on('click', function(){
		          obj.upload(index, file);
		        });
		        
		        //删除
		        tr.find('.demo-delete').on('click', function(){
		          delete files[index]; //删除对应的文件
		          tr.remove();
		        });
		        
		        demoListView.append(tr);
		      });
		    }
		    ,done: function(res, index, upload){
		      if(res.code == "10000"){ //上传成功
		    	layer.close(fengindex);
		    	layer.msg(res.msg+res.obj+"条数据");
		        var tr = demoListView.find('tr#upload-'+ index)
		        ,tds = tr.children();
		        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
		        tds.eq(3).html(''); //清空操作
		        delete files[index]; //删除文件队列已经上传成功的文件
		        setInterval(function(){
		        	var index =parent.layer.getFrameIndex(window.name);
		        	parent.layer.close(index);
		        }, 2500);
		        return;
		      }
		      this.error(index, upload);
		    }
		    ,error: function(index, upload){
		      var tr = demoListView.find('tr#upload-'+ index)
		      ,tds = tr.children();
		      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
		      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
		    }
		  });
  });
  
  
  </script>
</html>
