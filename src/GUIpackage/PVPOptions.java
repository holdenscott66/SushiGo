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

public class PVPOptions{
	Stage window;
	private GameConfiguration game;

	public void setGame(GameConfiguration gameType) {
		this.game = gameType;
	}
	
	public GameConfiguration getGame() {
		return game;
	}

	public void start(Stage primaryStage) {
		window = primaryStage;
		PlayScreen playGame = new PlayScreen();
		Stage playStage = new Stage();
		
		//Buttons
		Button twoPlayers = new Button("Two Players");
		window.setOnCloseRequest(e -> {
			e.consume();
			window.close();
		});
		
		twoPlayers.setOnAction(e -> {
			playGame.setGame(1,2);
			playGame.start(playStage);
			window.close();
		});

		StackPane playerPane = new StackPane();
		ImageView selectionBackground = new ImageView("/pictures/player.png");
		selectionBackground.setFitWidth(1000);
		selectionBackground.setFitHeight(600);
		VBox playerVBox = new VBox(20);
		playerVBox.setAlignment(Pos.CENTER);
		playerVBox.getChildren().addAll(twoPlayers);
		playerPane.getChildren().addAll(selectionBackground, playerVBox);
		Scene playerScene = new Scene(playerPane, 1000, 600);
		
		window.setTitle("Sushi Go");
		window.setScene(playerScene);
		window.show();
		
	}
}
