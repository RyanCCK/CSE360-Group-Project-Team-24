package application;
import java.io.IOException;


public class Customer extends User
{
    public Order order;	//The order being created by the customer
    public OrderList instance;

    public Customer(String asuriteID, String password, String name) throws ClassNotFoundException, IOException
    {
        super(asuriteID, password, name);
        order = new Order(ASURITEID);

        instance = OrderList.getOrderList();
    }

    //getter
    public Order getOrder() 
    {
        return order;
    }
    
    //Submit the customer's current order to the orderList
    public void submitOrder() throws IOException
    {
    	instance.insertOrder(order);
        order = new Order(ASURITEID);	//reset the customer's current order 
    }
}
