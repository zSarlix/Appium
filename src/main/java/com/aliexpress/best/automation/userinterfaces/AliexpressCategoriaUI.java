package com.aliexpress.best.automation.userinterfaces;

import com.aliexpress.best.automation.utils.DatosExcel;

import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AliexpressCategoriaUI {

    private static ArrayList<Map<String, String>> dataExcel;

    static {

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("ExcelDatos.xlsx", "XpathCategoria");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final Target BTN_CATEGORIA = Target.the("Go to category button").locatedBy(dataExcel.get(0).get("Categoria"));

    public static final Target BTN_ROPE_MUXER = Target.the("button choose woman clothes").locatedBy(dataExcel.get(0).get("RopaMujer"));

    public static final Target BTN_PANDAS_CALL = Target.the("Call search button").locatedBy(dataExcel.get(0).get("BandaCabello"));

    public static final Target BTN_SAILOR = Target.the("exit shopping").locatedBy(dataExcel.get(0).get("Salir"));


}
