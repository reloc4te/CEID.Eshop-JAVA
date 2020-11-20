public class Pen extends Item
{
	
//Variables
// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
    private String color;
    private double tipSize;
    private String iCategory = "Pen";

    
//Constructor
    public Pen (String iName, double iPrice, String iDescription, int iStock, int iId, String color, double tipSize)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.color = color;
        this.tipSize = tipSize;
    }

    
//Methods
    public String getColor()
    {
        return color;
    }
    public double getTipSize()
    {
        return tipSize;
    }
    public String iCategory()
    {
    	return iCategory;
    }
    public void setColor(String a)
    {
        color = a;
    }
    public void setTipSize(double b)
    {
        tipSize = b;
    }
    public void setiCategory()
    {
    	iCategory = "Pen";
    }
    
//υλοποίηση της getDetails() για τα extra στοιχεια του pen
    public String getDetails()
    {
    	return "Color: " +getColor()+ "\n         Tip Size: "+getTipSize()+" mm";
    }
}
