import java.util.*;

public class EasyComputer extends Player{
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board = new Hashtable();
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	private int score = 0;
	
	/**
	*The getPossibleMoves method is the getter for the possibleMoves
	*variable after it has been set
	*@return possibleMoves that is set by the setter method setPossibleMoves
	*/
	public EasyComputer() {
		playerID = 1;
	}
	
	public EasyComputer(int id) {
		playerID = id + 1;
	}
	
	
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	public int getID() {
		return playerID;
	}
	
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