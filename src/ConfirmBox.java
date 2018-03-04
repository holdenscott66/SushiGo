import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static Boolean answer;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		
		Label label = new Label(message);
		
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
		
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,yes,no);
		Scene scene = new Scene(layout, 300, 200);
		window.setScene(scene);
		window.showAndWait();
		return answer;
	}

}