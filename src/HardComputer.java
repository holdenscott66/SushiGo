import java.util.*;
/**
 * incomplete
 */
public class HardComputer extends Player {
	
	private LinkedList<String> allCards;
	private LinkedList<String>[] hands;
	public static final String PLAYER_NAME = "Computer ";
	
	/**
	 * constructor HardComputer
	 * @param id    initializes playerID with specified value
	 */
	public HardComputer(int id, LinkedList<String>[] hands ) {
		super(id + 1);
		this.hands = hands;
		for(int handNum = 0; handNum < hands.length; handNum++) {
			for(int card = 0; card < hands[handNum].size(); card++) {
				allCards.add(hands[handNum].get(card));
			}
		}
		allCards.sort(null);
		
	}
	
	/**
	 *toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + super.getID();
	}
	
	public void move() {
		
	}
}