package TEXTpackage;
import java.util.*;

/**
*This is the abstract superclass used by all types of players
*contains empty methods that will be used by subclasses 
*/

public abstract class Player {
	
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	private int score = 0;
	
	public Player() {
		this.playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	
	public Player(int playerID) {
		this.playerID = playerID;
		board = new Hashtable<String, Integer>();
	}
	
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	public int getID() {
		return playerID;
	}
	
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	
	public abstract void move(int turn) ;
	
	public abstract String toString() ;
	
	public Hashtable<String,Integer> getBoard() {
		return board;
	}

	public void setScore(int newScore) {
		score = newScore;
	}
	
	public void updateBoard() {
		if(board.containsKey(card)) {
			board.replace(card, (board.get(card) + 1));
		}
		else {
			board.put(card, 1);
		}
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setBoard(Hashtable<String, Integer> newBoard) {
		this.board = newBoard;
	}
	
	protected void setCardPlayed(String card) {
		this.card = card;
	}
	
	public String getCardPlayed() {
		return card;
	}
}