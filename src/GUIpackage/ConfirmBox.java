package GUIpackage;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class ConfirmBox {
	
	static Boolean answer;
	static Boolean choice;
	
	public static boolean choiceCard() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmation");
		window.setMinWidth(300);
		
		Label label = new Label("Are you sure you want to choose this card?");
		label.setFont(new Font("Arial",15));
		label.setTextFill(Color.BLACK);
		
		Button yes = new Button("Yes");
		yes.setOnAction(e -> {
		choice= true;
		window.close();
		});
		Button no = new Button("No");
		no.setOnAction(e -> {
		choice = false;
		window.close();
		});
		StackPane displayPane = new StackPane();
		ImageView displayBackground = new ImageView("/GUIpackage/pictures/areyousure.jpg");
		displayBackground.setFitWidth(328);
		displayBackground.setFitHeight(294);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,yes,no);
		displayPane.getChildren().addAll(displayBackground, layout);
		Scene scene = new Scene(displayPane, 328, 294);
		window.setScene(scene);
		window.showAndWait();
		return choice;
	}
	
	public static boolean display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmation");
		window.setMinWidth(300);
		
		Label label = new Label("Are you sure you want to quit?");
		label.setFont(new Font("Arial",30));
		label.setTextFill(Color.BLACK);
		
		Button yes = new Button("Yes");
		yes.setOnAction(e -> {
		answer = true;
		window.close();
		});
		Button no = new Button("No");
		no.setOnAction(e -> {
		answer = false;
		window.close();
		});
		StackPane displayPane = new StackPane();
		ImageView displayBackground = new ImageView("/GUIpackage/pictures/quit.jpg");
		displayBackground.setFitWidth(657);
		displayBackground.setFitHeight(588);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,yes,no);
		displayPane.getChildren().addAll(displayBackground, layout);
		Scene scene = new Scene(displayPane, 657, 588);
		window.setScene(scene);
		window.showAndWait();
		return answer;
	}
	public static void select() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmation");
		window.setMinWidth(300);
		
		Label label = new Label("Please select a card");
		Button back = new Button("Back");
		back.setOnAction(e -> {
			window.close();
		});
		StackPane displayPane = new StackPane();
		ImageView displayBackground = new ImageView("/GUIpackage/pictures/quit.jpg");
		displayBackground.setFitWidth(657);
		displayBackground.setFitHeight(588);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,back);
		displayPane.getChildren().addAll(displayBackground, layout);
		Scene scene = new Scene(displayPane, 657, 588);
		window.setScene(scene);
		window.showAndWait();
	}

}
