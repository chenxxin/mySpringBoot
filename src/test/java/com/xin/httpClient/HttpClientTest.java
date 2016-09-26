package com.xin.httpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXINXIN on 2016/7/8.
 */
@SuppressWarnings("TryFinallyCanBeTryWithResources")
public class HttpClientTest {
    @Test
    public void testHttpClient() throws Exception {
        // 1. 创建默认的客户端实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. 创建get请求实例
        HttpGet httpGet = new HttpGet("http://www.apache.org/");// httpGet: GET http://http://www.apache.org/ HTTP/1.1
        //在请求中明确定义不要进行压缩 (那么，getContentLength()就不会返回-1，前提是响应头Header中含有这个字段)
        httpGet.setHeader("Accept-Encoding", "identity");

        CloseableHttpResponse response = null;
        try{
            // 3. 客户端执行get请求 返回响应实体
            response = httpClient.execute(httpGet);

            // 服务器响应状态行
            response.getStatusLine(); // HTTP/1.1 200 OK

            // 响应头
            Header[] headers = response.getAllHeaders();
    //        for(Header header : headers){
    //            System.out.println(header.getName()+" : "+header.getValue());
    //        }

            // 响应消息实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 响应内容
                String content = EntityUtils.toString(entity);
                // 响应内容长度
                content.length(); // 得到 响应消息实体entity 的长度
                entity.getContentLength(); // 有可能返回-1
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 解决异常：Caused by: org.apache.http.ProtocolException: The server failed to respond with a valid HTTP response
            httpGet.abort();
//            httpClient.close(); //是否不需要？
            // 解决：HttpClient 发送请求后莫名卡死，然后经历很长一段时间后，返回response 为null
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
    }

    @Test
    public void testPost() throws Exception {
        String url = "http://localhost:8088/post";
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type","application/json");

        List<NameValuePair> list = new ArrayList<>();
        NameValuePair pair1 = new BasicNameValuePair("id","123");
        NameValuePair pair2 = new BasicNameValuePair("name","xin");
        NameValuePair pair3 = new BasicNameValuePair("age","18");
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
        post.setEntity(entity);
        String strEntity = EntityUtils.toString(entity);
        System.out.println("strEntity = " + strEntity);

        // {"id":123,"name":"xin","age":18}
        String data = "{\"id\":123,\"name\":\"xin\",\"age\":18}";
        StringEntity params = new StringEntity(data, "utf-8");
        post.setEntity(params);


        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode()==200){
            String strResult = EntityUtils.toString(response.getEntity());
            System.out.println(strResult);
        }
    }
}
