var host = window.location.host;
var url = "http://" + host +"/";

function pageGo(number){
    if(number == 3){
        $("#demo").attr("src","./jsp/RuningVer.jsp");
    }
    if(number == 1){
        $("#demo").attr("src","./jsp/AddSysEnv.jsp");
    }
    if(number == 2){
        $("#demo").attr("src","./jsp/AddModule.jsp");
    }
    if(number == 4){
        $("#demo").attr("src","./jsp/AutoJobSetting.jsp");
    }
    if(number == 5){
        $("#demo").attr("src","./jsp/SysEnvVerHistory.jsp");
    }
}