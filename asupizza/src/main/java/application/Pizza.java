package application;
import java.io.Serializable;

public class Pizza implements Serializable
{
    private String size;
    private String type;
    private boolean mushroom;
    private boolean onions;
    private boolean olives;
    private boolean extraCheese;

    //default constructor
    public Pizza()
    {
        size = "";
        type = "";
        mushroom = false;
        olives = false;
        onions = false;
        extraCheese = false;
    }

    //constructor with parameters
    public Pizza(String size, String type, boolean mushroom, boolean onions, boolean olives, boolean extraCheese)
    {
        this.size = size.toUpperCase();
        this.type = type.toUpperCase();
        this.mushroom = mushroom;
        this.onions = onions;
        this.olives = olives;
        this.extraCheese = extraCheese;
    }

    //getters
    public String getSize()
    {
        return size;
    }

    public String getType()
    {
        return type;
    }

    public boolean hasMushroom()
    {
        return mushroom;
    }

    public boolean hasOnions()
    {
        return onions;
    }

    public boolean hasOlives()
    {
        return olives;
    }

    public boolean hasExtraCheese()
    {
        return extraCheese;
    }

    //setters
    public void setSize(String newSize)
    {
        size = newSize.toUpperCase();
    }

    public void setType(String newType)
    {
        type = newType.toUpperCase();
    }
    
    public void setMushroom(boolean bool)
    {
    	mushroom = bool;
    }
    
    public void setOnions(boolean bool)
    {
    	onions = bool;
    }
    
    public void setOlives(boolean bool)
    {
    	olives = bool;
    }
    
    public void setExtraCheese(boolean bool)
    {
    	extraCheese = bool;
    }
    
    //calculate and return the price
    public double getPrice()
    {
        double price = 0;

        //size prices
        if(size.equals("SMALL"))
        {
            price += 5.0;
        }
        else if(size.equals("MEDIUM"))
        {
            price += 10.0;
        }
        else
        {
            price += 15.0;
        }

        //type prices
        if(type.equals("PEPPERONI"))
        {
            price += 3;
        }
        else
        {
            price += 2;
        }

        //topping price
        if(mushroom)
        {
            price++;
        }
        if(onions)
        {
            price++;
        }
        if(olives)
        {
            price++;
        }
        if(extraCheese)
        {
            price++;
        }

        return price;
    }
    
    public String toString() {
		String pizza = "Size: " + size;
		pizza += "\nType: " + type;
		pizza += "\nToppings:\t";
		if (mushroom) {
			pizza += "Mushrooms";
		}
		if (onions) {
			pizza += "\n\tOnions";
		}
		if(olives) {
			pizza += "\n\tOlives";
		}
		if(extraCheese) {
			pizza += "\n\tExtraCheese";
		}
    	
    	return pizza;
    }
}
