package GUIpackage;
import TEXTpackage.*;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class PlayScreen {
	Stage window;
	GameConfiguration game;
	static Hashtable<String, Integer> player1Board;
	static Hashtable<String, Integer> player2Board;
	static LinkedList<Button> hand1;
	static LinkedList<Button> hand2;
	HBox hand1HBox;
	static int player1turn;
	static int player2turn;
	private LinkedList<Button> tempHand1;
	private LinkedList<Button> tempHand2;
	boolean lockPlayer1;
	boolean lockPlayer2;
	boolean endGame;
	public static Human player1;
	public static Human player2;
	static Boolean answer;
	static Boolean choice;
	
	public static void resetGameVariables()
	{
		player1Board = new Hashtable<String, Integer>();
		player2Board = new Hashtable<String, Integer>();
		hand1 = new LinkedList<Button>();
		hand2 = new LinkedList<Button>();
		player1turn = 0;
		player2turn = 0;
		
	}
	
	public static int getPlayer1TurnCount() {
		return player1turn;
	}
	
	public static int getPlayer2TurnCount() {
		return player2turn;
	}
	
	public static void updatePlayer1Count(int count) {
		player1turn += count;
	}
	
	public static void updatePlayer2Count(int count) {
		player2turn += count;
	}

	public GameConfiguration getGame() {
		return game;
	}
	
	public void setGame(int gameMode, int players) {
		this.game = new GameConfiguration(gameMode,players);
	}
	
	public void resetGame(int newGame, int newPlayers)
	{
		this.game = new GameConfiguration(newGame, newPlayers);
	} 
	
	public ImageView getBackground() {
		ImageView Background = new ImageView("/GUIpackage/pictures/Background.jpg");
		Background.setFitWidth(1000);
		Background.setFitHeight(600);
		return Background;
	}
	
	public ImageView getCard(int hand, int card) {
		ImageView cardImage = new ImageView("/GUIpackage/pictures/" + game.getHand(hand).get(card) + ".png");
		cardImage.setFitHeight(100);;
		cardImage.setFitWidth(75);
		return cardImage;	
	} 
	
	public Button getButton(int hand, int card) {
		Button cardButton = new Button (game.getHand(hand).get(card), getCard(hand,card));
		cardButton.setContentDisplay(ContentDisplay.TOP);
		return cardButton;
	}
	
	public static void putOnBoard(Hashtable<String, Integer> board, String cardPlayed) {
        if(board.containsKey(cardPlayed)) {
			board.replace(cardPlayed, (board.get(cardPlayed) + 1));
					
        }
		else {
			board.put(cardPlayed, 1);	
		}
	}
	
	public void setBoardPlayer1() {
		player1Board = new Hashtable<String, Integer>();
	}
	
	public void setBoardPlayer2() {
		player2Board = new Hashtable<String, Integer>();
	}
	
 	public static Hashtable<String, Integer> getPlayer1Board() {
		return player1Board;
	}
	
	public static Hashtable<String, Integer> getPlayer2Board() {
		return player2Board;
	}
	
	public void setHand1() {
		hand1 = new LinkedList<Button>();
		for(int card = 0; card < game.getHand(0).size(); card++) {
			getCard(0,card);
			Button cardButton = getButton(0,card);
			hand1.add(cardButton);
		}
	}
	
	public void setHand2() {
		hand2 = new LinkedList<Button>();
		for(int card = 0; card < game.getHand(1).size(); card++) {
			getCard(1,card);
			Button cardButton = getButton(1,card);
			hand2.add(cardButton);
		}
	}
	
	public static LinkedList<Button> getHand1() {
		return hand1;
	}
	
	public static LinkedList<Button> getHand2() {
		return hand2;
	}
	
	public static void updateHand1(LinkedList<Button> newHand) {
		hand1 = new LinkedList<Button>(newHand);
	}
	
	public static void updateHand2(LinkedList<Button> newHand) {
		hand2 = new LinkedList<Button>(newHand);
	}
	
	public void switchHands() {
		int totalTurns = player1turn + player2turn;
		if(totalTurns % 2 ==0 && totalTurns > 0) {
			tempHand1 = hand1;
			tempHand2 = hand2;
			updateHand1(tempHand2);
			updateHand2(tempHand1);
		}
	}

	public void endGame() {
		int totalTurns = player1turn + player2turn;
		if(totalTurns == 20) {
			
			endGame = true;
		}
	}

	public boolean lockPlayer1Button() {
		if(Player1Turn.getBoardOfStrings().size() == 10) {
			lockPlayer1 = true;
		}
		else if(Player1Turn.getBoardOfStrings().size()> Player2Turn.getBoardOfStrings().size()) {
			lockPlayer1 = true;
		}
		else {
			lockPlayer1 = false;
		}
		return lockPlayer1;	
	}

	public boolean lockPlayer2Button() {
		if(Player1Turn.getBoardOfStrings().size() == Player2Turn.getBoardOfStrings().size()) {
			lockPlayer2 = true;
		}
		else {
			lockPlayer2 = false;
		}
		return lockPlayer2;	
	}
	
	public Human createHumanPlayer1()
	{
		player1 = new Human(getPlayer1Board(), 1);
		return player1;
	}
	
	public Human createHumanPlayer2()
	{
		player2 = new Human(getPlayer2Board(), 2);
		return player2;
	}
	
	public static Human getPlayer1()
	{
		return player1;
	}
	
	public static Human getPlayer2()
	{
		return player2;
	}
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox.closeProgram(window);
		});
		Player1Turn player1 = new Player1Turn();
		Player2Turn player2 = new Player2Turn();
		Stage player1Stage = new Stage();
		Stage player2Stage = new Stage();
		Rules rules = new Rules();
		Stage rulesStage = new Stage();
		FinalScoreScreen finalScore = new FinalScoreScreen();
		Stage finalStage = new Stage();
		Player1Board player1Board = new Player1Board();
		Stage boardStage1 = new Stage();
		Player2Board player2Board = new Player2Board();
		Stage boardStage2 = new Stage();
		window.setOnCloseRequest(e -> {
			e.consume();
			window.close();
		});
////////////////////////////////////////////////////////////////////////////		
		//Buttons
		Button checkBoard1 = new Button("Check Player 1 Board");
		checkBoard1.setOnAction(e -> {
			player1Board.start(boardStage1);
		});
		Button checkBoard2 = new Button("Check Player 2 Board");
		checkBoard2.setOnAction(e -> {
			player2Board.start(boardStage2);
		});
		Button finalScoreButton = new Button("FINAL SCORE");
		finalScoreButton.setOnAction(e -> {
			endGame();
			if(endGame == true) {	
				
				createHumanPlayer1();
				createHumanPlayer2();
				System.out.println("You've reached this part of the code if the game is over. The human player 1 is : " +player1);
				System.out.println("You've reached this part of the code if the game is over. The human player 2 is : " +player2);
				
			
				
				
				finalScore.start(finalStage);
				window.close();
//				resetGameVariables();
			}
			else {
				finalScoreButton.isDisabled();
			}
		});
		Button p1 = new Button("Player 1 Turn!");
		p1.setOnAction(e -> {
			endGame();
			lockPlayer1Button();
			if(endGame == true) {
				p1.isDisabled();
			}
			if(lockPlayer1 == true) {
				p1.isDisabled();
			}
			else {
				if(player1turn > 0) {
					switchHands();
				}
				player1.setHandPlayer1(hand1);
				player1.start(player1Stage);
			}
		});
		Button p2 = new Button("Player 2 Turn!");
		p2.setOnAction(e ->{
			endGame();
			lockPlayer2Button();
			if(endGame == true) {
				p2.isDisabled();
			}
			if(lockPlayer2 == true) {
				p2.isDisabled();
				System.out.println("It's the other player's turn!");
			}
			else {
				if(player2turn > 0)	{
					switchHands();
				}
				player2.setHandPlayer2(hand2);
				player2.start(player2Stage);
			}
		});
		Button doubleCheckRules = new Button("Double check the rules!");
		doubleCheckRules.setOnAction(e ->{
			rules.start(rulesStage);
		});
////////////////////////////////////////////////////////////////////////////
		//Display
		StackPane playScreen = new StackPane();
		VBox playScreenVBox = new VBox(20);
		playScreenVBox.setAlignment(Pos.CENTER);
		playScreenVBox.getChildren().addAll(p1,checkBoard1,p2,checkBoard2,doubleCheckRules,finalScoreButton);
		playScreen.getChildren().addAll(getBackground(),playScreenVBox);
		Scene playScreenScene = new Scene(playScreen, 1000, 600);
		
		window.setTitle("LET'S PLAY!");
		window.setScene(playScreenScene);
		window.show();
////////////////////////////////////////////////////////////////////////////
		//Set HBox
		//Start by creating the boards
		setBoardPlayer1();
		setBoardPlayer2();
		//Set hands
		setHand1();
		setHand2();
		//Test Humans
//		createHumanPlayer1();
//		createHumanPlayer2();
//		System.out.println(player1);
//		System.out.println(player2);
//
//	}
}	
}
	