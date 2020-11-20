public class Buyer extends User{

	
//Variables
// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
	private int bonus;                                
	private String buyerCategory;                     
	private ShoppingCart scb;                         // αντικείμενο κλάσης ShoppingCart
    private String uCategory = "Buyer";               
	
//Constructor
	public Buyer (String uName, String uEmail, int bonus)
	{
		super(uName, uEmail);
		this.bonus=bonus;
		this.scb = scb;
		setbuyerCategory();
	}

//Methods
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int a) {
		bonus = a;
	}

	public String getbuyerCategory() {
		return buyerCategory;
	}

	public String getuCategory() 
    {
        return uCategory;
    }
	
	public void setuCategory()
    {
        uCategory = "Buyer";
    }
	
	public ShoppingCart getScb() {
		return scb;
	}

	public void setScb(ShoppingCart scb) {
		this.scb = scb;
	}
	
//μέθοδος όπου μετράμε τους Bonus πόντους των buyers
	public void awardBonus() {
//		int startBonus = 0;
//		int bonus = startBonus;
		double myBonus = bonus;		
		if (ShoppingCart.getTotalCost() > 0) {
			bonus = (int) (myBonus + 0.1*ShoppingCart.getTotalCost());
			if (bonus > 100 || bonus > 200) {
				this.setbuyerCategory();
			}
		}
	}

// μέθοδος μέσω της οποίας καθορίζουμε τις συνθήκες για το πως θα αλλάζει το buyerCategory
	public void setbuyerCategory() {
		if (bonus <= 100) {
			buyerCategory = "Bronze";
//			System.out.println("Category: Bronze");
//			b.setCourierCost(a); 
			}
		else if (bonus > 100 && bonus <= 200) {
			buyerCategory = "Silver";
//			System.out.println("Category: Silver");
//			b.setCourierCost(a * 0.5); 
			}
		else if (bonus > 200) {
			buyerCategory = "Gold";
//			System.out.println("Category: Gold");
//			b.setCourierCost(0); 
			}
		else {
			System.out.println("Wrong in setbuyerCategory");  //για την περιπτωση που βρεθεί λαθος στον κωδικα, ιδανικά δεν θα χρησιμοποιηθεί ποτέ
			}
	}

// μέθοδος μέσω της οποίας δινουμε στον buyer δυνατότητα να τοποθετησει ενα προιον, καλώντας και την addItemOrdered της ShoppingCart
	private void placeOrder(Item a, int b) {
		for (int i = 0; i < b;i++)  {
			ShoppingCart.addItemOrdered(a);
		}
	}
	
}
