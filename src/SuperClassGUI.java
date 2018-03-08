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
 * Hopefully it will create methods that allow us to create scenes and other 
 * shit more easily
 * @author Daniel
 *
 */
public class SuperClassGUI 
{
	//Instanced variables that this class will have
	//NODES
	private Button newButton;
	private Label newLabel;
	
	private Node newGraphic;
	private Scene newScene;
	private StackPane newStackPane;
	private ImageView newImage;
	private VBox newVbox;
	private HBox newHbox;

	//method to make a button,returns a button
	public Button make_Button(String text)
	{
		Button new_Button = new Button(text);
		return new_Button;
	}
	
	//method to make a labe, returns a label
	public Label make_Label(String name_Label)
	{
		Label new_Label = new Label(name_Label);
		return new_Label;
	}

	//method to make an image returns an image
	public ImageView make_Image(String name_Of_Pic)
	{
		String picture_Name = name_Of_Pic +".png";
		ImageView new_Pic = new ImageView(picture_Name);
		return new_Pic;
	}
	//method to make a Vbox returns VBox
	public VBox makeVbox()
	{
		VBox newVbox = new VBox ();
		return newVbox;
	}
	//method to make a Hbox returns VBox
	public HBox makeHbox()
	{
		HBox newHbox = new HBox ();
		return newHbox;
	}
	
}