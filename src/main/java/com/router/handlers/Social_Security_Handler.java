package com.router.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;


public class Social_Security_Handler {

    private static URL url = null;
    private static  HttpURLConnection connection = null;

    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        url = new URL("https://www.ssa.gov/appeals/DataSets/01_NetStat_Report.xml");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setReadTimeout(15*1000);
        connection.connect();

        String result ="";

        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
            result = br.lines().collect(Collectors.joining());
            resp.setStatus(200);
            resp.setHeader("Content-Type", "application/xml");
            resp.getOutputStream().println(result);
        }

            connection.disconnect();
    }
    public static void getFieldOfficeList(HttpServletRequest req, HttpServletResponse resp){




    }
    public void toDatabase(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/social_security_data";
        String pin = "student";
        String password = "student";

        try(Connection connection = DriverManager.getConnection(url,pin,password)){




        }



    }
}
