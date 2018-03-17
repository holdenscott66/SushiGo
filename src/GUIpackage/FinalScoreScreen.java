package GUIpackage;
import java.lang.reflect.Array;

import TEXTpackage.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalScoreScreen {

	Stage window;
	Scene finalScoreScene;
	private FinalScore scoreBoard;
	private GameConfiguration game;
	private Player[] players;
	private int score;
	FinalScore thisGamesScore;
	Human human1;
	Human human2;
	Player[] playerArray;
	static Boolean answer;
	static Boolean choice;
	
	

	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox.closeProgram(window);
		});
		
		window.setOnCloseRequest(e -> {
			e.consume();
			//closeProgram(window);
		});
		PlayScreen againAndAgain = new PlayScreen();
		Stage twoStage = new Stage();
///////////////////////////////////////////////////////////////////////
		//Scoring Methods called here
		human1 = PlayScreen.getPlayer1();
		human2 = PlayScreen.getPlayer2();
		//Test to see that the humans are being created and they have a board
		System.out.println("This is human 1 from Play screen" + human1);
		System.out.println("This is player1 from Play screen, it should be identical to the above line!!" + PlayScreen.getPlayer1());
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("This is human 2 from Play screen" + human2);
		System.out.println("This is player2 from Play screen, it should be identical to the above line!!" + PlayScreen.getPlayer2());
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("This should be human1's board" + human1.getBoard());
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("This should be human2's board" + human2.getBoard());
		//Test to see if the boards get wiped out when i reset the variables after the game is over
		PlayScreen.resetGameVariables();
		System.out.println("Player 1 turn count should be 0, is: " +PlayScreen.getPlayer1TurnCount());
		System.out.println("Player 2 turn count should be 0, is: " +PlayScreen.getPlayer2TurnCount());
		System.out.println("Player 1 hand should [], is: " +PlayScreen.getHand1());
		System.out.println("Player 2 hand should [], is: " +PlayScreen.getHand2());
		System.out.println("Player 1 board should {}, is: " +PlayScreen.getPlayer1Board());
		System.out.println("Player 1 board should {}, is: " +PlayScreen.getPlayer2Board());
		////////////////////////////////////////////////////////////////////////////////////////
		//Creating an array of players human1 and human2
		playerArray = new Player[2];
		playerArray[0] = human1;
		playerArray[1] = human2;
		///////////////////////////////////////////////////////////////////////////////////////
		//Use FinalScore constructor 
		scoreBoard = new FinalScore(playerArray);
		scoreBoard.calcScore();
		int player1SCORE = human1.getScore();
		int player2SCORE = human2.getScore();
		
		//Test to see if they produce a score!
		System.out.println("Player 1's score, if they have a score, is: " +player1SCORE);
		System.out.println("Player 2's score, if they have a score, is: " +player2SCORE);
		
		
		StackPane finalScore = new StackPane();
//		Button playAgain = new Button("Back To Main Screen?");
//		playAgain.setOnAction(e -> {
//			
//			score = 0;
////			scoreBoard.dumplingScore(getPlayer1Board());
////			scoreBoard.sashimiScore(getPlayer1Board());
////			scoreBoard.tempuraScore(getPlayer1Board());
////			scoreBoard.wasabiNigiriScore(getPlayer1Board());
////			scoreBoard.nigiriScore(getPlayer1Board());
////			scoreBoard.puddingScore(getPlayer1Board(), 0);
////			scoreBoard.makiRollScore(getPlayer1Board(), 0);
//			System.out.println(score);
//			window.close();
//			//main.start(mainStage);
//		});
//		Button playRightAway = new Button ("I NEED TO PLAY AGAIN NOW");
//		playRightAway.setOnAction(e -> {
//			window.close();
//			againAndAgain.setGame(1,2);
//			againAndAgain.start(twoStage);
//			System.out.println(players[0].getScore());
//		});
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////
	//BUTTONS ARE COOLER THAN LABELS
		
		Button explain = new Button("YOU CAN ONLY CLICK ON THE WINNER TO ESCAPE");
		explain.setOnAction(e -> explain.isDisabled());
		Button player1ScoreButton = new Button("PLAYER 1 SCORED : " +player1SCORE);
		player1ScoreButton.setOnAction(e ->
		{
			if (player1SCORE >= player2SCORE)
			{
				window.close();
			}
			else
			{
				player1ScoreButton.isDisabled();
			}
		});
		
		Button player2ScoreButton = new Button("PLAYER 2 SCORED : " +player2SCORE);
		player2ScoreButton.setOnAction(e ->
		{
			if (player1SCORE <= player2SCORE)
			{
				window.close();
			}
			else
			{
				player2ScoreButton.isDisabled();
			}
		});
		//Button player1Score = new Button("Player 1:" + );
		ImageView background = new ImageView("/GUIpackage/pictures/playagain.jpg");
		background.setFitHeight(600);
		background.setFitWidth(1000);
		//Score Display
		HBox finalScoreHBox = new HBox(100);
		finalScoreHBox.setAlignment(Pos.CENTER);
		finalScoreHBox.getChildren().addAll(explain, player1ScoreButton, player2ScoreButton);
		finalScore.getChildren().addAll(background,finalScoreHBox);
		Scene finalScoreScene = new Scene(finalScore, 1000,600);
		
		window.setTitle("Sushi Go");
		window.setScene(finalScoreScene);
		window.show();
	}
}