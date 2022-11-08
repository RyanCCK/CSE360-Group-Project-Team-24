import java.io.IOException;
import java.util.HashMap;

public class Accounts {

	private static HashMap<String, Customer> customers = new HashMap<>();		//id to customer objects
	private static HashMap<String, User> employees = new HashMap<>();			//id to employee objects (chef & cashier)

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

	public static boolean addCustomer(String asuriteID, String password, String name) throws ClassNotFoundException, IOException
	{
		if(customers.containsKey(asuriteID))
		{
			return false;
		}

		customers.put(asuriteID, new Customer(asuriteID, password, name));
		return true;
	}

	public static boolean addEmployee(String asuriteID, String password, String name)
	{
		if(employees.containsKey(asuriteID))
		{
			return false;
		}

		employees.put(asuriteID, new User(asuriteID, password, name));
		return true;
	}
}
