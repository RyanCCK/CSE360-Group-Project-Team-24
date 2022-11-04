import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.time.LocalTime;

public class Order implements Serializable, Comparable<Order>
{
	public ArrayList<Pizza> pizzas;
	
	private static final long serialVersionUid= 1L;	
	
	public int id;
	public double cost;
	
	private LocalTime pickupTime;
	private String status;
	private int customerID;
	
	
	//Basic unfinished constructor of an Order, used for testing OrderList
	public Order(int orderID, int size, LocalTime time, int custID)
	{
		id = orderID;
		pickupTime = time;
		status = "Not Started";
		customerID = custID;
		cost = 0.00;
		
		pizzas = new ArrayList<Pizza>();
	}

	@Override
	public int compareTo(Order o) {
		if (this.id> o.id)
			return 1;
		else if (this.id< o.id)
			return -1;
		else return 0;
	}
	
	public void calculateCost()
	{
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
	
	public int getCustID()
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
}



