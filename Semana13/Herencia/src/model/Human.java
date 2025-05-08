package model; 

//	     Human -> Hereda -> Primate
public class Human extends Primate {

    private String cc; 

    public Human(String name, int age, String cc){
	super(name, age); // LLamado al constructor
			  // de la clase superior 
	this.cc = cc; 
    }

    public Human(String name, int age){
	super(name, age);
	this.cc = "";
    }

    public String getCc(){
	return cc; 
    }

    public void setCc(String cc){
	this.cc = cc;     
    }

    @Override
    public String hello(){
	return "Say Hello from Human "; 
    }

    public String screen(){
	return "AHHH"; 
    }

    public String screen(String msj){
	return msj; 
    }


    public String toString(){
	String msg = super.getName();
	
	return "Name: " + msg + " " + super.age; 
    }
}
