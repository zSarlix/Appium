package com.aliexpress.best.automation.task;


import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CANCEL;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CARRIED;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CONTINUER;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_DETAILS;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_INITIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.aliexpress.best.automation.interaction.SearchScroll;
import com.aliexpress.best.automation.interaction.SelectionPromo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class SearhWithRecomend implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        actor.attemptsTo(
                SearchScroll.on(),
                SelectionPromo.on(),
                WaitUntil.the(BTN_CARRIED, isVisible()).forNoMoreThan(150).seconds(),
                Click.on(BTN_CARRIED),
                Check.whether(WebElementQuestion.stateOf(BTN_CONTINUER), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_CONTINUER)).otherwise(),
                Check.whether(WebElementQuestion.stateOf(BTN_CANCEL), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_CANCEL)).otherwise(),
                WaitUntil.the(BTN_DETAILS, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_DETAILS),
                WaitUntil.the(BTN_INITIO, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_INITIO)

        );


    }
    public static Performable go() {
        return Instrumented.instanceOf(SearhWithRecomend.class).withProperties();
    }


}
