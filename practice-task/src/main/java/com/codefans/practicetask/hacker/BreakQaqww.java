package com.codefans.practicetask.hacker;

import com.codefans.practicetask.httprequest.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * @author: codefans
 * @date: 2019-08-06 13:54
 *
 */
public class BreakQaqww {

    public void requestUrls() {

    }

    public void doPost(String url) {
        HttpResponse httpResponse = new HttpResponse();
        try {

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);

            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                // do something useful with the response body
                Locale local = response.getLocale();
                ProtocolVersion protocolVersion = response.getProtocolVersion();
                InputStream content = entity.getContent();

                // and ensure it is fully consumed
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet() {

    }

}
