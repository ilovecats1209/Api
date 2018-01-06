package apiFramework;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class getRequest {

    public static String getRequestStatus(String endpoint) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpuriRequest = new HttpGet(endpoint);

        CloseableHttpResponse response = httpclient.execute(httpuriRequest);

        try {
            String responseHeader = response.getStatusLine().toString();

            return responseHeader;

        } finally {
            response.close();
        }
    }

    public static String getRequestResponse(String endpoint) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpuriRequest = new HttpGet(endpoint);

        CloseableHttpResponse response = httpclient.execute(httpuriRequest);

        try {

            HttpEntity responseBody = response.getEntity();

            EntityUtils.consume(responseBody);

            String responseBodyText = responseBody.toString();

            return responseBodyText;
        } finally {
            response.close();
        }
    }
}