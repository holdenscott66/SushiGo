import java.util.Scanner;

/**
 * GamePlay class is the game iterating through turns and calling all necessary methods. 
 */
public class GamePlay {
	private Player[] players;
	int numPlayers;
	boolean again;
	private FinalScore scoreBoard;
	private static Scanner user_input;
	private GameConfiguration game;
/**
 * GamePlay constructor, initializes the instance variables, and calls the play method to run the game
 * @param game   the object of gameConfiguration containing required information and methods. 
 */
	public GamePlay(GameConfiguration game1) {
		game = game1;
		players = game.getPlayers();
		numPlayers = players.length;
		scoreBoard = new FinalScore(game);
		do {
			play(numPlayers);
			playAgain();
		} while (again = true);
	}
/**
 * play method iterates for how ever many cards are in each hand for each player (2-4)
 * after the player chooses a move, hands and boards are updated and displayed. 
 * after each round, the hands alternate by one. 
 * 
 * @param numPlayers   the number of players in the game to determine how many 
 * 			times to alternate hands and which players get which hands
 * @param game       the gameConfiguration object which contains all of the methods 
 * 					to play the game
 * 
 * uses for loop to check that all hands are empty, if true, breaks from loop.
 * 
 * then creates an instance of FinalScore to calculate the scores of the players after 10 rounds
 */
	private void play(int numPlayers) {
		int handNum;
		int turn = 0;
		boolean gameEnd = false;
		while(gameEnd == false) {
			turn++;
			for(int count = 0; count < numPlayers; count++) { //count is the player for which the methods are being called
				handNum = turn % numPlayers; //turn % numPlayers is the value of the hand used. Each iteration increases turn by one, thus increasing handNum by 1
				players[count].setPossibleMoves(game.getHand((count + handNum) % numPlayers)); //increases the value used by getHand() based on the player
				game.displayHand(players[count], (count + handNum) % numPlayers);
				players[count].move(turn);
				game.updateHand(count, (count + handNum) % numPlayers);
			}
			for(int hand = 0; hand < numPlayers; hand++) {
				if(game.getHand(hand).isEmpty())
					gameEnd = true;
				else {
					gameEnd = false;
				}
			}
		}
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
			scoreBoard.calcScore();
	}
	
	private boolean playAgain() {
		int selection;
		user_input = new Scanner(System.in);
		do {
			System.out.print("Would you like to play again? \n 1) Yes \n 2) No");
           while (!user_input.hasNextInt()) {
               String input = user_input.next();
               System.out.printf("\"%s\" is not a valid number.\n", input);
           }
           selection = user_input.nextInt();
        } while (selection < 1 || selection > 2);
		if(selection == 1) {
			again = true;
			game.newGame(numPlayers);
		}
		else
			again = false;
		return again;
	}
}