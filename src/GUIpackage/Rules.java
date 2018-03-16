package GUIpackage;
import TEXTpackage.*;

import javafx.scene.control.Label;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.MouseEvent;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Hashtable;
	import java.util.LinkedList;
	import java.util.Scanner;

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
	
	import javafx.scene.control.ScrollPane;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.shape.*;
	import javafx.scene.paint.*;
	
	 
public class Rules extends MainScreen
{
		public static void main(String[] args) 
		{
			launch(args);
		}
		private GameConfiguration game;
		private Player[ ] players;
		
		public void start(Stage primaryStage) 
		{
			
			Stage window = primaryStage;
		
			
			
			
					
					
					Button quitRulesButton = new Button("Close Rules");
					quitRulesButton.setOnAction(e -> 
					
					{
							window.close();
					});
					
					
					//RULES Display
				
				
					StackPane mainScreenPane = new StackPane();
					ImageView mainScreenBackground = new ImageView("/pictures/rules.jpeg");
					mainScreenBackground.setFitHeight(600);
					mainScreenBackground.setFitWidth(1000);
					VBox mainScreenVBox = new VBox(20);
					mainScreenVBox.setAlignment(Pos.CENTER);
					mainScreenVBox.getChildren().add(quitRulesButton);
					mainScreenPane.getChildren().addAll(mainScreenBackground, mainScreenVBox);
					Scene mainScreenScene = new Scene(mainScreenPane, 1000,600);
					
					window.setTitle("Sushi Go Rules");
					window.setScene(mainScreenScene);
					window.show();
	}
	

}