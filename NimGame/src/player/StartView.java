package player;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartView extends BorderPane {

	private Stage stage;
	private Text title;
	private Button playGame, instructions;
	private VBox box;
	
	public StartView(Stage stage, PlayerController controller) {
		this.stage = stage;
		
		//Title
		this.title = new Text("Nim");
		title.setFont(Font.font("Arial"));
		this.title.setFont(Font.font("Casandra",200));
		
		
		
		//Buttons
		this.playGame = new Button("Start Playing!");
		this.instructions = new Button("How To Play");
		
		
		//View
		this.box = new VBox();
		box.getChildren().addAll(this.title, this.playGame, this.instructions);
		this.setCenter(box);
		VBox.setMargin(title, new Insets(0,0,30,100));
		VBox.setMargin(playGame, new Insets(0,0,40,230));
		VBox.setMargin(instructions, new Insets(0,0,0,230));
		
	}
	
	
	public void start() {
		this.stage.show();
	}
}
