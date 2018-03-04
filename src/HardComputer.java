import java.util.*;
/*
 * incomplete
 */
public class HardComputer extends Player {
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	public static final String PLAYER_NAME = "Computer ";
	
	/*
	 * constructor HardComputer takes no 
	 * parameters and initializes the instance variables
	 */
	public HardComputer() {
		playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	/*
	 * constructor HardComputer
	 * @param id    initializes playerID with specified value
	 */
	public HardComputer(int id) {
		playerID = id + 1;
		board = new Hashtable<String, Integer>();
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
	
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	
	public void move() {
		
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
	
	public String cardPlayed() {
		return card;
	}
}