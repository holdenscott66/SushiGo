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

// issue right now is to break out of the loop and redo the create images method
//easiest way is to make the load image into a method
//or figure out a way to only make the user click one button at a time, limit the button clicks?

// still have to figure out how to pass turns back and forth (should just be an external for loop with the amount of players?)

//if you want user events you need the eventHandler<ActionEvent> at the end of the class
public class GUI extends Application {

	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, scene6;
	
	//declare the button
	Button playButton;
	Button exitButton;
	Button rulesButton;
	Button easyAIButton;
	Button playerPVPButton;
	Button hardAIButton;
	Button backButton;
	Button twoPlayerButton;
	Button threePlayerButton;
	Button fourPlayerButton;
	Button readyButton;
	Button buttonCards;
	
	private GameConfiguration game;
	private Player[] players;
	int numPlayers;
	private FinalScore score;
	

	/*
	for (int i = 0; i < game.getHand(1).size(); i++) {
		System.out.println(game.getHand(1).get(i));
		fD = new ImageView("FaceDown.png");
		fD.setFitWidth(100);
		fD.setFitHeight(150);
		FaceDown.getChildren().add(fD);
		}
	*/
	
	
	public void start(Stage primaryStage) throws Exception {
		
		
		
		window = primaryStage;
		
		
	
		StackPane layout1 = new StackPane();
		
		
		// Label label1 = new Label("Welcome to Sushi Go!");
		
		playButton = new Button();
		
			playButton.setText("Play");
										
										//CHANGE THIS TO SCENE 2
			playButton.setOnAction(e -> window.setScene(scene5));
		
		//move the button a little bit off the edge
	//	playButton.setTranslateX(30);
		playButton.setTranslateY(0);
		
		
		rulesButton = new Button();
			rulesButton.setText("Rules");
			
			rulesButton.setOnAction(e -> window.setScene(scene3));
		
	//	rulesButton.setTranslateX(30);
			rulesButton.setTranslateY(50);
		
		exitButton = new Button();
			exitButton.setText("Exit");
			exitButton.setOnAction(e -> Platform.exit());
		
		
	//	exitButton.setTranslateX(30);
		exitButton.setTranslateY(100);
		
		//Layout 1 - vertical column
		
		//ImageView mainmenu = new ImageView("h.png");
		
		layout1.getChildren().addAll(playButton, rulesButton, exitButton);
		scene1 = new Scene(layout1, 1000,600);
	
		
		// the play button scene, can choose between easy AI or hard AI
		VBox layout2 = new VBox(15);

	
		easyAIButton = new Button();
			easyAIButton.setText("Player vs Easy Computer");
			easyAIButton.setOnAction(e -> System.out.println("hello"));
		
		hardAIButton = new Button();
			hardAIButton.setText("Player vs Hard Computer");
			hardAIButton.setOnAction(e -> System.out.println("goodbye"));
		
		backButton = new Button();
			backButton.setText("Back");
			backButton.setOnAction(e -> window.setScene(scene1));
		
		playerPVPButton = new Button();
			playerPVPButton.setText("Player vs Player");
			playerPVPButton.setOnAction(e -> window.setScene(scene4));
		
		layout2.getChildren().addAll(playerPVPButton, easyAIButton, hardAIButton, backButton);
		
		scene2 = new Scene(layout2, 1000	,600);
		//default 1366, 768
		
		
		
		
		//layout 3
		VBox layout3 = new VBox(30);
		
		backButton = new Button();
			backButton.setText("Back");
			backButton.setOnAction(e -> window.setScene(scene1));
		
		layout3.getChildren().addAll(backButton);
		
		scene3 = new Scene(layout3, 1000, 600);
		
		
		
		StackPane layout4 = new StackPane();
		
		
		twoPlayerButton = new Button();
			twoPlayerButton.setText("Two Players");
			 game = new GameConfiguration(1, 2);
	      //  new GamePlay(G1);
			
			
		//	players = game.getPlayers();
		//	numPlayers = players.length;
			
			
			
			twoPlayerButton.setOnAction(e -> window.setScene(scene5));
			
			twoPlayerButton.setTranslateY(-100);
			
			
		threePlayerButton = new Button();
			threePlayerButton.setText("Three Players");
			threePlayerButton.setOnAction(e -> window.setScene(scene5));
			threePlayerButton.setTranslateY(-50);
			
			
		fourPlayerButton = new Button();
			fourPlayerButton.setText("Four Players");
			game = new GameConfiguration(1, 4);
			
			
			fourPlayerButton.setOnAction(e -> window.setScene(scene5));
			
			
		
			fourPlayerButton.setTranslateY(0);
			
			backButton = new Button();
			backButton.setText("Back");
			backButton.setOnAction(e -> window.setScene(scene2));
		
		
			backButton.setTranslateY(50);
			
		layout4.getChildren().addAll(twoPlayerButton, threePlayerButton, fourPlayerButton, backButton);
		
		scene4 = new Scene(layout4, 1000, 600);
		
		
		StackPane layout5 = new StackPane();
		
		ImageView Background = new ImageView("Background.jpg");
		Background.setFitWidth(1000);
		Background.setFitHeight(600);
		
		HBox boxPic = new HBox(15);
		HBox FaceDown = new HBox(15);
		boxPic.setAlignment(Pos.BOTTOM_CENTER);
		FaceDown.setAlignment(Pos.TOP_CENTER);
		LinkedList<Button> buttons = new LinkedList<Button>();
			
		//Images Player 1
		   Hashtable<String, Integer> board = new Hashtable<String, Integer>();
			for (int i = 0; i< game.getHand(0).size(); i++) {
				System.out.println(i+") " + game.getHand(0));
				ImageView view = new ImageView(game.getHand(0).get(i)+".png");
				view.setFitWidth(75);
				view.setFitHeight(100);
				
				buttonCards = new Button(null, view);
				buttonCards.setText(game.getHand(0).get(i));
				buttonCards.setContentDisplay(ContentDisplay.TOP);
				buttons.add(buttonCards);
				boxPic.getChildren().add(buttonCards);
				buttons.get(i).setOnAction(e-> {
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
				//	SimpleBooleanProperty isDisabled = new SimpleBooleanProperty();
		    		//	isDisabled.setValue(true);
					System.out.println("hi");
				//	((Button)(e.getSource())).disableProperty().bind(isDisabled);
					buttons.remove(0);
		            game.getHand(0).remove(cardPlayed);
		            game.updateHand(0,0);
		            if(board.containsKey(cardPlayed)) {
	    				board.replace(cardPlayed, (board.get(cardPlayed) + 1));
	    			}
	    			else {
	    				board.put(cardPlayed, 1);
	    			}
	    		
	    				System.out.println(board);
		            boxPic.getChildren().remove(buttonPlayed);
		            window.setScene(scene6);
			
			});
			}
			layout5.getChildren().addAll(Background,boxPic);
			scene5 = new Scene(layout5, 1000, 600);
			
			//Player 2
			
			StackPane layout6 = new StackPane();
			ImageView Background1 = new ImageView("Background.jpg");
			Background1.setFitWidth(1000);
			Background1.setFitHeight(600);
			HBox boxPic1 = new HBox(15);
			HBox FaceDown1 = new HBox(15);
			boxPic1.setAlignment(Pos.BOTTOM_CENTER);
			FaceDown1.setAlignment(Pos.TOP_CENTER);
			LinkedList<Button> buttons1 = new LinkedList<Button>();
				
			//Images Player 2
			    Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();

				for (int i = 0; i< game.getHand(1).size(); i++) {
					System.out.println(i+") " + game.getHand(1));
					ImageView view = new ImageView(game.getHand(1).get(i)+".png");
					view.setFitWidth(75);
					view.setFitHeight(100);
					
					buttonCards = new Button(null, view);
					buttonCards.setText(game.getHand(1).get(i));
					buttonCards.setContentDisplay(ContentDisplay.TOP);
					buttons1.add(buttonCards);
					boxPic1.getChildren().add(buttonCards);
					buttons1.get(i).setOnAction(e-> {
						String cardPlayed = ((Button)(e.getSource())).getText();
						Button buttonPlayed = ((Button)(e.getSource()));
					//	SimpleBooleanProperty isDisabled = new SimpleBooleanProperty();
			    		//	isDisabled.setValue(true);
						System.out.println("hi");
					//	((Button)(e.getSource())).disableProperty().bind(isDisabled);
						buttons1.remove(0);
			            game.getHand(1).remove(cardPlayed);
			            game.updateHand(1,1);
		    				if(board1.containsKey(cardPlayed)) {
		    					board1.replace(cardPlayed, (board1.get(cardPlayed) + 1));
		    				}
		    				else {
		    					board1.put(cardPlayed, 1);
		    			}
		    		
		    				System.out.println(board1);
			            boxPic1.getChildren().remove(buttonPlayed);
			            window.setScene(scene5);
				
				});
				}
				layout6.getChildren().addAll(Background1,boxPic1);
				scene6 = new Scene(layout6, 1000, 600);
				
		StackPane layout7 = new StackPane();
		new FinalScore(game);
		/*	SimpleBooleanProperty isDisabled = new SimpleBooleanProperty();
	    		isDisabled.setValue(true);
            ((Button)(e.getSource())).setTranslateX(150);
            ((Button)(e.getSource())).setTranslateY(-250);
            ((Button)(e.getSource())).disableProperty().bind(isDisabled);
            ((Button)(e.getSource())).setAlignment(Pos.BASELINE_RIGHT);
            */

		window.setTitle("Sushi Go");
		window.setScene(scene1);
		window.show();
			}
	}
