package com.router.handlers;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

class HelperHandler {

    static void connectionEstablished(HttpServletResponse resp, URL url) throws IOException {
       HttpURLConnection connection = null;
       String result ="";

        connection.setRequestMethod("GET");
        connection.setReadTimeout(15*1000);
        connection = (HttpURLConnection) url.openConnection();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            result = br.lines().collect(Collectors.joining());
            resp.setStatus(200);
            resp.getOutputStream().println(result);
        }finally {
            connection.disconnect();
            connection.getInputStream().close();
            connection.getOutputStream().close();
        }

    }

}
