package player;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GameView extends BorderPane {
	
	public HBox topBar, firstRandomizer, buttonBox;
	public FlowPane sticks;
	public VBox centerBox;
	public Text playerOne, playerTwo, roundChanges, firstTurn;
	public TextField userInput, inputName;
	public Alert playerName, firstPlayer;
	public Button buttonOne, buttonTwo, buttonThree;

	public GameView() {
		topBar = new HBox();
		
		
		//Text(Player Names)
		
		playerOne = new Text("Hisui");
		playerTwo = new Text("Computer");
		
		topBar.getChildren().addAll(playerOne, playerTwo);
		HBox.setMargin(playerOne, new Insets(0,400, 0, 0));
		HBox.setMargin(playerTwo, new Insets(0, 0, 0, 0));
		
		this.setTop(topBar);
		BorderPane.setMargin(topBar, new Insets(15,15, 0, 15));
		
		//Input
		this.buttonBox = new HBox();
		
		buttonOne = new Button("One (1)");
		//buttonOne.setPadding(new Insets(25));
		buttonTwo = new Button("Two (2)");
		buttonThree = new Button("Three (3)"); 
		buttonBox.getChildren().addAll(buttonOne, buttonTwo, buttonThree);
		buttonBox.setSpacing(30);
		buttonBox.setMaxSize(445, 15);
		buttonBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
		
		userInput = new TextField();
		
		this.setBottom(userInput);
		
		BorderPane.setMargin(userInput, new Insets(0, 15, 15, 15));
		BorderPane.setMargin(buttonBox, new Insets(0, 15, 15, 35));
		
		
		//Game Visual
		centerBox = new VBox();
		sticks = new FlowPane();
		sticks.setVgap(10);
		sticks.setHgap(10);
		sticks.setPrefSize(400, 400);
		sticks.setPadding(new Insets(5));
		sticks.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
		
		roundChanges = new Text(); 
	//	roundChanges.setTextAlignment(TextAlignment.CENTER);
		
		VBox.setMargin(sticks, new Insets(15, 15, 7, 15));
		VBox.setMargin(roundChanges, new Insets(0, 0, 0, 125));
		centerBox.getChildren().addAll(sticks, roundChanges);
		
		this.setCenter(centerBox);
		
		playerName = new Alert(AlertType.INFORMATION);
		playerName.setTitle("Enter your username");
		playerName.setHeaderText("What's your username?");
		inputName = new TextField();
		playerName.getDialogPane().setContent(inputName);
		
		firstPlayer = new Alert(AlertType.INFORMATION);
		firstPlayer.setTitle("First Turn");
		firstPlayer.setHeaderText("This player will go first:");
		firstTurn = new Text();
		firstPlayer.getDialogPane().setContent(firstTurn);
			
	}
	
}
