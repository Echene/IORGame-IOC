package com.unice.ioc;


import java.net.HttpURLConnection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Commandes implements KeyListener {

    private final String USER_AGENT = "Mozilla/5.0";

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        String ordre = "";
        String url = "";

        try{

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=1";
                ordre = "UP";

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=0&x3=1";
                ordre = "DOWN";

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=0";
                ordre = "LEFT";

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=0";
                ordre = "RIGHT";

            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=1";
                ordre = "SPACE";

            } else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                url = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=1";
                ordre = "CONTROL";

            } else {

            }



            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add request header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " +  ordre);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        } catch (Exception ex){
            System.out.print(ex);
        }
    }


    public void keyReleased(KeyEvent e) {

    }
}
