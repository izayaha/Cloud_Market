package com.iza.pay.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/7 15:34
 * description:
 */
public class HttpUtil {
    //设置11请求参数1的格式类型
    public static final String TYPE_JSON= "application/json";
    public static final String TYPE_XML="text/xml";

    //GET
    public static String get(String url){
        //1.创建请求对象
        HttpGet httpGet = new HttpGet(url);
        //2.创建客户端对象
        HttpClient client = HttpClientBuilder.create().build();
        //3.执行请求并获取响应对象
        try {
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200) {
                //获取响应的结果
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //POST
    public  static String post(String url,String params,String type){
        //创建请求对象
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(180*1000)
                .setConnectionRequestTimeout(180*1000).setSocketTimeout(180*1000)
                .setRedirectsEnabled(true).build();
        //2.创建参数对象
        StringEntity reqParams = new StringEntity(params,"UTFF-8");
        httpPost.setEntity(reqParams);
        httpPost.addHeader("Content-Type",type);
        httpPost.setConfig(requestConfig);
        //创建客户端对象
        HttpClient client = HttpClientBuilder.create().build();
        //4.执行请求并获取响应对象
        try {
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode()==200) {
                //获取响应结果
                return EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
