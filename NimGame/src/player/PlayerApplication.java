package player;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayerApplication extends Application{

	private PlayerModel model;
	private StartView startView;
	private PlayerController controller;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		this.model = new PlayerModel();
		this.controller = new PlayerController(this.model);
		this.startView = new StartView(stage, this.controller);
		
		this.controller.setViews(this.startView);

		Scene scene = new Scene(this.startView, 600, 600);
		scene.getStylesheets().add(getClass().getResource("DefaultStyle.css").toExternalForm());

		stage.setScene(scene);
		stage.setTitle("Nim");

		this.startView.start();
		
	}

	public static void main(String[] args) {
		launch();
	
	}
}
