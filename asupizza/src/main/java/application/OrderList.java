package application;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

//Singleton class that stores all orders in active memory
public class OrderList implements Serializable
{
	//private static final long serialVersionUid = -2215140946170431079;
	private static OrderList instance = null;	//There will only be 1 instance of an OrderList
	private ArrayList<Order> orderList;
	private static String filename = "database.txt";
	private File file = new File(filename);
	
	//private constructor
	private OrderList() throws ClassNotFoundException, IOException 
	{
		orderList = new ArrayList<Order>();	
		if (!file.exists())
		{
			file.createNewFile();
		}
		loadOrderList();
	}
	
	//public getter 
	public static OrderList getOrderList() throws ClassNotFoundException, IOException
	{
		if (instance == null)
			instance = new OrderList();
		
		return instance;
	}
	
	//Load orderList from file
	public void loadOrderList() throws IOException, ClassNotFoundException 
	{
		if (file.length() != 0)	//Verify that file is not empty before reading
		{
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			orderList = (ArrayList<Order>) objIn.readObject();
			
			fileIn.close();
			objIn.close();
		}
	}
	
	//Save orderList to file
	private void saveOrderList() throws IOException
	{
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

		objOut.writeObject(orderList);
		
		fileOut.close();
		objOut.close();
	}
	
	//TODO:
	//	Check that an Order has at least one pizza, an ASUID and a pickup time before inserting it
	//
	//Insert Order in the correct sorted position
	public void insertOrder(Order order) throws IOException 
	{
		orderList.add(order);
		Collections.sort(orderList);
		saveOrderList();
	}
	
	//Delete Order
	public boolean deleteOrder(int orderID) throws IOException
	{
		//Find order in orderList with given orderID
		boolean found = false;
		int i=0;
		while (!found && i<orderList.size())
		{
			if (orderList.get(i).id == orderID)
			{
				found = true;
				orderList.remove(i);
				Collections.sort(orderList);
				saveOrderList();
			}
			else ++i;
		}
		return found;
	}
	
	//for testing purposes
	public String toString()
	{
		String orderListString = "";
		
		for(int i=0; i<orderList.size(); ++i)
		{
			orderListString += ("id: " + orderList.get(i).id);
			orderListString += ("number of pizzas: " + orderList.get(i).pizzas.size());
			for (int j=0; j<orderList.get(i).pizzas.size(); ++j)
			{
				orderListString += (orderList.get(i).pizzas.get(j) + "\t");
			}
			orderListString += ("\n");
		}
		
		return orderListString;
	}
	
	//Returns a sorted arraylist containing all orders with the given customer ID
	public ArrayList getCustomerOrderList(int customerID)
	{
		ArrayList<Order> custList = new ArrayList<Order>();
		
		for (int i=0; i<orderList.size(); ++i)
		{
			if (orderList.get(i).getID() == customerID)
				custList.add(orderList.get(i));
		}
		
		return custList;
	}
	
	//Returns a sorted arraylist containing all orders that display to the cashier
	public ArrayList getCashierOrderList()
	{
		ArrayList<Order> cashList = new ArrayList<Order>();
		
		for (int i=0; i<orderList.size(); ++i)
		{
			if (orderList.get(i).getStatus().equals("Not Started") || orderList.get(i).getStatus().equals("READY"))
				cashList.add(orderList.get(i));
		}
		
		return cashList;
	}
	
	//Returns a sorted arraylist containing all orders that display to the chef
	public ArrayList getChefOrderList()
	{
		ArrayList<Order> chefList = new ArrayList<Order>();
		
		for (int i=0; i<orderList.size(); ++i)
		{
			if (orderList.get(i).getStatus().equals("READY TO COOK") || orderList.get(i).getStatus().equals("COOKING"))
				chefList.add(orderList.get(i));
		}
		
		return chefList;
	}
	
	public Order getOrder(int orderID)
	{
		for(Order o : orderList)
		{
			if(o.getID() == orderID)
			{
				return o;
			}
		}

		return null;
	}
	
	//Helper function to clear current contents of database file
	private void clearFile() throws IOException
	{
		FileWriter fwOb = new FileWriter(filename, false); 
        	PrintWriter pwOb = new PrintWriter(fwOb, false);
        	pwOb.flush();
        	pwOb.close();
        	fwOb.close();
		System.out.println("File contents cleared");
	}
}
