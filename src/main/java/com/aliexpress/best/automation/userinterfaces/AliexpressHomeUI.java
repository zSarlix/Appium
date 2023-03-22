package com.aliexpress.best.automation.userinterfaces;

import com.aliexpress.best.automation.utils.DatosExcel;

import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class AliexpressHomeUI {

    private static ArrayList<Map<String, String>> dataExcel;

    static {

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("ExcelDatos.xlsx", "Xpath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final Target LBL_TEXT = Target.the("Validate output").locatedBy(dataExcel.get(0).get("Validation"));

    public static final Target BTN_PROMO = Target.the("Go to promo selection").locatedBy(dataExcel.get(0).get("PromoInvierno"));

    public static final Target BTN_ARTICLE = Target.the("Select an item button").locatedBy(dataExcel.get(0).get("Articulo"));

    public static final Target BTN_CARRIED = Target.the("upload file button").locatedBy(dataExcel.get(0).get("Carrito"));

    public static final Target BTN_CONTINUER = Target.the("Continue next position button").locatedBy(dataExcel.get(0).get("Continuar"));

    public static final Target BTN_CANCEL = Target.the("Cancel purchase button").locatedBy(dataExcel.get(0).get("Cancelar"));

    public static final Target BTN_DETAILS = Target.the("See details button").locatedBy(dataExcel.get(0).get("Detalles"));

    public static final Target BTN_INITIO = Target.the("go home button").locatedBy(dataExcel.get(0).get("Inicio"));

}


