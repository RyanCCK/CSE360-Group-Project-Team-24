package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//launch(args);		//JavaFX 
		
		OrderList orderList = OrderList.getOrderList();
		
		//Insert 5 orders into the order list
		for (int i=1; i<=5; ++i)
		{
			orderList.insertOrder(new Order(i, i));
		}
		
		//Test print
		orderList.printOrderList();
		System.out.println("\n\n");
		
		//Insert 2 more orders into the order list
		orderList.insertOrder(new Order(42, 3));
		orderList.insertOrder(new Order(6, 7));
		
		//Test print
		orderList.printOrderList();
		System.out.println("\n\n");
		
		//Remove several orders
		orderList.deleteOrder(1);
		orderList.deleteOrder(2);
		orderList.deleteOrder(3);
		
		//Test print
		orderList.printOrderList();
		System.out.println("\n\n");
	}
}
