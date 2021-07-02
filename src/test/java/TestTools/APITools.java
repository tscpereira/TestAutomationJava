package TestTools;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APITools {

    public void Post(Object object, String uri) throws IOException, InterruptedException {

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(object);

        System.out.println("Payload:\n" + requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("Content-type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("Response:\n" + response.body());
    }
}
