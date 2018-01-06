package apiFramework;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class requestTypes {

    public static String getRequestStatus (String endpoint) throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault(); //open browser
        HttpGet httpuriRequest = new HttpGet(endpoint); //type url

            CloseableHttpResponse response = httpclient.execute(httpuriRequest);  // enter- does the get

            try {
                String responseHeader = response.getStatusLine().toString(); //gets header/status

                return responseHeader;
                //HttpEntity entity1 = response.getEntity();

                //System.out.print(EntityUtils.toString(entity1));

                //EntityUtils.consume(entity1);
                }

            finally{
                response.close();
            }
        }
    }
