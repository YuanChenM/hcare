/**
 * 新增环境
 */
function sysEnvAdd(){
    var sysEnvId = $("#sysEnvId").val();
    var sysEnvName = $("#sysEnvName").val();
    var sysEnvIpAddr = $("#sysEnvIpAddr").val();
    var sysEnvURL = $("#sysEnvURL").val();

    $.ajax({
        type : "GET",
        async:false,
        url:url + "AddSysEnv",
        timeout:60,
        dataType:'json',
        data:{
            "sysEnvId":sysEnvId,
            "sysEnvName":sysEnvName,
            "sysEnvIpAddr":sysEnvIpAddr,
            "sysEnvURL":sysEnvURL
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $("#sysEnvId").val("");
                $("#sysEnvName").val("");
                $("#sysEnvIpAddr").val("");
                $("#sysEnvURL").val("");
                $("#successMessage").css("display","block");
                $("#inputSuccess").text("系统运行环境新增成功");
                $("#errorMessage").css("display","none");
            }else{
                $("#successMessage").css("display","none");
                $("#errorMessage").css("display","block");
                $("#inputError").text("环境已经录入请重新输入!");
            }
        },
        error:function(){
            alert("error");
        }
    });
}