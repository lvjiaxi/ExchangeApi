package com.iduoyu.Api;


import net.sf.json.JSONObject;
import org.junit.Test;

public class BinanceTickerPrice {
    public  static String binanceTickerAllSymbolClosePrice(){
        String temp="https://api.binance.com/api/v3/ticker/price";
        String allSymbol = CommonUrlData.commonUrlConnectData(temp);
        return allSymbol;

    }
    public  static double binanceTickerOneSymbolClosePrice(String symbol){
        String temp="https://api.binance.com/api/v3/ticker/price"+"?symbol="+symbol;
        JSONObject jsonObject = CommonUrlData.commonUrlConnectJsonData(temp);
        double price = jsonObject.getDouble("price");
        return price;
    }


}
