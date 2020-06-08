package com.router.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;


public class Social_Security_Handler {

    private static  HttpURLConnection connection = null;
    private static String result ="";


    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URL url = new URL("https://www.ssa.gov/appeals/DataSets/01_NetStat_Report.xml");
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15*1000);
        connection = (HttpURLConnection) url.openConnection();


        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            result = br.lines().collect(Collectors.joining());
            resp.setStatus(200);
            resp.setHeader("Content-Type", "application/xml");
            resp.setContentType("application/xml");
            resp.getOutputStream().println(result);
        }finally {
            connection.disconnect();
            connection.getInputStream().close();
            connection.getOutputStream().close();
        }



    }

    public static void getFieldOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URL url = new URL("https://www.ssa.gov/open/data/FO-Address-Open-Close-Times.csv");
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15*1000);
        connection = (HttpURLConnection) url.openConnection();


        try(BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            result = bufferedReader.lines().collect(Collectors.joining("\n"));
            resp.setStatus(200);
            resp.setHeader("Content-Type", "text/csv");
            resp.setContentType("text/csv");
            resp.getOutputStream().print(result);
        }finally {
            connection.disconnect();
            connection.getInputStream().close();
            connection.getOutputStream().close();
        }


    }


}
