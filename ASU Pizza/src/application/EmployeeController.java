
import java.time.LocalTime;
import java.net.URL;
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
	private static Chef chef;
	private static Cashier cashier;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/***************************************************************************************************************************************************
	 * HELPER FUNCTIONS
	 ***************************************************************************************************************************************************/
	public static void setEmployee(User emp) {
		if (emp.isCashier()) {
			cashier = (Cashier) emp;
		} else if (emp.isChef()) {
			chef = (Chef) emp;
		}
	}

}