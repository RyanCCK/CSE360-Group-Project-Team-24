public class Pizza
{
    //need to come up with some prices

    private int size;
    private double price;
    private String type;
    private boolean mushroom;
    private boolean onions;
    private boolean olives;
    private boolean extraCheese;

    //default constructor
    public Pizza()
    {
        price = 0;
        size = 0;
        type = "";
        mushroom = false;
        olives = false;
        extraCheese = false;
    }

    //constructor with parameters
    public Pizza(int size, String type, boolean mushroom, boolean onions, boolean olives, boolean extraCheese)
    {
        this.size = size;
        this.type = type;
        this.mushroom = mushroom;
        this.onions = onions;
        this.olives = olives;
        this.extraCheese = extraCheese;
    }

    //getters
    public int getSize()
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

    public boolean hashOlives()
    {
        return olives;
    }

    public boolean hasExtraCheese()
    {
        return extraCheese;
    }

    //setters
    public void setSize(int newSize)
    {
        if(newSize <= 10){
         price = 8;   
        } 
        else if(newSize <= 14){
         price = 10;   
        }else {
         price = 12;   
        }
        size = newSize;
    }

    public void setType(String newType)
    {
        type = newType;
    }

    public void addMushroom()
    {
        price += 1;
        mushroom = true;
    }

    public void removeMushroom()
    {
        price -= 1;
        mushroom = false;
    }

    public void addOnions()
    {
        price += 1;
        onions = true;
    }

    public void removeOnions()
    {
        price -= 1;
        onions = false;
    }

    public void addOlives()
    {
        price += 1;
        olives = true;
    }

    public void removeOlives()
    {
        price -= 1;
        olives = false;
    }

    public void addExtraCheese()
    {
        price += 1;
        extraCheese = true;
    }

    public void removeExtraCheese()
    {
        price -= 1;
        extraCheese = false;
    }
    
    
    //more functions to be added by Tom
    public double getPrice()
    {
        return price;
    }
}
