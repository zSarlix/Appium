package com.aliexpress.best.automation.interaction;

import static com.aliexpress.best.automation.userinterfaces.AliexpressShopCar.CHK_BOTON;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;

public class SelectListArticle implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> list;
        list = CHK_BOTON.resolveAllFor(actor);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).click();
        }
    }
    public static Performable on(){
        return Instrumented.instanceOf(SelectListArticle.class).withProperties();
    }
}
