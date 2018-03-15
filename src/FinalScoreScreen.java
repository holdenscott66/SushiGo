import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalScoreScreen extends PlayScreen {

	Stage window;
	Scene finalScoreScene;
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) 
	{
		window = primaryStage;
		MainScreen main = new MainScreen();
		Stage mainStage = new Stage();
		
		PlayScreen againAndAgain = new PlayScreen();
		Stage twoStage = new Stage();
		
		StackPane finalScore = new StackPane();
		Button playAgain = new Button("Back To Main Screen?");
		playAgain.setOnAction(e ->
		{
			
			window.close();
			main.start(mainStage);
		});
		
		Button playRightAway = new Button ("I NEED TO PLAY AGAIN NOW");
		playRightAway.setOnAction(e ->
		{
			window.close();
			againAndAgain.setGame(1,2);
			againAndAgain.start(twoStage);
		});
		
		
		ImageView background = new ImageView("/pictures/playagain.jpg");
		background.setFitHeight(600);
		background.setFitWidth(1000);
		//Score Display
			
			VBox finalScoreVBox = new VBox(100);
			finalScoreVBox.setAlignment(Pos.BOTTOM_CENTER);
			finalScoreVBox.getChildren().addAll(playAgain,playRightAway);
			finalScore.getChildren().addAll(background,finalScoreVBox);
			Scene finalScoreScene = new Scene(finalScore, 1000,600);
			
			window.setTitle("Sushi Go");
			window.setScene(finalScoreScene);
			window.show();
	}
	
	
}