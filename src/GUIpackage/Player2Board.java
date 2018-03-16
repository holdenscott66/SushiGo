package GUIpackage;
import TEXTpackage.*;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
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

public class Player2Board extends MainScreen {
	Stage window;
	ArrayList<String> board;
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		//Button
		Button back = new Button("Back");
		back.setOnAction(e ->window.close());
		//Display
		StackPane player2BoardStackPane = new StackPane();
		ImageView player2BoardBackground = new ImageView("/pictures/board.jpg");
		player2BoardBackground.setFitHeight(600);
		player2BoardBackground.setFitWidth(1000);
		HBox boardBox = new HBox(5);
		boardBox.setAlignment(Pos.CENTER);
		////////////////////////////////
		//Lets make player 2's board
		board = Player2Turn.getBoardOfStrings();
		if(board.size() > 0) {
			for(int card = 0; card <board.size(); card++) {
				ImageView boardCard = new ImageView("/pictures/" + board.get(card) +".png");
				boardCard.setFitHeight(100);
				boardCard.setFitWidth(75);
				boardBox.getChildren().add(boardCard);
			}
		}
		boardBox.getChildren().add(back);
		player2BoardStackPane.getChildren().addAll(player2BoardBackground, boardBox);
		Scene boardScene = new Scene (player2BoardStackPane, 1000,600);
		
		window.setTitle("Player 2's Board!");
		window.setScene(boardScene);;
		window.show();
	}//start end curly brackets
}//end of class brackets