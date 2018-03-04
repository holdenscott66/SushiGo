import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
/*
 * Class human is a subclass of Player. Inherits all the methods and overrides move, toString, and 
 */
public class Human extends Player {
	
	private LinkedList<String> possibleMoves;
	private int selection;
	private Scanner user_input;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	public static final String PLAYER_NAME = "Player ";
	private int score = 0;
	
	
	
	/*
	 * constructor Human takes no parameters 
	 * initializes the variables
	 */
	public Human() {
		playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	
	public Human(int id) {
		playerID = id + 1;
		board = new Hashtable<String, Integer>();
	}
	
	/*
	 * @see Player#getPossibleMoves()
	 */
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	/*
	 * @see Player#getID()
	 */
	public int getID() {
		return playerID;
	}
	
	/*
	 * @see Player#setPossibleMoves(java.util.LinkedList)
	 */
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	
	/*
	 * Overrides toString to return the player's name + id
	 * 
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + playerID;
	}
	/*
	 * overrides move method in superclass
	 * takes no parameters, and prompts user for input. 
	 * if selection is valid, it is removed from the hand and added to the player's board.
	 */
	public void move() {
		user_input = new Scanner(System.in);
		do {
            System.out.println(this.toString() + ", Enter the number of the card you choose:");
            while (!user_input.hasNextInt()) {
                String input = user_input.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            selection = user_input.nextInt();
        } while (selection > (possibleMoves.size()) || selection < 1);
		
		card = possibleMoves.get(selection - 1);

		if(board.containsKey(card)) {
			board.replace(card, (board.get(card) + 1));
		}
		else {
			board.put(card, 1);
		}
	}
	/*
	 * @see Player#getBoard()
	 */
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	/*
	 * @see Player#updateScore(int)
	 */
	public void updateScore(int add) {
		score += add;
	}
	/*
	 * @see Player#getScore()
	 */
	public int getScore() {
		return score;
	}
	/*
	 * @see Player#cardPlayed()
	 */
	public String cardPlayed() {
		return card;
	}
}