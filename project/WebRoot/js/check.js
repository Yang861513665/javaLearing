$(function(){
	
	$('#user_name').blur(function(){
        var phone=$(this).val();
        var span1;
        if(phone.length==0){
            span1=$('<span>用户名不能为空</span>');

        }
        span1.addClass("u");
        span1.css('color','red');
        span1.css('fontSize','12px');
        $('#phone').append(span1);
    });
    $('#user_name').focus(function(){
        $('.u').remove();
    });
    $('#password').blur(function(){
        var phone=$(this).val();
        var span1;
        if(phone.length==0){
            span1=$('<span>密码不能为空</span>');

        }
        span1.addClass("p");
        span1.css('color','red');
        span1.css('fontSize','12px');
        $('#pwd').append(span1);
    });
    $('#password').focus(function(){
        $('.p').remove();
    });
    $('#code').blur(function(){
        var code=$(this).val();
        var span1;
        if(code.length==0){
            span1=$('<span>验证码不能为空</span>');
        }
        span1.addClass("s");
        span1.css('color','red');
        span1.css('fontSize','12px');
        $('#codes').append(span1);
    });
    $('#code').focus(function(){
        $('.s').remove();
    });

});