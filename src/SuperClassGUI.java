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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** This method turns newButton into a button using
	 * @param text to show what the text will be on the button
	 * The intended purpose is to use this objects newButton instanced
	 * variable to use that button and have it saved as part of a scene
	 * This will work whenever you want to create a button and just want to 
	 * have text on it
	 */

	public void make_Button_Text(String text)
	{
		newButton = new Button(text);
	}
	/**
	 * This method uses
	 * @param text to create a button with that text and
	 * @param graphic to use that node as an icon for the button
	 * 
	 */
	public void make_Button_Text_And_Icon(String text, Node graphic)
	{
		newButton = new Button(text, graphic);
		
	}
	
	/**
	 * Want that sick fucking button you just made dawg??
	 * Say no more homie, just get your object and be like object.get_Button() 
	 * and you get that good good button
	 */
	public Button get_Button()
	{
		return newButton;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * You want a label? Well here you go my dude, just call .make_Label(put label string here) and then call the getter
	 * and you got your mofuckin label
	 * @param name_Label
	 */
	public void make_Label(String name_Label)
	{
		newLabel = new Label(name_Label);
	}
	/**
	 * This is the getter I was talking bout. object.get_Label()
	 * @return newLabel so you get what you ask for
	 */
	public Label get_Label()
	{
		return newLabel;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * So you want to add pictures huh?
	 * This method object.make_Image(name of picture) should help you out
	 * What this mofucka does is it takes
	 * @param name_Of_Pic as a parameter and has 4 string variables that take that name and 
	 * add the common picture files. I add those bitches into a list and iterate through
	 * that list making a new image using those parameters.
	 * This isnt done yet, because it will need some exception handling if it errors
	 * out, but once this is done, all you need to make a picture is this function and the
	 * pic name. you dont even need to add the file extension i got you bro.
	 */
	public void make_Image(String name_Of_Pic)
	{
		ImageView check_Pic = null;
		ImageView compare_Pic;
		String picture_Name1 = name_Of_Pic +".jpg";
		String picture_Name2 = name_Of_Pic +".png";
		String picture_Name3 = name_Of_Pic +".jpeg";
		String picture_Name4 = name_Of_Pic +".gif";
		ArrayList<String> picture_Name_List = new ArrayList<String>();
		
		picture_Name_List.add(picture_Name1);
		picture_Name_List.add(picture_Name2);
		picture_Name_List.add(picture_Name3);
		picture_Name_List.add(picture_Name4);
		
		for(int allTypes = 0; allTypes < picture_Name_List.size(); allTypes++)
		{	
			compare_Pic = new ImageView(picture_Name_List.get(allTypes));
			//probably put exception handling here so if it errors out check pic doesnt change. 
			//if it doesnt change then it prints out a message saying your picture isnt in the bin folder dude
			if(check_Pic== new ImageView(picture_Name_List.get(allTypes)) )
		{
			newImage = check_Pic;
		}
		if(check_Pic == null)
		{
			System.out.println("Dawg, we cant find this pic, check your bin and workspace aight. Much Love, Daniel <3 <3");
		}
		}
		
	}
}
