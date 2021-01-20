package player;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerController {
	
	private StartView startView;
	private PlayerModel playerModel;
	private GameView gameView;
	

	public PlayerController(PlayerModel model) {
		this.playerModel = model;
	}

	public void setViews(StartView startView) {
		this.startView = startView;
		this.gameView = new GameView();
		
		startView.buttonPlayGame.setOnAction(this :: startGame);
		startView.buttonInstructions.setOnAction(this :: showInstruction);
		
	}
	
	
	public void startGame(ActionEvent e) {
		Optional<ButtonType> chooseName = this.gameView.playerName.showAndWait();
	     if (chooseName.get() == ButtonType.OK) {
	    	 this.gameView.playerOne.setText(this.gameView.inputName.getText());
	    	 
	    	 this.gameView.inputName.clear();
	     }
	     
		Stage gameStage = new Stage();
		Scene gameScene =  new Scene(this.gameView, 615, 600);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Nim");
		gameStage.show();
		this.startView.stage.close();
		
		Random playerChooser = new Random();
		int playerDecision = playerChooser.nextInt((26 - 1)+ 1) + 1;
		
		if(playerDecision % 2 == 0) {
			this.gameView.firstTurn.setText(this.gameView.playerOne.getText());
		}else {
			this.gameView.firstTurn.setText("Computer");
		}
		   this.gameView.firstPlayer.showAndWait();
		   
		
		   
		Timer timer = new Timer();
		TimerTask task = new dynamic(gameScene, gameStage, playerModel);
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
