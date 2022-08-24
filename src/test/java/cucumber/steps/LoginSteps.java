package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;

import static cucumber.steps.Example.*;

public class LoginSteps {

    @Given("Setup Driver")
    public void setup_driver() {
        setUp();
    }

    @When("Registration with login and password")
    public void registration_with_login_and_password() throws InterruptedException {
        loginTest();
    }

    @When("Get list of players")
    public void get_list_of_players() throws InterruptedException {
        listPlayersTest();
    }

    @When("Check sorting table of players")
    public void check_sorting_table_of_players() throws ParseException, InterruptedException {
        sortColDateTest();
    }

    @Then("Close driver")
    public void close_driver() {
        tearDown();
    }


}

