package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Put {
    protected String url = "https://reqres.in/api/";

    @Step("I set PUT api endpoint")
    public String setPutApiEndpoint() {
        return url + "users/2";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "morpheus");
        requestBody.put("job","zion resident");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .put(setPutApiEndpoint());
    }

    @Step("I receive valid data for updated user")
    public void validateDataUpdatedUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();

        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("zion resident")));
        restAssuredThat(response -> response.body(matchesJsonSchema(helper.getPutResponseSchema())));
    }
}
