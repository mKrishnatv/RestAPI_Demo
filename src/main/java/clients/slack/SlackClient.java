package clients.slack;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SlackClient {
    public Response sendSlackNotifications(Entities entities, String channelToken) {

        String url = String.format("https://hooks.slack.com/services/%s", channelToken);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(entities)
                .post(url);

        return response;

    }
}
