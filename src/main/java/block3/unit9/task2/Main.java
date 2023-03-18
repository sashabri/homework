package block3.unit9.task2;

import block3.unit9.task1.FactsAboutCats;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static final String SERVICE_URL = "https://api.nasa.gov/planetary/apod?api_key=0YTyxgdPcIhAIsfUfUWhe91qZfOjKNlxsB5n2kjY";
    public static ObjectMapper mapper = new ObjectMapper();

    public static String nameInUrl(String url) {
        String[] arr = url.split("/");

        return arr[arr.length - 1];
    }

    public static void saveFile(InputStream is, String fileName) {

        try(OutputStream os = new FileOutputStream(fileName)) {

            for (int c = is.read(); c != -1; c = is.read()) {
                os.write(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(SERVICE_URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = httpClient.execute(request);

        Answer answer = mapper.readValue(response.getEntity().getContent(), Answer.class);

        String url = answer.getUrl();

        String nameFile = nameInUrl(url);

        HttpGet request2 = new HttpGet(url);

        CloseableHttpResponse response2 = httpClient.execute(request2);

       InputStream inputStream = response2.getEntity().getContent();

       saveFile(inputStream, nameFile);
    }
}
