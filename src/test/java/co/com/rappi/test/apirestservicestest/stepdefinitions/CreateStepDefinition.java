package co.com.rappi.test.apirestservicestest.stepdefinitions;

import co.com.rappi.test.apirestservicestest.exceptions.ConsumptionServicesException;
import co.com.rappi.test.apirestservicestest.models.DataService;
import co.com.rappi.test.apirestservicestest.tasks.ConsumptionServicePost;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static co.com.rappi.test.apirestservicestest.utils.ExceptionsConstants.CONSUMPTION_SERVICE_CREATE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateStepDefinition {
    DataService dataService;

    @When("he send name {} and job {} to endpoint {}")
    public void heSendNameNameAndJobJobToEndpointEndpoint(String name, String job, String endpoint) {
        dataService = new DataService(name, job, endpoint);
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServicePost.apiRest(dataService));
    }

    @Then("he will be able to visualize the user's creation response {} with the fields name, job")
    public void heWillBeAbleToVisualizeTheUserSCreationResponseResponseCodeWithTheFieldsNameNameJobJob(int responseCode) {
        dataService.setResponseCode(responseCode);
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("mensaje", response -> response.statusCode(responseCode)),
                seeThatResponse("mensaje", response -> response.body("name", Matchers.containsString(dataService.getName()))),
                seeThatResponse("mensaje", response -> response.body("job", Matchers.containsString(dataService.getJob())))
                        .orComplainWith(ConsumptionServicesException.class, CONSUMPTION_SERVICE_CREATE));
        SerenityRest.lastResponse().body().print();
    }
}