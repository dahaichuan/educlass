package com.haoyi.educlass.utils;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
    private static final Gson gson=new Gson();

    /**
     * 封装get
     * @param url
     * @return
     */
    public static Map<String,Object> doGet(String url){
        Map<String,Object> map=new HashMap<>();
        CloseableHttpClient httpClient= HttpClients.createDefault();
        RequestConfig requestConfig=RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)
                .build();
        HttpGet httpGet=new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            HttpResponse httpResponse= httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode()==200){
                String jsonResult= EntityUtils.toString(httpResponse.getEntity());
                map=gson.fromJson(jsonResult,map.getClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String doPost(String url,String data,int timeout){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        RequestConfig requestConfig=RequestConfig.custom().setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .setRedirectsEnabled(true)
                .build();

        HttpPost httpPost=new HttpPost(url);
        httpPost.setConfig(requestConfig);

        httpPost.addHeader("Content-Type","text/html;charset=UTF-8");
        if(data!=null && data instanceof String){
            StringEntity stringEntity=new StringEntity(data,"UTF-8");
            httpPost.setEntity(stringEntity);
        }

        try {
            HttpResponse httpResponse= httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode()==200){
                String result= EntityUtils.toString(httpResponse.getEntity());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
