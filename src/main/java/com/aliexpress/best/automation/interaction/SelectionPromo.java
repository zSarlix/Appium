package com.aliexpress.best.automation.interaction;



import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_PROMO;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;

public class SelectionPromo implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> list;
        list = BTN_PROMO.resolveAllFor(actor);

            list.get(0).click();

    }
    public static Performable on(){
        return Instrumented.instanceOf(SelectionPromo.class).withProperties();
    }
}
