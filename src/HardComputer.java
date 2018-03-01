import java.util.*;

public class HardComputer extends Player {
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board = new Hashtable();
	public static final String PLAYER_NAME = "Computer ";
	
	public HardComputer() {
		playerID = 1;
	}
	
	public HardComputer(int id) {
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