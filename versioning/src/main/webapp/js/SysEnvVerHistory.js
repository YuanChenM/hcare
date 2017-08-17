$(function () {
    $.ajax({
        type: "GET",
        async: false,
        url: url + "SysEnvVerHistory",
        timeout: 60,
        dataType: 'json',
        contentType: "application/json",
        success: function (data) {
            if (data.status == "S") {
                var resultList = data.result;
                $.each(resultList, function (i, item) {
                    var str = "<tr>";
                    str = str + "<td align='left' width='7%'>" + item.sysEnvName + "</td>";
                    str = str + "<td align='left' width='2%'>" + item.projectVersion + "</td>";
                    str = str + "<td align='left' width='5%'>" + item.svnVersion + "</td>";
                    if (item.isSteady == '0') {
                        str = str + "<td align='left' width='8%'>不稳定版本</td>";
                    } else if (item.isSteady == '1') {
                        str = str + "<td align='left' width='8%'>稳定版本</td>";
                    }
                    if (item.isRuning == '0') {
                        str = str + "<td align='left' width='8%'>不在运行</td>";
                    } else if (item.isRuning == '1') {
                        str = str + "<td align='left' width='8%'>运行中</td>";
                    }
                    str = str + "<td align='left' width='20%'>" + item.publishTime + "</td>";
                    str = str + "</tr>";
                    $("#historyTable").append(str);
                });
            }
        },
        error: function () {
            alert("error");
        }
    });

    $("#searchVer").click(function(){

        var sysEnvName = $("#sysEnvName").val();
        var svnVersion = $("#svnVersion").val();
        var isSteady = $("#isSteady option:selected").val();
        var isRuning = $("#isRuning option:selected").val();

        $.ajax({
            type: "GET",
            async: false,
            url: url + "SysEnvVerSearch",
            timeout: 60,
            dataType: 'json',
            data: {
                "sysEnvName": sysEnvName,
                "svnVersion": svnVersion,
                "isSteady":isSteady,
                "isRuning":isRuning
            },
            contentType: "application/json",
            success: function (data) {
                if (data.status == "S") {
                    var resultList = data.result;
                    //清空表格
                    $("#historyTable").html('');
                    //遍历返回数据,显示表格
                    var str = "<tr>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>运行环境</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>运行工程版本</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>系统版本</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>是否稳定版</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>是否运行中</td>";
                    str = str + "<td align='center' style='font-weight: bold' width='10%'>发布时间</td>";
                    str = str + "</tr>";
                    if(resultList.length == 0){
                        str = str + "<tr>";
                        str = str + "<td align='left' width='20%'>未查到有效数据,请检查查询条件</td>";
                        str = str + "</tr>";
                    }else{
                        $.each(resultList, function (i, item) {
                            str = str + "<tr>";
                            str = str + "<td align='left' width='7%'>" + item.sysEnvName + "</td>";
                            str = str + "<td align='left' width='2%'>" + item.projectVersion + "</td>";
                            str = str + "<td align='left' width='5%'>" + item.svnVersion + "</td>";
                            if (item.isSteady == '0') {
                                str = str + "<td align='left' width='8%'>不稳定版本</td>";
                            } else if (item.isSteady == '1') {
                                str = str + "<td align='left' width='8%'>稳定版本</td>";
                            }
                            if (item.isRuning == '0') {
                                str = str + "<td align='left' width='8%'>不在运行</td>";
                            } else if (item.isRuning == '1') {
                                str = str + "<td align='left' width='8%'>运行中</td>";
                            }
                            str = str + "<td align='left' width='20%'>" + item.publishTime + "</td>";
                            str = str + "</tr>";
                        });
                    }

                    $("#historyTable").html(str);
                }
            },
            error: function () {
                alert("error");
            }
        });
    });
});