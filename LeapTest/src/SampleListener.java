import java.util.ResourceBundle.Control;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;
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
        //HandList hands = frame.hands();
        
        //Hand leftmost = hands.leftmost();

        System.out.println("Frame id: " + frame.id()
                       + ", timestamp: " + frame.timestamp()
                       + ", hands: " + frame.hands().count()
                       + ", fingers: " + frame.fingers().count());
                       //+ ", left: " + leftmost);
    }

}
