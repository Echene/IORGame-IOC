import java.io.IOException;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;

public class Sample {
    public static void main(String[] args) {
    	// Create a sample listener and controller
        SampleListener listener = new SampleListener();
        Controller controller = new Controller();

        controller.addListener(listener);
        // Have the sample listener receive events from the controller
        // controller.addListener(listener);
        
        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);
    
        Listener objListener = new Listener();
        objListener.onConnect(controller);
       /* public void onConnect(Controller controller) {
            System.out.println("Connected");
            controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        }*/
    }
}
