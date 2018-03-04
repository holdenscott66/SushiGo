import java.util.*;
/**
 * EasyComputer is a subclass of player
 * Defines all methods that an easy computer object uses
 */
public class EasyComputer extends Player{
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	private int score = 0;
	
	/**
	 * constructor EasyComputer takes no 
	 * parameters and initializes the instance variables
	 */
	public EasyComputer() {
		playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	
	/**
	 * constructor EasyComputer
	 * @param id    initializes playerID with specified value
	 */
	public EasyComputer(int id) {
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
		randNum = new Random();
		int cardNum = randNum.nextInt(possibleMoves.size());
		
		card = possibleMoves.get(cardNum);
		System.out.println(this.toString() + " chooses: " + card);
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