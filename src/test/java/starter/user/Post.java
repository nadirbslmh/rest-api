package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected String url = "https://reqres.in/api/";

    @Step("I set POST api endpoint")
    public String setPostApiEndpoint() {
        return url + "users";
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "morpheus");
        requestBody.put("job","leader");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setPostApiEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveValidHttp201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for new user")
    public void validateDataNewUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();

        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("leader")));
        restAssuredThat(response -> response.body(matchesJsonSchema(helper.getPostResponseSchema())));
    }
}
