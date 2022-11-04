package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

//Singleton class that stores all orders in active memory
public class OrderList 
{
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
	public void printOrderList()
	{
		for(int i=0; i<orderList.size(); ++i)
		{
			System.out.println("id: " + orderList.get(i).id);
			System.out.println("number of pizzas: " + orderList.get(i).pizzas.length);
			for (int j=0; j<orderList.get(i).pizzas.length; ++j)
			{
				System.out.print(orderList.get(i).pizzas[j] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public ArrayList getCustomerOrderList(int customerID)
	{
		return orderList;
	}
	
	public ArrayList getCashierOrderList()
	{
		return orderList;
	}
	
	public ArrayList getChefOrderList()
	{
		return orderList;
	}
	
	public Object getOrder()
	{
		return orderList;
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
