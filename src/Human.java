import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class Human extends Player {
	
	private LinkedList<String> possibleMoves;
	private int selection;
	private Scanner user_input;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board = new Hashtable();
	public static final String PLAYER_NAME = "Player ";
	private int score = 0;
	
	public Human() {
		playerID = 1;
	}
	
	public Human(int id) {
		playerID = id + 1;
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
	
	public String toString() {
		return PLAYER_NAME + playerID;
	}
	public void move() {
		user_input = new Scanner(System.in);
		do {
            System.out.println(this.toString() + ", Enter the number of the card you choose:");
            while (!user_input.hasNextInt()) {
                String input = user_input.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            selection = user_input.nextInt();
        } while (selection > (possibleMoves.size()) || selection < 1);
		
		card = possibleMoves.get(selection - 1);

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