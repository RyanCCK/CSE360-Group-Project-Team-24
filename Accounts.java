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

	public static boolean addCustomer(Customer customer)
	{
		if(customers.containsKey(customer.ASURITEID))
		{
			return false;
		}

		customers.put(customer.ASURITEID, customer);
		return true;
	}

	public static boolean addEmployee(User chefOrCashier) //need to input a Chef or Cashier object
	{
		if(employees.containsKey(chefOrCashier.ASURITEID))
		{
			return false;
		}

		employees.put(chefOrCashier.ASURITEID, chefOrCashier);
		return true;
	}

	public static void loadDefaultUsers() throws ClassNotFoundException, IOException
	{
		customers.put("jdoe123", new Customer("jdoe123", "password", "John Doe"));
		customers.put("jtest456", new Customer("jtest456", "12345", "Johnny Test"));

		employees.put("rwater100", new Chef("rwater100", "waterfall", "Royce Waterfall"));
		employees.put("gbox000", new Cashier("gbox000", "models", "George Box"));
	}
}
