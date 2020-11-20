import java.util.ArrayList;

public class Eshop
{
	
//Variables
// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
    private String eName;
    private Owner eOwner;
//λίστες που θα αποθηκεύονται τα items και τους buyers που περιέχει το eshop
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
		if (itemsList.contains(a)) {    //ελέγχει άμα το item υπαρχει μεσα στην itemsList
			throw new AlreadyExistsException("Already exists.");  //αν υπάρχει τότε κάνει χρήση custom exception
		}
		else { itemsList.add(a); }   //αμα δεν υπάρχει τότε προσθέτει το item στην itemsList
    }
    
 
    public static Item getItembyId(int b)
    {
        for (int i = 0; i < itemsList.size();i++)      //μπαινουμε σε loop για να "κοιτάξουμε" ολα τα υπάρχοντα items
        {
            if (b == itemsList.get(i).getiId())    //ελέγχουμε άμα το ID που έχουμε ταιριάζει με κάποιο item που έχουμε
            {
                System.out.println("The product is: " + itemsList.get(i).getiName());
                return itemsList.get(i);     //επιστρέφει το item με το ID που θέλαμε
            }
        }
        return null;
    }
    
	public static void removeItem(Item a)
    {
        itemsList.remove(a);       //αφαιρει ένα item απο την itemsList
    }
    
	public static void addBuyer(Buyer c) throws AlreadyExistsException
	{
    	if (buyersList.contains(c)) {    //ελέγχει άμα ο buyer υπαρχει μεσα στην buyersList
			throw new AlreadyExistsException("Already exists.");     //αν υπάρχει τότε κάνει χρήση custom exception
		}
		else { buyersList.add(c); }      //αμα δεν υπάρχει τότε προσθέτει τον buyer στην buyersList
	}
	 
    public void removeBuyer(Buyer d) 
    {
    	buyersList.remove(d);     //αφαιρεί έναν buyer από την buyersList
    }
	
    public static void updateItemStock(int e, int f)
    {
        for (int i = 0; i < itemsList.size();i++)    //μπαινουμε σε loop για να "κοιτάξουμε" ολα τα υπάρχοντα items
        {
            if (e == itemsList.get(i).getiId())    //ελέγχουμε άμα το ID που έχουμε ταιριάζει με κάποιο item που έχουμε, γιατί θα αλλάξουμε το stock με την βοηθεια του ID, γιατι κάθε item είναι διαφορετικο, αλλά όσα έχουν ιδιο ID είναι ακριβως τα ιδια σε όλα τα χαρακτηριστα BasicInfo & getDetails
            {
                itemsList.get(i).setiStock(f); 
            }
        }
    }
    
    public void showCategories()
    {
    	System.out.println("mpainei sti showcategory");
    	int penCounter = 0;                                     //βάζουμε για κάθε item ένα counter ώστε να μετραμε ανα πασα στιγμη την ποσοτητα
    	int pencilCounter = 0;                                  //που εχουμε απο το καθε item και μετα μπαινουμε σε for-loop για να παρουμε τις ποσοτητες των 
    	int paperCounter= 0;                                    //items (απο τη main) και αντιστοιχα θα αλλαζει ο counter
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
        System.out.println("mpainei sti showcategory");                //τυπωνουμε παρακατω τις κατηγοριες/items και την ποσοτητα τους
    	System.out.printf("1) Pen (%d) \n" , penCounter);
    	System.out.printf("2) Pencil (%d) \n" , pencilCounter);
    	System.out.printf("3) Paper (%d) \n" , paperCounter);
    	System.out.printf("4) Notebook (%d) \n" , notebookCounter);
    	System.out.printf("5) Back \n");    //τυπωνουμε το Back ωστε μετα μεσω της κλασης menu να εχουμε εναν τροπο να γυρισουμε πισω στην καρτελα printBuyerMenu (μεθοδος της menu)

    }
    
    public void showProductsInCategory(String g)                  //Εμφανίζει λίστα με τα προϊόντα μιας συγκεκριμένης κατηγορίας

    {
        System.out.println("--------------------------------");
        for (int i = 0; i < itemsList.size();i++)     //for-loop για να "εμφανισουμε" καθε item που υπαρχει στην itemsList
        {
            if (g == itemsList.get(i).getiCategory())     //ελεγχει αμα το item αντιστοιχει με αυτα που υπαρχουν ηδη
            {
                System.out.println((i+1) + ") Name: " + itemsList.get(i).getiName() + "\n   ID: " + itemsList.get(i).getiId());    //τυπωνει ονομα και ID για καθε item μεσα στην κατηγορια
                System.out.println("--------------------------------");
            }
        }
        System.out.println(itemsList.size()+1 + ") Back");        //τυπωνουμε το Back ωστε μετα μεσω της κλασης menu να εχουμε εναν τροπο να γυρισουμε πισω στην καρτελα showProductsCategory
        System.out.println("--------------------------------");

        return counterCategory;
    }
    
	
	public static void showProduct(int f) 
	{
		Item tempitem;       //θετουμε ενα temp item για να χρησιμοποιησουμε μεσα στην μεθοδο
		tempitem = getItembyId(f);   //κανουμε χρηση της μεθοδου getItembyID για να παρουμε το item που θελουμε να κοιταξουμε
		tempitem.toString();   //κανουμε χρηση της toString (μεθοδος στην Buyer) για να παρουμε τις πληροφοριες του item μας
		
	}
	
	public static void checkStatus()
	{
		for (int i = 0; i < buyersList.size();i++)   //for-loop για να "εμφανισουμε" καθε buyer που υπαρχει στην buyersList
        {
           System.out.println( (i+1) + ")\n" + "Onoma: " + buyersList.get(i).getuName() + "\nBonus: " + buyersList.get(i).getBonus() + "\nBuyers Category:" + buyersList.get(i).getbuyerCategory());  //τυπωνει ονομα, ποντους bonus και σε τι category βρισκονται για καθε buyer
           System.out.println("----------------------------------------");          
        }
	}
	
} 