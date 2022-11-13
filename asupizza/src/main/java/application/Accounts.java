package application;
import java.io.*;
import java.util.HashMap;

public class Accounts {

	public static HashMap<String, Customer> customers;		//id to customer objects
	public static HashMap<String, User> employees;			//id to employee objects (chef & cashier)

	public static void setUp()
	{
		customers = new HashMap<>();
		employees = new HashMap<>();
	}

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
		Accounts.storeCustomers();

		return true;
	}

	public static boolean addEmployee(User chefOrCashier) //need to input a Chef or Cashier object
	{
		if(employees.containsKey(chefOrCashier.ASURITEID))
		{
			return false;
		}

		employees.put(chefOrCashier.ASURITEID, chefOrCashier);
		Accounts.storeEmployees();

		return true;
	}

	public static void loadDefaultUsers() throws ClassNotFoundException, IOException
	{
		customers.put("jdoe123", new Customer("jdoe123", "password", "John Doe"));
		customers.put("jtest456", new Customer("jtest456", "12345", "Johnny Test"));

		employees.put("rwater100", new Chef("rwater100", "waterfall", "Royce Waterfall"));
		employees.put("gbox000", new Cashier("gbox000", "models", "George Box"));
	}

	public static void storeCustomers()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("customers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			for(Customer customer : customers.values())
			{
				out.writeObject(customer);
			}

			out.close();
			fileOut.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void loadCustomers()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("customers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			Customer customer;
			while((customer = (Customer)in.readObject()) != null)
			{
				customers.put(customer.ASURITEID, customer);
			}

			in.close();
			fileIn.close();
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		}
	}

	public static void storeEmployees()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("employees.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			for(User employee : employees.values())
			{
				out.writeObject(employee);
			}

			out.close();
			fileOut.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void loadEmployees()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("employees.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			User employee;
			while((employee = (User)in.readObject()) != null)
			{
				if(employee.isCashier())
				{
					employees.put(employee.ASURITEID, (Cashier)employee);
				}

				if(employee.isChef())
				{
					employees.put(employee.ASURITEID, (Chef)employee);
				}
			}

			in.close();
			fileIn.close();
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		}
	}
}
