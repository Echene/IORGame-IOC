package com.unice.ioc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Commandes implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        HttpConnection httpConnection = new HttpConnection();

        try{

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=0&x2=0&x3=1");
                System.out.println("UP");
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=1&x2=0&x3=1");
                System.out.println("DOWN");
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=0&x2=1&x3=0");
                System.out.println("LEFT");
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=1&x2=1&x3=0");
                System.out.println("RIGHT");
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=0&x2=1&x3=1");
                System.out.println("SPACE");
            } else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                httpConnection.sendPost("http://iotserver.univ-brest.fr/robot.php?", "x1=1&x2=1&x3=1");
                System.out.println("CONTROL");
            }

        } catch (Exception ex){

        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
