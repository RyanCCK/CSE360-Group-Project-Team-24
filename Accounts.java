import java.util.HashMap;

public class Accounts {

	private static HashMap<String, Customer> customers = new HashMap<>();		//id to customer objects
	private static HashMap<String, User> employees = new HashMap<>();

	public static Customer verifyCustomerLogin(String id, String password)
	{
		if(!customers.containsKey(id))
		{
			System.out.println("User does not exist");
			return null;
		}
		
		Customer obj = customers.get(id);
		if(!password.equals(obj.getPassword()))
		{
			System.out.println("Password is wrong");
			return null;
		}

		return obj;
	}
	
	public static User verifyEmployeeLogin(String id, String password)
	{
		if(!employees.containsKey(id))
		{
			System.out.println("User does not exist");
			return null;
		}
		
		User obj = employees.get(id);
		if(!password.equals(obj.getPassword()))
		{
			System.out.println("Password is wrong");
			return null;
		}

		return obj;
	}

	//will need to add default user/passwords and methods to create new users
}
