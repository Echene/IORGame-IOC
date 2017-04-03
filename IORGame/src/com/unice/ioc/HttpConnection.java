package com.unice.ioc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;


public class HttpConnection {

    public static void main(String[] args) throws Exception {

        HttpConnection http = new HttpConnection();

        //System.out.println("Testing 1 - Send Http GET request");
        //http.sendGet();

        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();

        System.out.println("\nTesting - Send Http POST request");
        http.testPost();

    }

    private void testPost() throws Exception {
        String urlParameters = "";
        URL url = new URL("http://iotserver.univ-brest.fr/off.php");
        java.net.URLConnection conn = url.openConnection();

        conn.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write(urlParameters);
        writer.flush();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();
    }

}
