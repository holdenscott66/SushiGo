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
	//variables
	
	Hashtable<String, Integer>[] boards;

	/**
	
	
	*The FinalScore constructor takes the payers boards and creates an array of hashtables
	*calls calcScore method for each player
	*@param game	This is the game object that is created from the GameConfiguration class
	*		This parameter is used to refer to the players and their boards and to be able to 
	*		compare the current player's board against their opponent to calculate
	*		special card scores that rely on comparing boards
	*/
	
	public FinalScore(GameConfiguration game) {
		Player[] players = game.getPlayers();
		boards = new Hashtable[players.length];
		for (int count = 0; count < players.length; count ++) {
			boards[count] = players[count].getBoard();
		}
		for (int count = 0; count < players.length; count ++) {
			calcScore(players[count]);
		}
	}
	
	/*
	 * calcScore method calls all the scoring methods based on the specified player
	 * outputs the players score
	 * @param player    the player object for which the score will be calculated
	 */
	private void calcScore(Player player) {
		dumplingScore(player);
		puddingScore(player);
		makiRollScore(player);
		sashimiScore(player);
		tempuraScore(player);
		wasabiNigiriScore(player);
		nigiriScore(player);
		System.out.println(player.toString() + "'s score: " + player.getScore());
	}
	
	/**
	*The method dumplingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void dumplingScore(Player player) {
		int score = 0;
		switch(player.getBoard().getOrDefault("Dumpling", 0)) {
		case 1:
			score += 1;
			break;
		case 2:
			score += 3;
			break;
		case 3:
			score += 6;
			break;
		case 4:
			score += 10;
			break;
		case 5:
			score += 15;
			break;
		default:
			score += 0;
			break;
		}
		player.updateScore(score);
	}
	
	/**
	*The method puddingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void puddingScore(Player player) {
		boolean mostPudding = true;
		boolean leastPudding = true;
		Hashtable<String, Integer> playerBoard = player.getBoard();
		int score = 0;
		for(int num = 0; num < boards.length; num++) {
			if(playerBoard.getOrDefault("Pudding", 0) > boards[num].getOrDefault("Pudding", 0))
				mostPudding = true;
			else {
				mostPudding = false;
				break;
			}
		}
		for(int num = 0; num < boards.length; num++) {
			if(playerBoard.getOrDefault("Pudding", 0) < boards[num].getOrDefault("Pudding", 0))
				leastPudding = true;
			else {
				leastPudding = false;
				break;
			}
		}
		if(mostPudding == true && leastPudding == false)
			score += 6;
		else if(mostPudding == false && leastPudding == true)
			score -= 6;
		else
			score += 0;
		player.updateScore(score);
		
	}
	
	/**
	*The method makiRollScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void makiRollScore(Player player) {
		boolean mostMaki = true;
		int score = 0;
		Hashtable<String, Integer> playerBoard = player.getBoard();
		for(int num = 0; num < boards.length; num++) {
			if(playerBoard.getOrDefault("MakiRoll", 0) > boards[num].getOrDefault("MakiRoll", 0))
				mostMaki = true;
			else {
				mostMaki = false;
				break;
			}
		}
		if(mostMaki == true)
			score += 5;
		else
			score += 0;
		player.updateScore(score);
	}
	
	/**
	*The method sashimiScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void sashimiScore(Player player) {
		int score = 0;
		score += (player.getBoard().getOrDefault("Sashimi", 0) / 3) * 10;
		player.updateScore(score);
	}
	
	/**
	*The method tempuraScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void tempuraScore(Player player) {
		int score = 0;
		score += (player.getBoard().getOrDefault("Tempura", 0) / 2) * 5;
		player.updateScore(score);
	}
	
	/**
	*The method nigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void nigiriScore(Player player) {
		int score = 0;
		score += (player.getBoard().getOrDefault("squidNigiri", 0) * 3);
		score += (player.getBoard().getOrDefault("SalmonNigiri", 0) * 2);
		score += (player.getBoard().getOrDefault("EggNigiri", 0) * 1);
		
		player.updateScore(score);
	}
	
	/**
	*The method wasabiNigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*This methods does not take parameters or return values, but update the int variable
	*finalScore
	*/
	
	private void wasabiNigiriScore(Player player) {
		Hashtable<String, Integer> playerBoard = player.getBoard();
		int score = 0;
		while(playerBoard.getOrDefault("Wasabi", 0) > 0) {
			if(playerBoard.getOrDefault("SquidNigiri", 0) > 0) {
				score += 9;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SquidNigiri", (playerBoard.get("SquidNigiri") - 1));
			}
			else if (playerBoard.getOrDefault("SalmonNigiri", 0) > 0) {
				score += 6;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SalmonNigiri", (playerBoard.get("SalmonNigiri") - 1));
			}
			else if(playerBoard.getOrDefault("EggNigiri", 0) > 0) {
				score += 3;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("EggNigiri", (playerBoard.get("EggNigiri") - 1));
			}
			else
				playerBoard.replace("Wasabi", 0);
		}
		player.updateScore(score);
	}
}
