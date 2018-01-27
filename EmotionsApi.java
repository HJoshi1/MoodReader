/**
 * Created by harshil on 27/01/2018.
 */
// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EmotionsApi
{
    public static void main(String[] args)
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "{5afdffd06cc04110bd42217f5ee41f28}");

            // Request body
            StringEntity reqEntity = new StringEntity("{ \"url\": \"https://i.pinimg.com/736x/0d/57/53/0d5753c8d581c9dd68384055cabce991--face-reference-interesting-faces.jpg\" }");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

