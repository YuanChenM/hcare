$(function () {
    $.ajax({
        type: "GET",
        async: false,
        url: url + "RuningVerHistory",
        timeout: 60,
        dataType: 'json',
        data: {
            "sysEnvId": localStorage.sysEnvId
        },
        contentType: "application/json",
        success: function (data) {
            if (data.status == "S") {
                localStorage.removeItem("sysEnvId");
                var resultList = data.result;
                $.each(resultList, function (i, item) {
                    var str = "<div class='panel panel-default'>";
                    str = str + "<div class='panel-heading'>";
                    str = str + "<h4 class='panel-title'>";
                    str = str + "<a data-toggle='collapse' data-parent='#accordion' href='#collapse" + i + "'>"
                    str = str + "<table class='table-condensed'>";
                    str = str + "<tr>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>运行环境:</td>";
                    str = str + "<td align='left' width='7%'>" + item.sysEnvName + "</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>运行工程版本:</td>";
                    str = str + "<td align='left' width='2%'>" + item.projectVersion + "</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>系统版本:</td>";
                    str = str + "<td align='left' width='5%'>" + item.svnVersion + "</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>是否稳定版:</td>";
                    if (item.isSteady == '0') {
                        str = str + "<td align='left' width='8%'>不稳定版本</td>";
                    } else if (item.isSteady == '1') {
                        str = str + "<td align='left' width='8%'>稳定版本</td>";
                    }
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>发布时间:</td>";
                    str = str + "<td align='left' width='20%'>" + item.publishTime + "</td>";
                    str = str + "<td align='right'><button type='button' onclick='sysEnvDetail(" + item.id + "," + item.sysEnvId + ")' class='btn btn-default btn-sm'><span class='glyphicon glyphicon-cog'></span>查看详情</button></td>";
                    str = str + "</tr>";
                    str = str + "</table>";
                    str = str + "</a>";
                    str = str + "</h4>";
                    str = str + "</div>";
                    str = str + "<input type='hidden' value='false' id='firstOrNot" + item.id + "'/>";
                    str = str + "<div id='sysEnvDetail" + item.id + "' style='display:none;' class='panel-collapse collapse in'>";
                    str = str + "</div>";
                    str = str + "</div>";
                    $("#history").append(str);
                });
            }
        },
        error: function () {
            alert("error");
        }
    });
});
/**
 * 展示详细模块的版本
 * @param versionId
 * @param sysEnvId
 */
function sysEnvDetail(versionId, sysEnvId) {
    if($("#firstOrNot" + versionId).val() == "false"){
        $.ajax({
            type: "GET",
            async: false,
            url: url + "ModuleVerHistory",
            timeout: 60,
            dataType: 'json',
            data: {
                "sysEnvId": sysEnvId,
                "versionId": versionId
            },
            contentType: "application/json",
            success: function (data) {
                if (data.status == "S") {
                    //设置下一次点击不是初次点击,不需要查数据
                    $("#firstOrNot" + versionId).val(true);
                    //展示数据
                    var resultList = data.result;
                    if (resultList.length > 0) {
                        var str = "<div class='panel-body'>";
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
                        $.each(resultList, function (i, item) {
                            str = str + "<tr>";
                            str = str + "<td align='center'>" + item.moduleName + "</td>";
                            str = str + "<td align='center'>" + item.moduleShort + "</td>";
                            str = str + "<td align='center'>" + item.svnVersion + "</td>";
                            str = str + "<td align='center'>" + item.svnSubVersion + "</td>";
                            if (item.isRuning == '0') {
                                str = str + "<td align='center'>不在运行</td>";
                            } else if (item.isRuning == '1') {
                                str = str + "<td align='center'>运行中</td>";
                            }
                            str = str + "<td align='center'>" + item.publishTime + "</td>";
                            str = str + "<td align='center'>" + item.publisher + "</td>";
                            str = str + "</tr>";
                        });
                        str = str + "</table>";
                        str = str + "</div>";
                        $("#sysEnvDetail" + versionId).html(str);
                    }
                }
            },
            error: function () {
                alert("error");
            }
        });
    }
    $("#sysEnvDetail" + versionId).slideToggle();
}