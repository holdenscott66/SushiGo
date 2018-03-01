import java.util.*;

/**
*Represents the FinalScore class that is used to produce the final score once the game is over
*
*The FinalScore takes the cards that are on the boards of the players and adds up the points
*based on the cards on the board. The boards are compared to produce the result for the Pudding
*and Maki cards that add points based on who has the most of the respective cards
*
*Each card has a specific method to calculate their points based on the special rules attributed to
*the card.
*
*Once the scores are calculated, the player number and score are displayed
*/

public class FinalScore {
	Hashtable<String, Integer> playerBoard;
	Hashtable<String, Integer> opponentBoard1, opponentBoard2, opponentBoard3; 
	Hashtable<String, Integer>[] opponents;
	private int finalScore;
	
	/**
	*The method FinalScore takes in the player's specific boards where the cards they choose to
	*keep are stored.
	*This method calls on the card scoring methods to come up with a finalScore and prints the
	*final score beside the player it belongs to.
	*This method does not return anything
	*
	*@param game	This is the game object that is created from the GameConfiguration class
	*		This parameter is used to refer to the player's board and to be able to 
	*		compare the current player's board against their opponent to calculate
	*		special card scores that rely on comparing boards
	*
	*@param player	This is the player object from the game object that is used to determine
	*		the player number so that their boards can be assigned and compared 
	*		accurately
	*/
	
	public FinalScore(GameConfiguration game, Player player1, Player opponent1) {
		playerBoard = player1.getBoard();
		opponents = new Hashtable[1];
		opponents[0] = opponent1.getBoard();
		calcScore(player1);
	}
	
	public FinalScore(GameConfiguration game, Player player1, Player opponent1, Player opponent2) {
		playerBoard = player1.getBoard();
		opponents = new Hashtable[2];
		opponents[0] = opponent1.getBoard();
		opponents[1] = opponent2.getBoard();
		calcScore(player1);
	}
	
	public FinalScore(GameConfiguration game, Player player1, Player opponent1, Player opponent2, Player opponent3) {
		playerBoard = player1.getBoard();
		opponents = new Hashtable[3];
		opponents[0] = opponent1.getBoard();
		opponents[1] = opponent2.getBoard();
		opponents[2] = opponent3.getBoard();
		calcScore(player1);
	}
	
	private void calcScore(Player player) {
		dumplingScore();
		puddingScore();
		makiRollScore();
		sashimiScore();
		tempuraScore();
		wasabiNigiriScore();
		nigiriScore();
		System.out.println(player.toString() + "'s score: " + finalScore);
	}
	
	/**
	*The method dumplingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void dumplingScore() {
		switch(playerBoard.getOrDefault("Dumpling", 0)) {
		case 1:
			finalScore += 1;
			break;
		case 2:
			finalScore += 3;
			break;
		case 3:
			finalScore += 6;
			break;
		case 4:
			finalScore += 10;
			break;
		case 5:
			finalScore += 15;
			break;
		default:
			finalScore += 0;
			break;
		}
	}
	
	/**
	*The method puddingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void puddingScore() {
		boolean mostPudding = true;
		boolean leastPudding = true;
		for(int num = 0; num < opponents.length; num++) {
			if(playerBoard.getOrDefault("Pudding", 0) > opponents[num].getOrDefault("Pudding", 0))
				mostPudding = true;
			else {
				mostPudding = false;
				break;
			}
		}
		for(int num = 0; num < opponents.length; num++) {
			if(playerBoard.getOrDefault("Pudding", 0) < opponents[num].getOrDefault("Pudding", 0))
				leastPudding = true;
			else {
				leastPudding = false;
				break;
			}
		}
		if(mostPudding == true && leastPudding == false)
			finalScore += 6;
		else if(mostPudding == false && leastPudding == true)
			finalScore -= 6;
		else
			finalScore += 0;
		
	}
	
	/**
	*The method makiRollScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void makiRollScore() {
		boolean mostMaki = true;
		for(int num = 0; num < opponents.length; num++) {
			if(playerBoard.getOrDefault("MakiRoll", 0) > opponents[num].getOrDefault("MakiRoll", 0))
				mostMaki = true;
			else {
				mostMaki = false;
				break;
			}
		}
		if(mostMaki == true)
			finalScore += 5;
		else
			finalScore += 0;
	}
	
	/**
	*The method sashimiScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void sashimiScore() {
		finalScore += (playerBoard.getOrDefault("Sashimi", 0) / 3) * 10;
	}
	
	/**
	*The method tempuraScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void tempuraScore() {
		finalScore += (playerBoard.getOrDefault("Tempura", 0) / 2) * 5;
	}
	
	/**
	*The method nigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void nigiriScore() {
		finalScore += (playerBoard.getOrDefault("squidNigiri", 0) * 3);
		finalScore += (playerBoard.getOrDefault("SalmonNigiri", 0) * 2);
		finalScore += (playerBoard.getOrDefault("EggNigiri", 0) * 1);
	}
	
	/**
	*The method wasabiNigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void wasabiNigiriScore() {
		while(playerBoard.getOrDefault("Wasabi", 0) > 0) {
			if(playerBoard.getOrDefault("SquidNigiri", 0) > 0) {
				finalScore += 9;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SquidNigiri", (playerBoard.get("SquidNigiri") - 1));
			}
			else if (playerBoard.getOrDefault("SalmonNigiri", 0) > 0) {
				finalScore += 6;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SalmonNigiri", (playerBoard.get("SalmonNigiri") - 1));
			}
			else if(playerBoard.getOrDefault("EggNigiri", 0) > 0) {
				finalScore += 3;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("EggNigiri", (playerBoard.get("EggNigiri") - 1));
			}
			else
				playerBoard.replace("Wasabi", 0);
		}
	}
}
