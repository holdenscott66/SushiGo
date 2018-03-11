import java.util.*;

/**
*Represents the GameConfiguration class that is used to set up the game Sushi-Go
*This class uses methods from the Deck class to create a deck and hands for the players.
*This class creates turns and boards that are specific for each player
*This class uses objects in the Player class to create players
*Players can view the cards in their hand, can select a card to keep and place on their board,
*update the hand to remove the chosen card, and updates the board to reflect the player's choice
*The hands are then switched between players at the end of the turn and the board is displayed
*/

public class GameConfiguration {
	private Player[] players; 
	private LinkedList<String>[] hands;
	private Deck newDeck;
	
	
	/**
	*The GameConfiguration method creates the deck, the boards, an array of the player objects,
	* the player objects depending on the game typeand the hands
	*Takes in no parameters and does not return anything
	*/
	
	public GameConfiguration(int mode, int numPlayers) {
		players = new Player[numPlayers];
		newDeck = new Deck();
		hands = newDeck.setHand(numPlayers);
		if(mode == 1) {
			for(int count = 0; count < numPlayers; count++) {
				players[count] = new Human(count);
			}
		}
		else if(mode == 2) {
			players[0] = new Human();
			for(int count = 1; count < numPlayers; count++) {
				players[count] = new EasyComputer(count - 1);
			}
		}
		
		else if(mode == 3) {
			players[0] = new Human();
			for(int count = 1; count < numPlayers; count++) {
				players[count] = new HardComputer(count - 1);
			}
		}
	}
	
	/**
	*The getHand method returns a LinkedList of the hand depended on which hand number is specified
	*@param handNum    the int value of the required hand
	*@return the respective hand based on the parameter
	*/
	
	public LinkedList<String> getHand(int handNum) {
		return hands[handNum];
	}
	
	/**
	*The displayHand method displays the hand to the player
	*@param player 	is the player object, which determines
	*		the player's name
	*@param hand	is the hand that is currently assigned to 
	*		the player
	*/
	
	public void displayHand(Player player, int handNum) {
			System.out.println(player.toString() + ":" );
			for(int count = 0; count < hands[handNum].size(); count++) {
				System.out.println((count + 1) + ")" + "      " + hands[handNum].get(count));
			}
	}
	
	/**
	*The updateHands method is used to update the player's hand
	*after they've chosen which card to place on their board
	*This method removes the card they've chosen from their hand
	*@param playerNum 	which player in the Array
	*@param handNum	   which hand to update
	*/
	
	public void updateHand(int playerNum, int handNum) {
		hands[handNum].remove(players[playerNum].getCardPlayed());
	}	
	
	/*
	 * @return players     Array of player objects
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	/**
	*The displayBoard method is used to display the board with the cards
	*that have been added to it by the respective player
	*@param player 	is to distinguish which player is being selected so 
	*		that their board is displayed
	*No value is returned, rather the board is displayed showing that 
	*player's cards
	*/
	
	public void displayBoard(Player player) {
		Hashtable<String, Integer> board = new Hashtable<String, Integer>();
		System.out.println(player.toString() + "'s board:");
		board = player.getBoard();
		for (String val : ((Hashtable<String,Integer>) board).keySet()) {
		    System.out.println(val + ":" + board.get(val));
		}
	}
}