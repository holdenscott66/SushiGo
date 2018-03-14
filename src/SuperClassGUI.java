import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

/**
 * This class will be used as a super class for the GUI portion of our game
 * The methods included will allow for subclasses to create things like buttons,
 * labels, scenes, images, and stackpanes by just calling the method.
 */
public abstract class SuperClassGUI 
{
	

	/*
	 * makeButton takes in the @param of a string that will hold the title
	 * of the button. It returns a new button that uses the string for the title
	 * button.
	 */
	public Button makeButton(String buttonTitle)
	{
		Button newButton = new Button(buttonTitle);
		return newButton;
	}
	
	/*
	 * makeLabel takes in the @param of a string that will hold the title of 
	 * the label. It returns a new label that uses the string for the label name.
	 */
	public Label makeLabel(String nameOfLabel)
	{
		Label newLabel = new Label(nameOfLabel);
		return newLabel;
	}

	/*
	 * makeImage takes in the @param of a string that is the title of the picture
	 * that will be in our bin folder. This method takes the parameter and adds .png
	 * and is saved under a string variable that then makes a new image based on that variable
	 * and returns that to make an image.
	 */
	public ImageView makeImage(String nameOfPic)
	{
		String pictureName = nameOfPic +".png";
		ImageView newPic = new ImageView(pictureName);
		return newPic;
	}
	/*
	 * makeVbox creates a new Vbox, takes in no parameters. Returns a new vbox.
	 */
	public VBox makeVbox()
	{
		VBox newVbox = new VBox ();
		return newVbox;
	}
	
	/*
	 * makeHbox creates a new Hbox, takes in no parameters. Returns a new hbox.
	 */
	public HBox makeHbox()
	{
		HBox newHbox = new HBox ();
		return newHbox;
	}
	
	/*
	 * makeStackPane creates a new StackPane, takes in no parameters. Returns a new StackPane.
	 */
	public StackPane makeStackPane()
	{
		return new StackPane();
	}
	
	/*
	 * makeScene takes in @param StackPane, @param double @param double as parameters and creates
	 * a new scene that displays the Stackpane along with the desired width and height in that order
	 */
	
	public Scene makeScene(StackPane newStackPane, double width, double height)
	{
		return new Scene(newStackPane, width, height);
	}
	
	
}
