package com.aliexpress.best.automation.userinterfaces;

import com.aliexpress.best.automation.utils.DatosExcel;

import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AliexpressSearchText {
    private static ArrayList<Map<String, String>> dataExcel;

    static {

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("ExcelDatos.xlsx", "XpathSearh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final Target BTN_SEARCH_BAR = Target.the("Seek Bar Button").locatedBy(dataExcel.get(0).get("SearhBar"));

    public static final Target BTN_TEXT_WRITE = Target.the("Click Bar Button").locatedBy(dataExcel.get(0).get("TextWrite"));

    public static final Target BTN_SEND_TEXT = Target.the("send text button").locatedBy(dataExcel.get(0).get("SendText"));

    public static final Target BTN_SELECT_FIRSTS = Target.the("select first button").locatedBy(dataExcel.get(0).get("SelectFirts"));


}
