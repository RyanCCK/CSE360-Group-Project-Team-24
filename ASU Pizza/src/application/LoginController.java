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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController implements Initializable
{
	@FXML
	private Button custLogin;
	@FXML
	private TextField asuid;
	@FXML
	private PasswordField password;
	@FXML
	private TextField empID;
	@FXML
	private PasswordField empPassword;
	@FXML
	private Text failText;
	@FXML
	private Text empFailText;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Accounts.setUp();
		try {
			Accounts.loadDefaultUsers();
			Accounts.storeCustomers();
			Accounts.storeEmployees();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Handles a user clicking on the customer login button
	@FXML
	public void onCustLogin(ActionEvent event) throws IOException {
		String id = asuid.getText();
		String pass = password.getText();
		Customer customer = Accounts.verifyCustomerLogin(id, pass);
		
		if (customer != null) {
			CustomerController.setCustomer(customer);;	
			changeScene("CustomerView.fxml", event);
		} else {
			failText.setVisible(true);
		}
	}
	
	//Handles a user clicking on the employee login button
	@FXML
	 public void onEmployeeLogin(ActionEvent event) throws IOException {
		 String id = empID.getText();
		 String pass = empPassword.getText();
		 User user = Accounts.verifyEmployeeLogin(id, pass);
		 
		 if (user != null) {
			 EmployeeController.setEmployee(user);
			 changeScene("EmployeeView.fxml", event);
		 } else {
			 empFailText.setVisible(true);
		 }
	 }
	
	
	/***************************************************************************************************************************************************
	 * HELPER FUNCTIONS
	 ***************************************************************************************************************************************************/
	
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