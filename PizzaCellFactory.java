import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class PizzaCellFactory implements Callback<ListView<Pizza>, ListCell<Pizza>>
{
	//Customize the display of Pizza objects in pizzaList ListView
		@Override
	    public ListCell<Pizza> call(ListView<Pizza> param) {
	        return new ListCell<>(){
	            @Override
	            public void updateItem(Pizza pizza, boolean empty) {
	                super.updateItem(pizza, empty);
	                if (empty || pizza == null) {
	                    setText(null);
	                } else {
	                    String pizzaInfo = pizza.getSize() + " " + pizza.getType() + " pizza";
	                    if (pizza.hasExtraCheese() || pizza.hasOlives() || pizza.hasMushroom() || pizza.hasOnions())
	                    {
	                    	pizzaInfo += " with:";
	                    	if (pizza.hasExtraCheese())
	                    		pizzaInfo += "\n\tExtra Cheese";
	                    	if (pizza.hasMushroom())
	                    		pizzaInfo += "\n\tMushrooms";
	                    	if (pizza.hasOlives())
	                    		pizzaInfo += "\n\tOlives";
	                    	if (pizza.hasOnions())
	                    		pizzaInfo += "\n\tOnions";
	                    }
	                    pizzaInfo += "\n\n";
	                    setText(pizzaInfo);
	                }
	            }
	        };
	    }
}
