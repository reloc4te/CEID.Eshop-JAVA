
public class Paper extends Item
{
//Variables
// ������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
    private int weight;
    private int papers;
    private String iCategory = "Paper";

    
//Constructor
    public Paper (String iName, double iPrice, String iDescription, int iStock, int iId, int weight, int papers)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.weight = weight;
        this.papers = papers;
    }

//Methods
    public int getWeight()
    {
        return weight;
    }
    public void setWeights(int a)
    {
        weight = a;
    }
    public int getPapers()
    {
        return papers;
    }
    public void setPapers(int b)
    {
        papers = b;
    }
    public String iCategory()
    {
    	return iCategory;
    }
    public void setiCategory()
    {
    	iCategory = "Paper";
    }
//��������� ��� getDetails() ��� �� extra �������� ��� paper
    public String getDetails()
    {
    	return "Weight: " +getWeight()+ " gr \n       No of papers: "+getPapers();
    }
}
