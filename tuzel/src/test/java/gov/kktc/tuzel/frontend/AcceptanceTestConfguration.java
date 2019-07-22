package gov.kktc.tuzel.frontend;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions (features = {"src/test/resources/features/sirket"})
public class AcceptanceTestConfguration {

}
