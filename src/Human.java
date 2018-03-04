import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Class human is a subclass of Player.
 * Defines all methods that a human player object uses
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
	
	/**
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
	
	/**
	*The getPossibleMoves method is the getter for the possibleMoves
	*variable after it has been set
	*@return possibleMoves that is set by the setter method setPossibleMoves
	*/
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	/**
	 * getID returns the id of the player object
	 * @return playerID  int value of player
	 */
	public int getID() {
		return playerID;
	}
	
	/**
	*The setPossibleMoves is a method that assigns the possibleMoves variable 
	*to the hand parameter
	*@param hand 	is from the Deck class and has the cards that are in the 
	*		player's hand that are used to determine what the player's
	*		possible moves are
	*/
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	
	/**
	 * toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + playerID;
	}
	/**
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
	/**
	 * returns the hashtable of cards that the player object has chosen
	 * @return board     returns hashtable board
	 */
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	/**
	 * updateScore adds a value to the player object's current score
	 * @param int add      the value added to score
	 */
	public void updateScore(int add) {
		score += add;
	}
	/**
	 * getScore method returns value of the player object's current score
	 * @return score   returns int value of score
	 */
	public int getScore() {
		return score;
	}
	/**
	*The method cardPlayed just returns the card that is played
	*@return 	the card that is chosen to be placed on the board
	*/
	public String cardPlayed() {
		return card;
	}
}