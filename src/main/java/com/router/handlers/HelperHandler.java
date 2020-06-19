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

        connection.setRequestMethod("GET");
        //sets the connection time for no response to 2 minutes (milliseconds)
        connection.setConnectTimeout(15*20000);
        //set the return data time
        connection.setReadTimeout(15*1000);
        //returns UrlConnection objects -- not this does not initiate a connection
        // an implied connection is establish when an inputstream is activated.
        connection = (HttpURLConnection) url.openConnection();

                ///Connects to the server and response is wrraped in a BufferReader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                //set the responseCode
                resp.setStatus(connection.getResponseCode());
                //sets the contenet type()
                resp.setContentType(connection.getContentType());
                // turns the input in a stream... collecting it into a string
                String result = br.lines().collect(Collectors.joining("\n"));
                //returns the string to the HTTPServlet outputstream
                resp.getOutputStream().println(result);

            } finally {
                //close the HttpURLConnection
                connection.disconnect();
                //close the inputStream assoicated with the URLconnection
                connection.getInputStream().close();
            }

    }

}
