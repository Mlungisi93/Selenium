package com.expleo.qe.Runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\onlinePurchase.feature",
        glue = "com\\expleo\\qe\\StepDefinition")
public class RunnerTest {
}
