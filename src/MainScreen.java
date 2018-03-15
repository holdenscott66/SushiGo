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

public class MainScreen extends Application
{
	Stage window;
	boolean answer;
	
	/*
	 * This method is used to confirm the user's choice to quit.
	 */
	private void closeProgram() 
	{
		boolean answer = ConfirmBox.display();
		if (answer) 
		{
			window.close();
			System.out.println("Closed");
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	

	public void start(Stage primaryStage)  
	{
		window = primaryStage;
		PlayOptions options = new PlayOptions();
		Stage optionsStage = new Stage();
		window.setOnCloseRequest(e -> 
		{
			e.consume();
			closeProgram();
		});
		
		
		Rules rules = new Rules();
		Stage ruleStage = new Stage();
		
		//FinalScore finalScore = new FinalScore();
		//Stage finalScoreStage = new Stage();
	
		//BUTTONS AND WHAT THEY DO

		Button playButton = new Button("Let's Play!");
		playButton.setOnAction(e ->
			{
				window.close();
				options.start(optionsStage);
			});
		
		Button rulesButton = new Button("Rules");
		rulesButton.setOnAction(e ->
			{
				rules.start(ruleStage);
			});
		
		Button exitButton = new Button("Quit");
		exitButton.setOnAction(e ->
		{
			closeProgram();
			if(answer == true)
			{
				window.close();
			}
		});
				
				
		//mainScreen Display
		StackPane mainScreenPane = new StackPane();
		ImageView mainScreenBackground = new ImageView("/pictures/mainscreen.png");
		mainScreenBackground.setFitHeight(600);
		mainScreenBackground.setFitWidth(1000);
		VBox mainScreenVBox = new VBox(20);
		mainScreenVBox.setAlignment(Pos.CENTER);
		mainScreenVBox.getChildren().addAll(playButton, rulesButton, exitButton);
		mainScreenPane.getChildren().addAll(mainScreenBackground, mainScreenVBox);
		Scene mainScreenScene = new Scene(mainScreenPane, 1000,600);
	
		window.setTitle("Sushi Go");
		window.setScene(mainScreenScene);
		window.show();
			
				
		
				
				
				
	}


}