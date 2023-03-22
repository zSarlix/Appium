package com.aliexpress.best.automation.userinterfaces;

import com.aliexpress.best.automation.utils.DatosExcel;

import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AliexpressShopCar {
    private static ArrayList<Map<String, String>> dataExcel;

    static {

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("ExcelDatos.xlsx", "XpathClean");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final Target BTN_SHOP_CAR= Target.the("Shopping cart button").locatedBy(dataExcel.get(0).get("ShopCart"));

    public static final Target CHK_BOTON = Target.the("clickable button").locatedBy(dataExcel.get(0).get("CheckBoton"));

    public static final Target BTN_DELETE= Target.the("delete section button").locatedBy(dataExcel.get(0).get("Delete"));

    public static final Target BTN_DELETE_SELECT= Target.the("delete selected button").locatedBy(dataExcel.get(0).get("DeleteALL"));

    public static final Target BTN_GO_TO_FITS = Target.the("Go to first button").locatedBy(dataExcel.get(0).get("BackInicio"));


}
