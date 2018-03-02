
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
		for(int turn = 0; turn < 10; turn ++) {
			if(turn % numPlayers == 0) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand(count));
					game.displayHand(players[count], count);
					players[count].move();
					game.updateHand(count, count);
				}
			}
			else if(turn % numPlayers == 1) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 1) % numPlayers));
					game.displayHand(players[count], (count + 1) % numPlayers);
					players[count].move();
					game.updateHand(count, (count + 1) % numPlayers);
				}
			}
			else if(turn % numPlayers == 2) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 2) % numPlayers));
					game.displayHand(players[count], (count + 2) % numPlayers);
					players[count].move();
					game.updateHand(count, (count + 2) % numPlayers);
				}
			}
			else if(turn % numPlayers == 3) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 3) % numPlayers));
					game.displayHand(players[count], (count + 3) % numPlayers);
					players[count].move();
					game.updateHand(count, (count + 3) % numPlayers);
				}
		}
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
		}
			new FinalScore(game);
	}
}
