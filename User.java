public abstract class User 
{
	
//Variables
// ������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
    private String uName;           
    private String uEmail;          
    private String uCategory;        //��� ������� �� ����������� �� user ������� ���� ���� ���� ��� Menu
      
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