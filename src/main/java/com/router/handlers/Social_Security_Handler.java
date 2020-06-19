package com.router.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


public class Social_Security_Handler {


    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        URL url = new URL("https://www.ssa.gov/appeals/DataSets/01_NetStat_Report.xml");
        HelperHandler.connectionEstablished(resp,url);
    }
    public static void getFieldOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URL url = new URL("https://www.ssa.gov/open/data/FO-Address-Open-Close-Times.csv");
        HelperHandler.connectionEstablished(resp,url);
    }


}
