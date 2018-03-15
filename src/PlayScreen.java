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

public class PlayScreen extends Application 
{
	Stage window;
	Scene player1Scene;
	Scene player2Scene;
	GameConfiguration game;
	private Player[ ] players;

	
	public GameConfiguration getGame()
	{
		return game;
	}
	public void setGame(int gameMode, int players)
	{
		this.game = new GameConfiguration(gameMode,players);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) 
	{
		Stage window = primaryStage;
		StackPane player1Pane = new StackPane();
		HBox bottomHBox1 = new HBox(5);
		HBox topHBox1 = new HBox(5);
		bottomHBox1.setAlignment(Pos.BOTTOM_CENTER);
		topHBox1.setAlignment(Pos.TOP_CENTER);
		
		//Player 1 Stackpane addons
		LinkedList<Button> gameButtons1 = new LinkedList<Button>();
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		ImageView Background1 = new ImageView("/pictures/Background.jpg");
		Background1.setFitWidth(1000);
		Background1.setFitHeight(600);
		
		FinalScoreScreen score = new FinalScoreScreen();
		Stage finalStage = new Stage();
		Button finalScore = new Button("Final Score");
		finalScore.setOnAction(e ->
			{
				window.close();
				score.start(finalStage);
				
			});
		ImageView Background3 = new ImageView("/pictures/Background.jpg");
		Background3.setFitWidth(1000);
		Background3.setFitHeight(600);
		StackPane scorePane = new StackPane();
		VBox scoreVBox = new VBox(20);
		scoreVBox.setAlignment(Pos.CENTER);
		scoreVBox.getChildren().addAll(finalScore);
		scorePane.getChildren().addAll(Background3, scoreVBox);
		Scene scoreScene = new Scene(scorePane, 1000, 600);
		
		//NOW TO MAKE THE HAND WITH BUTTONS ON THEM CARDS
		
		
		for(int handSize = 0; handSize < game.getHand(0).size(); handSize ++)
			{
				ImageView cardImage = new ImageView("/pictures/" + game.getHand(0).get(handSize) + ".png");
				cardImage.setFitHeight(100);;
				cardImage.setFitWidth(75);
				Button cardButton = new Button (game.getHand(0).get(handSize), cardImage);
				cardButton.setContentDisplay(ContentDisplay.TOP);
				gameButtons1.add(cardButton);
				bottomHBox1.getChildren().add(cardButton);
			
				
				gameButtons1.get(handSize).setOnAction(e -> 
				{
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
					gameButtons1.remove(buttonPlayed);
					game.getHand(0).remove(cardPlayed);
					game.updateHand(0, 0);
					
		            if(board1.containsKey(cardPlayed)) 
		            	{
	    					board1.replace(cardPlayed, (board1.get(cardPlayed) + 1));
	    					bottomHBox1.getChildren().remove(buttonPlayed);
	    					
	    					window.setScene(player2Scene);
		            	}
	    			else 
	    				{
	    					board1.put(cardPlayed, 1);
	    					bottomHBox1.getChildren().remove(buttonPlayed);
	    					
	    					window.setScene(player2Scene);
	    				}
				});
			}
			
			//set Player1 Scene
			player1Pane.getChildren().addAll(Background1, bottomHBox1);
			player1Scene = new Scene(player1Pane, 1000, 600);
				
			
			

		
		//Player 2 Display
				StackPane player2Pane = new StackPane();
				HBox bottomHBox2 = new HBox(5);
				HBox topHBox2 = new HBox(5);
				bottomHBox2.setAlignment(Pos.BOTTOM_CENTER);
				topHBox2.setAlignment(Pos.TOP_CENTER);
				
				//buttons for Player 2
				LinkedList<Button> gameButtons2 = new LinkedList<Button>();
				Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
				ImageView Background2 = new ImageView("/pictures/Background.jpg");
				Background2.setFitWidth(1000);
				Background2.setFitHeight(600);
				
				for (int i = 0; i< game.getHand(1).size(); i++) 
				{
					ImageView cardImage = new ImageView("/pictures/" + game.getHand(0).get(i) + ".png");
					cardImage.setFitHeight(100);
					cardImage.setFitWidth(75);
					
					Button cardButton = new Button((game.getHand(1).get(i)), cardImage);
					cardButton.setContentDisplay(ContentDisplay.BOTTOM);
					gameButtons2.add(cardButton);
					topHBox2.getChildren().add(cardButton);
					
					gameButtons2.get(i).setOnAction(e -> 
					{
						String cardPlayed = ((Button)(e.getSource())).getText();
						Button buttonPlayed = ((Button)(e.getSource()));
						gameButtons2.remove(buttonPlayed);
						game.getHand(1).remove(cardPlayed);
						game.updateHand(1, 1);
						
						if(board2.containsKey(cardPlayed)) 
						{
							board2.replace(cardPlayed, (board2.get(cardPlayed) + 1));
							topHBox2.getChildren().remove(buttonPlayed);
							
							window.setScene(player1Scene);
						}
						else 
						{
							board2.put(cardPlayed, 1);
							topHBox2.getChildren().remove(buttonPlayed);
							
							window.setScene(player1Scene);
						}
						
						if(game.getHand(0).size() == 0 && game.getHand(1).size() == 0)
						{
							
							window.setTitle("FINAL SCORE");
							window.setScene(scoreScene);
							window.show();
						
							
							
						}
					});
				}
				
				//set Player2 Scene
				player2Pane.getChildren().addAll(Background2, topHBox2);
				player2Scene = new Scene(player2Pane, 1000, 600);
		
	
		window.setTitle("Let's Play!");
		window.setScene(player1Scene);
		window.show();
	}
	
}
	