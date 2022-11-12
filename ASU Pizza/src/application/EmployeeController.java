
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

}