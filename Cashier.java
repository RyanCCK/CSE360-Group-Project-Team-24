public class Cashier extends User{

	public Cashier(String asuriteID, String password, String name) 
	{
		super(asuriteID, password, name);
	}
	
	public void login() 
	{
		//login through data base
	}
	
	public void logout()
	{
		//logout through database
	}
	
	public void sendtoChef(Order order)
	{
		//send order details to chef method added later.
		order.setStatus("Sent to Chef");
	}
	
	public void markAsRecieved(Order order)
	{
		order.setStatus("Received!");
	}
	
}
