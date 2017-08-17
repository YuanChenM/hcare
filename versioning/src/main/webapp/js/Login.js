$(function(){
    if(localStorage.loginFlg && localStorage.loginFlg == "1"){
        window.location = "./HomePage";
    }
    $("#loginButton").click(function(){
        var account = $("#account").val();
        var password = $("#password").val();
        localStorage.loginFlg = "0";
        $.ajax({
            type : "GET",
            async:false,
            url:url + "LoginCheck",
            timeout:60,
            dataType:'json',
            data:{
                "account":account,
                "password":password
            },
            contentType:"application/json",
            success:function(data){
                if(data.status == "F"){
                    if($("#loginFlg").is(":checked")){
                        localStorage.loginFlg = "1";
                    }
                    window.location = "./HomePage";
                }else{
                    alert("输入的账号或密码错误,请重新输入");
                    return false;
                }
            },
            error:function(){
                alert("error");
            }
        });
    });
});

