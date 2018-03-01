
public class GamePlay {
	private Player[] players;
	int numPlayers;
	GameConfiguration game;

	public GamePlay(GameConfiguration config) {
		game = config;
		players = game.getPlayers();
		numPlayers = players.length;
		if(numPlayers == 2)
			twoPlayer();
		else if (numPlayers == 3)
			threePlayer();
		else if (numPlayers == 4)
			fourPlayer();
	}
		
	public void twoPlayer() {
		int turn = 0;
		while ((game.getHand(0).size() > 0) && (game.getHand(1).size() > 0)) {
			if(turn % 2 == 0) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand(count));
					game.displayHand(players[count], count);
					players[count].move();
					game.updateHand(count, count);
				}
			}
			else if(turn % 2 == 1) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 1) % 2));
					game.displayHand(players[count], (count + 1) % 2);
					players[count].move();
					game.updateHand(count, (count + 1) % 2);
				}
			}
			turn++;
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
		}
		new FinalScore(game, players[0], players[1]).toString();
		new FinalScore(game, players[1], players[0]).toString();
	}
	
	public void threePlayer() {
		int turn = 0;
		while ((game.getHand(0).size() > 0) && (game.getHand(1).size() > 0) && (game.getHand(2).size() > 0)) {
			if(turn % numPlayers == 0) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 1) % numPlayers));
					game.displayHand(players[count], (count + 1) % numPlayers);
					players[count].move();
					game.updateHand(count, (count + 1) % numPlayers);
				}
			}
			else if(turn % numPlayers == 1) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand(count));
					game.displayHand(players[count], count);
					players[count].move();
					game.updateHand(count, count);
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
			turn++;
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
		}
		new FinalScore(game, players[0], players[1], players[2]).toString();
		new FinalScore(game, players[1], players[0], players[2]).toString();
		new FinalScore(game, players[2], players[1], players[0]).toString();
	}
	
	public void fourPlayer() {
		int turn = 0;
		while ((game.getHand(0).size() > 0) && (game.getHand(1).size() > 0) && (game.getHand(2).size() > 0) && (game.getHand(3).size() > 0)) {
			if(turn % numPlayers == 2) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand(count));
					game.displayHand(players[count], count);
					players[count].move();
					game.updateHand(count, count);
				}
			}
			else if(turn % numPlayers == 1) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 1) % 4));
					game.displayHand(players[count], (count + 1) % 4);
					players[count].move();
					game.updateHand(count, (count + 1) % 4);
				}
			}
			else if(turn % numPlayers == 0) {
				for(int count = 0; count < numPlayers; count++) {
					players[count].setPossibleMoves(game.getHand((count + 2) % 4));
					game.displayHand(players[count], (count + 2) % 4);
					players[count].move();
					game.updateHand(count, (count + 2) % 4);
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
			turn++;
			System.out.println("*********************************************************");
			for(int x = 0; x < numPlayers; x++) {
				game.displayBoard(players[x]);
				System.out.println("*********************************************************");
			}	
		}
		new FinalScore(game, players[0], players[1], players[2], players[3]).toString();
		new FinalScore(game, players[1], players[0], players[2], players[3]).toString();
		new FinalScore(game, players[2], players[1], players[0], players[3]).toString();
		new FinalScore(game, players[3], players[1], players[2], players[0]).toString();
	}
}
