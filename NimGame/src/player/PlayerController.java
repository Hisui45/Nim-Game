package player;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerController {
	
	private StartView startView;
	private PlayerModel playerModel;
	private GameView gameView;
	private static final Logger logger = Logger.getLogger("CONTROLLER");
	public boolean checkUserInput = false;
	

	public PlayerController(StartView startView) {
		this.startView = startView;
		this.gameView = new GameView();
		this.playerModel = new PlayerModel(this.gameView, this);
		
		this.startView.buttonPlayGame.setOnAction(this :: startGame);
		this.startView.buttonInstructions.setOnAction(this :: showInstruction);
		
		this.gameView.userInput.setOnKeyPressed(this :: getStartValue);
		
		this.gameView.buttonOne.setOnAction(this :: getValue);
		this.gameView.buttonTwo.setOnAction(this :: getValue);
		this.gameView.buttonThree.setOnAction(this :: getValue);
		
		this.gameView.userInput.textProperty().addListener((observable, oldValue, newValue) -> checkUserInput(newValue));
	}


	public void startGame(ActionEvent e) {
		
		Optional<ButtonType> chooseName = this.gameView.playerName.showAndWait();
	     if (chooseName.get() == ButtonType.OK) {
	    	 this.gameView.playerOne.setText(this.gameView.inputName.getText());
	    	 
	    	 this.gameView.inputName.clear();
	     }
	     
		Stage gameStage = new Stage();
		Scene gameScene =  new Scene(this.gameView, 515, 520);
		gameScene.getStylesheets().add(getClass().getResource("DefaultStyle.css").toExternalForm());
		gameStage.setScene(gameScene);
		gameStage.setTitle("Nim");
		gameStage.show();
		this.startView.stage.close();
		
		this.gameView.firstTurn.setText(playerModel.pickFirst());
		this.gameView.firstPlayer.showAndWait();
		   
		this.playerModel.playGame();
		   
		//Timer timer = new Timer();
		//TimerTask task = new dynamic(gameScene, gameStage, playerModel);
		//timer.schedule(task, new Date(), 500);
		
		
	}
	
	public void showInstruction(ActionEvent e) {
		Stage instructionsStage = new Stage();
		Scene instructionsScene =  new Scene(new InstructionView(playerModel), 300, 300);
		instructionsStage.setScene(instructionsScene);
		instructionsStage.setTitle("How To Play");
		instructionsStage.initModality(Modality.APPLICATION_MODAL);
		instructionsStage.show();
	
	}
	
	public void checkUserInput(String newValue) {
		int userNum = 0;
		if(!(newValue.compareTo("") == 0)){
			userNum = Integer.valueOf(newValue);
		}
		
		this.gameView.userInput.getStyleClass().remove("userInputNotOK");
		this.gameView.userInput.getStyleClass().remove("userInputOK");
		if(userNum > 28 || userNum < 6) {
			this.gameView.userInput.getStyleClass().add("userInputNotOK");
			checkUserInput = false;
		}else {
			this.gameView.userInput.getStyleClass().add("userInputOK");
			checkUserInput = true;
		}
	}
	
	public void getStartValue(KeyEvent e)  {
		logger.info("Checking Recieved Stick Count...");
		int dimension = 85;
		if(e.getCode() == KeyCode.ENTER) {
			if(checkUserInput) {
				int sticks = Integer.valueOf(this.gameView.userInput.getText());
				
				this.gameView.roundChanges.setText("Player has choosen to start with "+ sticks + " sticks." );
				if(sticks>24) {
					dimension = 70;
				}else if(sticks>20) {
					dimension = 68;
				}
				
				for(int x = 0; x<sticks; x++) {
					Stick stick = new Stick(dimension);
					this.gameView.sticks.getChildren().add(stick);
				}
				this.playerModel.press = true;
				this.gameView.setBottom(this.gameView.buttonBox);
			}else {
				this.gameView.roundChanges.setText("Enter a number between 6 and 28 to start." );
			}
	
		}
	}
	
	public void getValue(ActionEvent e){
		logger.info(logger.getName()+": Recieved Stick Count...");
		int numSticks;
		if(e.getSource().equals(this.gameView.buttonOne)){
			numSticks = 1;
		}else if (e.getSource().equals(this.gameView.buttonTwo)){
			numSticks = 2;
		}else {
			numSticks = 3;
		}
			
		this.gameView.roundChanges.setText("Player has choosen to take "+ numSticks + " stick(s)." );
		for(int x = 0; x<numSticks; x++) {
			this.gameView.sticks.getChildren().remove(this.gameView.sticks.getChildren().size()-1);
		}
		this.playerModel.press = true;
	}
	
	class dynamic extends TimerTask {

		private Scene scene;
		private Stage stage;
		private PlayerModel playerModel;
		
		public dynamic(Scene scene, Stage stage, PlayerModel playerModel ){
			
			this.scene = scene;
			this.stage = stage;
			this.playerModel= playerModel;
		}
		@Override
		public void run() {
			 Platform.runLater(new Runnable() {
	             @Override public void run() {
	            	 scene = new Scene(new GameView(), 615, 600);
	         		 stage.setScene(scene);
	             }
	         });
			
			
		}
}

}
