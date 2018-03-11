import java.util.*;
/**
 * EasyComputer is a subclass of player
 * Defines all methods that an easy computer object uses
 */
public class EasyComputer extends Player{
	
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	
	/**
	 * constructor EasyComputer
	 * @param id    initializes playerID with specified value
	 */
	public EasyComputer(int id) {
		super(id + 1);
	}
	
	public String toString() {
		return PLAYER_NAME + super.getID();
	}
	
	public void move() {
		randNum = new Random();
		int cardNum = randNum.nextInt(super.getPossibleMoves().size());
		String card = super.getPossibleMoves().get(cardNum);
		super.setCardPlayed(card);
		super.updateBoard();
		System.out.println(this.toString() + " chooses: " + card);
		
	}
}