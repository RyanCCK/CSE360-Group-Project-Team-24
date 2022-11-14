package application;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalTime;

public class Order implements Serializable, Comparable<Order>
{
	private static final long serialVersionUid= -124916025845113285L;	
	Random rand = new Random();
	
	public ArrayList<Pizza> pizzas;
	public int id;
	public double cost;
	
	private LocalTime pickupTime;
	private String status;
	private String customerID;
	
	public Order(String customerID)
	{
		this.customerID = customerID;
		pizzas = new ArrayList<Pizza>();
		status = "NOT STARTED";
		cost = 0.00;
		id = rand.nextInt(100000000);      //creates random 8 digit number
        //TODO: Check for duplicate ID's
	}
	
	public void calculateCost()
	{
		cost = 0;
		for(int i = 0; i < pizzas.size(); i++)
		{
			cost += pizzas.get(i).getPrice();
		}
	}
	
	public LocalTime getTime()
	{
		return pickupTime;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public int getID()
	{
		return id;
	}

	public String getCustID()
	{
		return customerID;
	}
	
	public void setTime(LocalTime time)
	{
		pickupTime = time;
	}
	
	public void setStatus(String newStatus)
	{
		status = newStatus;
	}
	
	public void addPizza(Pizza pizza)
	{
		pizzas.add(pizza);
		this.calculateCost();
	}
	
	public void removePizza(Pizza pizza)
	{
		pizzas.remove(pizza);
		this.calculateCost();
	}
	
	//Compares the pickup times of orders
	@Override
	public int compareTo(Order o) {
		return this.pickupTime.compareTo(o.pickupTime);
	}
}
