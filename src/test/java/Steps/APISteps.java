package Steps;

import PageObjects.Payloads.PayloadSample;
import TestTools.APITools;
import io.cucumber.java.en.Given;
import java.io.IOException;

public class APISteps {

    @Given("I send a request for sample API")
    public void i_send_a_request_for_sample_api() throws IOException, InterruptedException {
        APITools api = new APITools();

        PayloadSample payload = new PayloadSample();
        payload.setTitle("foo");
        payload.setBody("bar");
        payload.setUserId("6");

        api.Post(payload, "https://jsonplaceholder.typicode.com/posts");
    }
}
