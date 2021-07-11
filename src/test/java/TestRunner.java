import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/java/features/"},
        //glue = {"steps"}
       // dryRun = true,
       // monochrome = true,
        plugin = {"pretty","html:target/report.html"},
        tags = "@sanity"
       // tags = "@regression" // single tag
       // tags = "@regression or @sanity"
       // tags = "@regression and @sanity"


)


public class TestRunner
{

}
