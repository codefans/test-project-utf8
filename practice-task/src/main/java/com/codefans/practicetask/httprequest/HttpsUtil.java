package com.codefans.practicetask.httprequest;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * 参考资料：
 * HttpClient4.5 SSL访问工具类
 * http://www.cnblogs.com/skyblog/p/6145421.html
 *
 * http://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/connmgmt.html
 *
 * https://docs.oracle.com/javase/6/docs/technotes/guides/security/jsse/JSSERefGuide.html#SSC
 *
 *
 * @author: codefans
 * @date: 2017-12-04 18:14
 *
 **/
public class HttpsUtil {

    public static CloseableHttpClient createClient() throws Exception{
        TrustStrategy trustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] xc, String msg)
                    throws CertificateException {
                return true;
            }
        };
        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(trustStrategy);
        HostnameVerifier hostnameVerifierAllowAll = new HostnameVerifier() {
            @Override
            public boolean verify(String name, SSLSession session) {
                return true;
            }
        };
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                builder.build(), new String[] { "SSLv2Hello", "SSLv3", "TLSv1",
                "TLSv1.1", "TLSv1.2" }, null, hostnameVerifierAllowAll);

        HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(
                    IOException exception,
                    int executionCount,
                    HttpContext context) {
                //重试设置
                if (executionCount >= 5) {
                    // Do not retry if over max retry count
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                    // Timeout
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    // Unknown host
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {
                    // Connection refused
                    return false;
                }
                if (exception instanceof SSLException) {
                    // SSL handshake exception
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent) {
                    return true;
                }
                return false;
            }
        };
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(120000)
                .setSocketTimeout(120000)//超时设置
                .build();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setRetryHandler(myRetryHandler)//重试设置
                .setDefaultRequestConfig(requestConfig)
                .build();
        return httpclient;
    }

    public static String get(String url) throws Exception {
        return get(url,null,null);
    }

    public static String get(String url, Map<String, String> header, Map<String, String> outCookies) throws Exception {
        String body = "";
        String Encoding ="utf-8";
        CloseableHttpClient client = createClient();
        try {
            CookieStore cookieStore = new BasicCookieStore();
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setCookieStore(cookieStore);
            // 创建get方式请求对象
            HttpGet httpGet = new HttpGet(url);
            setHeader(httpGet, header);

            System.out.println("请求地址：" + url);
            // 执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpGet,localContext);
            // 获取结果实体
            try {
                // 如果需要输出cookie
                if(outCookies!=null){
                    List<Cookie> cookies = cookieStore.getCookies();
                    for (int i = 0; i < cookies.size(); i++) {
                        outCookies.put(cookies.get(i).getName(),cookies.get(i).getValue());
                    }
                }
                HttpEntity entity = response.getEntity();
                System.out.println("返回：" + response.getStatusLine());
                if (entity != null) {
                    // 按指定编码转换结果实体为String类型
                    body = EntityUtils.toString(entity, Encoding);
                    // System.out.println("返回："+body);
                }
            } finally {
                response.close();
            }
        } finally {
            client.close();
        }
        return body;
    }

    public static String post(String url, Map<String, String> params)
            throws Exception {
        return post(url, params, null,null);
    }

    public static String post(String url, Map<String, String> params, Map<String, String> header,Map<String, String> outCookies)
            throws Exception {
        String body = "";
        String encoding ="utf-8";
        String contentType="text/html";
        CloseableHttpClient client = createClient();
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);
        try {
            // 创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            setHeader(httpPost, header);

            // 装填参数
            if (contentType.equalsIgnoreCase("text/html")) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                    }
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
            }
            //JOSN格式参数
            if (contentType.equalsIgnoreCase("application/json")) {
                StringEntity myEntity = new StringEntity(JSON.toJSONString(params.get("data")),
                        ContentType.create("application/json", "UTF-8"));
                httpPost.setEntity(myEntity);
            }
            System.out.println("请求地址：" + url);
            // 执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost,localContext);
            // 获取结果实体
            try {
                // 如果需要输出cookie
                if(outCookies!=null){
                    List<Cookie> cookies = cookieStore.getCookies();
                    for (int i = 0; i < cookies.size(); i++) {
                        outCookies.put(cookies.get(i).getName(),cookies.get(i).getValue());
                    }
                }
                HttpEntity entity = response.getEntity();
                System.out.println("返回：" + response.getStatusLine());
                if (entity != null) {
                    // 按指定编码转换结果实体为String类型
                    body = EntityUtils.toString(entity, encoding);
                    // System.out.println("返回："+body);
                }
            } finally {
                response.close();
            }
        } finally {
            client.close();
        }
        return body;
    }

    public static void setHeader(AbstractHttpMessage httpMessage, Map<String, String> headers) {
        if(headers != null) {
            Iterator<String> iter = headers.keySet().iterator();
            String key = "";
            String val = "";
            while(iter.hasNext()) {
                key = iter.next();
                val = headers.get(key);
                httpMessage.setHeader(key, val);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "";
//        url = "https://www.baidu.com/";
        url = "https://activity.waimai.meituan.com/coupon/sharechannel/B2EA8E1ABA8B47EA82DB475BA17B517D?urlKey=BE74ED05036D46D3836289A75464A2D9&utm_term=AiphoneBgroupC8.4.1DweixinEwm-orderGF8A3848E9B6C216A4256215A50BE7FDCF1EC5C2E836B8CB464359A6CF70F782920171124112540608&utm_source=appshare&utm_medium=iOSweb&from=singlemessage&isappinstalled=0";
//        url = "http://localhost:8080/http/test";
//        url = "http://wx.qaqww.xyz/app/index.php?i=3&c=entry&rid=51&m=tyzm_diamondvote&do=Index";
        Map<String, String> header = new HashMap<String, String>();

        header.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2 like Mac OS X) AppleWebKit/602.3.12 (KHTML, like Gecko) Mobile/14C92 MicroMessenger/7.0.5(0x17000523) NetType/WIFI Language/zh_CN");
//        header.put("Accept", "application/json, text/javascript, */*; q=0.01");
//        header.put("Accept-Language", "zh-cn");
//        header.put("Connection", "keep-alive");
//        header.put("Accept-Encoding", "gzip, deflate");
//        header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        header.put("Connection", "keep-alive");
////        header.put("Upgrade-Insecure-Requests", "1");
//        header.put("Cookie", "PHPSESSID=8ba47614a27c0a9ba18dfabe0b9c0975");
//        header.put("Cache-Control", "no-cache");
//        header.put("cache-control", "no-cache");
        header.put("X-Requested-With", "XMLHttpRequest");
//        Postman-Token: 72785a33-be82-44bc-925d-9324dd2d904c,29973e5d-afda-4a12-8218-b86974840bd2
//        Host: wx.qaqww.xyz
//        Cookie: PHPSESSID=8ba47614a27c0a9ba18dfabe0b9c0975
//        cache-control: no-cache

//        header.put("Origin", "http://wx.qaqww.xyz");
//        header.put("Host", "activity.waimai.meituan.com");

//        String body =get(url, header, null);
//        System.out.println(body);
//        header.remove("Host");

        url = "http://wx.qaqww.xyz/app/index.php?i=3&c=entry&rid=51&m=tyzm_diamondvote&do=Index";
        /**
         * 加上Host就报404
         */
//        header.put("Host", "wx.qaqww.xyz");
//        header.put("Origin", "http://wx.qaqww.xyz");

        Map<String, String> outCookies = null;
//        Map<String, String> outCookies = new HashMap<String, String>();
//        outCookies.put("PHPSESSID", "8ba47614a27c0a9ba18dfabe0b9c0975");

        String qaqwwContent = get(url, header, outCookies);
        System.out.println(qaqwwContent);
//        System.out.println("body.equals(qaqwwContent)=" + body.equals(qaqwwContent));

    }


}
