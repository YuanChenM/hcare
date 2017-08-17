$(function(){
    $.ajax({
        type : "GET",
        async:false,
        url: url + "RuningVer",
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        success:function(data){
            if(data.status == "S"){
                var resultList = data.result;
                $.each(resultList,function(i,item){
                    var str = "<div class='panel panel-default'>";
                    str = str + "<div class='panel-heading'>";
                    str = str + "<h4 class='panel-title'>";
                    str = str + "<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"'>"
                    str = str + "<table class='table-condensed'>";
                    str = str + "<tr>";
                    str = str + "<td align='center' style='font-weight: bold'  width='10%'>运行环境:</td>";
                    str = str + "<td align='left' width='7%'>"+item.sysEnvName+"</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>运行工程版本:</td>";
                    str = str + "<td align='left' width='2%'>"+item.projectVersion+"</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>系统版本:</td>";
                    str = str + "<td align='left' width='5%'>"+item.svnVersion+"</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>是否稳定版:</td>";
                    if(item.isSteady == '0'){
                        str = str + "<td align='left' width='8%'>不稳定版本</td>";
                    }else if(item.isSteady == '1'){
                        str = str + "<td align='left' width='8%'>稳定版本</td>";
                    }
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>发布时间:</td>";
                    str = str + "<td align='left' width='20%'>"+item.publishTime+"</td>";
                    str = str + "<td align='right'><button type='button' onclick='sysEnvEdit("+item.id+")' class='btn btn-default btn-sm'><span class='glyphicon glyphicon-cog'></span>编辑</button></td>";
                    str = str + "</tr>";
                    str = str + "</table>";
                    str = str + "</a>";
                    str = str + "</h4>";
                    str = str + "</div>";
                    str = str + "<div id='collapse"+i+"' class='panel-collapse collapse in'>";
                    str = str + "<div class='panel-body'>";
                    if(item.moduleVersionList.length > 0){
                        str = str + "<table class='table table-bordered'>";
                        str = str + "<tr>";
                        str = str + "<td style='font-weight: bold' align='center'>模块名称</td>";
                        str = str + "<td style='font-weight: bold' align='center'>英文名称</td>";
                        str = str + "<td style='font-weight: bold' align='center'>系统版本</td>";
                        str = str + "<td style='font-weight: bold' align='center'>模块版本</td>";
                        str = str + "<td style='font-weight: bold' align='center'>是否运行中</td>";
                        str = str + "<td style='font-weight: bold' align='center'>发布时间</td>";
                        str = str + "<td style='font-weight: bold' align='center'>发布者</td>";
                        str = str + "</tr>";
                        $.each(item.moduleVersionList,function(j,item1){
                            str = str + "<tr>";
                            str = str + "<td align='center'>"+item1.moduleName+"</td>";
                            str = str + "<td align='center'>"+item1.moduleShort+"</td>";
                            str = str + "<td align='center'>"+item1.svnVersion+"</td>";
                            str = str + "<td align='center'>"+item1.svnSubVersion+"</td>";
                            if(item1.isRuning == '0'){
                                str = str + "<td align='center'>不在运行</td>";
                            }else if(item1.isRuning == '1'){
                                str = str + "<td align='center'>运行中</td>";
                            }
                            str = str + "<td align='center'>"+item1.publishTime+"</td>";
                            str = str + "<td align='center'>"+item1.publisher+"</td>";
                            str = str + "</tr>";
                        });
                        str = str + "</table>";
                    }
                    if(item.historyCount == 0){
                        str = str + "<button onclick='viewHistory("+item.sysEnvId+")' style='height: 40px;' type='button' class='btn btn-default btn-sm' disabled>";
                        str = str + "<span style='height:40px;line-height:20px;' class='glyphicon glyphicon-search'>查看历史版本</span>";
                        str = str + "</button>";
                    }else{
                        str = str + "<button onclick='viewHistory("+item.sysEnvId+")' style='height: 40px;' type='button' class='btn btn-default btn-sm'>";
                        str = str + "<span style='height:40px;line-height:20px;' class='glyphicon glyphicon-search'>查看历史版本</span>";
                        str = str + "</button>";
                    }
                    str = str + "</div>";
                    str = str + "</div>";
                    str = str + "</div>";
                    $("#accordion").append(str);
                });
            }
        },
        error:function(){
            alert("error");
        }
    });
});
/**
 * 编辑模块版本
 */
function sysEnvEdit(id){
    localStorage.id = id;
    window.location = "./SysEnvEdit.jsp";
}
function viewHistory(sysEnvId){
    localStorage.sysEnvId = sysEnvId;
    window.location = "./RuningVerHistory.jsp";
}