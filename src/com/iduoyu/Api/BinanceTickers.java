package com.iduoyu.Api;

import com.iduoyu.Dao.KlineDayDate;
import com.iduoyu.Dao.UpdateData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinanceTickers {
    @Test
    public void binanceTickers(){
        String s = CommonUrlData.commonUrlConnectData("https://api.binance.com/api/v3/ticker/price");
        JSONArray jsonArray = JSONArray.fromObject(s);
        String reg="[A-Z]BTC";
        Pattern compile = Pattern.compile(reg);
        Long opentime=null;
        String open=null;
        String high=null;
        String low=null;
        String close=null;
        String volume=null;
        Long closetime=null;
        String sql="insert into klineday (symbol,opentime,open,high,low,close,volume,closetime) values(?,?,?,?,?,?,?,?)";
        String selsql="select * from klineday where symbol=? and opentime=?";


        for (Object j:jsonArray
             ) {
            JSONObject jsonObject = JSONObject.fromObject(j);
            String symbol = (String) jsonObject.get("symbol");
            Matcher matcher = compile.matcher(symbol);
            if (matcher.find()){
                //symbol 币安的货币种类
                String klineUrl="https://api.binance.com/api/v1/klines?symbol="+symbol+"&interval=1d";
                String urlConnectData = CommonUrlData.commonUrlConnectData(klineUrl);
                JSONArray urlConnectDataJsonArray = JSONArray.fromObject(urlConnectData);

                for (Object o:urlConnectDataJsonArray
                     ) {
                    JSONArray ojsonArray = JSONArray.fromObject(o);//可以获取单个货币的一天的数据 ， 分拆出来
                    opentime= (Long) ojsonArray.get(0);
                    open= (String) ojsonArray.get(1);
                    high= (String) ojsonArray.get(2);
                    low= (String) ojsonArray.get(3);
                    close= (String) ojsonArray.get(4);
                    volume= (String) ojsonArray.get(5);
                    closetime= (Long) ojsonArray.get(6);
                    try {
                        if (KlineDayDate.getOneKlineDayData(selsql,symbol,opentime)==null){
                            UpdateData.UpdateOneData(sql,symbol,opentime,open,high,low,close,volume,closetime);
                            System.out.println("写入成功");

                        }else {
                            System.out.println("已存在，跳过");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            }

        }

    }
}
