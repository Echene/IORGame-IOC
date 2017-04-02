import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpUrlReq {
	
	public HttpUrlReq(){}
	
	public void envoi(String instruction) throws IOException{
		
		final Logger logger = Logger.getLogger(HttpUrlReq.class.getName());
		String message = URLEncoder.encode(instruction, "UTF-8");
		URL objUrl = new URL("http://iotserver.univ-brest.fr/robot.php");
		HttpURLConnection connexion = (HttpURLConnection) objUrl.openConnection();
		
		connexion.setRequestMethod("POST");
		OutputStreamWriter writer = new OutputStreamWriter(connexion.getOutputStream());
		writer.write(message);
		writer.flush();
		
		if (connexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        // OK
			logger.log(Level.SEVERE,"Envoie reussi : "+connexion.getResponseCode());
	        // otherwise, if any other status code is returned, or no status
	        // code is returned, do stuff in the else block
	    } else {
	        // Server returned HTTP error code.
	    	logger.log(Level.SEVERE,"Echec : "+connexion.getResponseCode());
	    }
	}

}
