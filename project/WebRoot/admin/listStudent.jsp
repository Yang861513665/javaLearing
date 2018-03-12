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
	
  		<button class="layui-btn" id="btnSave1">批量增加</button>
  		<button class="layui-btn" id="btnSave">添加</button>
  </div>
    <div id="jsGrid"></div>
   
    <div id="divSave" style="display: none; padding: 15px;">
	  <form class="layui-form" action="" id="form1">
	  <div style="display: none;"><input type="text" name="sid"></div>
	  	
	  	
		  <div class="layui-form-item">
		    <label class="layui-form-label">姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="sname" required  lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="text" name="spassword" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		
		  
		  
	  	  <div class="layui-form-item">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="ssex" id="m" value="男" title="男" checked>
			      <input type="radio" name="ssex" id="g" value="女" title="女" >
			     
			    </div>
			</div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">电话号码</label>
		    <div class="layui-input-block">
		      <input type="text" name="stelephone" required  lay-verify="required|phone" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">班级</label>
		    <div class="layui-input-block">
		    	<select name="sclass" id="sclass"> 
		   			<option value="软件1班">软件1班</option>
			   		<option value="软件2班">软件2班</option>
			   		<option value="软件3班">软件3班</option>
			   		<option value="软件4班">软件4班</option>
		   		</select>
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">分组</label>
		    <div class="layui-input-block">
		    	<select name="sgroup" id="sgroup"> 
		   			<option value="第1小组">第1小组</option>
			   		<option value="第2小组">第2小组</option>
			   		<option value="第3小组">第3小组</option>
			   		<option value="第4小组">第4小组</option>
		   		</select>
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">项目名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="proname" required  lay-verify="required" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">指导老师</label>
		    <div class="layui-input-block">
		      <input type="text" name="cteacher" required  lay-verify="required" placeholder="请输入指导老师名称" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		<br><br>
		  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formuser">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
	  	</div>
	  
	  
	  </form>
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
	  	
        $('#btnSave').click(function(){
        	 //加载
        	
            loadLayer('save');
        	return false;
        });
        $('#btnSave1').click(function(){
        	  
        	var url='<%=basePath%>admin/upload.jsp';
			layer.open({
			  type: 2,
			  title: '数据批量插入',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['500px', '60%'],
			  content: url, //iframe的url
			  end: function () {
	                location.reload();
	                $("#jsGrid").jsGrid('render');
	            }
			}); 
			return false;
       	 });
       
     
        //表单提交
        
      	
        form.on('submit(formuser)', function(data){
        
        	if(document.getElementById("m").checked) {
        		data.field.ssex='男';
        	}else{
        		data.field.ssex='女';
        	}
        	
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
        //文件上传提交
      
    });
    
    
    
    //弹出层的代码复用方法
	function loadLayer(flag,item){
    	
    	$('#form1')[0].reset();
    	if(flag=='save'){
    		myUrl='<%=basePath%>admin/querystudent?flag=save';
    	}else{
    		myUrl='<%=basePath%>admin/querystudent?flag=update';
    		
    		for(i in item){
    			$('#form1').find(':input[name="'+i+'"]').val(item[i]);//如果有多个表单先找到form在找所有的输入框并将原来的值写入里面
    		}
    		$('#sclass').val(item.sclass);
    		$('#sgroup').val(item.sgroup);
    		if(item.ssex=='男'){
    			$('#m').attr('checked',true);
    			$('#g').attr('checked',false);
    		}else{
    			$('#g').attr('checked',true);
    			$('#m').attr('checked',false);
    		}
    		
    		form.render();
    		//form.render('select');
    		
    		
    		
    	}
		//页面层
        layerSave=layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['500px', '440px'], //宽高
            content: $('#divSave'),
            end:function()
  		   {
  			  $("#jsGrid").jsGrid('render');
  		   }

        });
        
	}
    
    
    
    
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
            pageSize:10,
            editing:true,
            deleteConfirm: "您确定要删除这条记录吗？",
            controller:{

                loadData:function(f){
                	
                	if(filter){
                		filter.pageSize=f.pageSize;
                		filter.pageIndex=f.pageIndex;
                		filter.sortField=f.sortField;
                		filter.sortOrder=f.sortOrder;
                	}else{
                		filter=f;
                	}
                	
                    return $.ajax({
                        url:'<%=basePath%>admin/querystudent',
                        type:'POST',
                        dataType:'JSON',
                        data:filter

                    });
                },
                deleteItem:function(item){
                    return $.ajax({
                        type:'POST',
                        url:'<%=basePath%>admin/querystudent?flag=delete',
                        data:{id:item.sid},
                        success:function(){
                        		layer.msg("删除成功");
                        }

                    });
                }
                
            },
            fields: [
               
                { name: "sname",       title: "姓名",   width: 100 },
                { name: "spassword",   title: "密码",     width: 100 },
                { name: "ssex",        title: "性别",  width: 100 },
                { name: "stelephone",  title: "电话号码",     width: 150},
                { name: "sgrade",      title: "成绩",  width: 40},
                { name: "sclass",      title: "班级",    width: 100 },
                { name: "sgroup",      title: "分组",  width: 100},
                { name: "proname",     title: "项目名称",  width: 150},
                { name: "cteacher",    title: "指导老师",  width: 100},
                { type: "control" }
            ],
            onItemEditing:function(args){
            	
            	loadLayer('update',args.item);
            },
            onItemUpdating:function(args){
            	$.ajax({
            		url:'<%=basePath%>admin/querystudent?flag=update',
            		dataType:'json',
            		data:args.item,
            		type:'post',
            		success:function(d){
            			alert('修改成功');
            		}
            	});
            }
           
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
