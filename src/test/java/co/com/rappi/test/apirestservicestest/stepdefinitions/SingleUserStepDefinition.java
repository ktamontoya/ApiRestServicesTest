package co.com.rappi.test.apirestservicestest.stepdefinitions;

import co.com.rappi.test.apirestservicestest.exceptions.ConsumptionServicesException;
import co.com.rappi.test.apirestservicestest.tasks.ConsumptionServiceGet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static co.com.rappi.test.apirestservicestest.utils.ExceptionsConstants.CONSUMPTION_SERVICE_SINGLE_USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class SingleUserStepDefinition {

    @When("he consults the information presented at endpoint {}")
    public void heConsultsTheInformationPresentedAt(String endpoint) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServiceGet.apiRest(endpoint));
    }

    @Then("will compare the answer it shows with response Code {}, id {}, firstName {} y lastName {}")
    public void heWillCompareTheResponseAndResponseCodeData(int responseCode, int id, String firstName, String lastName) {
        theActorInTheSpotlight()
                .should(seeThatResponse("mensaje", response -> response.statusCode(responseCode)),
                        seeThatResponse("mensaje", response -> response.body("data.id", Matchers.equalTo(id))),
                        seeThatResponse("mensaje", response -> response.body("data.first_name", Matchers.containsString(firstName))),
                        seeThatResponse("mensaje", response -> response.body("data.last_name", Matchers.containsString(lastName)))
                                .orComplainWith(ConsumptionServicesException.class, CONSUMPTION_SERVICE_SINGLE_USER));
        SerenityRest.lastResponse().body().print();
    }
}