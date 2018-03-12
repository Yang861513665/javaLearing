<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <title>教师信息列显</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/jsgrid.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jsgrid/css/theme.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css">
  </head>
  
  <body style="padding:15px;">
	  	  <input type="text" name="param" id="param" placeholder="请输入您要查询的姓名" class="layui-input" style="float: left; width:180px;margin-bottom: 5px" >
		  		<button class="layui-btn" id="btnSave" style="float: right;margin-bottom: 5px">添加</button>
	<div id="jsGrid"></div>
    
    <div id="divSave" style="display: none; padding: 15px;">
	  <form class="layui-form" action="" id="form1">
		  <div class="layui-form-item">
		    <label class="layui-form-label">姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="tname" required  lay-verify="required" placeholder="请输入教师姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="text" name="tpassword" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
	  	  <div class="layui-form-item">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="tsex" value="男" title="男" checked>
			      <input type="radio" name="tsex" value="女" title="女" >
			    </div>
			 </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">电话号码</label>
		    <div class="layui-input-block">
		      <input type="text" name="ttelephone" required  lay-verify="required|phone" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
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
    
    var myUrl='<%=basePath%>admin/queryteacher?flag=save';
    //弹出层
    layui.use(['layer','element','form'], function(){
  	  layer = layui.layer;
	  form=layui.form;
	  
	//模糊查询
  	  $('#param').keyup(function(event){
  		  /*if(event.keyCode==13){   //回车键keyCode值为13
  			  filter.param=$('#param').val();
  			  $('#jsGrid').jsGrid('loadData');
  		  }*/
  		  filter.param=$('#param').val();
		  $('#jsGrid').jsGrid('loadData');
  	  });

	  
      $('#btnSave').click(function(){
      	 //加载
          loadLayer('save');
      	  return false;
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
    
    
  //弹出层的代码复用方法
	function loadLayer(flag,item){
    	
    	$('#form1')[0].reset();
    	if(flag=='save'){
    		myUrl='<%=basePath%>admin/queryteacher?flag=save';
    	}else{
    		myUrl='<%=basePath%>admin/queryteacher?flag=update';
    		
    		for(i in item){
    			$('#form1').find(':input[name="'+i+'"]').val(item[i]);//如果有多个表单先找到form在找所有的输入框并将原来的值写入里面
    		}
    		$('#usertype').val(item.usertype);
    		$('#jobtype').val(item.jobtype);
    		$('#city').val(item.city);
    		form.render('select');
    		
    		
    		
    	}
		//页面层
        layerSave=layer.open({
            type: 1,
            title:"添加教师",
            skin: 'layui-layer-rim', //加上边框
            area: ['500px', '400px'], //宽高
            content: $('#divSave'),
            end:function()
  		    {
  			    $("#jsGrid").jsGrid('render');
  		    }

        });
        //设置select的默认值 这里如果设置了默认值在修改的时候则获取不到下拉列表的值
        //$('#usertype').val('兼职');
        //form.render('select');
	}
    

    $(function(){
		jsGrid.locale("zh-cn");
			
		$('#jsGrid').jsGrid({
			height:"80%",
			width:"100%",
			paging:true,
			autoload: true,
			pageLoading:true,
			sorting:true,
			pageIndex:1,
			pageSize:10,
			deleteConfirm:"您确定要删除这条记录吗？",
			editing:true,
			controller:{ 
            	loadData:function(f){
            		
            		if(filter){
            			filter.pageSize=f.pageSize;
            			filter.pageIndex=f.pageIndex;
            			filter.sortField=f.sortField;
            			filter.sortOrder=f.sortOrder;//asc  还是desc
            			
            		}else{
            			filter=f;
            		}
            		
            		return $.ajax({
            			url:'<%=basePath%>admin/queryteacher',
            			type:'POST',
            			dataType:'JSON',
            			data:filter
            			
            		});
            	},
            	deleteItem:function(item){
                    return $.ajax({
                        type:'POST',
                        url:'<%=basePath%>admin/queryteacher?flag=delete',
                        data:{id:item.tid},
                        success:function(){
                        		alert("删除成功");
                        }

                    });
                },
                
			},
			fields:[
				
			    {name:"tname",title:"姓名",width:50,   type:'text'}, 
			    {name:"tpassword",title:"密码",width:50,   type:'text'}, 
			    {name:"tsex",title:"性别",width:50,   type:'select',items:[{key:'男',value:'男'},{key:'女',value:'女'}],valueField:'value',textField:'key'},
			    {name:"ttelephone",title:"电话号码",width:100,   type:'text'},
			    {type: "control"}
			],
			
            onItemUpdating:function(args){
            	$.ajax({
            		url:'<%=basePath%>admin/queryteacher?flag=update',
            		dataType:'json',
            		data:args.item,
            		type:'post',
            		success:function(d){
            			alert(d.msg);
            			
            		}
            	});
            }
			
		});
		
    });
    
    
    
    
    </script>
  </body>
</html>
