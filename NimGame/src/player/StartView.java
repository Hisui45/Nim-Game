package player;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartView extends BorderPane {

	public Stage stage;
	public PlayerController controller;
	public Scene scene;
	private Text title;
	public Button buttonPlayGame, buttonInstructions;
	private VBox box;
	
	public StartView(Stage stage) {
		this.stage = stage;
		
		//Title
		this.title = new Text("Nim");
		title.setFont(Font.font("Arial"));
		this.title.setFont(Font.font("Casandra",200));
		
		
		
		//Buttons
		this.buttonPlayGame = new Button("Start Playing!");
		buttonPlayGame.setFont(Font.font(buttonPlayGame.getFont().getSize()+10));
		buttonPlayGame.setPadding(new Insets(10, 25, 10, 25));
		
		this.buttonInstructions = new Button("How To Play");
		buttonInstructions.setFont(Font.font(buttonInstructions.getFont().getSize()+10));
		buttonInstructions.setPadding(new Insets(10, 33, 10, 25));
		
		
		//View
		this.box = new VBox();
		box.getChildren().addAll(this.title, this.buttonPlayGame, this.buttonInstructions);
		this.setCenter(box);
		VBox.setMargin(title, new Insets(0,0,30,65));
		VBox.setMargin(buttonPlayGame, new Insets(0,0,40,155));
		VBox.setMargin(buttonInstructions, new Insets(0,0,0,155));
		
	}
	
	
	public void start() {
		this.stage.show();
	}
}
