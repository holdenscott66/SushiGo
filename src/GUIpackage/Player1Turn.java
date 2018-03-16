package GUIpackage;
import TEXTpackage.*;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;
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
public class Player1Turn {
	Stage window;
	LinkedList<Button> hand;
	HBox player1Hbox = new HBox(5);
	private int count = 1;
	public static ArrayList<String> boardOfStrings = new ArrayList<String>();
	
	public static ArrayList<String> getBoardOfStrings() {
		return boardOfStrings;
	}
	
	public void setHandPlayer1(LinkedList<Button> newHand) {
		hand = new LinkedList<Button>(newHand);
		//Test to check the full hand passing through, the cards in the hand passing
		//through and to check that those same cards are now converted into the hand
//		System.out.println("The hand that is being passed contains" + newHand);
//		for(int i = 0; i < newHand.size(); i++)
//		{
//			System.out.println("The hand that is being passed contains: " + newHand.get(i).getText());
//		}
//		System.out.println("Player 1 hand has:" + hand);
//		for(int j = 0; j< hand.size(); j++)
//		{
//			System.out.println("The specific cards in Player 1 hand are: " + hand.get(j).getText());
//		}	
	}
	public void setHandButtons(LinkedList<Button> currentHand) {
		for(int card = 0; card < currentHand.size(); card++) {
			player1Hbox.getChildren().add(hand.get(card));
			currentHand.get(card).setOnAction(e -> {
				//boolean answer = ConfirmBox.choiceCard();
				//if (answer) {
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
					boardOfStrings.add(cardPlayed);
					//quick test to print out your board as strings
					for(int i = 0; i <boardOfStrings.size(); i++) {
						System.out.println("PLAYER 1 This is your current board as Strings: " +boardOfStrings.get(i));	
					}
					
//					//Quick test to show list of cards before and after removing the card
//					System.out.println("This is the list of cards before you removed this button");
//					for(int i = 0; i < hand.size(); i++)
//					{
//						System.out.println("The card: "+ hand.get(i).getText() +"is in the hand for now");
//					}
//					System.out.println("This is the name of the card you will remove: " +cardPlayed);
//					
					hand.remove(buttonPlayed);
					PlayScreen.putOnBoard(PlayScreen.getPlayer1Board(), cardPlayed);
					player1Hbox.getChildren().remove(buttonPlayed);
//					for(int j = 0; j < hand.size(); j++)
//					{
//						System.out.println("The card: "+ hand.get(j).getText() +"remains in the hand");
//					}
//					
//					System.out.println("As you can see, you have removed "+cardPlayed);
					
					//CLOSES WINDOW AFTER SELECTION
					PlayScreen.updateHand1(getPlayer1Hand());
//					//Test to see what the new hand is. should match current hand in this class
//					for(int i = 0; i < PlayScreen.getHand1().size(); i++)
//					{
//					System.out.println("This is now the updated hand1 in the PlayScreen: " +PlayScreen.getHand1().get(i).getText());
//					}
					
					
					PlayScreen.updatePlayer1Count(count);
					
					//Test to check out player 1 count
//					System.out.println("Player 1 has completed " +PlayScreen.getPlayer1TurnCount() +" turns.");
					
					
					//Need this so that you don't show too many cards
					for(int allButtons = 0; allButtons <hand.size(); allButtons++) {
						player1Hbox.getChildren().remove(hand.get(allButtons));
					}
					window.close();
			});
		}		
	}

	public LinkedList<Button> getPlayer1Hand() {
		return hand;
	}
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox.select();
		});
////////////////////////////////////////////////////////////////////////////
	//Display
	StackPane player1Pane = new StackPane();
	ImageView player1Background = new ImageView("/GUIpackage/pictures/player1.jpg");
	player1Background.setFitHeight(600);
	player1Background.setFitWidth(1000);
	player1Hbox.setAlignment(Pos.BOTTOM_CENTER);
	player1Pane.getChildren().addAll(player1Background,player1Hbox);
	Scene player1Scene = new Scene(player1Pane, 1000, 600);
	
	window.setTitle("PLAYER 1 TURN!");
	window.setScene(player1Scene);
	window.show();
////////////////////////////////////////////////////////////////////////////
	//Set player 1 hand based on hand put in through PlayScreen
	//Test out setHandPlayer1 
	setHandPlayer1(hand);
	//Test out setHandButtons
	setHandButtons(hand);
	//Other Buttons
	}//start end curly bracket
}//curly bracket that ends this class