$(function(){
    $.ajax({
        type : "GET",
        async:false,
        url:url + "SysEnvEditVer",
        timeout:60,
        dataType:'json',
        data:{
            "id":localStorage.id
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $("#sysEnvId").val(data.result.sysEnvId);
                $("#sysEnvName").val(data.result.sysEnvName);
                $("#projectVersion").val(data.result.projectVersion);
                $("#svnVersion").val(data.result.svnVersion);
                if(data.result.isRuning == "1"){
                    $("#isYRuning").attr("checked","checked");
                }else{
                    $("#isNRuning").attr("checked","checked");
                }
                if(data.result.isSteady == "1"){
                    $("#isYSteady").attr("checked","checked");
                }else{
                    $("#isNSteady").attr("checked","checked");
                }
            }
        },
        error:function(){
            alert("error");
        }
    });
});

function saveModuleEdit(){
    var id = localStorage.moduleId;
    var isSteady = "0";
    if($("#isYSteady").is(":checked")){
        isSteady = "1";
    }
    $.ajax({
        type : "GET",
        async:false,
        url:url + "SysEnvEditVerSave",
        timeout:60,
        dataType:'json',
        data:{
            "id":localStorage.id,
            "isSteady":isSteady
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                localStorage.removeItem("moduleId");
                window.location = "./RuningVer.jsp"
            }
        },
        error:function(){
            alert("error");
        }
    });
}