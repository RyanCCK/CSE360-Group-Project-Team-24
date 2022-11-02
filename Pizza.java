public class Pizza
{
    //need to come up with some prices

    private int size;
    private String type;
    private boolean mushroom;
    private boolean onions;
    private boolean olives;
    private boolean extraCheese;

    public Pizza()
    {
        size = 0;
        type = "";
        mushroom = false;
        olives = false;
        extraCheese = false;
    }

    public Pizza(int size, String type, boolean mushroom, boolean onions, boolean olives, boolean extraCheese)
    {
        this.size = size;
        this.type = type;
        this.mushroom = mushroom;
        this.onions = onions;
        this.olives = olives;
        this.extraCheese = extraCheese;
    }

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

    public void setSize(int newSize)
    {
        size = newSize;
    }

    public void setType(String newType)
    {
        type = newType;
    }

    public void addMushroom()
    {
        mushroom = true;
    }

    public void removeMushroom()
    {
        mushroom = false;
    }

    public void addOnions()
    {
        onions = true;
    }

    public void removeOnions()
    {
        onions = false;
    }

    public void addOlives()
    {
        olives = true;
    }

    public void removeOlives()
    {
        olives = false;
    }

    public void addExtraCheese()
    {
        extraCheese = true;
    }

    public void removeExtraCheese()
    {
        extraCheese = false;
    }
    
}
