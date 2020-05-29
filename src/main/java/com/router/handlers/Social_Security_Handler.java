package com.router.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Social_Security_Handler {

    private static final Gson GSON = new GsonBuilder().create();

    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json ="";

        URL url = new URL("https://www.ssa.gov/appeals/DataSets/01_NetStat_Report.xml");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);


        try (InputStream inputStream = connection.getInputStream()) {

            json = GSON.toJson(inputStream.toString());
            connection.disconnect();
        }



        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(json);

    }



}
