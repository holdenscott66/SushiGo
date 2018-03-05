import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
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

public class GUI extends Application {

	private void closeProgram() {
		boolean answer = ConfirmBox.display("Confirmation", "Sure you want to Exit?");
		if (answer) {
			window.close();
			System.out.println("Closed");
		}
	}
	
	//********************************************************************************************************************************		
	
	public static void main(String[] args) {
		launch(args);
	}
	//Stage and Scenes
	Stage window;
	Scene mainScreenScene, selectionScene, rulesScene, playerScene, player1Scene, player2Scene, finalScoreScene;
	
	//Instance Variables
	private GameConfiguration game;
	private Player players;
	private int numPlayers;
	private FinalScore score;
	
	//********************************************************************************************************************************		
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		//********************************************************************************************************************************		
		
		//buttons for mainScreen
		Button playButton = new Button("Play");
		Button rulesButton = new Button("Rules");
		Button exitButton = new Button("Quit");
		playButton.setOnAction(e -> window.setScene(selectionScene));
		rulesButton.setOnAction(e -> window.setScene(rulesScene));
		exitButton.setOnAction(e -> closeProgram());
		
		//mainScreen Display
		StackPane mainScreenPane = new StackPane();
		VBox mainScreenVBox = new VBox(20);
		mainScreenVBox.setAlignment(Pos.CENTER);
		mainScreenVBox.getChildren().addAll(playButton, rulesButton, exitButton);
		mainScreenPane.getChildren().add(mainScreenVBox);
		mainScreenScene = new Scene(mainScreenPane, 1000,600);
	
		//********************************************************************************************************************************
		
		//buttons for Selection
		Button playerPVPButton = new Button("Player vs Player");
		Button easyAIButton = new Button("Player vs Easy Computer");
		Button hardAIButton = new Button("Player vs Hard Computer");
		Button backButton = new Button("Back");
		playerPVPButton.setOnAction(e -> window.setScene(playerScene));
		easyAIButton.setOnAction(e -> System.out.println("Easy Computer"));
		hardAIButton.setOnAction(e -> System.out.println("Hard Computer"));
		backButton.setOnAction(e -> window.setScene(mainScreenScene));
		
		//Selection Display
		StackPane selectionPane = new StackPane();
		VBox selectionVBox = new VBox(20);
		selectionVBox.setAlignment(Pos.CENTER);
		selectionVBox.getChildren().addAll(playerPVPButton, easyAIButton, hardAIButton, backButton);
		selectionPane.getChildren().add(selectionVBox);
		selectionScene = new Scene(selectionPane, 1000, 600);

		//********************************************************************************************************************************
		
		//buttons for Rules
		Button rulesBackButton = new Button("Back");
		rulesBackButton.setOnAction(e -> window.setScene(mainScreenScene));
		
		//Rules Display
		StackPane rulesPane = new StackPane();
		VBox rulesVBox = new VBox(20);
		rulesVBox.setAlignment(Pos.CENTER);
		Label rulesLabel = new Label("Rules Soon to Come");
		rulesVBox.getChildren().addAll(rulesLabel, rulesBackButton);
		rulesPane.getChildren().add(rulesVBox);
		rulesScene = new Scene(rulesPane, 1000, 600);

		//********************************************************************************************************************************
		
		//buttons for Player
		Button twoPlayerButton = new Button("Two Players");
		Button threePlayerButton = new Button("Three Players");
		Button fourPlayerButton = new Button("Four Players");
		Button playerBackButton = new Button("Back");
		game = new GameConfiguration(1,2);
		twoPlayerButton.setOnAction(e -> window.setScene(player1Scene));
		threePlayerButton.setOnAction(e -> System.out.println("Three Player mode coming soon"));
		fourPlayerButton.setOnAction(e -> System.out.println("Four Player mode coming soon"));
		playerBackButton.setOnAction(e -> window.setScene(selectionScene));
		
		//Player Display
		StackPane playerPane = new StackPane();
		VBox playerVBox = new VBox(20);
		playerVBox.setAlignment(Pos.CENTER);
		playerVBox.getChildren().addAll(twoPlayerButton, threePlayerButton, fourPlayerButton, playerBackButton);
		playerPane.getChildren().add(playerVBox);
		playerScene = new Scene(playerPane, 1000, 600);
		
		//********************************************************************************************************************************
		
		//Player 1 Display
		StackPane player1Pane = new StackPane();
		HBox bottomHBox1 = new HBox(5);
		HBox topHBox1 = new HBox(5);
		bottomHBox1.setAlignment(Pos.BOTTOM_CENTER);
		topHBox1.setAlignment(Pos.TOP_CENTER);
		
		//buttons for Player 1
		LinkedList<Button> gameButtons1 = new LinkedList<Button>();
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		ImageView Background1 = new ImageView("Background.jpg");
		Background1.setFitWidth(1000);
		Background1.setFitHeight(600);
		for (int i = 0; i< game.getHand(0).size(); i++) {
			ImageView cardImage = new ImageView(game.getHand(0).get(i) + ".png");
			cardImage.setFitHeight(100);
			cardImage.setFitWidth(75);
			Button cardButton = new Button((game.getHand(0).get(i)), cardImage);
			cardButton.setContentDisplay(ContentDisplay.TOP);
			gameButtons1.add(cardButton);
			bottomHBox1.getChildren().add(cardButton);
			gameButtons1.get(i).setOnAction(e -> {
				String cardPlayed = ((Button)(e.getSource())).getText();
				Button buttonPlayed = ((Button)(e.getSource()));
				gameButtons1.remove(buttonPlayed);
				game.getHand(0).remove(cardPlayed);
				game.updateHand(0, 0);
	            if(board1.containsKey(cardPlayed)) 
    				board1.replace(cardPlayed, (board1.get(cardPlayed) + 1));
    			else 
    				board1.put(cardPlayed, 1);
	            bottomHBox1.getChildren().remove(buttonPlayed);
	            window.setScene(player2Scene);
			});
		}

		//set Player1 Scene
		player1Pane.getChildren().addAll(Background1, bottomHBox1);
		player1Scene = new Scene(player1Pane, 1000, 600);
		
		//********************************************************************************************************************************
		
		//Player 2 Display
		StackPane player2Pane = new StackPane();
		HBox bottomHBox2 = new HBox(5);
		HBox topHBox2 = new HBox(5);
		bottomHBox2.setAlignment(Pos.BOTTOM_CENTER);
		topHBox2.setAlignment(Pos.TOP_CENTER);
		
		//buttons for Player 2
		LinkedList<Button> gameButtons2 = new LinkedList<Button>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		ImageView Background2 = new ImageView("Background.jpg");
		Background2.setFitWidth(1000);
		Background2.setFitHeight(600);
		for (int i = 0; i< game.getHand(1).size(); i++) {
			ImageView cardImage = new ImageView(game.getHand(1).get(i) + ".png");
			cardImage.setFitHeight(100);
			cardImage.setFitWidth(75);
			Button cardButton = new Button((game.getHand(1).get(i)), cardImage);
			cardButton.setContentDisplay(ContentDisplay.BOTTOM);
			gameButtons2.add(cardButton);
			topHBox2.getChildren().add(cardButton);
			gameButtons2.get(i).setOnAction(e -> {
				String cardPlayed = ((Button)(e.getSource())).getText();
				Button buttonPlayed = ((Button)(e.getSource()));
				gameButtons2.remove(buttonPlayed);
				game.getHand(1).remove(cardPlayed);
				game.updateHand(1, 1);
				if(board2.containsKey(cardPlayed)) 
					board2.replace(cardPlayed, (board2.get(cardPlayed) + 1));
				else 
					board2.put(cardPlayed, 1);
	            topHBox2.getChildren().remove(buttonPlayed);
	            window.setScene(player1Scene);
			});
		}
		
		//set Player2 Scene
		player2Pane.getChildren().addAll(Background2, topHBox2);
		player2Scene = new Scene(player2Pane, 1000, 600);
		
		//********************************************************************************************************************************
		
		//Final Score Display (NOT READY YET)
		StackPane finalScorePane = new StackPane();
		new FinalScore(game);

		//********************************************************************************************************************************

		window.setTitle("Sushi Go");
		window.setScene(mainScreenScene);
		window.show();
	}
}

