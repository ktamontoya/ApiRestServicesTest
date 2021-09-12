package co.com.rappi.test.apirestservicestest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumptionServiceGet implements Task {
    private String endpoint;

    public ConsumptionServiceGet(String endpoint) {
        this.endpoint = endpoint;
    }

    public static ConsumptionServiceGet apiRest(String endpoint) {
        return Tasks.instrumented(ConsumptionServiceGet.class, endpoint);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(Get.resource(endpoint).with(request -> request
                .relaxedHTTPSValidation()));
    }
}