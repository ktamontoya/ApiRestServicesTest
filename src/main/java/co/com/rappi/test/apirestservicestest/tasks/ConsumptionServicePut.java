package co.com.rappi.test.apirestservicestest.tasks;

import co.com.rappi.test.apirestservicestest.models.DataService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;
import sun.net.www.ParseUtil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumptionServicePut implements Task {
    public DataService dataService;

    public ConsumptionServicePut (DataService dataService) {
        this.dataService = dataService;
    }

    public static ConsumptionServicePut apiRest(DataService dataService) {
        return Tasks.instrumented(ConsumptionServicePut.class, dataService);
    }

    @Step("{0} enters consumption service put api rest")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(Put.to(dataService.getEndpoint()).with(request -> request
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"name\": \"" + dataService.getName() + "\",\n" +
                        "  \"job\": \"" + dataService.getJob() + "\"\n" +
                        "}")
                .relaxedHTTPSValidation()));
    }
}