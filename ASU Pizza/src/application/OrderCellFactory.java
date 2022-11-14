import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class OrderCellFactory implements Callback<ListView<Order>, ListCell<Order>>
{
	//Customize the display of Pizza objects in pizzaList ListView
		@Override
	    public ListCell<Order> call(ListView<Order> param) {
	        return new ListCell<>(){
	            @Override
	            public void updateItem(Order order, boolean empty) {
	                super.updateItem(order, empty);
	                if (empty || order == null) {
	                    setText(null);
	                } else {
	                    String orderInfo = "Customer ID: " + order.getCustID();
	                    orderInfo += "\nPickup Time: " + order.getTime();
	                    orderInfo += "\nStatus: " + order.getStatus();
	                    orderInfo += "\nPizzas: 1. " + order.pizzas.get(0).toString();
	                    for (int i = 1; i < order.pizzas.size(); i++) {
	                    	orderInfo += "\n  " + (i+1) + ". " + order.pizzas.get(i).toString();
	                    }
	                    orderInfo += "\n\n";
	                    setText(orderInfo);
	                }
	            }
	        };
	    }
}
