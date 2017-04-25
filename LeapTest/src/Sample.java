import java.io.IOException;
import java.util.Scanner;

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

        Listener objListener = new Listener();
        objListener.onConnect(controller);
        objListener.onFrame(controller);
        
        // Keep this process running until Enter is pressed
        int text;
        try {
        	Scanner lectureClavier = new Scanner(System.in);
        	text = lectureClavier.nextInt();
            if(text == 1){
                // Remove the sample listener when done
                controller.removeListener(listener);	
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       /* public void onConnect(Controller controller) {
            System.out.println("Connected");
            controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        }*/
    }
}
