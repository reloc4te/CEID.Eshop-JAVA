public class Notebook extends Item
{
	
//Variables
// ������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
    private int sections;
    private String iCategory = "Notebook";

//Constructor
    public Notebook (String iName, double iPrice, String iDescription, int iStock, int iId, int sections)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.sections = sections;
    }

    
//Methods
    public int getSections()
    {
        return sections;
    }
    public void setSections(int a)
    {
        sections = a;
    } 
    public String iCategory()
    {
    	return iCategory;
    }
    public void setiCategory()
    {
    	iCategory = "Notebook";
    }
//��������� ��� getDetails() ��� �� extra �������� ��� notebook
    public String getDetails()
    {
    	return "Number of Themes: " +getSections();
    }
}
