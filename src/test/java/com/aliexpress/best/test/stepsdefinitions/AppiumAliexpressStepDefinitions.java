package com.aliexpress.best.test.stepsdefinitions;


import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.LBL_TEXT;

import com.aliexpress.best.automation.com.aliexpress.driver.AppiumAndroidDriver;
import com.aliexpress.best.automation.interaction.Validation;
import com.aliexpress.best.automation.models.Global;
import com.aliexpress.best.automation.task.*;

import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppiumAliexpressStepDefinitions {


    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());

    }


    @Given("^I am in the aliexpress application$")
    public void iAmInTheAliexpressApplication() {

        OnStage.theActorCalled("").can(BrowseTheWeb.with(AppiumAndroidDriver.suNavegador().onDriver()));
    }

    @When("^I look for my product in the featured categories$")
    public void iLookForMyProductInTheFeaturedCategories() {

       OnStage.theActorInTheSpotlight().attemptsTo(SearhWithRecomend.go());
    }

    @When("^I look for my product in the categories$")
    public void iLookForMyProductInTheCategories() {

         OnStage.theActorInTheSpotlight().attemptsTo(SearchWithCategory.go());
    }


    @When("^I search for my product in the search window$")
    public void iSearchForMyProductInTheSearchWindow() {

          OnStage.theActorInTheSpotlight().attemptsTo(SearchWithText.go());
    }

    @When("^I Clean My Shop Car$")
    public void iCleanMyShopCar() {

           OnStage.theActorInTheSpotlight().attemptsTo(CleanCar.go());
    }

    @Then("^Valid that you have done everything correctly (.*)$")
    public void validThatYouHaveDoneEverythingCorrectly(String model) {
        OnStage.theActorInTheSpotlight().attemptsTo(Validation.go());
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_TEXT.of(model)), WebElementStateMatchers.containsText(Global.validation)));
    }

}
