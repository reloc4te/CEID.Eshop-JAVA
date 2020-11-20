public abstract class User 
{
	
//Variables
// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
    private String uName;           
    private String uEmail;          
    private String uCategory;        //μας βοηθάει να ξεχωρίζουμε τι user καλούμε κάθε φορά μέσω της Menu
      
//Constructor
    public User (String uName, String uEmail) {
        this.uName = uName;
        this.uEmail = uEmail;               
        }

//Methods
    public void setuName(String n)
    {
        uName = n;
    }
    public String getuName() 
    {
        return uName;
    }
    public void setuEmail(String e)
    {
        uEmail = e;
    }
    public String getuEmail() 
    {
        return uEmail;
    }
    public String getuCategory() 
    {
        return uCategory;
    }

	
}