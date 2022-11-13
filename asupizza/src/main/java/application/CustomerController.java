package application;
import java.io.IOException;
import java.time.LocalTime;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CustomerController implements Initializable
{
	//Innovate-A-Pizza
	@FXML
	private Button addToOrderButton;
	@FXML
	private Text orderMessage;
	@FXML
	private RadioButton small;
	@FXML
	private RadioButton medium;
	@FXML
	private RadioButton large;
	@FXML
	private RadioButton cheese;
	@FXML
	private RadioButton vegetable;
	@FXML
	private RadioButton pepperoni;
	@FXML
	private RadioButton extraCheese;
	@FXML
	private RadioButton mushroom;
	@FXML
	private RadioButton olives;
	@FXML
	private RadioButton onions;
	//Pizza Cart 
	@FXML
	private Button submitOrderButton;
	@FXML
	private Text subtotalDisplay;
	@FXML
	private Text taxDisplay;
	@FXML
	private Text totalDisplay;
	@FXML
	private Text submissionMessage;
	@FXML
	private Text emptyOrderMessage;
	@FXML
	private TextField asuIdField;
	@FXML
	private Button logout;
	@FXML
	private ChoiceBox<LocalTime> pickupTimeBox;
	@FXML
	private ListView<Pizza> pizzasList;
	
	private static Customer customer;
	private Pizza pizza;
	private String message = "";
	private double subtotal;
	private double tax;
	private double total;
	private String subtotalString = "$0";
	private String taxString = "$0";
	private String totalString = "$0";
	private String asuId;
	private LocalTime pickupTime;
	
	private final double salesTax = 0.081;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{	
		pizza = new Pizza();
		setPickupTimeChoiceBox();
		orderMessage.setText("");
		subtotalDisplay.setText(subtotalString);
		taxDisplay.setText(taxString);
		totalDisplay.setText(totalString);
		emptyOrderMessage.setText("You haven't added any pizzas!");
	}
	
	/***************************************************************************************************************************************************
	 * INNOVATE-A-PIZZA PAGE
	 ***************************************************************************************************************************************************/
	//Handles events when the "Add To Order" button is clicked
	@FXML
	public void onAddToOrder(ActionEvent event)
	{
		//Check if either of the required fields (size or type) has not been selected
		if (!(small.isSelected() || medium.isSelected() || large.isSelected()) 
			|| !(cheese.isSelected() || vegetable.isSelected() || pepperoni.isSelected()))
		{
			//If neither has been selected:
			if (!(small.isSelected() || medium.isSelected() || large.isSelected()) 
				&& !(cheese.isSelected() || vegetable.isSelected() || pepperoni.isSelected()))
				message = "Please select a size and type.";
			//If only size hasn't been selected:
			else if (!(small.isSelected() || medium.isSelected() || large.isSelected()))
				message = "Please select a size.";
			//If only type hasn't been selected:
			else message = "Please select a type.";
			
			orderMessage.setText(message);
		}
		//If required fields are filled in, set the pizza values and add to cart
		else
		{
			//Set pizza size
			if (small.isSelected())
				pizza.setSize("SMALL");
			else if (medium.isSelected())
				pizza.setSize("MEDIUM");
			else if (large.isSelected())
				pizza.setSize("LARGE");
			
			//Set pizza type
			if (cheese.isSelected())
				pizza.setType("CHEESE");
			else if (vegetable.isSelected())
				pizza.setType("VEGETABLE");
			else if (pepperoni.isSelected())
				pizza.setType("PEPPERONI");
			
			//Set toppings
			pizza.setExtraCheese(extraCheese.isSelected());
			pizza.setMushroom(mushroom.isSelected());
			pizza.setOlives(olives.isSelected());
			pizza.setOnions(onions.isSelected());
			
			//Set the display message
			message = "You have innovated a \n" + pizza.getSize().toLowerCase() + " " + pizza.getType().toLowerCase() + " pizza!";
			orderMessage.setText(message);
			
			//Add the pizza to the customer's order
			customer.order.addPizza(pizza);
			updatePizzaCart();
		}
	}
	
	/***************************************************************************************************************************************************
	 * PIZZA CART PAGE
	 ***************************************************************************************************************************************************/
	//Handles event where the customer clicks the "submit" button for their order
	@FXML
	public void onSubmitOrder(ActionEvent event)
	{
		//MUST check that the following 3 requirements are met:
		//	1. ASU ID must be entered, and must match customer's ASU ID
		//	2. Pickup Time must be selected
		//	3. There must be at least 1 pizza within the order
		//If any of these conditions are not met, display an appropriate error message.
		//If all conditions are met, submit the order
		
		//Error conditions
		if (asuIdField.getText().equals(""))	//If no ASU ID has been entered
		{
			submissionMessage.setText("Please enter your ASU ID");
		}
		else if (!asuIdField.getText().equals(customer.ASURITEID))	//If the ASU ID entered doesn't match the customer's actual ASU ID
		{
			submissionMessage.setText("ASU ID is incorrect");
		}
	}
	
	/***************************************************************************************************************************************************
	 * TRACK ORDER PAGE
	 ***************************************************************************************************************************************************/
	//Handles event where customer clicks the "logout" button
	@FXML
	public void onLogoutClick(ActionEvent event) {
		try {
			changeScene("Login.fxml", event);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/***************************************************************************************************************************************************
	 * HELPER FUNCTIONS
	 ***************************************************************************************************************************************************/
	//Updates the display on Pizza Cart page based on the customer's current order 
	private void updatePizzaCart()
	{
		//Update order prices and price display
		subtotal = customer.order.cost;
		tax = customer.order.cost * salesTax;
		total = customer.order.cost + (customer.order.cost * salesTax);
		subtotalString = "$" + String.format("%.2f", subtotal);
		taxString = "$" + String.format("%.2f", tax);    
		totalString = "$" + String.format("%.2f", total); 
		subtotalDisplay.setText(subtotalString);
		taxDisplay.setText(taxString);
		totalDisplay.setText(totalString);
		
		//Update pizzas list
		//pizzasList.get
	}
	
	private void setPickupTimeChoiceBox()
	{
		
	}
	
	//Handles scene changes
	private void changeScene(String fxml, ActionEvent event) throws IOException {
		Stage stage;
		Scene scene;
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void setCustomer(Customer cust) {
		customer = cust;
	}
}
