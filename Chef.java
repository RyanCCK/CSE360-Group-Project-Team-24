
public class Chef extends User
{
	public Chef(String asuriteID, String password, String name)	//constructor
	{
		super.ASURITEID = asuriteID;
        super.password = password;
        super.name = name;
        
        //maybe instead of login/logout, we call the constructor 
        // with just asurite id and password, then it searches 
        //through the "database" to find a matching name, that is then displayed
	}
	
	public void login()
	{
		//look through database to find user name and password
	}
	
	public void logout()
	{
		
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
