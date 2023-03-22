package com.aliexpress.best.automation.task;

import static com.aliexpress.best.automation.userinterfaces.AliexpressShopCar.BTN_DELETE;
import static com.aliexpress.best.automation.userinterfaces.AliexpressShopCar.BTN_DELETE_SELECT;
import static com.aliexpress.best.automation.userinterfaces.AliexpressShopCar.BTN_GO_TO_FITS;
import static com.aliexpress.best.automation.userinterfaces.AliexpressShopCar.BTN_SHOP_CAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.aliexpress.best.automation.interaction.HoldOnFor;
import com.aliexpress.best.automation.interaction.SelectListArticle;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CleanCar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_SHOP_CAR, isVisible()).forNoMoreThan(3).seconds(),
                Click.on(BTN_SHOP_CAR),
                SelectListArticle.on(),
                WaitUntil.the(BTN_DELETE, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_DELETE),
                WaitUntil.the(BTN_DELETE_SELECT, isVisible()).forNoMoreThan(30).seconds(),
                Check.whether(WebElementQuestion.stateOf(BTN_DELETE_SELECT), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_DELETE_SELECT)).otherwise(),
                SelectListArticle.on(),
                WaitUntil.the(BTN_DELETE, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_DELETE),
                HoldOnFor.thisSeconds(20),
                Check.whether(WebElementQuestion.stateOf(BTN_DELETE_SELECT), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_DELETE_SELECT)).otherwise(),
                Click.on(BTN_GO_TO_FITS)
        );

    }

    public static Performable go() {
        return Instrumented.instanceOf(CleanCar.class).withProperties();
    }

}