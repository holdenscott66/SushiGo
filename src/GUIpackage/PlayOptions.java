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

public class PlayOptions{
	Stage window;
	Scene playOptionsScene;

	public void start(Stage primaryStage) {
		window = primaryStage;
		PVPOptions pvp = new PVPOptions();
		Stage pvpStage = new Stage();
		EasyAI easyAI = new EasyAI();
		Stage easyAIStage = new Stage();
		HardAI hardAI = new HardAI();
		Stage hardAIStage = new Stage();
		Stage mainStage = new Stage();
		
	//buttons for Selection
		Button playerPVPButton = new Button("Player vs Player");
		Button easyAIButton = new Button("Player vs Easy Computer");
		Button hardAIButton = new Button("Player vs Hard Computer");
		Button backButton = new Button("Back");
		
		playerPVPButton.setOnAction(e -> {
			window.close();
			pvp.start(pvpStage);
		});
		easyAIButton.setOnAction(e ->{
			window.close();
			//easyAI.start(easyAIStage);
		});
		hardAIButton.setOnAction(e -> {
			window.close();
			//hardAI.start(hardAIStage);
		});
		backButton.setOnAction(e -> {
			window.close();
			//main.start(mainStage);
		});
		
		//PlayOptions Display
		StackPane playOptionsPane = new StackPane();
		ImageView playOptionsBackground = new ImageView("/pictures/Background.jpg");
		playOptionsBackground.setFitWidth(1000);
		playOptionsBackground.setFitHeight(600);
		VBox playOptionsScreenVBox = new VBox(20);
		playOptionsScreenVBox.setAlignment(Pos.CENTER);
		playOptionsScreenVBox.getChildren().addAll(playerPVPButton, easyAIButton, hardAIButton,backButton);
		playOptionsPane.getChildren().addAll(playOptionsBackground, playOptionsScreenVBox);
		Scene playOptionsScene = new Scene(playOptionsPane, 1000,600);
			
		window.setTitle("Sushi Go");
		window.setScene(playOptionsScene);
		window.show();
	}
}