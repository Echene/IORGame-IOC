import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Commandes implements KeyListener {



    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        String order = "";
        String URL = "";
        Boolean OK = true;

        HttpConnection httpConnection = new HttpConnection();

        try{

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=1";
                order = "Avancer - UP";

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=0&x3=1";
                order = "Reculer - DOWN";

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=0";
                order = "Gauche - LEFT";

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=0";
                order = "Droite - RIGHT";

            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=1";
                order = "Monter - SPACE";

            } else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=1";
                order = "Descendre - CONTROL";

            } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=0&x3=0";
                order = "Ouvrir - Z";

            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=0";
                order = "Fermer - S";

            } else {
                OK = false;
            }

            if (OK){
                httpConnection.sendOrder(URL, order);
            } else {
                System.out.println("Commande non reconnue");
            }


        } catch (Exception ex){
            System.out.print(ex);
        }
    }


    public void keyReleased(KeyEvent e) {

    }

    public void SendCommande(String commande) {

        String order = "";
        String URL = "";
        Boolean OK = true;

        HttpConnection httpConnection = new HttpConnection();

        try{

            if (commande == "AVANCER") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=1";
                order = "Avancer - UP";

            } else if (commande == "RECULER") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=0&x3=1";
                order = "Reculer - DOWN";

            } else if (commande == "GAUCHE") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=0";
                order = "Gauche - LEFT";

            } else if (commande == "DROITE") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=0";
                order = "Droite - RIGHT";

            } else if (commande == "MONTER") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=1&x3=1";
                order = "Monter - SPACE";

            } else if (commande == "DESCENDRE") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=1&x3=1";
                order = "Descendre - CONTROL";

            } else if (commande == "OUVRIR") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=1&x2=0&x3=0";
                order = "Ouvrir - Z";

            } else if (commande == "FERMER") {
                URL = "http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=0";
                order = "Fermer - S";

            } else {
                OK = false;
            }

            if (OK){
                httpConnection.sendOrder(URL, order);
            } else {
                System.out.println("Commande non reconnue");
            }


        } catch (Exception ex){
            System.out.print(ex);
        }
    }
}
