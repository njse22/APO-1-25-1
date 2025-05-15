package exceptions; 

public class NoAnimalsInListException extends RuntimeException {

    public NoAnimalsInListException(String message){
	super(message); 
    }
}
