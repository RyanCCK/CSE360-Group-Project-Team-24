package application;

import java.io.Serializable;
import java.util.Comparator;

public class Order implements Serializable, Comparable<Order>
{
	private static final long serialVersionUID = 1L;	
	int id;
	String[] pizzas;
	
	//Basic unfinished constructor of an Order, used for testing OrderList
	public Order(int id, int size)
	{
		this.id = id;
		pizzas = new String[size];
		for (int i=0 ; i<size; ++i)
		{
			pizzas[i] = "Medium";
		}
	}

	@Override
	public int compareTo(Order o) {
		if (this.id > o.id)
			return 1;
		else if (this.id < o.id)
			return -1;
		else return 0;
	}	
}
