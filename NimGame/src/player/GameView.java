package player;

import java.awt.geom.Line2D;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
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
	
	public HBox topBar, sticks;
	public VBox centerBox;
	public Text playerOne, playerTwo, roundChanges;
	public TextField userInput;

	public GameView(PlayerModel model) {
		topBar = new HBox();
		
		
		//Text(Player Names)
		
		playerOne = new Text("Player One");
		playerTwo = new Text("Player Two");
		
		topBar.getChildren().addAll(playerOne, playerTwo);
		HBox.setMargin(playerOne, new Insets(0,440, 0, 0));
		HBox.setMargin(playerTwo, new Insets(0, 0, 0, 30));
		
		this.setTop(topBar);
		BorderPane.setMargin(topBar, new Insets(15));
		
		//Input
		userInput = new TextField();
		
		this.setBottom(userInput);
		BorderPane.setMargin(userInput, new Insets(15));
		
		
		//Visual
		centerBox = new VBox();
		sticks = new HBox();
		sticks.setPrefSize(500, 500);
		sticks.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
		
		
		roundChanges = new Text("Hisui took 3 sticks"); 
//		Node stick = new Stick();
//		sticks.getChildren().add(stick);
//		HBox.setMargin(stick, new Insets(15));
		VBox.setMargin(sticks, new Insets(15));
		VBox.setMargin(roundChanges, new Insets(0, 0, 0, 250));
		centerBox.getChildren().addAll(sticks, roundChanges);
		
		this.setCenter(centerBox);

		
	}
	
}
