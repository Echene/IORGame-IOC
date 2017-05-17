import java.io.IOException;
import java.util.ResourceBundle.Control;
import java.util.concurrent.TimeUnit;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Vector;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;


public class SampleListener extends Listener {
	
	public SampleListener() {
		// TODO Auto-generated constructor stub
	}
	
	public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onFrame(Controller controller) {
        Frame frame = controller.frame();
        HandList hands = frame.hands();
        Hand hand = hands.frontmost();
        
        Pointable pointable = frame.pointables().frontmost();
        Vector direction = pointable.direction();
        float length = pointable.length();
        float width = pointable.width();
        Vector stabilizedPosition = pointable.stabilizedTipPosition();
        Vector position = pointable.tipPosition();
        Vector speed = pointable.tipVelocity();
        float touchDistance = pointable.touchDistance();
        Pointable.Zone zone = pointable.touchZone();
        
        Hand handRight = frame.hands().rightmost();
		Hand handLeft = frame.hands().leftmost();

		Commandes objHttp = new Commandes();
        //HttpConection objHttp = new HttpConection();
		
		try{
			if (frame.hands().count() != 0)
			{
				TimeUnit.SECONDS.sleep(1);
				if(handRight.palmPosition().getZ() > 5)
				{
					objHttp.SendCommande("RECULER");
					System.out.println("Reculer");
				}
				else if(handRight.palmPosition().getZ() < -5)
				{
					objHttp.SendCommande("AVANCER");
					System.out.println("Avancer");
				}
				else if(handRight.palmPosition().getZ() == 0)
				{
					System.out.println("Rien");
				}
				
				 if (pointable.isExtended() == true) {
					 objHttp.SendCommande("OUVRIR");
			    	   System.out.println("Poignée ouvert");
				 }else if (pointable.isExtended() == false){
					 objHttp.SendCommande("FERMER");
			    	   System.out.println("Poignée fermer");
				 }	
				 if(handRight.palmPosition().getY() > 100.000){ 
					 objHttp.SendCommande("MONTER");
					 System.out.println("hauteur main  : haut");
				 }else if(handRight.palmPosition().getY() < 100.000 && handRight.palmPosition().getY() > 0.000){
					 objHttp.SendCommande("DESCENDRE");
					 System.out.println("hauteur main  : bas");
				 }
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		System.out.println("Frame id: " + frame.id()
        + ", Hands: " + frame.hands().count()
         + ", Fingers: " + frame.fingers().count()
         + ", Palm: " + pointable.isExtended()
         + ", Left: " + hand.isLeft()
         + ", Right: " + hand.isRight());*/

         //+ ", left: " + leftmost));
        // Faire un Sleep pour exectuer l'action       
			/*
        try {
			TimeUnit.SECONDS.sleep(2);
			 HttpConection objHttp = new HttpConection();
		        if (pointable.isExtended() == true) {
		    	   System.out.println("Poignée ouvert");  	  
		    	   try {
					objHttp.sendPost("http://iotserver.univ-brest.fr/robot.php", "?x1=0&x2=0&x3=0");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }else if (pointable.isExtended() == false){
		    	   System.out.println("Poignée fermer");
		    	   try {
					objHttp.sendPost("http://iotserver.univ-brest.fr/robot.php", "?x1=1&x2=0&x3=0");
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }
			}catch (Exception e) {
				// TODO: handle exception
			} 
*/
     // UTILISER THREAD
        // BAISSER/MONTER LE BRAS
        /*
        try {
			TimeUnit.SECONDS.sleep(1);
			 HttpConection objHttp = new HttpConection();
			 if(handRight.palmPosition().getY() > 100.000){
					System.out.println("hauteur main  : haut");
			    	   try {
			    		   // Envoie la commande main levé
							objHttp.sendPost("http://iotserver.univ-brest.fr/robot.php", "?x1=0&x2=1&x3=1");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}		
				 }else if(handRight.palmPosition().getY() < 100.000 && handRight.palmPosition().getY() > 0.000){
						System.out.println("hauteur main  : bas");
				    	   try {
				    		   // Envoie la commande main baissé
								objHttp.sendPost("http://iotserver.univ-brest.fr/robot.php", "?x1=1&x2=1&x3=1");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
				 }
			}catch (Exception e) {
				e.printStackTrace();
			}
	       */

        /*
        while(pointable.isExtended() == false)
        {
        // fermer poignée http://iotserver.univ-brest.fr/robot.php?x1=0&x2=0&x3=0
        }*/
   }

    
    
    public void OpenHand(Controller controller, HttpConection objHttp) {
    	Frame frame = controller.frame();
    	Pointable pointable = frame.pointables().frontmost();
        Boolean condition = pointable.isExtended();
    	while(condition == true) {
            try {
				objHttp.sendPost("x1=0&x2=0&x3=0", "http://iotserver.univ-brest.fr/robot.php?");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}
