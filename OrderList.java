import java.util.ArrayList;
import java.io.*;

//Singleton class that stores all orders in active memory
public class OrderList
{
	
	private ArrayList orderList;
	static String file = "";
	
	//Constructor
	public OrderList()  throws IOException
	{
		orderList = new ArrayList<Object>();	//Object will be Order
	}
	
	//Read OrderList from file
	private void readOrderList() throws IOException 
	{
		FileInputStream fileInStream = new FileInputStream(file);
		ObjectInputStream objIn = new ObjectInputStream(fileInStream);
	}
	
	//Write OrderList to file
	private void writeOrderList() throws IOException
	{
		FileOutputStream fileOutStream = new FileOutputStream(file);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOutStream);
	}
	
	//Insert Order in the correct sorted position
	public boolean insertOrder() 
	{
		return true;
	}
	
	//Delete Order
	public boolean deleteOrder()
	{
		return true;
	}
	
	public ArrayList getCustomerOrderList(int customerID)
	{
		ArrayList customerLinkedList = new ArrayList<Object>();
		//get head node
		int orderListSize = orderList.size();
		//Add every order created by customer with customerID to the customer's order list
		//while(orderList.)
		return customerLinkedList;
	}
	
	public ArrayList getCashierOrderList()
	{
		
	}
	
	public ArrayList getChefOrderList()
	{
		
	}
	
	public Object getOrder()
	{
		
	}
}
