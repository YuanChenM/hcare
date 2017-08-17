$(function(){
    $.ajax({
        type : "GET",
        async:false,
        url: url + "findSysEnv",
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $.each(data.result,function(i,item){
                   var str = "<option value='"+item.sysEnvId+"'>"+item.sysEnvName+"</option>";
                    $("#sysEnvId").append(str);
                });
            }
        },
        error:function(){
            alert("error");
        }
    });
});

/**
 * 新增环境
 */
function moduleAdd(){
    var moduleId = $("#moduleId").val();
    var sysEnvId = $("#sysEnvId option:selected").val();
    var sysEnvName = $("#sysEnvId option:selected").text();
    var moduleName = $("#moduleName").val();
    var moduleShort = $("#moduleShort").val();
    var interfaceId = $("#interfaceId").val();
    var interfaceURL = $("#interfaceURL").val();

    $.ajax({
        type : "GET",
        async:false,
        url:url + "AddModule",
        timeout:60,
        dataType:'json',
        data:{
            "moduleId":moduleId,
            "sysEnvId":sysEnvId,
            "sysEnvName":sysEnvName,
            "moduleName":moduleName,
            "moduleShort":moduleShort,
            "interfaceId":interfaceId,
            "interfaceURL":interfaceURL
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $("#successMessage").css("display","block");
                $("#inputSuccess").text("模块新增成功");
                $("#errorMessage").css("display","none");
            }else{
                $("#successMessage").css("display","none");
                $("#errorMessage").css("display","block");
                $("#inputError").text("模块已经录入请重新输入!");
            }
        },
        error:function(){
            alert("error");
        }
    });
}