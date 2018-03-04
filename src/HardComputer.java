import java.util.*;
/**
 * incomplete
 */
public class HardComputer extends Player {
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	public static final String PLAYER_NAME = "Computer ";
	private int score = 0;
	/**
	 * constructor HardComputer takes no 
	 * parameters and initializes the instance variables
	 */
	public HardComputer() {
		playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	/**
	 * constructor HardComputer
	 * @param id    initializes playerID with specified value
	 */
	public HardComputer(int id) {
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
	 *toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + playerID;
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
	 * takes no parameters and returns nothing
	 * generates a random integer within the size of the hand
	 * adds selected card to the objects board
	 */
	public void move() {
		
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