import java.util.ArrayList;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class newGUI extends Application {
	private GameConfiguration hand;
	Stage window;
	Scene mainScreen, selection, gameRules, game, finalScore;
	
	public static void main(String[] args) {
		launch (args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {	
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		//buttons for Layout 1
		
		Button play = new Button("Play");
		Button rules = new Button("Rules");
		play.setOnAction(e -> window.setScene(selection));
		rules.setOnAction(e -> window.setScene(gameRules));
		
		//MainScreen
		
		StackPane layout1 = new StackPane();
		VBox vbox1 = new VBox(20);
		vbox1.setAlignment(Pos.CENTER);
		vbox1.getChildren().addAll(play, rules);
		layout1.getChildren().add(vbox1);
		mainScreen = new Scene(layout1, 1000, 600);
		
		//buttons for layout 2
		Button PvP = new Button("Player vs Player");
		Button easyAI = new Button("Player vs Easy Computer");
		Button hardAI = new Button("Player vs Hard Computer");
		Button selectionBack = new Button("Back");
		PvP.setOnAction(e -> window.setScene(game));
		selectionBack.setOnAction(e -> window.setScene(mainScreen));
		
		//Selection Screen
		StackPane layout2 = new StackPane();
		VBox vbox2 = new VBox(20);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.getChildren().addAll(PvP, easyAI, hardAI, selectionBack);
		layout2.getChildren().add(vbox2);
		selection = new Scene(layout2, 1000, 600);
		
		//buttons for Rules Screen
		Button ruleBack = new Button("Back");
		ruleBack.setOnAction(e -> window.setScene(mainScreen));
		
		//Rules Screen
		Label label = new Label("Rules Soon to Come");
		StackPane layout3 = new StackPane();
		VBox vbox3 = new VBox(20);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.getChildren().addAll(label, ruleBack);
		layout3.getChildren().add(vbox3);
		gameRules = new Scene(layout3, 1000, 600);
		
		//Game Screen
		hand = new GameConfiguration(1,2);
		StackPane layout4 = new StackPane();
		HBox bottom = new HBox(5);
		HBox top = new HBox(5);
		HBox both = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		top.setAlignment(Pos.TOP_CENTER);
		ImageView Background = new ImageView("Background.jpg");
		Background.setFitWidth(1920);
		Background.setFitHeight(1080);
		
		//Buttons for Game Screen
		for (int i = 0; i<hand.getHand(0).size(); i++) {
			ImageView topView = new ImageView(hand.getHand(0).get(i) +".png");
			topView.setFitHeight(100);
			topView.setFitWidth(75);
			Button bottomCards = new Button(null, topView);
			bottomCards.setText(hand.getHand(0).get(i));
			bottomCards.setContentDisplay(ContentDisplay.TOP);
			bottom.getChildren().addAll(bottomCards, topView);
		}
		for (int i = 0; i<hand.getHand(1).size(); i++) {
			ImageView bottomView = new ImageView("FaceDown.png");
			bottomView.setFitHeight(100);
			bottomView.setFitWidth(75);
			Button topCards = new Button(null, bottomView);
			topCards.setText("Card");
			topCards.setContentDisplay(ContentDisplay.BOTTOM);
			top.getChildren().addAll(topCards, bottomView);
			
		}
		
		layout4.getChildren().addAll(Background,bottom,top);
		game = new Scene(layout4, 1000, 600);
		
		
		
		
		
		
		//SHOW SCREEN
		primaryStage.setScene(mainScreen);
		primaryStage.setTitle("Sushi Go");
		primaryStage.show();
	}
	private void closeProgram() {
		boolean answer = ConfirmBox.display("Confirmation", "Sure you want to Exit?");
		if (answer) {
			window.close();
			System.out.println("Closed");
		}
	}
}
