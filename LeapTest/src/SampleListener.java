import java.util.ResourceBundle.Control;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;


public class SampleListener extends Listener {

	public SampleListener() {
		// TODO Auto-generated constructor stub
	}
	
	public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onFrame(Controller controller) {
        Frame frame = controller.frame();

        System.out.println("Frame id: " + frame.id()
                       + ", timestamp: " + frame.timestamp()
                       + ", hands: " + frame.hands().count()
                       + ", fingers: " + frame.fingers().count());
    }

}
