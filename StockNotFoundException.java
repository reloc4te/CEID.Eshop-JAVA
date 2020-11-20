import java.lang.Exception;

//δημιουργια κλασης για να μπορεσουμε να δημιουργησουμε την custom exception μας
public class StockNotFoundException extends Exception {

	public StockNotFoundException (String message) {
		super(message);   //καλουμε το μηνυμα που εχουμε θεσει οταν κανουμε χρηση της exception
	}
}
