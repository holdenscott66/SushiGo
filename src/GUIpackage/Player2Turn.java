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
public class Player2Turn extends MainScreen {
	Stage window;
	LinkedList<Button> hand;
	HBox player2Hbox = new HBox(5);
	HBox boardButtons = new HBox(5);
	private int count = 1;
	public static ArrayList<String> boardOfStrings = new ArrayList<String>();
	
	public static ArrayList<String> getBoardOfStrings() {
		return boardOfStrings;
	}
	
	public void setHandPlayer2(LinkedList<Button> newHand) {
		hand = new LinkedList<Button>(newHand);
		//Test to check the full hand passing through, the cards in the hand passing
		//through and to check that those same cards are now converted into the hand
//		System.out.println("The hand that is being passed contains" + newHand);
//		for(int i = 0; i < newHand.size(); i++)
//		{
//			System.out.println("The hand that is being passed contains: " + newHand.get(i).getText());
//		}
//		System.out.println("Player 2 hand has:" + hand);
//		for(int j = 0; j< hand.size(); j++)
//		{
//			System.out.println("The specific cards in Player 2 hand are: " + hand.get(j).getText());
//		}	
	}
	
	public void setHandButtons(LinkedList<Button> currentHand) {
		for(int card = 0; card < currentHand.size(); card++) {
			player2Hbox.getChildren().add(hand.get(card));
			currentHand.get(card).setOnAction(e -> {
				//boolean answer = ConfirmBox.choiceCard();
				//if (answer) {
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
					boardOfStrings.add(cardPlayed);
					//Quick test to print out your board as strings
					for(int i = 0; i <boardOfStrings.size(); i++) {
						System.out.println("PLAYER 2 This is your current board as Strings: " +boardOfStrings.get(i));	
					}
					//Quick test to show list of cards before and after removing the card
//					System.out.println("This is the list of cards before you removed this button");
//					for(int i = 0; i < hand.size(); i++)
//					{
//						System.out.println("The card: "+ hand.get(i).getText() +"is in the hand for now");
//					}
//					System.out.println("This is the name of the card you will remove: " +cardPlayed);
//					
					hand.remove(buttonPlayed);
					PlayScreen.putOnBoard(PlayScreen.getPlayer1Board(), cardPlayed);
					player2Hbox.getChildren().remove(buttonPlayed);
//					for(int j = 0; j < hand.size(); j++)
//					{
//						System.out.println("The card: "+ hand.get(j).getText() +"remains in the hand");
//					}
//					
//					System.out.println("As you can see, you have removed "+cardPlayed);
					
					//CLOSES WINDOW AFTER SELECTION
					PlayScreen.updateHand2(getPlayer2Hand());
//					//Test to see what the new hand is. should match current hand in this class
//					for(int i = 0; i < PlayScreen.getHand2().size(); i++)
//					{
//						System.out.println("This is now the updated hand2 in the PlayScreen: " +PlayScreen.getHand2().get(i).getText());
//					}
					
					PlayScreen.updatePlayer2Count(count);
					
					//Test to check out player 2 count
//					
//					System.out.println("Player 2 has completed " +PlayScreen.getPlayer2TurnCount() +" turns.");
					
					//Need this so that you don't show too many cards
					for(int allButtons = 0; allButtons <hand.size(); allButtons++) {
						player2Hbox.getChildren().remove(hand.get(allButtons));
					}
					window.close();
				//}
			});
		}
	}
	
	public LinkedList<Button> getPlayer2Hand() {
		return hand;
	}
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox.select();
		});
		Player1Board board1 = new Player1Board();
		Player2Board board2 = new Player2Board();
		Stage board1Stage = new Stage();
		Stage board2Stage = new Stage();
		
		
		/////////////
		//Buttons iuts fucking up
//		Button boardPlayer1 = new Button("View Player 1's Board");
//		boardPlayer1.setOnAction(e ->
//		{
//			board1.start(board1Stage);
//		});
//		
//		Button boardPlayer2 = new Button("View Player 2's Board");
//		boardPlayer2.setOnAction(e ->
//		{
//			board2.start(board2Stage);
//		});
////////////////////////////////////////////////////////////////////////////
		//Display
		StackPane player2Pane = new StackPane();
		ImageView player2Background = new ImageView("/pictures/player2.jpg");
		player2Background.setFitHeight(600);
		player2Background.setFitWidth(1000);
		player2Hbox.setAlignment(Pos.TOP_CENTER);
		//boardButtons.getChildren().addAll(boardPlayer1, boardPlayer2);
		player2Pane.getChildren().addAll(player2Background,player2Hbox);
		Scene player2Scene = new Scene(player2Pane, 1000, 600);

		window.setTitle("PLAYER 2 TURN!");
		window.setScene(player2Scene);
		window.show();
////////////////////////////////////////////////////////////////////////////
		//Set player 2 hand based on hand put in through PlayScreen
		//Test out setHandPlayer2 
		setHandPlayer2(hand);
		//Test out setHandButtons
		setHandButtons(hand);	
	}//start end curly bracket

}//curly bracket that ends this class