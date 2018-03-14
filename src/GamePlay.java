/*
 * GamePlay class is the game iterating through turns and calling all necessary methods. 
 */
public class GamePlay {
	private Player[] players;
	int numPlayers;
/*
 * GamePlay constructor, initializes the instance variables, and calls the play method to run the game
 * @param game   the object of gameConfiguration containing required information and methods. 
 */
	public GamePlay(GameConfiguration game) {
		players = game.getPlayers();
		numPlayers = players.length;
		play(numPlayers, game);
	}
/*
 * play method iterates for ten round for each player (2-4)
 * after the player chooses a move, hands and boards are updated and displayed. 
 * after each round, the hands alternate by one. 
 * 
 * @param numPlayers   the number of players in the game to determine how many 
 * 			times to alternate hands and which players get which hands
 * @param game       the gameConfiguration object which contains all of the methods 
 * 					to play the game
 * 
 * then creates an instance of FinalScore to calculate the scores of the players after 10 rounds
 */
	public void play(int numPlayers, GameConfiguration game) {
		int handNum;
		for(int turn = 0; turn < 10; turn ++) {
			for(int count = 0; count < numPlayers; count++) {
				handNum = turn % numPlayers; 
				players[count].setPossibleMoves(game.getHand((count + handNum) % numPlayers));
				game.displayHand(players[count], (count + handNum) % numPlayers);
				players[count].move(turn);
				game.updateHand(count, (count + handNum) % numPlayers);
			}
		}
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
			new FinalScore(game);
	}
}