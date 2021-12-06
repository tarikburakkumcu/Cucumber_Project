package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\ProjectCucumber-reports.html",
                "json:target/json-reports/ProjectCucumber.json",
                "junit:target/xml-report/ProjectCucumber.xml"},
        features="src/test/resources/features",
        glue="stepdefinitions",
        tags="@US004"  ,

        dryRun= false

)


public class ProjectRunner {
}
