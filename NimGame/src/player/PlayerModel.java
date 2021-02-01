package player;

import java.util.Random;
import java.util.logging.Logger;

import javafx.application.Platform;

public class PlayerModel {
	
	private GameView gameView;
	private int firstTurn;
	private PlayerController playerController;
	public boolean enter;
	public boolean press;
	private static final Logger logger = Logger.getLogger("");
	
	public PlayerModel(GameView gameView, PlayerController playerController) {
		this.gameView = gameView;
		this.playerController = playerController;
	}
	
	
	public String pickFirst() {
		
		Random playerChooser = new Random();
		int playerDecision = playerChooser.nextInt((26 - 1)+ 1) + 1;
		
		if(playerDecision % 2 == 0) {
			firstTurn = 0;
			return this.gameView.playerOne.getText();
		}else {
			firstTurn = 1;
			return "Computer";
		}
	
	}
	public void playGame() {
		//Populate Sticks
		
		
		GameManager console = new GameManager();		
		console.start();
        
	}
	
	public void startSticks() throws InterruptedException {
		synchronized(this) 
        { 
			Platform.runLater(new Runnable() {
	             @Override public void run() {
	            	 if(firstTurn == 1) {
	            		 gameView.roundChanges.setText(gameView.playerOne.getText() +" enter the starting number of sticks. (6-28)");
	            	 }else {
	            		 gameView.roundChanges.setText(gameView.playerTwo.getText() +" will pick the starting number of sticks. (6-28)");
	            	 }
	            		
	             }
	         });
		
            logger.info("Prompting for Stating Stick Amount...");

            // releases the lock on shared resource 
            wait(); 

            // and waits till some other method invokes notify(). 
           logger.info("Sticks Have Generated."); 
       //    gameView.roundChanges.setText("Next Player: How many sticks will you take?");
        } 
		
	
	}
	
	public void getStartSticks() throws InterruptedException {
			
			Thread.sleep(1000);
			
			synchronized(this){ 
				
	            logger.info("Waiting for Starting Stick Count...");
	            this.press = false;
	         
	                while(!press) {
	                	Thread.sleep(100);
	                }
	                notify();
	        } 
			
		}
	
	public void promptForInput() throws InterruptedException {
		
		synchronized(this) 
        { 
			Platform.runLater(new Runnable() {
	             @Override public void run() {
	            		gameView.roundChanges.setText("How many sticks will you take?");
	             }
	         });
		
            logger.info("Prompting for Stick Count...");

            // releases the lock on shared resource 
            wait(); 

            // and waits till some other method invokes notify(). 
           logger.info("Sticks Have Been Handled."); 
       //    gameView.roundChanges.setText("Next Player: How many sticks will you take?");
        } 
		
	}
	
	
	
	public void getInput() throws InterruptedException {
		
		Thread.sleep(1000);
		
		synchronized(this){ 
			
            logger.info("Waiting for Stick Count...");
            this.press = false;
         
                while(!press) {
                	Thread.sleep(100);
                }
                notify();
        } 
		
	}
	
//	public void checkForEnter(KeyEvent e) throws InterruptedException {
//		logger.info("Recieved Stick Count...");
//		if(this.playerController.checkUserInput == true) {
//			this.gameView.roundChanges.setText("Player has choosen to take "+ this.gameView.userInput.getText() + " sticks." );
//			removeSticks(this.gameView.userInput.getText());
//			PlayerModel.enter = true;
//		}else {
//			this.gameView.roundChanges.setText("Please enter " );
//		}
//	}
//	
	

//	public class FirstPlayer extends Thread {
//		
//		
//		public void run() {
//			
//			try {
//				promptForInput();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public class SecondPlayer extends Thread {
//		
//		
//		public void run() {
//			try {
//				//promptForInput();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	}
//	


	
	class GameManager extends Thread {
		
		public void run() {
			
			//Getting Starting Amount
			Thread startPrompt = new Thread(new Runnable(){ 
	            @Override
	            public void run(){ 
	                try{ 
	                   startSticks();
	                }catch(InterruptedException e){ 
	                    e.printStackTrace(); 
	                } 
	            } 
	        });
			
			 Thread startAnswer = new Thread(new Runnable(){ 
		            @Override
		            public void run(){ 
		            	
		                try{ 
		                    getStartSticks(); 
		                } 
		                catch(InterruptedException e){ 
		                    e.printStackTrace(); 
		                } 
		            } 
		        }); 
		  
		        // Start both threads 
		        startPrompt.start(); 
		        startAnswer.start(); 
		  
		        // t1 finishes before t2 
		        try {
		        	startPrompt.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        try {
		        	startAnswer.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  
			//Taking Sticks Away
			Thread t1 = new Thread(new Runnable(){ 
	            @Override
	            public void run(){ 
	                try{ 
	                   promptForInput(); 
	                }catch(InterruptedException e){ 
	                    e.printStackTrace(); 
	                } 
	            } 
	        });
			
			 Thread t2 = new Thread(new Runnable(){ 
		            @Override
		            public void run(){ 
		            	
		                try{ 
		                    getInput(); 
		                } 
		                catch(InterruptedException e){ 
		                    e.printStackTrace(); 
		                } 
		            } 
		        }); 
		  
		        // Start both threads 
		        t1.start(); 
		        t2.start(); 
		  
		        // t1 finishes before t2 
		        try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	

	            }
		
		
	            
		
		
	}
}
