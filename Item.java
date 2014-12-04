// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 11/30/2014 10:44:00 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Product.java



/**Set and get methods for item returning the name and price of the item.
 * 
 * @author Jacob
 *
 */
public class Item
{

    public Item()
    {
        name = "";
        price = 0.0D;
    }

    public Item(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean equals(Item other)
    {
        return name.equals(other.getName()) && price == other.getPrice();
    }

    public String toString()
    {
        String output = "";
        output = (new StringBuilder(String.valueOf(output))).append(name).append(" $").append(price).toString();
        return output;
    }

    private String name;
    private double price;
}
