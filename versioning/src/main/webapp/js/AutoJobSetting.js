function autoJobStart(){

    var startTime = $("#startTime").val();
    var executeInterval = $("#executeInterval").val();
    var executeCount = "-1";
    if($("#setCount").is(":checked")){
        executeCount = $("#executeCount").val();
    }

    $.ajax({
        type : "GET",
        async:false,
        url:url + "AutoJob",
        timeout:60,
        dataType:'json',
        data:{
            "startTime":startTime,
            "executeInterval":executeInterval,
            "executeCount":executeCount,
            "flag":"start"
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $("#successMessage").css("display","block");
                $("#inputSuccess").text("自动调度启动成功");
                $("#errorMessage").css("display","none");
                $("#jobStart").attr("disabled","disabled");
                $("#jobStop").removeAttr("disabled","disabled");
            }
        },
        error:function(){
            alert("error");
        }
    });
}
function autoJobStop(){
    $.ajax({
        type : "GET",
        async:false,
        url:url + "AutoJob",
        timeout:60,
        dataType:'json',
        data:{
            "flag":"stop"
        },
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                $("#successMessage").css("display","block");
                $("#inputSuccess").text("自动调度停止成功");
                $("#errorMessage").css("display","none");
                $("#jobStop").attr("disabled","disabled");
                $("#jobStart").removeAttr("disabled","disabled");
            }
        },
        error:function(){
            alert("error");
        }
    });
}
function countLimit(){
    if($("#setCount").is(":checked")){
        $("#executeCount").removeAttr("disabled");
    }
    if($("#never").is(":checked")){
        $("#executeCount").attr("disabled","disabled");
    }
}