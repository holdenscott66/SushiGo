package GUIpackage;
import TEXTpackage.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		//MainScreen main = new MainScreen();
		//Stage mainStage = new Stage();
		
		window.setOnCloseRequest(e -> {
			e.consume();
			//closeProgram(window);
		});
		PlayScreen againAndAgain = new PlayScreen();
		Stage twoStage = new Stage();
		
		StackPane finalScore = new StackPane();
		Button playAgain = new Button("Back To Main Screen?");
		playAgain.setOnAction(e -> {
			score = 0;
//			scoreBoard.dumplingScore(getPlayer1Board());
//			scoreBoard.sashimiScore(getPlayer1Board());
//			scoreBoard.tempuraScore(getPlayer1Board());
//			scoreBoard.wasabiNigiriScore(getPlayer1Board());
//			scoreBoard.nigiriScore(getPlayer1Board());
//			scoreBoard.puddingScore(getPlayer1Board(), 0);
//			scoreBoard.makiRollScore(getPlayer1Board(), 0);
			System.out.println(score);
			window.close();
			//main.start(mainStage);
		});
		Button playRightAway = new Button ("I NEED TO PLAY AGAIN NOW");
		playRightAway.setOnAction(e -> {
			window.close();
			againAndAgain.setGame(1,2);
			againAndAgain.start(twoStage);
			System.out.println(players[0].getScore());
		});
		//Button player1Score = new Button("Player 1:" + );
		ImageView background = new ImageView("/GUIpackage/pictures/playagain.jpg");
		background.setFitHeight(600);
		background.setFitWidth(1000);
		//Score Display
		VBox finalScoreVBox = new VBox(100);
		finalScoreVBox.setAlignment(Pos.BOTTOM_CENTER);
		finalScoreVBox.getChildren().addAll(playAgain,playRightAway);
		finalScore.getChildren().addAll(background,finalScoreVBox);
		Scene finalScoreScene = new Scene(finalScore, 1000,600);
		
		window.setTitle("Sushi Go");
		window.setScene(finalScoreScene);
		window.show();
	}
}