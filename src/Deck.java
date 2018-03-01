import java.util.*;

/**
*Represents the Deck that will be used in the game
*The Deck is comprised of 104 cards that will be used in the game
*The hand used to play the game will be created from the Deck
*/

public class Deck {

	private LinkedList<String> deckOfCards;
	private LinkedList<String>[] hands;
	private Random randCard;
	
	/**
	*The Deck method creates the deck by running through a for loop
	*that makes sure the appropriate amount of each card is added into
	*the deck.
	*This method does not take in any parameters and does not return 
	*anything
	*/
	
	public Deck() {
		deckOfCards = new LinkedList<String>();
		randCard = new Random();
		
		for(int cardNumber = 0; cardNumber < 14; cardNumber++) {
			deckOfCards.add("Dumpling");
		}
		
		for(int cardNumber = 0; cardNumber < 5; cardNumber++) {
			deckOfCards.add("EggNigiri");
		}
		
		for(int cardNumber = 0; cardNumber < 10; cardNumber++) {
			deckOfCards.add("SalmonNigiri");
		}
		
		for(int cardNumber = 0; cardNumber < 5; cardNumber++) {
			deckOfCards.add("SquidNigiri");
		}
		
		for(int cardNumber = 0; cardNumber < 26; cardNumber++) {
			deckOfCards.add("MakiRoll");
		}
		
		for(int cardNumber = 0; cardNumber < 14; cardNumber++) {
			deckOfCards.add("Sashimi");
		}
		
		for(int cardNumber = 0; cardNumber < 14; cardNumber++) {
			deckOfCards.add("Tempura");
		}
		
		for(int cardNumber = 0; cardNumber < 6; cardNumber++) {
			deckOfCards.add("Wasabi");
		}
			
		for(int cardNumber = 0; cardNumber < 10; cardNumber++) {
			deckOfCards.add("Pudding");
		}
	}
	
	/**
	*setHand method used to create a hand from the deck
	*Cards from the deck are taken at random, and once the card is
	*added to the hand, the card is removed from the deck
	*Takes in no parameters
	*@return the hand used to play the game
	*/
	
	public LinkedList<String>[] setHand(int numHands){
		hands = new LinkedList[numHands];
		for(int handNum = 0; handNum < numHands; handNum++) {
			LinkedList<String> hand = new LinkedList<String>();
			for(int count = 0; count < 10; count ++) {
				int cardNum = randCard.nextInt(deckOfCards.size());
				String newCard = deckOfCards.get(cardNum);
				hand.add(newCard);
				deckOfCards.remove(cardNum);
			}
			hands[handNum] = hand;
		}
		
		return hands;
	}
}