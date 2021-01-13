import java.util.Scanner;
import java.util.Random;
public class NimProgram {
	
	
	//bd54f18cc2512efd94002fca168d888fba30db62
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		boolean sessionStart = false;
		boolean playGame = true;
		System.out.println("=========**====== Welcome to Nim! ================");
		
	while(playGame==true){
		
		if(sessionStart==false){
			String userAnswerPlay;
			System.out.println("Do you know how to play Nim?(Y/N)");
			userAnswerPlay = keyboard.nextLine();
			if(userAnswerPlay.equalsIgnoreCase("Y")||userAnswerPlay.equalsIgnoreCase("Yes")){
				System.out.println("Alright... no need for instructions then.");
			}else if (userAnswerPlay.equalsIgnoreCase("N")||userAnswerPlay.equalsIgnoreCase("No")){
				System.out.println("How To Play:");
				System.out.println("The player that goes second will choose a number of toothpicks between 6 and 28. Player A can only remove 1, 2, or 3 toothpicks.");
				System.out.println("Player B can then remove 1, 2 or 3 toothpicks. This process keeps repeating, ");
				System.out.println("alternating between players A and B until there are no more toothpicks left. ");
				System.out.println("The player that removed the last toothpick is the loser.");
			}else{
				
			}
			System.out.println("So...would you like to play a game of Nim? (Y/N)");
			String userAnswer = keyboard.nextLine();
			
				if(userAnswer.equalsIgnoreCase("Y")||userAnswer.equalsIgnoreCase("Yes")){
					sessionStart = true;
					NimGame();
				}else if(userAnswer.equalsIgnoreCase("N")||userAnswer.equalsIgnoreCase("No")){
					System.out.println("Awww.... maybe next time.");
					playGame = false;
				}
				
		}else if(sessionStart==true){
			System.out.println("Would you like to play another game of Nim? (Y/N)");
			String userAnswer = keyboard.nextLine();
				if(userAnswer.equalsIgnoreCase("Y")||userAnswer.equalsIgnoreCase("Yes")){
					NimGame();
				}else if(userAnswer.equalsIgnoreCase("N")||userAnswer.equalsIgnoreCase("No")){
					System.out.println("Awww.... well thanks for playing!");
					playGame = false;
				}
		}
	}
	
		
		
		
	}
	public static void NimGame(){
		
		//intialize variables
		boolean playerWentLast = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the player's name.");
		String userName = keyboard.nextLine();
		boolean computer = FirstPlayer(userName);
		Random pete = new Random();
		int numPicks = 0;
		int numRemovePicks;
		
		//picking number of toothpicks
		if(computer == true){
			System.out.println(userName+ " picks amount of toothpicks");
			System.out.println("Enter a number between 6 and 28.");
			numPicks = keyboard.nextInt();
			while(numPicks <6 || numPicks >28){
				System.out.println("Number is not in range. Try again");
				System.out.println("Enter a number between 6 and 28.");
				numPicks = keyboard.nextInt();
			}
		}else if(computer == false){
			System.out.println("Computer picks amount of toothpicks");
			numPicks = pete.nextInt((28 - 6)+ 1) + 6;
		}
		
		//meat of the game; removing toothpicks
		if(computer == true){
			numRemovePicks = pete.nextInt(2)+1;
			System.out.println("Computer's turn. There are " +numPicks+" left. Computer removes "+ numRemovePicks+ " toothpicks.");
			numPicks = numPicks - numRemovePicks;
			playerWentLast = false;
			
		}else if(computer == false){
			System.out.println(userName+"'s turn. There are " +numPicks+" left. How many will you remove?");
			numRemovePicks = keyboard.nextInt();
			while(numRemovePicks < 1 || numRemovePicks > 3){
				System.out.println("Invalid move. Pick again.");
				numRemovePicks = keyboard.nextInt();
			}
			numPicks = numPicks - numRemovePicks;
			playerWentLast = true;
		}
		while(numPicks != 0 && numPicks > 0){
			if(playerWentLast == false){
				System.out.println(userName+"'s turn. There are " +numPicks+" left. How many will you remove?");
				numRemovePicks = keyboard.nextInt();
				while(numRemovePicks < 1 || numRemovePicks > 3){
					System.out.println("Invalid move. Pick again.");
					numRemovePicks = keyboard.nextInt();
				}
				numPicks = numPicks - numRemovePicks;
				playerWentLast = true;
			}else if(playerWentLast == true){
				numRemovePicks = pete.nextInt(2)+1;
				System.out.println("Computer's turn. There are " +numPicks+" left. Computer removes "+ numRemovePicks+ " toothpicks.");
				numPicks = numPicks - numRemovePicks;
				playerWentLast = false;
			}
		//checking for winner		
		}
		if(playerWentLast == false){
			System.out.println("==========================================");
			System.out.println(userName + " Wins");
			System.out.println("------------------------------------------");
		}else if(playerWentLast==true){
			System.out.println("------------------------------------------");
			System.out.println("The Computer Wins");
		}
	
	}
	
	public static boolean FirstPlayer(String userName){
		//Deciding what player goes to go first
			boolean computer = true;
			Scanner keyboard3 = new Scanner(System.in);
			System.out.println("Which player will go first? Enter 'Computer' or '"+userName+"'");
		String userInput = keyboard3.nextLine();
		//computer equal zero or rather true
		if(userInput.equalsIgnoreCase("Computer")){
			computer = true;
			System.out.println("The Computer will go first.");
		}else if(userInput.equals(userInput)){
			computer = false;
			System.out.println(userName+ " will go first.");
		}
	
		return computer;
	}
	
}
