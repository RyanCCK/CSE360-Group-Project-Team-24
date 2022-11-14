
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.stage.Stage;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

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
	@FXML
	private ListView<Order> cashList;
	@FXML
	private ListView<Order> chefList;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			orderList = OrderList.getOrderList();
			orderList.loadOrderList();
			cashList.setCellFactory(new OrderCellFactory());
			chefList.setCellFactory(new OrderCellFactory());
			cashList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			chefList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			updateCashierList();
			updateChefList();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***************************************************************************************************************************************************
	 * CASHIER FUNCTIONS
	 *  
	 ***************************************************************************************************************************************************/
	public void sendToKitchen() {
		int selectedIndex = cashList.getSelectionModel().getSelectedIndex();
		getCashierList().get(selectedIndex).setStatus("READY TO COOK");
		updateCashierList();
		updateChefList();
	}
	
	public void markPickedUp() {
		int selectedIndex = cashList.getSelectionModel().getSelectedIndex();
		getCashierList().get(selectedIndex).setStatus("PICKED UP");
		updateCashierList();
	}
	
	
	
	/***************************************************************************************************************************************************
	 * CHEF FUNCTIONS
	 *  
	 ***************************************************************************************************************************************************/
	public void markCooking() {
		int selectedIndex = chefList.getSelectionModel().getSelectedIndex();
		getChefList().get(selectedIndex).setStatus("COOKING");
		updateChefList();
	}
	
	public void markDone() {
		int selectedIndex = chefList.getSelectionModel().getSelectedIndex();
		
		if (getChefList().get(selectedIndex).getStatus().equals("COOKING")) {
			getChefList().get(selectedIndex).setStatus("READY");		
			updateChefList();
			updateCashierList();
		}
		
	}
	
	
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
	
	private void updateCashierList() {
		cashList.getItems().clear();
		//cashList.getItems().add(orderList.orderList.get(0).pizzas.get(0));
		//System.out.println(orderList.orderList.get(0).getStatus());
		for(int i = 0; i < getCashierList().size(); i++) {
			cashList.getItems().add(getCashierList().get(i));
		}
	}
	
	private ArrayList<Order> getChefList() {
		ArrayList<Order> chefList = orderList.getChefOrderList();
		return chefList;
	}
	
	private void updateChefList() {
		chefList.getItems().clear();
		for (int i = 0; i < getChefList().size(); i++) {
			chefList.getItems().add(getChefList().get(i));
			System.out.println(i);
		}
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