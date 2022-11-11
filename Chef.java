
public class Chef extends User
{
	public Chef(String asuriteID, String password, String name)	//constructor
	{
		super(asuriteID, password, name);
	}
	
	public void markAsCooking(Order order)
	{
		order.setStatus("COOKING");
	}
	
	public void markAsDone(Order order)
	{
		order.setStatus("READY");
	}
}
