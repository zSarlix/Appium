package com.aliexpress.best.test.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/AppiumAliexpress.feature",
        glue ="com/aliexpress/best/test/stepsdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@SearchTest"
)

public class AppiumAliexpressRunner {
}
