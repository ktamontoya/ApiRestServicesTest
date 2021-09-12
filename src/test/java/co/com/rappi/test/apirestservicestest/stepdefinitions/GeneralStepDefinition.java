package co.com.rappi.test.apirestservicestest.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.rappi.test.apirestservicestest.utils.DataConstans.NOMBRE_USUARIO;
import static co.com.rappi.test.apirestservicestest.utils.DataConstans.URL_BASE;

public class GeneralStepDefinition {

    @Given("the user loads the url information")
    public void theUserLoadsTheUrlInformation() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(NOMBRE_USUARIO);
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(URL_BASE));
    }
}