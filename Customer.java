import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;


public class Customer extends User
{
    private Order order = null;
    private int orderID = -1;

    OrderList instance;

    public Customer(String asuriteID, String password, String name) throws ClassNotFoundException, IOException
    {
        super(asuriteID, password, name);

        instance = OrderList.getOrderList();
    }

    //getters
    public Order getOrder() throws Exception
    {
        if(order == null)
        {
            throw new Exception("Order never initialized");
        }

        return order;
    }

    public int getOrderID() throws Exception
    {
        if(orderID == -1)
        {
            throw new Exception("Order never initialized");
        }

        return orderID;
    }
    
    public void createOrder(int size, LocalTime time, int ASURITEID)
    {
        Random rand = new Random();
        orderID = rand.nextInt(100000000);      //creates random 8 digit number

        //not sure what size does,
        order = new Order(orderID, size, time, ASURITEID); 
    }

    public void sendOrder() throws IOException
    {
        instance.insertOrder(order);
    }

    public void deleteOrder() throws IOException
    {
        instance.deleteOrder(orderID);
        order = null;
        orderID = -1;
    }

    public boolean isOrderComplete(int orderID)
    {  
        Order check = instance.getOrder(orderID);
        
        if(check.getStatus().toUpperCase().equals("READY"))
        {
            order = null;   //resets customer order once complete
            orderID = -1;
            return true;
        }

        return false;
    }
}
