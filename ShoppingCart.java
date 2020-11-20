import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCart {
	
//Variables
//������� �� private ��� ���������� ����� ����� "����������" ����������� ��� �� �������� �� ��� ������� ���� �� gettes-setters
//����������� ��� �������� ���������� ��� �� ����� ��� ������ �� ������� �� ������ ���� item category (������� �� ��� �������� ��� ���� �������� � buyer)
//�� ������� �� �������� ������ ���� ��� items ��� ���� ����������� � buyer ��� �� ������ ��� �����������
	private static double quantityCost;
	private static double totalCost;
	private static double courierCost;
	
	private int count = 0;
	private int scID;
	
	static boolean exit;  //����� ���������� ��� ����������� ��� �� ������������ �� ���������
	static Scanner scnr = new Scanner(System.in);  //��� �� ������ � user �� ������ ����� ��� �� ������
	
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
//		while (ItemOrdered.getQuantity() <= b.getiStock())     //while-loop ��� ��� �� quantity ����� ��������� ��� stock ���� item
//			try {
//				Item.setiStock(Item.getiStock() - ItemOrdered.getQuantity());   //������� ��� �� stock ��� �� ������ ����� >= 0
//			} catch (Exception StockNotFoundException) {       //�� �� stock ����� < 0 ���� ����� ����� custom exception
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
		OrderList.remove(a);	 //��������� ��� item ��� ��� orderList
		Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());  //����������� �� stock
		System.out.println("you have removed an item from your cart");
	}
	
	public void changeItemOrderedQuantity(ItemOrdered a, Item b, int e, int f) throws StockNotFoundException {
		if (a.getQuantity() <= b.getiStock()) {    //for-loop ��� ��� �� quantity ����� <= ��� stock 
			Eshop.updateItemStock(e, f);       //������� ��� ������ ��� �� ����������� �� item stock
		} else 
			throw new StockNotFoundException ("Out of stock.");   //�� �� stock ����� < 0 ���� ����� ����� custom exception
	}
	
	public static void showCart() {

//��������� �� ������ ������ ��� buyer �� ���� ��� ����������� �����������
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
		for (int i = 0; i < OrderList.size(); i++)   //for-loop ��� �� ������� ��� �� items ��� �������� ���� orderList, ���� �� �� ����������� ����
		{
			removeItemOrdered(OrderList.get(i));	//��������� ��� ��� orderList �� ����������� item
		}
		
	}
	
	public static void checkout() {
		
		System.out.println("Checking Out. \n");
		showCart();      //����������� ��� showCart ��� �� ������ � buyer �� ����� ��� �� ���� ��������
		
		System.out.println("Procceed with payment?  (y/n)");   //��� ������� �� �������� ��� ����� �� ��������
        String answerYorN=scnr.nextLine();
		if (answerYorN.equals("y") || answerYorN.equals("Y"))
    	{
			Buyer bb = new Buyer("a", "b", 0); //������������ object ��� ������ buyer
			bb.awardBonus();    //������� ��� awardBonus ��� �� ���������� �� ������ bonus ��� Buyer 
			OrderList.clear();     // ����������� �� ������ ��� buyer 
			Item.setiStock(Item.getiStock() - ItemOrdered.getQuantity());    //������ ��� ����������, ����� ��� ��� ������ ��� stock, ���� ���� ����� ��� ���� ��� (�� ��������)
			
			System.out.println("Money has been transfered.");
			System.out.println("We hope you enjoy your new items!");
    	}
    	else if (answerYorN.equals("n") || answerYorN.equals("N"))
    	{
            System.out.println("Are you sure? Your order will be deleted.   (y/n)");   //��� ������� �� ��������� �� ����� �������� ��� ��� ����� �� ��������, ��� ����� �����
            String answerYorN1=scnr.nextLine();
            if (answerYorN1.equals("y") || answerYorN1.equals("Y"))
            {
            	OrderList.clear();    //����������� �� ������, ���� ��� ��� ���� ��� ��� ��� ����� �� ��������, � ���������� ��� �� ���������
            	Item.setiStock(Item.getiStock() + ItemOrdered.getQuantity());    //����������� ���� ��� Stock ��� �� items ��� ���� "��������" � buyer ���� ��� ����������� ���
            	exit = true;     //���������� �� ���������
            }
            else if (answerYorN1.equals("n") || answerYorN1.equals("N"))
            {
            	Menu mm = new Menu();   //������������ object ��� ������ menu
            	mm.printBuyerMenu();    //������� ��� ������ ��� �� ������ � buyer �� �������� ���� ����
            }
            
            
          //��� ������� �� ������ �� ���������� � User, ����� ����������� ���� �� printBuyerMenu ��� ���������� �� ���������
            
    	}
	}
	
	public double calculateNet(Item a) {
		for (int i = 0; i < OrderList.size(); i++) { 
			if (a == OrderList.get(i).getItem()) {  //for-loop ��� �� ��� ����� ��� �� ��������� items ��� ��� orderList
				OrderList.get(i).getQuantity();    //��������� �� quantity ��� ���� item
				quantityCost = ItemOrdered.getQuantity() * Item.getiPrice();  //��������� �� quantityCost
				System.out.println("Price for " + OrderList.get(i).getQuantity() + " " + OrderList.get(i).getItem() + " is: " + getQuantityCost());
			} else { return 0; }
		} 
		totalCost = getQuantityCost(); //��������� �� �������� ������ ��� ��� �� items ��� orderList
		return totalCost;
	}
	
	public void calculateCourierCost(Buyer a, double b) {
		courierCost = totalCost * 0.02;   //��������� �� ������ ��� ����������� 
		if (courierCost <= 3) {   //������ ��� �� ���������� ����� <= ��� 3 ����
			setCourierCost(3);    //������� �� ������ �� ����� ����� 3 ����
			
			switch (a.getbuyerCategory()) {    //��������� �� buyerCategory �� switch ������ ��� �� ���������� ��� ���� ������� buyer ���������
				case "Bronze":  {
					setCourierCost(b);    //����� �� ������ ����������� 
					System.out.printf("Category: Bronze \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Silver": {
					setCourierCost(b * 0.5);  //������� � ������� 50% ��� ���������� ���� ��� ����������
					System.out.printf("Category: Silver \n Courier Cost: %d", getCourierCost());
				}	break;
				
				case "Gold": {
					setCourierCost(0);  //���������� = 0 ���� ���� ��� ����������
					System.out.printf("Category: Gold \n Courier Cost: %d", getCourierCost());
				}	break;
			}
		}
		else {   //��������� ��� �� ���������� ����� ���������� ��� 3 ����
//			a.getbuyerCategory(); 
			switch (a.getbuyerCategory()) { //��������� �� buyerCategory �� switch ������ ��� �� ���������� ��� ���� ������� buyer ���������
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
	
	


