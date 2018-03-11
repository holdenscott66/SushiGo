import java.util.*;
/**
 * incomplete
 */
public class HardComputer extends Player {
	
	public static final String PLAYER_NAME = "Computer ";
	
	/**
	 * constructor HardComputer
	 * @param id    initializes playerID with specified value
	 */
	public HardComputer(int id) {
		super(id + 1);
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