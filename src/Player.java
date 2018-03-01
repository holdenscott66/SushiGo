import java.util.*;

/**
*Represents the player class in the game
*This class creates the instance of the player that is assigned to the user
*The player class will include the method for possibleMoves that determine
*whether a move is allowed or not
*This class also includes the card that is played
*/

public class Player {
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board = new Hashtable();
	
	/**
	*The getPossibleMoves method is the getter for the possibleMoves
	*variable after it has been set
	*@return possibleMoves that is set by the setter method setPossibleMoves
	*/
	
	
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	public int getID() {
		return playerID;
	}
	/**
	*The setPossibleMoves is a method that assogms the possibleMoves variable 
	*to the hand parameter
	*@param hand 	is from the Deck class and has the cards that are in the 
	*		player's hand that are used to determine what the player's
	*		possible moves are
	*/
	
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	
	public void move() {
		
	}
	
	public String toString() {
		return null;
	}
	/**
	*The move method asks the player which card they choose to place on their
	*board
	*This method checks to see if the user input is possible with the hand they have
	*@param player	is used to determine which player is making a move and what hand
	*		the player has to figure out if their move is possible
	*/
	
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	
	/**
	*The method cardPlayed just returns the card that is played
	*@return 	the card that is chosen to be placed on the board
	*/
	
	public String cardPlayed() {
		return card;
	}
}