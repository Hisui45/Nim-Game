package player;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stick extends ImageView {
	
	public Stick() {
	
		File file = new File(System.getProperty("user.dir")+"\\resources\\stick_image.png");
		String localUrl = null;
		try {
			localUrl = file.toURI().toURL().toString();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		Image logo = new Image(localUrl, 50, 50, false, false);
	
		this.setImage(logo);
		
	}
}
