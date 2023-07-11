package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Delete;
import starter.user.Get;
import starter.user.Post;
import starter.user.Put;

public class UserSteps {
    @Steps
    Get get;
    @Steps
    Post post;

    @Steps
    Put put;

    @Steps
    Delete delete;

    @Given("I set GET api endpoint")
    public void setGetApiEndpoints() {
        get.setApiEndpoint();
    }

    @When("I send GET HTTP request")
    public void sendGetHttpRequest() {
        get.sendGetHttpRequest();
    }

    @Then("I receive valid HTTP response code 200")
    public void receiveValidHttpResponses() {
        get.validateHttpResponseCode200();
    }

    @And("I receive valid data for detail user")
    public void receiveValidDataForDetailUser() {
        get.validateDataDetailUser();
    }

    @Given("I set POST api endpoint")
    public void setPostApiEndpoints() {
        post.setPostApiEndpoint();
    }

    @When("I send POST HTTP request")
    public void setPostHttpRequest() {
        post.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP response code 201")
    public void receiveValidHttp201() {
        post.receiveValidHttp201();
    }

    @And("I receive valid data for new user")
    public void validateDataNewUser() {
        post.validateDataNewUser();
    }

    @Given("I set PUT api endpoint")
    public void setPutApiEndpoints() {
        put.setPutApiEndpoint();
    }

    @When("I send PUT HTTP request")
    public void setPutHttpRequest() {
        put.sendPutHttpRequest();
    }

    @And("I receive valid data for updated user")
    public void validateDataUpdatedUser() {
        put.validateDataUpdatedUser();
    }

    @Given("I set DELETE api endpoint")
    public void setDeleteApiEndpoints() {
        delete.setDeleteApiEndpoint();
    }

    @When("I send DELETE HTTP request")
    public void setDeleteHttpRequest() {
        delete.sendDeleteHttpRequest();
    }

    @Then("I receive valid HTTP response code 204")
    public void validateDeletedUser() {
        delete.validateDeletedUser();
    }
}
