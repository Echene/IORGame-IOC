/*Classe LeapArm 
 * Desc : Classe Principale (d�faut)
 * By : Lo�c MONOT
 * Date : 08/05/2016
 * Group : Lo�c MONOT / Pierre-Antoine CHARPENTIER
 * Section : LP SIL IDSE 2016
*/

import java.io.IOException;

import com.leapmotion.leap.Controller;

import CommRS232.ConnectRS232;
import leapMotion.LeapListener;

public class LeapArm {
	public static void main(String[] args) throws Exception {
		
		// Instanciation de la classe RS232
		ConnectRS232 cr232 = new ConnectRS232();
		
		//cr232.connect("COM4"); // Veuillez indiquer le port de comunication... ex:"COM4"
		
		// Instanciation des classes LeapMotion 
    	LeapListener listener = new LeapListener();
        Controller controller = new Controller();

        // Initialisation du THREAD LeapMotion
        controller.addListener(listener);

        // Destruction du THREAD LeapMotion
        controller.removeListener(listener);
	}
}