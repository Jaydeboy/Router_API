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

    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URL url = null;
        BufferedReader br = null;
        HttpURLConnection connection = null;

        try {
            url = new URL("https://www.ssa.gov/appeals/DataSets/01_NetStat_Report.xml");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setReadTimeout(15*1000);
            connection.connect();

            String result ="";

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            result = br.lines().collect(Collectors.joining());
            resp.setStatus(200);
            resp.setHeader("Content-Type", "application/xml");
            resp.getOutputStream().println(result);

        }catch (IOException e) {
            e.printStackTrace();
            resp.setStatus(404);

        }finally{
            br.close();


        }



    }


}
