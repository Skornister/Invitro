package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenarios"},
        plugin = {"pretty", "html:build/reports/cucumber-report.html"},
        glue = {"hooks", "steps"})
public class CucumberRunnerTest {
}