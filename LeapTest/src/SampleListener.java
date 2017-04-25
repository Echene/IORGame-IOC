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

        //HttpConection objHttp = new HttpConection();

        /*
        System.out.println("Frame id: " + frame.id()
                       + ", Timestamp: " + frame.timestamp()
                       + ", Hands: " + frame.hands().count()
                       + ", Fingers: " + frame.fingers().count()
                       + ", Palm: " + pointable.isExtended()
                       + ", Left: " + hand.isLeft()
                       + ", Right: " + hand.isRight()
                       + ", Direction " + hand.direction());
                       //+ ", left: " + leftmost);*/
        // Faire un Sleep pour exectuer l'action       
			
        try {
			TimeUnit.SECONDS.sleep(3);
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
