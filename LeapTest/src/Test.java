import java.io.IOException;

import com.leapmotion.leap.*;

public class Test extends Listener{
	
	public void onConnect(){
		
	}

	public static void main(String[] args) {
		 Controller controller = new Controller();
		System.out.println("Press Enter to quit...");
        try {
            System.in.read();
            controller.frame();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
