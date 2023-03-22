package com.aliexpress.best.automation.task;

import static com.aliexpress.best.automation.userinterfaces.AliexpressCategoriaUI.*;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

public class SearchWithCategory implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
        actor.attemptsTo(

                WaitUntil.the(BTN_CATEGORIA, isVisible()).forNoMoreThan(3).seconds(),
                Click.on(BTN_CATEGORIA),
                WaitUntil.the(BTN_ROPE_MUXER, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ROPE_MUXER)
                );

            Thread.sleep(10000);

        List< WebElementFacade > shortlist = BTN_PANDAS_CALL.resolveAllFor(actor);

            Thread.sleep(5000);

        actor.attemptsTo(
                Click.on(shortlist.get(1)),
                WaitUntil.the(BTN_CARRIED, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CARRIED),
                Check.whether(WebElementQuestion.stateOf(BTN_CONTINUER), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_CONTINUER)).otherwise(),
                Check.whether(WebElementQuestion.stateOf(BTN_SAILOR), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_SAILOR)).otherwise(),
                WaitUntil.the(BTN_INITIO, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_INITIO)
        );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Performable go() {
        return Instrumented.instanceOf(SearchWithCategory.class).withProperties();
    }

}