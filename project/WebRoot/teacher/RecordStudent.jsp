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
  <title>违规汇总</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">

  </head>
  
  <body>
   <div style="text-align: right; padding: 10px">
   		<input type="text" name="paramname" id="paramname" placeholder="请输入您要查询的姓名" class="layui-input" style="float: left; width:180px;margin-bottom: 5px" >
  		
	    <label style="float: left;margin-top: 10px;margin-left: 50px;margin-right: 10px; font-size: 15px">违规类别</label>
	    <div style="float: left;margin-top: 5px;">
	    		
   			<select name="paramrtype" id="paramrtype" style="font-size: 16px;height: 30px;"> 
   				<option value="" selected="true">选择查询类别</option>
	   			<option value="迟到">迟到</option>
		   		<option value="玩游戏">玩游戏</option>
		   		<option value="看视频">看视频</option>
		   		<option value="早退">早退</option>
		   		<option value="睡觉">睡觉</option>
		   		<option value="逃课">逃课</option>
		   		<option value="其他">其他</option>
	   		</select>
	    </div>
   
  		<button class="layui-btn" id="btnSave">添加</button>
  </div>
    <div id="jsGrid"></div>
   <div id="divSave" style="display: none; padding: 15px;">
	  <form class="layui-form" action="" id="form1">
	  	
		<input type="text" name="rid" style="display: none;">
		  <div class="layui-form-item">
		    <label class="layui-form-label">违规类型</label>
		    <div class="layui-input-block">
		    	<select name="rtype" id="rtype"> 
		   			<option value="迟到">迟到</option>
			   		<option value="玩游戏">玩游戏</option>
			   		<option value="看视频">看视频</option>
			   		<option value="早退">早退</option>
			   		<option value="睡觉">睡觉</option>
			   		<option value="逃课">逃课</option>
			   		<option value="其他">其他</option>
		   		</select>
		    </div>
		  </div>
	  	
	  	
		  <div class="layui-form-item">
		    <label class="layui-form-label">时间</label>
		    <div class="layui-input-block">
		      <input type="date" name="rtime" id="rtime" required lay-verify="required" placeholder="请填写违规时间" autocomplete="off" class="layui-input">
		      
		  </div>
		  <div class="layui-form-item" style="margin-top: 10px;">
		    <label class="layui-form-label">违规人</label>
		    <div class="layui-input-block">
		      <input type="text" id="recorder" style="cursor: pointer;" required  lay-verify="required" placeholder="请输入违规人姓名" autocomplete="off" class="layui-input">
		   	  <input type="text" style="display: none;" name="recorderid" id="recorderid">
		    </div>
		  </div>
		
		  
		 
		 
		   
		   <div class="layui-form-item">
		    <label class="layui-form-label">备注</label>
		    <div class="layui-input-block">
		      <input type="text" name="remarks" required   placeholder="请填写备注" autocomplete="off" class="layui-input">
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
    /*
    //用户进入添加时取当前时间
    var times = $('#rtime').val();
    if(times==""){
    	var date=new Date();
    	alert(date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate());
    	$('#rtime').val(date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate());
    	
    }*/
   
    var filter={};
    var myUrl='<%=basePath%>teacher/record?flag=save';
    layui.use(['layer','element','form'], function(){
    	  layer = layui.layer;
	  	  form=layui.form;
      
	  	  
	  	  
	  	//添加违规者时选择学生时的请求
	  	$('#recorder').click(function(){
			  layer.open({
				  type: 2,
				  title:'学生信息',
				  shadeClose:true,
				  shade:0.8,
				  area: ['250px', '400px'], //宽高
				  content: '<%=basePath%>teacher/searchstudentname.jsp',
				  end:function(){
					  
				  }
			  
		  });
	  	});
	      
	  	$('#paramname').keyup(function(){
	  		 filter.paramname=$('#paramname').val();
	  		 $("#jsGrid").jsGrid('loadData');
	  		 
	  	 });
	  	$('#paramrtype').change(function(){
	  		 filter.paramrtype=$('#paramrtype').val();
	  		 $("#jsGrid").jsGrid('loadData');
	  		 
	  	 });
	  	  
	  	 $('#btnSave').click(function(){
        	 //加载
	  		loadLayer('save');
            
			
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
    
  //添加修改公用
	function loadLayer(flag,item){
		$('#form1')[0].reset();
		if(flag=='save'){ 
    		myUrl='<%=basePath%>teacher/record?flag=save';
    	}else{
    		myUrl='<%=basePath%>teacher/record?flag=update';
    		for(var i in item){  // 取item属性   表中字段名
    			$('#form1').find(':input[name="'+i+'"]').val(item[i]);
    		}
    		$('#recorder').val(item.student.sname);
    		$('#rtype').val(item.rtype);
    		form.render();
    	}
		//页面层
        layerSave=layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['500px', '380px'], //宽高
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
            deleteConfirm: "您确定要删除吗？",
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
                        url:'<%=basePath%>teacher/record',
                        type:'POST',
                        dataType:'JSON',
                        data:filter

                    });
                },
                deleteItem:function(item){
                    return $.ajax({
                        type:'POST',
                        url:'<%=basePath%>teacher/record?flag=delete',
                        data:{id:item.rid},
                        success:function(){
                        		alert("删除成功");
                        }

                    });
                }
                
                
            },
            fields: [
               
                { name: "rtype",       title: "违规类别",   width: 100},
                { name: "rtime",        title: "时间",  width: 100},
                { name: "student.sname",  title: "违规者",     width: 80},
                { name: "student.sclass",  title: "班级",     width: 100},
                { name: "remarks",  title: "备注", width: 150,
                	itemTemplate:function(value,item){
                		if(value==""||value==undefined){
                			return "暂无";
                		}else{
                			
                			var s=value;
                			if(s.length>10){
                				s=value.substring(0,10)+"...";
                			}
                			return s;
                		}
                	}	
                
                },
                { type: "control" }
            ],
           
            onItemEditing:function(args){
            	loadLayer('update',args.item);
            }
           
            
        });

    });
    
    
    
    
    </script>
  </body>
</html>
