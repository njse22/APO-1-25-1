package exceptions; 

public class AnimalNotFoundException extends Exception {

    public AnimalNotFoundException(String message){
	super(message); 
    }
}
