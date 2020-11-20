import java.util.ArrayList;

public class Eshop
{
	
//Variables
// ������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
    private String eName;
    private Owner eOwner;
//������ ��� �� ������������� �� items ��� ���� buyers ��� �������� �� eshop
    static ArrayList<Item> itemsList = new ArrayList<>();
	static ArrayList<Buyer> buyersList = new ArrayList<>();
	
	
//Constructor	   
    public Eshop(String eName, Owner eOwner)
    {
    this.eName = eName;
    this.eOwner = eOwner;
    }

//Methods
    public String geteName()
    {
        return eName;
    }
    
    public void seteName(String z)
    {
    	z = eName; 
    }
           
    public Owner geteOwner() 
    {
		return eOwner;
	}

	public void seteOwner(Owner eOwner) 
	{
		this.eOwner = eOwner;
	}


	public static void addItem(Item a) throws AlreadyExistsException 
    {
		if (itemsList.contains(a)) {    //������� ��� �� item ������� ���� ���� itemsList
			throw new AlreadyExistsException("Already exists.");  //�� ������� ���� ����� ����� custom exception
		}
		else { itemsList.add(a); }   //��� ��� ������� ���� ��������� �� item ���� itemsList
    }
    
 
    public static Item getItembyId(int b)
    {
        for (int i = 0; i < itemsList.size();i++)      //��������� �� loop ��� �� "����������" ��� �� ��������� items
        {
            if (b == itemsList.get(i).getiId())    //��������� ��� �� ID ��� ������ ��������� �� ������ item ��� ������
            {
                System.out.println("The product is: " + itemsList.get(i).getiName());
                return itemsList.get(i);     //���������� �� item �� �� ID ��� ������
            }
        }
        return null;
    }
    
	public static void removeItem(Item a)
    {
        itemsList.remove(a);       //������� ��� item ��� ��� itemsList
    }
    
	public static void addBuyer(Buyer c) throws AlreadyExistsException
	{
    	if (buyersList.contains(c)) {    //������� ��� � buyer ������� ���� ���� buyersList
			throw new AlreadyExistsException("Already exists.");     //�� ������� ���� ����� ����� custom exception
		}
		else { buyersList.add(c); }      //��� ��� ������� ���� ��������� ��� buyer ���� buyersList
	}
	 
    public void removeBuyer(Buyer d) 
    {
    	buyersList.remove(d);     //������� ���� buyer ��� ��� buyersList
    }
	
    public static void updateItemStock(int e, int f)
    {
        for (int i = 0; i < itemsList.size();i++)    //��������� �� loop ��� �� "����������" ��� �� ��������� items
        {
            if (e == itemsList.get(i).getiId())    //��������� ��� �� ID ��� ������ ��������� �� ������ item ��� ������, ����� �� ��������� �� stock �� ��� ������� ��� ID, ����� ���� item ����� �����������, ���� ��� ����� ���� ID ����� ������� �� ���� �� ��� �� ������������ BasicInfo & getDetails
            {
                itemsList.get(i).setiStock(f); 
            }
        }
    }
    
    public void showCategories()
    {
    	System.out.println("mpainei sti showcategory");
    	int penCounter = 0;                                     //������� ��� ���� item ��� counter ���� �� ������� ��� ���� ������ ��� ��������
    	int pencilCounter = 0;                                  //��� ������ ��� �� ���� item ��� ���� ��������� �� for-loop ��� �� ������� ��� ��������� ��� 
    	int paperCounter= 0;                                    //items (��� �� main) ��� ���������� �� ������� � counter
    	int notebookCounter = 0;
    	
        for (int i = 0; i < itemsList.size();i++)  
        {
        	if (itemsList.get(i).getiCategory().equals("Pen")) 
        	{
        		penCounter++;
        	}
        	else if (itemsList.get(i).getiCategory() == "Pencil") 
        	{
        		pencilCounter++;
        	}
        	else if (itemsList.get(i).getiCategory() == "Paper") 
        	{
        		paperCounter++;
        	}
        	else if (itemsList.get(i).getiCategory() == "Notebook") 
        	{
        		notebookCounter++;
        	}
        	else 
        	{
        		System.out.println("Random error");
        	}       	
        } 
        System.out.println("mpainei sti showcategory");                //��������� �������� ��� ����������/items ��� ��� �������� ����
    	System.out.printf("1) Pen (%d) \n" , penCounter);
    	System.out.printf("2) Pencil (%d) \n" , pencilCounter);
    	System.out.printf("3) Paper (%d) \n" , paperCounter);
    	System.out.printf("4) Notebook (%d) \n" , notebookCounter);
    	System.out.printf("5) Back \n");    //��������� �� Back ���� ���� ���� ��� ������ menu �� ������ ���� ����� �� ��������� ���� ���� ������� printBuyerMenu (������� ��� menu)

    }
    
    public void showProductsInCategory(String g)                  //��������� ����� �� �� �������� ���� ������������� ����������

    {
        System.out.println("--------------------------------");
        for (int i = 0; i < itemsList.size();i++)     //for-loop ��� �� "�����������" ���� item ��� ������� ���� itemsList
        {
            if (g == itemsList.get(i).getiCategory())     //������� ��� �� item ����������� �� ���� ��� �������� ���
            {
                System.out.println((i+1) + ") Name: " + itemsList.get(i).getiName() + "\n   ID: " + itemsList.get(i).getiId());    //������� ����� ��� ID ��� ���� item ���� ���� ���������
                System.out.println("--------------------------------");
            }
        }
        System.out.println(itemsList.size()+1 + ") Back");        //��������� �� Back ���� ���� ���� ��� ������ menu �� ������ ���� ����� �� ��������� ���� ���� ������� showProductsCategory
        System.out.println("--------------------------------");

        return counterCategory;
    }
    
	
	public static void showProduct(int f) 
	{
		Item tempitem;       //������� ��� temp item ��� �� ���������������� ���� ���� ������
		tempitem = getItembyId(f);   //������� ����� ��� ������� getItembyID ��� �� ������� �� item ��� ������� �� ����������
		tempitem.toString();   //������� ����� ��� toString (������� ���� Buyer) ��� �� ������� ��� ����������� ��� item ���
		
	}
	
	public static void checkStatus()
	{
		for (int i = 0; i < buyersList.size();i++)   //for-loop ��� �� "�����������" ���� buyer ��� ������� ���� buyersList
        {
           System.out.println( (i+1) + ")\n" + "Onoma: " + buyersList.get(i).getuName() + "\nBonus: " + buyersList.get(i).getBonus() + "\nBuyers Category:" + buyersList.get(i).getbuyerCategory());  //������� �����, ������� bonus ��� �� �� category ���������� ��� ���� buyer
           System.out.println("----------------------------------------");          
        }
	}
	
} 