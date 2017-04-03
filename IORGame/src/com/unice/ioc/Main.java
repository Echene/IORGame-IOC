package com.unice.ioc;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {

        Commandes commandes = new Commandes();

        JFrame Win = new JFrame("IORGame");

        Win.addKeyListener(commandes);
        Win.setResizable(false);
        Win.setSize(900, 600);
        Win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Win.setVisible(true);
    }
}
