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

public class LoginController implements Initializable
{
	@FXML
	private Button login;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public Customer onCustLogin(ActionEvent event) throws IOException {
		changeScene("CustomerView.fxml", event);
		
		return null;
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