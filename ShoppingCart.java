import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCart {
	
//Variables
//βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
//προσθετουμε τις παρακατω μεταβλητες για να ειναι πιο ευκολο να μετραμε το κοστος ενως item category (αναλογα με την ποσοτητα που εχει επιλεξει ο buyer)
//να μετραμε το συνολικο κοστος ολων των items που εχει παραγγειλει ο buyer και το κοστος των μεταφορικων
	private static double quantityCost;
	private static double totalCost;
	private static double courierCost;
	
	private int count = 0;
	private int scID;
	
	static boolean exit;  //οποτε χρειαζεται την αξιοποιουμε για να τερματιζουμε το προγραμμα
	static Scanner scnr = new Scanner(System.in);  //για να μπορει ο user να γραφει οποτε του το ζηταμε
	
	static ArrayList<ItemOrdered> OrderList = new ArrayList<ItemOrdered>();
	
//Constructor
	public ShoppingCart (Item item, int quantity, double quantityCost, double totalCost, double courierCost, Buyer a) {
		super();
		this.quantityCost = quantityCost;
		this.totalCost = totalCost;
		this.courierCost = courierCost;
	}
	
//Methods
		
	public static double getQuantityCost() {
		return quantityCost;
	}
	public static void setQuantityCost(double quantityCost) {
		ShoppingCart.quantityCost = quantityCost;
	}
	public static double getTotalCost() {
		return totalCost;
	}
	public static void setTotalCost(double totalCost) {
		ShoppingCart.totalCost = totalCost;
	}
	public static double getCourierCost() {
		return courierCost;
	}
	public static void setCourierCost(double courierCost) {
		ShoppingCart.courierCost = courierCost;
	}
	public int getScID() {
		return scID;
	}
	public void setScID(int scID) {
		this.scID = scID;
	}
	

	public static void addItemOrdered(Item b) {
		//System.out.println("mpainei stin add item ordered");
		boolean itemFound = false;
//		while (ItemOrdered.getQuantity() <= b.getiStock())     //while-loop για οσο το quantity είναι μικροτερο του stock ενος item
//			try {
//				Item.setiStock(Item.getiStock() - ItemOrdered.getQuantity());   //ελεγχει αμα το stock που θα μεινει ειναι >= 0
//			} catch (Exception StockNotFoundException) {       //αν το stock ειναι < 0 τότε κάνει χρήση custom exception
//				System.out.println("Out of stock.");
//			}
		for (int i = 0; i < OrderList.size();i++)  
        {
        	System.out.println("i:"+ i);
        	System.out.println("size: " + OrderList.size());
        	Item a = OrderList.get(i).getItem();
        	System.out.println(a.getiName());
        	System.out.println("Item:"+ a);

            if (a.equals(b)) 
            {
            	ItemOrdered.setQuantity(1 + ItemOrdered.getQuantity());
            	itemFound = true;
            	//System.out.print("eimai stin if");
            	break;
           	}

            else
            {
            	System.out.println("else");
            	continue;
            }
        
        }

        if(itemFound == true)
        {
        	//System.out.println("eimai stin katw if");
        }
        else
        {
    		ItemOrdered io1 = new ItemOrdered(b,1);
    		OrderList.add(io1);
    		//System.out.println("eimai stin katw else");
        }
	}
	
	public void removeItemOrdered(ItemOrdered a) {
		OrderList.remove(a);	 //αφαιρουμε ενα item απο την orderList
		Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());  //ανανεωνεται το stock
		System.out.println("you have removed an item from your cart");
	}
	
	public void changeItemOrderedQuantity(ItemOrdered a, Item b, int e, int f) throws StockNotFoundException {
		if (a.getQuantity() <= b.getiStock()) {    //for-loop για οσο το quantity είναι <= του stock 
			Eshop.updateItemStock(e, f);       //καλουμε την μεθοδο για να ανανεωσουμε το item stock
		} else 
			throw new StockNotFoundException ("Out of stock.");   //αν το stock ειναι < 0 τότε κάνει χρήση custom exception
	}
	
	public static void showCart() {

//τυπωνουμε το καλαθι αγορων του buyer με ολες τις απαραιτητες πληροφοριες
		System.out.printf("Your order cost is: "+ totalCost+" Euros. \nShipping costs: "+courierCost+" Euros. \nTotal Price: "+(totalCost+courierCost)+" Euros \n");
		System.out.println("+------------------ More Details ------------------+");
		System.out.println("Item \t|\t Quantity \t|\t Price");
		for (int i=0; i <= OrderList.size(); i++) {
			System.out.printf(ItemOrdered.getItem() +" \t|\t " +ItemOrdered.getQuantity()+" \t|\t "+quantityCost+"\n");
			}
		System.out.println("+--------------------------------------------------+");
		
	}
	
	public void clearCart() 
	{
		for (int i = 0; i < OrderList.size(); i++)   //for-loop για να παρουμε ολα τα items που υπαρχουν στην orderList, ωστε να τα αφαιρεσουμε μετα
		{
			removeItemOrdered(OrderList.get(i));	//αφαιρουμε απο την orderList το καθορισμενο item
		}
		
	}
	
	public static void checkout() {
		
		System.out.println("Checking Out. \n");
		showCart();      //εμφανιζουμε την showCart για να βλεπει ο buyer τα κοστη και τι εχει αγορασει
		
		System.out.println("Procceed with payment?  (y/n)");   //τον βαζουμε να επιλεξει αμα θελει να πληρωσει
        String answerYorN=scnr.nextLine();
		if (answerYorN.equals("y") || answerYorN.equals("Y"))
    	{
			Buyer bb = new Buyer("a", "b", 0); //δημιουργουμε object της κλασης buyer
			bb.awardBonus();    //καλουμε την awardBonus για να ανανεωθουν οι ποντοι bonus του Buyer 
			OrderList.clear();     // καθαριζουμε το καλαθι του buyer 
			Item.setiStock(Item.getiStock() - ItemOrdered.getQuantity());    //λογικα δεν χρειαζεται, ειναι για την αλλαγη του stock, αλλα εχει γινει πιο πριν ηδη (το βλεπουμε)
			
			System.out.println("Money has been transfered.");
			System.out.println("We hope you enjoy your new items!");
    	}
    	else if (answerYorN.equals("n") || answerYorN.equals("N"))
    	{
            System.out.println("Are you sure? Your order will be deleted.   (y/n)");   //τον βαζουμε να απαντησει αν ειναι σιγουρος οτι δεν θελει να πληρωσει, για τυχον λαθος
            String answerYorN1=scnr.nextLine();
            if (answerYorN1.equals("y") || answerYorN1.equals("Y"))
            {
            	OrderList.clear();    //καθαριζουμε το καλαθι, μιας και του λεμε οτι αμα δεν θελει να πληρωσει, η παραγγελια του θα διαγραφει
            	Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());    //προσθετουμε πισω στο Stock ολα τα items που είχε "κρατησει" ο buyer μεσω της παραγγελιας του
            	exit = true;     //τερματιζει το προγραμμα
            }
            else if (answerYorN1.equals("n") || answerYorN1.equals("N"))
            {
            	Menu mm = new Menu();   //δημιουργούμε object της κλασης menu
            	mm.printBuyerMenu();    //καλουμε την μεθοδο για να μπορει ο buyer να διαλεξει κατι αλλο
            }
            
            
          //εδω θελουμε να μπορει να ξαναγραψει ο User, γιατι εμφανιζεται μονο το printBuyerMenu και τερματιζει το προγραμμα
            
    	}
	}
	
	public double calculateNet(Item a) {
		for (int i = 0; i < OrderList.size(); i++) { 
			if (a == OrderList.get(i).getItem()) {  //for-loop για να μας παρει ολα τα απαριτητα items απο την orderList
				OrderList.get(i).getQuantity();    //παιρνουμε το quantity για καθε item
				quantityCost = ItemOrdered.getQuantity() * Item.getiPrice();  //βρισκουμε το quantityCost
				System.out.println("Price for " + OrderList.get(i).getQuantity() + " " + OrderList.get(i).getItem() + " is: " + getQuantityCost());
			} else { return 0; }
		} 
		totalCost = getQuantityCost(); //παιρνουμε το συνολικο κοστος για ολα τα items της orderList
		return totalCost;
	}
	
	public void calculateCourierCost(Buyer a, double b) {
		courierCost = totalCost * 0.02;   //παιρνουμε το κοστος των μεταφορικων 
		if (courierCost <= 3) {   //ελεγχο αμα τα μεταφορικα ειναι <= των 3 ευρω
			setCourierCost(3);    //θετουμε το κοστος να ειναι παντα 3 ευρω
			
			switch (a.getbuyerCategory()) {    //παιρνουμε το buyerCategory με switch ελεγχο για να κοιταξουμε αμα εχει καποιος buyer εκπτωσεις
				case "Bronze":  {
					setCourierCost(b);    //θετει το κοστος μεταφορικων 
					System.out.printf("Category: Bronze \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Silver": {
					setCourierCost(b * 0.5);  //μπαινει η εκπτωση 50% στα μεταφορικα λογω της κατηγοριας
					System.out.printf("Category: Silver \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Gold": {
					setCourierCost(0);  //μεταφορικα = 0 ευρω λογω της κατηγοριας
					System.out.printf("Category: Gold \n Courier Cost: %d", getCourierCost());
				}	break;
			}
		}
		else {   //περιπτωση που τα μεταφορικα ειναι μεγαλυτερα απο 3 ευρω
//			a.getbuyerCategory(); 
			switch (a.getbuyerCategory()) { //παιρνουμε το buyerCategory με switch ελεγχο για να κοιταξουμε αμα εχει καποιος buyer εκπτωσεις
				case "Bronze":  {
					setCourierCost(b);
					System.out.printf("Category: Bronze \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Silver":  {
					setCourierCost(b * 0.5);
					System.out.printf("Category: Silver \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Gold":  {
					setCourierCost(0);
					System.out.printf("Category: Gold \n Courier Cost: %d", getCourierCost());
				}	break;
		
			}
		}

		
	}
	
	
	
}
	
	


