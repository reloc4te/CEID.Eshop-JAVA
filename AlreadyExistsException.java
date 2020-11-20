import java.lang.Exception;

//δημιουργια κλασης για να μπορεσουμε να δημιουργησουμε την custom exception μας
public class AlreadyExistsException extends Exception {

	public AlreadyExistsException (String message) {
		super(message);   //καλουμε το μηνυμα που εχουμε θεσει οταν κανουμε χρηση της exception
	}
}
