package player;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameView extends BorderPane {
	
	public HBox topBar, sticks, firstRandomizer;
	public VBox centerBox;
	public Text playerOne, playerTwo, roundChanges, firstTurn;
	public TextField userInput, inputName;
	public Alert playerName, firstPlayer;

	public GameView() {
		topBar = new HBox();
		
		
		//Text(Player Names)
		
		playerOne = new Text("Hisui");
		playerTwo = new Text("Computer");
		
		topBar.getChildren().addAll(playerOne, playerTwo);
		HBox.setMargin(playerOne, new Insets(0,440, 0, 0));
		HBox.setMargin(playerTwo, new Insets(0, 0, 0, 30));
		
		this.setTop(topBar);
		BorderPane.setMargin(topBar, new Insets(15));
		
		//Input
		userInput = new TextField();
		
		this.setBottom(userInput);
		BorderPane.setMargin(userInput, new Insets(15));
		
		
		//Game Visual
		centerBox = new VBox();
		sticks = new HBox();
		sticks.setPrefSize(500, 500);
		sticks.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
		
		roundChanges = new Text(); 
		
		VBox.setMargin(sticks, new Insets(15));
		VBox.setMargin(roundChanges, new Insets(0, 0, 0, 250));
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
