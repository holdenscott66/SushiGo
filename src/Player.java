import java.util.*;

/**
*This is the abstract superclass used by all types of players
*contains empty methods that will be used by subclasses 
*/

public abstract class Player {
	
	public abstract LinkedList<String> getPossibleMoves();
	
	public abstract int getID();
	
	public abstract void setPossibleMoves(LinkedList<String> hand);
	
	public abstract void move() ;
	
	public abstract String toString() ;
	
	public abstract Hashtable<String,Integer> getBoard();

	public abstract void updateScore(int add);
	
	public abstract int getScore();
	
	public abstract String cardPlayed();
}