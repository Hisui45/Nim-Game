package player;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stick extends ImageView {
	
	public Stick(int dimension) {
	
		File file = new File(System.getProperty("user.dir")+"\\NimGame\\resources\\stick_image.png");
		String localUrl = null;
		try {
			localUrl = file.toURI().toURL().toString();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		Image logo = new Image(localUrl, dimension, dimension, false, false);
	
		this.setImage(logo);
		
	}
}
