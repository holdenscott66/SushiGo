	package GUIpackage;
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
	 
public class Rules
{
		public void start(Stage primaryStage) 
		{
			
			Stage window = primaryStage;
		
			//RULES Display
			ImageView tempuraRule = new ImageView("/GUIpackage/pictures/Tempura.png");
			ImageView makiRollRule = new ImageView("/GUIpackage/pictures/MakiRoll.png");
			ImageView dumplingRule = new ImageView("/GUIpackage/pictures/dumpling.png");
			ImageView eggNigiriRule = new ImageView("/GUIpackage/pictures/EggNigiri.png");
			ImageView wasabiRule = new ImageView("/GUIpackage/pictures/Wasabi.png");
			ImageView salmonNigiriRule = new ImageView("/GUIpackage/pictures/SalmonNigiri.png");
			ImageView sashimiRule = new ImageView("/GUIpackage/pictures/Sashimi.png");
			ImageView puddingRule = new ImageView("/GUIpackage/pictures/Pudding.png");
			ImageView squidNigiriRule = new ImageView("/GUIpackage/pictures/SquidNigiri.png");

			//should really make a for loop here, with the pictures inside a folder then loop through and change each height and width
			
			
				makiRollRule.setFitWidth(80);
				makiRollRule.setFitHeight(120);
				tempuraRule.setFitWidth(80);
				tempuraRule.setFitHeight(120);
				dumplingRule.setFitWidth(80);
				dumplingRule.setFitHeight(120);
				wasabiRule.setFitWidth(80);
				wasabiRule.setFitHeight(120);
				eggNigiriRule.setFitWidth(80);
				eggNigiriRule.setFitHeight(120);
				squidNigiriRule.setFitWidth(80);
				squidNigiriRule.setFitHeight(120);
				salmonNigiriRule.setFitWidth(80);
				salmonNigiriRule.setFitHeight(120);
				puddingRule.setFitWidth(80);
				puddingRule.setFitHeight(120);
				sashimiRule.setFitWidth(80);
				sashimiRule.setFitHeight(120);
			
			
			Label gameRules = new Label("The Set Up:\n" + 
					"A standard deck is made up of 14 Dumpling cards, 5 Egg Nigiri cards, 10 Salmon Nigiri cards, 5 Squid Nigiri cards, 26 Maki Roll cards, 14 Sashimi cards, 14 Tempura cards, 6 Wasabi cards,\n"
					+ "and 10 Pudding cards is created totaling 104 cards.\n" + 
					"Your first step is to select if you would like to play against either a human or an A.I. If you choose A.I you can choose easy or Hard!" 
					
					+"Gameplay:\n" + 
					"Sushi GO is a game based on creating combinations with your cards and getting points! Each card has special rules and you must fulfill certain criteria to receive points! Every player has a hand and each player has a board.  Every turn each player chooses a card from their hand to put on their board so they can keep it for scoring at the end of the game. After every player has chosen a card the turn ends. At the end of the turn, the players switch hands! The next turn starts and you choose a new card from the new hand. This repeats until no cards are left, then the cards on each player’s board is scored!\n" + 
					"At the end of the game, you will be prompted to play again!");
				
			Label tempuraLabel = new Label("A set of 2 tempura cards scores 5 points.\n"
										+ "A single tempura card is worth nothing. \n"
										+ "A player may score multiple sets of tempura in a round.");

			Label makiRollLabel = new Label("The players each add up the makiroll icons at the top of all their makiroll cards. \n"
										+ "The player with the most scores 6 points. \n"
										+ "No second place points are awarded.\n "
										+ "The player with the second most scores 3 points. \n"
										+ "If multiple players are tied for first or second place \n"
										+ "they split the points evenly (ignoring remainder)");
			
			Label dumplingLabel = new Label("The more dumplings a player has the more points they will score, as follows:\n "
										+ "Dumplings 1 2 3 4 5 or more\n" 
										+ "Points 1 3 6 10 15");
				
			Label wasabiLabel = new Label("A wasabi card by itself scores nothing. \n "
										+ "If there are multiple nigiri cards \n"
										+ "the wasabi card will be paired with the highest scoring nigiri card for the highest possible score!");
			
			Label eggNigiriLabel = new Label("An egg nigiri scores 1 point. If there is a wasabi card it scores 3.");
			Label squidNigiriLabel = new Label("A squid nigiri scores 3 points. If there is a wasabi card it scores 9.");
			Label salmonNigiriLabel = new Label("A salmon nigiri scores 2 points. If there is a wasabi card it scores 6.");
			
			Label puddingLabel = new Label("The player with the most pudding cards scores 6 points. \n"
										+ "If multiple players are tied for the most, they split the points evenly (ignoring any remainder).\n "
										+ "The player with the least pudding cards (which may be 0) loses 6 points. \n"
										+ "If multiple players are tied for the least, they split the lost points evenly (ignoring any remainder).");
			
			Label sashimiLabel = new Label("A set of 3 sashimi cards scores 10 points. \n"
										+ "A single sashimi card or a set of only 2 is worth nothing. \n"
										+ "A player may score multiple sets of sashimi in a round, although this is very hard to do!");
			
			Button backButton = new Button();
			backButton.setOnAction(e -> 
			
			{
				window.close();
				
			});
			
			
			ScrollPane ruleLayout = new ScrollPane();
			
			VBox picLayout = new VBox(20);
			HBox zeroRow = new HBox();
			HBox firstRow = new HBox();
			HBox secondRow = new HBox();
			HBox thirdRow = new HBox();
			HBox fourthRow = new HBox();
			HBox fifthRow = new HBox();
			HBox sixthRow = new HBox();
			HBox seventhRow = new HBox();
			HBox eighthRow = new HBox();
			HBox ninthRow = new HBox();
			
			/*
			 * was going to layer the picture with the name of the picture
			VBox firstColu = new VBox();
			VBox secondColu = new VBox();
			VBox thirdColu = new VBox();
			VBox fourthColu = new VBox();
			VBox fifthColu = new VBox();
			VBox sixthColu = new VBox();
			VBox seventhColu = new VBox();
			VBox eighthColu = new VBox();
			VBox ninthColu = new VBox();
			*/
			
			zeroRow.getChildren().add(gameRules);
			firstRow.getChildren().addAll(tempuraRule,tempuraLabel);
			secondRow.getChildren().addAll(makiRollRule,makiRollLabel);
			thirdRow.getChildren().addAll(eggNigiriRule, eggNigiriLabel);
			fourthRow.getChildren().addAll(squidNigiriRule, squidNigiriLabel);
			fifthRow.getChildren().addAll(puddingRule, puddingLabel);
			sixthRow.getChildren().addAll(salmonNigiriRule, salmonNigiriLabel);
			seventhRow.getChildren().addAll(wasabiRule, wasabiLabel);
			eighthRow.getChildren().addAll(dumplingRule, dumplingLabel);
			ninthRow.getChildren().addAll(sashimiRule, sashimiLabel);
					
		
					
					
					
			picLayout.getChildren().addAll(zeroRow,firstRow,secondRow,thirdRow,fourthRow,fifthRow, sixthRow, seventhRow, eighthRow, ninthRow);
			ruleLayout.setContent(picLayout);
			
					
					
	Scene mainScreenScene = new Scene(ruleLayout, 1000,600);
					
	window.setTitle("Sushi Go Rules");
	window.setScene(mainScreenScene);
	window.show();
	}
	

}