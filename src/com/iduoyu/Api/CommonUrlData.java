package com.iduoyu.Api;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonUrlData {

    /**
     * 本接口是通用获取api接口
     * @param temp 是引入交易所api接口地址
     * @return
     */
    public static String commonUrlConnectData(String temp){
        String UrlData=null;
        try {
            URL url = new URL(temp);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
            urlConnection.connect();
            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            // 对数据进行访问
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // 关闭流
            bReader.close();
            // 关闭链接
            urlConnection.disconnect();
            UrlData= String.valueOf(stringBuilder);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return UrlData;
    }

    /**
     * 获取一个交易对最新价格已经其他详细信息json数据并且返回
     * @param url
     * @return
     */
    public static JSONObject commonUrlConnectJsonData(String url){
        String s = commonUrlConnectData(url);
        JSONObject jsonObject = JSONObject.fromObject(s);
        return jsonObject;
    }

    }


