package co.com.rappi.test.apirestservicestest.stepdefinitions;

import co.com.rappi.test.apirestservicestest.exceptions.ConsumptionServicesException;
import co.com.rappi.test.apirestservicestest.models.DataService;
import co.com.rappi.test.apirestservicestest.tasks.ConsumptionServicePut;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static co.com.rappi.test.apirestservicestest.utils.ExceptionsConstants.CONSUMPTION_SERVICE_UPDATE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateStepDefinition {
    DataService dataService;

    @When("he sends another name {} and new job {} to endpoint {}")
    public void heSendsAnotherNameAndNewJobToEndpoint(String name, String job, String endpoint) {
        dataService = new DataService(name, job, endpoint);
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServicePut.apiRest(dataService));
    }

    @Then("he will be able to view the update response of the user {} with the new fields name, job")
    public void heWillBeAbleToViewTheUpdateResponseOfTheUserWithTheNewFieldsNameJob(int responseCode) {
        dataService.setResponseCode(responseCode);
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("mensaje", response -> response.statusCode(responseCode)),
                seeThatResponse("mensaje", response -> response.body("name", Matchers.containsString(dataService.getName()))),
                seeThatResponse("mensaje", response -> response.body("job", Matchers.containsString(dataService.getJob())))
                        .orComplainWith(ConsumptionServicesException.class, CONSUMPTION_SERVICE_UPDATE));
        SerenityRest.lastResponse().body().print();
    }
}