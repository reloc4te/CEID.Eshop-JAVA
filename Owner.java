
public class Owner extends User
{
	
//Variables
// ������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
    private static boolean isAdmin = true;
    private String uCategory="Owner";

//Constructor     
    public Owner(String uName, String uEmail)
    {
        super(uName, uEmail);
    }
    
//Methods
	public static boolean getisAdmin() {
		return isAdmin;
	}
	public void setisAdmin(boolean isAdmin) {
		Owner.isAdmin = isAdmin;
		// isAdmin = true;
	}
	public void setuCategory(String uCategory) {
		this.uCategory = uCategory;
	}
	public String getuCategory() {
		return uCategory;
	}
    
}
