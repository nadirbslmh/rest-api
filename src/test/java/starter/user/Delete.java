package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Delete {
    protected String url = "https://reqres.in/api/";

    @Step("I set DELETE api endpoint")
    public String setDeleteApiEndpoint() {
        return url + "users/2";
    }

    @Step("I send DELETE HTTP request")
    public void sendDeleteHttpRequest() {
        SerenityRest.given().delete(setDeleteApiEndpoint());
    }

    @Step("I receive valid HTTP response code 204")
    public void validateDeletedUser() {
        restAssuredThat(response -> response.statusCode(204));
    }
}
