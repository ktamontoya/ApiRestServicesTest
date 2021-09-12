package co.com.rappi.test.apirestservicestest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/single_user.feature",
        glue = "co.com.rappi.test.apirestservicestest.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SingleUserRunner {
}