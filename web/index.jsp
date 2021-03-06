<%--
  Created by IntelliJ IDEA.
  User: lvjiaxi
  Date: 10/1/18
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="js/jquery-3.1.1.js"></script>

    <style type="text/css">
        .container {
            width: 1200px !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <table id="change" class="table table-hover ">
    <thead>
    <tr>
        <td id="th1">#</td> 
        <td id="th2">交易对</td> 
        <td id="th3">实时价格</td>                           
        <td id="th4">涨幅(24h)</td>                     
        <td id="th5">成交量(24h)</td>  
        <td id="th6">成交额(24h)</td>  
        <td id="th7">交易所</td> 
    </tr>
    </thead>

<c:forEach var="detailDatas" items="${detailDatas}" varStatus="index">
    <tr><td>${index.index+1}</td><td class="symbol">${fn:replace(detailDatas.symbol,"usdt","")}</td><td class="price">${detailDatas.realtimeprices}</td><td>${detailDatas.dailyincrease>0 ?'<font color=\"red\">'.concat(detailDatas.dailyincrease).concat("</font>"):'<font color=\"green\">'.concat(detailDatas.dailyincrease).concat("</font>")}</td><td>${detailDatas.dayvolume}</td><td>${detailDatas.dayturnvolume}</td><td>${detailDatas.exchange}</td></tr>
</c:forEach>
</table>
    </div>
</div>
<script>
    $(function(){
         setInterval(aa,2000);
        function aa(){
            jQuery.ajax({
                type: 'post', //可选get
                url: 'http://localhost:8080/HuobiJson', //这里是接收数据的程序
                dataType: 'json', //服务器返回的数据类型 可选XML ,Json jsonp script html text等
                success: function(data) {
                    // $("#change").empty();//清空
                    //这里是ajax提交成功后，程序返回的数据处理函数。data是返回的数据，数据类型在dataType参数里定义！
                    // $("#change").append("<thead>\n" +
                    //     "    <tr>\n" +
                    //     "        <td id=\"th1\">#</td> \n" +
                    //     "        <td id=\"th2\">交易对</td> \n" +
                    //     "        <td id=\"th3\">实时价格</td>                           \n" +
                    //     "        <td id=\"th4\">涨幅(24h)</td>                     \n" +
                    //     "        <td id=\"th5\">成交量(24h)</td>  \n" +
                    //     "        <td id=\"th6\">成交额(24h)</td>  \n" +
                    //     "        <td id=\"th7\">交易所</td> \n" +
                    //     "    </tr>\n" +
                    //     "    </thead>");
                    jQuery.each(data,function (i,result) {

                        $(".symbol").each(function () {
                            if (this.innerText==result.symbol.replace("usdt","")) {
                                $(this).text(result.symbol.replace("usdt",""));
                                $(this).next().text(result.realtimeprices);
                                $(this).next().next().html(result.dailyincrease>0?"<font color='red'>".concat(result.dailyincrease).concat("</font>"):"<font color='green'>".concat(result.dailyincrease).concat("</font>"));
                                $(this).next().next().next().text(result.dayvolume);
                                $(this).next().next().next().next().text(result.dayturnvolume);
                            }
                        })
                    })

                },
                error: function() {
                }
            });

        }
    })






</script>
</body>
</html>
