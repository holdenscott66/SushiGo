
public class GamePlay {
	private Player[] players;
	int numPlayers;
	GameConfiguration game;

	public GamePlay(GameConfiguration config) {
		game = config;
		players = game.getPlayers();
		numPlayers = players.length;
		play(numPlayers);
	}
		
	public void play(int numPlayers) {
		int handNum;
		for(int turn = 0; turn < 10; turn ++) {
			for(int count = 0; count < numPlayers; count++) {
				handNum = turn % numPlayers; 
				players[count].setPossibleMoves(game.getHand((count + handNum) % numPlayers));
				game.displayHand(players[count], (count + handNum) % numPlayers);
				players[count].move();
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