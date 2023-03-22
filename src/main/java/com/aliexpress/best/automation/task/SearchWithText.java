package com.aliexpress.best.automation.task;

import static com.aliexpress.best.automation.userinterfaces.AliexpressCategoriaUI.BTN_SAILOR;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CANCEL;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CARRIED;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_CONTINUER;
import static com.aliexpress.best.automation.userinterfaces.AliexpressHomeUI.BTN_INITIO;
import static com.aliexpress.best.automation.userinterfaces.AliexpressSearchText.BTN_SEARCH_BAR;
import static com.aliexpress.best.automation.userinterfaces.AliexpressSearchText.BTN_SELECT_FIRSTS;
import static com.aliexpress.best.automation.userinterfaces.AliexpressSearchText.BTN_SEND_TEXT;
import static com.aliexpress.best.automation.userinterfaces.AliexpressSearchText.BTN_TEXT_WRITE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.aliexpress.best.automation.utils.DatosExcel;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class SearchWithText implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        ArrayList<Map<String, String>> dataExcel;

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("ExcelDatos.xlsx", "DatosAliExpress");


        actor.attemptsTo(
                WaitUntil.the(BTN_SEARCH_BAR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SEARCH_BAR),
                WaitUntil.the(BTN_TEXT_WRITE, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(dataExcel.get(0).get("Search")).into(BTN_TEXT_WRITE),
                WaitUntil.the(BTN_SEND_TEXT, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SEND_TEXT),
                WaitUntil.the(BTN_SELECT_FIRSTS, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SELECT_FIRSTS),
                WaitUntil.the(BTN_CARRIED, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CARRIED),
                Check.whether(WebElementQuestion.stateOf(BTN_CONTINUER), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_CONTINUER)).otherwise(),
                Check.whether(WebElementQuestion.stateOf(BTN_CANCEL), WebElementStateMatchers.isVisible()).andIfSo(Click.on(BTN_SAILOR)).otherwise(),
                WaitUntil.the(BTN_SAILOR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SAILOR),
                WaitUntil.the(BTN_INITIO, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_INITIO)
        );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        public static Performable go() {
            return Instrumented.instanceOf(SearchWithText.class).withProperties();
        }


}