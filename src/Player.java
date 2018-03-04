import java.util.*;

/**
*This is the Superclass used by all types of players
*contains empty methods that will be used by subclasses 
*/

public class Player {
	//instance variables
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	private int score = 0;
	
	/**
	*The getPossibleMoves method is the getter for the possibleMoves
	*variable after it has been set
	*@return possibleMoves that is set by the setter method setPossibleMoves
	*/
	
	
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	/*
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
	
	/* 
	 * empty method move, dependent on what subclass it is being used by. 
	 */
	public void move() {
		
	}
	
	/*
	 * empty method toString, dependent on what subclass it is being used by.
	 * will return a string value of the player's name and id
	 * @return null    returns null, will be overridden by subclasses 
	 */
	public String toString() {
		return null;
	}
	
	/*
	 * returns the hashtable of cards that the player object has chosen
	 * @return board     returns hashtable board
	 */
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	
	/*
	 * updateScore adds a value to the player object's current score
	 * @param int add      the value added to score
	 */
	public void updateScore(int add) {
		score += add;
	}
	
	/*
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