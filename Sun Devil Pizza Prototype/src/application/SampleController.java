package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

public class SampleController implements Initializable{
	
	@FXML
	private Label addedToCartLabel;
	@FXML 
	private ChoiceBox<String> pizzaSizeChoiceBox;
	@FXML
	private ChoiceBox<String> pizzaTypeChoiceBox;
	@FXML
	private Button addToCartButton;
	@FXML
	private Button placeOrderButton;
	@FXML
	private ListView<String> pizzaCart;
	@FXML
	private Accordion myOrders;
	@FXML
	private TitledPane newOrder;
	private String[] pizzaSizes = {"Small", "Medium", "Large"};
	private String[] pizzaTypes = {"Cheese", "Pepperoni", "Vegetable"};
	private String currentPizzaSize;
	private String currentPizzaType;
	private int currentOrderNumber = 1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pizzaSizeChoiceBox.getItems().addAll(pizzaSizes);
		pizzaTypeChoiceBox.getItems().addAll(pizzaTypes);
	}
	
	@FXML
	public void onAddToCart(ActionEvent event)
	{
		currentPizzaSize = pizzaSizeChoiceBox.getValue();
		currentPizzaType = pizzaTypeChoiceBox.getValue();
		if (currentPizzaSize == null && currentPizzaType == null)
		{
			addedToCartLabel.setTextFill(Color.RED);
			addedToCartLabel.setText("Please make a selection");
		}
		else if (currentPizzaSize != null && currentPizzaType == null)
		{
			addedToCartLabel.setTextFill(Color.RED);
			addedToCartLabel.setText("Please select a pizza type");
		}
		else if (currentPizzaSize == null && currentPizzaType != null)
		{
			addedToCartLabel.setTextFill(Color.RED);
			addedToCartLabel.setText("Please select a pizza size");
		}
		else 
		{
			addedToCartLabel.setTextFill(Color.GREEN);
			addedToCartLabel.setText("Added " + currentPizzaSize + " " + currentPizzaType + " Pizza to your order");
			pizzaCart.getItems().add(currentPizzaSize + " " + currentPizzaType + " Pizza");
		}
	}
	
	@FXML public void onPlaceOrder(ActionEvent event)
	{
		newOrder = new TitledPane("Order " + currentOrderNumber, null);
		myOrders.getPanes().add(newOrder);
		pizzaCart.getItems().clear();
		currentOrderNumber++;
	}
}
