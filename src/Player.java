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
	private Hashtable<String, Integer> board = new Hashtable();
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
	 * @return playerID  int value of payer
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
	 * empty method move, 
	 */
	public void move() {
		
	}
	/*
	 * empty method toString
	 */
	public String toString() {
		return null;
	}
	
	
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	
	/**
	*The method cardPlayed just returns the card that is played
	*@return 	the card that is chosen to be placed on the board
	*/
	public void updateScore(int add) {
		score += add;
	}
	
	public int getScore() {
		return score;
	}
	
	public String cardPlayed() {
		return card;
	}
}