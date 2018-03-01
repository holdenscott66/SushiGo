import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.application.Platform;
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


/*
* personal notes: play button skips straight into the play area just for faster testing
* the for loop that creates the flipped cards was screwing with the buttons so it's been removed temporarily 
*
*
*/


//if you want user events you need the eventHandler<ActionEvent> at the end of the class
public class GUI extends Application {

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
	
	public GUI() {
		
		game = new GameConfiguration(1, 2);
		
	}

	

	
	//	  ImageView viewCard1 = new ImageView(new Image(game.getHand(0)+ ".png"));
	 //   ImageView viewCard2 = new ImageView(new Image(cards.get(1) + ".png"));
	 //   ImageView viewCard3 = new ImageView(new Image(cards.get(2) + ".png"));
	    
	
	
	
	
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
		scene1 = new Scene(layout1, 500,500);
	
		
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
		
		scene2 = new Scene(layout2, 500,500);
		//default 1366, 768
		
		
		
		
		//layout 3
		VBox layout3 = new VBox(30);
		
		backButton = new Button();
			backButton.setText("Back");
			backButton.setOnAction(e -> window.setScene(scene1));
		
		layout3.getChildren().addAll(backButton);
		
		scene3 = new Scene(layout3, 500, 500);
		
		
		
		StackPane layout4 = new StackPane();
		
		
		twoPlayerButton = new Button();
			twoPlayerButton.setText("Two Players");
			twoPlayerButton.setOnAction(e -> window.setScene(scene5));
			
			twoPlayerButton.setTranslateY(-100);
			
			
		threePlayerButton = new Button();
			threePlayerButton.setText("Three Players");
			threePlayerButton.setOnAction(e -> window.setScene(scene5));
			
			threePlayerButton.setTranslateY(-50);
			
			
		fourPlayerButton = new Button();
			fourPlayerButton.setText("Four Players");
			fourPlayerButton.setOnAction(e -> window.setScene(scene5));
			
		
			fourPlayerButton.setTranslateY(0);
			
			backButton = new Button();
			backButton.setText("Back");
			backButton.setOnAction(e -> window.setScene(scene2));
		
		
			backButton.setTranslateY(50);
			
		layout4.getChildren().addAll(twoPlayerButton, threePlayerButton, fourPlayerButton, backButton);
		
		scene4 = new Scene(layout4, 500, 500);
		
		
		
		
		
		
		
		
		StackPane layout5 = new StackPane();
		
		
		ImageView Background = new ImageView("Background.jpg");
		Background.setFitWidth(1920);
		Background.setFitHeight(1080);
		
		HBox boxPic = new HBox(15);
		HBox FaceDown = new HBox(15);
		
		boxPic.setAlignment(Pos.BOTTOM_CENTER);
		FaceDown.setAlignment(Pos.TOP_CENTER);
		
	
			
			ImageView view = null;
		//	ImageView fD = null;
			
			
			for (int i = 0; i < game.getHand(0).size(); i++) {
				view = new ImageView(game.getHand(0).get(i) + ".png");
				buttonCards = new Button(null, view);
				buttonCards.setText(game.getHand(0).get(i));
				buttonCards.setMaxWidth(100);
				
				//move the button to the middle while forcing the change to height and width
				//delete the button
					
			   
				
			    buttonCards.setOnAction((e)-> {
			    	
			    	System.out.println("Button pressed " + ((Button) e.getSource()).getText());
				
			    	
			    	
			    	
			    });
				
				view.setFitWidth(100);
				view.setFitHeight(150);
				

				buttonCards.setContentDisplay(ContentDisplay.TOP);
				boxPic.getChildren().addAll(buttonCards);

			}
			/*
			for (int i = 0; i < game.getHand(1).size(); i++) {
				System.out.println(game.getHand(1).get(i));
				fD = new ImageView("FaceDown.png");
				fD.setFitWidth(100);
				fD.setFitHeight(150);
				FaceDown.getChildren().add(fD);
				}
			*/
		layout5.getChildren().addAll(Background,boxPic);
		
		Label label1 = new Label("Your turn!");
		
		scene5 = new Scene(layout5, 1366, 766);
		
		
		
		
		window.setTitle("Sushi Go");
		window.setScene(scene1);
		window.show();
	}

			
			
	
	
	
	
}
