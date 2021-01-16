package player;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PlayerApplication extends Application{

	private PlayerModel model;
	private StartView startView;
	private PlayerController controller;
	protected Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		this.model = new PlayerModel();
		this.controller = new PlayerController(this.model);
		this.startView = new StartView(stage);
		
		this.controller.setViews(this.startView);

		scene = new Scene(this.startView, 600, 600);
		scene.getStylesheets().add(getClass().getResource("DefaultStyle.css").toExternalForm());

		stage.setScene(scene);
		stage.setTitle("Nim");

		this.startView.start();
		
		EventHandler<KeyEvent> refreshEvent = new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.R) {
					//stage.close();
					scene = new Scene(new StartView(stage), 600, 600);
					stage.setScene(scene);
				
				
					
				}
			}
		};
		
		
		stage.addEventHandler(KeyEvent.KEY_PRESSED, refreshEvent);
		
//		Timer timer = new Timer();
//		TimerTask task = new dynamic(scene, stage, controller);
//		timer.schedule(task, 5000, 5000);
		
	}
	 
	public static void main(String[] args) {
		launch();
	
	}
	
}

class dynamic extends TimerTask {

	private Scene scene;
	private Stage stage;
	private PlayerController controller;
	public dynamic(Scene scene, Stage stage, PlayerController controller ){
		
		this.scene = scene;
		this.stage = stage;
		this.controller = controller;
	}
	@Override
	public void run() {
		 Platform.runLater(new Runnable() {
             @Override public void run() {
            	 scene = new Scene(new StartView(stage), 600, 600);
         		stage.setScene(scene);
             }
         });
		
		
	}
	 
}
