package co.com.rappi.test.apirestservicestest.tasks;

import co.com.rappi.test.apirestservicestest.models.DataService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumptionServicePost implements Task {
    public DataService dataService;

    public ConsumptionServicePost(DataService dataService) {
        this.dataService = dataService;
    }

    public static ConsumptionServicePost apiRest(DataService dataService) {
        return Tasks.instrumented(ConsumptionServicePost.class, dataService);
    }

    @Step("{0} enters consumption service post api rest")
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(Post.to(dataService.getEndpoint()).with(request -> request
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"name\": \"" + dataService.getName() + "\",\n" +
                        "  \"job\": \"" + dataService.getJob() + "\"\n" +
                        "}")
                .relaxedHTTPSValidation()));
    }
}