import java.util.*;
/*
 * EasyComputer is a subclass of player, inherits all of the methods and overrides
 * move method so no user input is needed
 */
public class EasyComputer extends Player{
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	private int score = 0;
	
	/*
	 * constructor EasyComputer takes no 
	 * parameters and initializes the instance variables
	 */
	public EasyComputer() {
		playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	
	/*
	 * constructor EasyComputer
	 * @param id    initializes playerID with specified value
	 */
	public EasyComputer(int id) {
		playerID = id + 1;
		board = new Hashtable<String, Integer>();
	}
	/*
	 * @see Player#getPossibleMoves()
	 */
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	/*
	 * @see Player#getID()
	 */
	public int getID() {
		return playerID;
	}
	/*
	 * Overrides toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + playerID;
	}
	/*
	 * @see Player#setPossibleMoves(java.util.LinkedList)
	 */
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	/*
	 * overrides method move in superclass
	 * takes no parameters and returns nothing
	 * generates a random integer within the size of the hand
	 * adds selected card to the objectds board
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
	/*
	 * @see Player#getBoard()
	 */
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	/*
	 * @see Player#updateScore(int)
	 */
	public void updateScore(int add) {
		score += add;
	}
	/*
	 * @see Player#getScore()
	 */
	public int getScore() {
		return score;
	}
	/*
	 * @see Player#cardPlayed()
	 */
	public String cardPlayed() {
		return card;
	}
}