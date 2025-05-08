package model;

public class Monkey extends Primate{

    public Monkey(String name, int age){
        super(name, age);
    }

    public String hello(){
        return "Say hello from Monkey";
    }

    public String jump(){
	return "Jump";
    }
    
}
