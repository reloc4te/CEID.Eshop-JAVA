
public class ItemOrdered {

//Variables
// βάζουμε ως private τις μεταβλητές γιατί είναι "ευαίσθητες" πληροφορίες και θα μπορούμε να τις καλούμε μόνο με gettes-setters
		private static Item item;
		private static int quantity;
	
		
//Constructors
		public ItemOrdered (Item item, int quantity) {
			this.item = item;
			this.quantity = quantity;
		}

//Methods
		public static Item getItem() {
			return item;
		}
		public static void setItem(Item item) {
			ItemOrdered.item = item;
		}

		public static int getQuantity() {
			return quantity;
		}

		public static void setQuantity(int quantity) {
			ItemOrdered.quantity = quantity;
		}

		
		
}

