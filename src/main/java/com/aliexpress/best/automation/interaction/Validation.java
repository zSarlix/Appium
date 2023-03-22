package com.aliexpress.best.automation.interaction;


import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.LBL_TEXT;

import com.aliexpress.best.automation.models.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Validation implements Task {


        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                  WaitUntil.the(LBL_TEXT, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds()
            );
            Global.validation = LBL_TEXT.resolveFor(actor).getText();
        }
        public static Validation go() {
            return Tasks.instrumented(Validation.class);
        }
    }