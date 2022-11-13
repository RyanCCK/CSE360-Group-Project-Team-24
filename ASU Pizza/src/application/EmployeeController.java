
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class EmployeeController implements Initializable
{
	private static User employee;
	private OrderList orderList;
	
	@FXML
	private Button markPickup;
	@FXML
	private Button sendKitchen;
	@FXML
	private Button markFinished;
	@FXML
	private Button markCooking;
	@FXML
	private Button logout;
	@FXML
	private Button logout1;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			orderList = OrderList.getOrderList();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***************************************************************************************************************************************************
	 * CASHIER FUNCTIONS
	 *  
	 ***************************************************************************************************************************************************/
	
	
	
	/***************************************************************************************************************************************************
	 * HELPER FUNCTIONS
	 ***************************************************************************************************************************************************/
	public static void setEmployee(User emp) {
		employee = emp;
	}
	
	private ArrayList<Order> getCashierList() {
		ArrayList<Order> cashierList = orderList.getCashierOrderList();
		return cashierList;
	}
	
	private ArrayList<Order> getChefList() {
		ArrayList<Order> chefList = orderList.getChefOrderList();
		return chefList;
	}
	
	public void Logout(ActionEvent event) throws IOException {
		changeScene("Login.fxml", event);
	}
	
	public void changeScene(String fxml, ActionEvent event) throws IOException {
		Stage stage;
		Scene scene;
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}