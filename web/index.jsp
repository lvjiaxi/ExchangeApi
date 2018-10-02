<%--
  Created by IntelliJ IDEA.
  User: lvjiaxi
  Date: 10/1/18
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <style type="text/css">
        .container {
            width: 1200px !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th id="th1">#</th> 
        <th id="th2">交易对</th> 
        <th id="th3">实时价格</th>                           
        <th id="th4">涨幅(24h)</th>                     
        <th id="th5">成交量(24h)</th>  
        <th id="th6">成交额(24h)</th>  
        <th id="th7">交易所</th> 
    </tr>
    </thead>
<c:forEach var="detailDatas" items="${detailDatas}" varStatus="index">
    <tr><td>${index.index+1}</td><td>${detailDatas.symbol}</td><td>${detailDatas.realtimeprices}</td><td>${detailDatas.dailyincrease>0 ?'<font color=\"red\">'.concat(detailDatas.dailyincrease).concat("</font>"):'<font color=\"green\">'.concat(detailDatas.dailyincrease).concat("</font>")}</td><td>${detailDatas.dayvolume}</td><td>${detailDatas.dayturnvolume}</td><td>${detailDatas.exchange}</td></tr>
</c:forEach>
</table>
    </div>
</div>
</body>
</html>
