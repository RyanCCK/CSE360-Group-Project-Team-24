public class Cashier extends User{

	public Cashier(String asuriteID, String password, String name) 
	{
		super(asuriteID, password, name);
	}
	
	public void markAsReadyToCook(Order order)
	{
		order.setStatus("READY TO COOK");
	}
	
	public void markAsRecieved(Order order)
	{
		order.setStatus("RECEIVED");
	}	
}
