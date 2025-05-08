package model;

public abstract class Primate extends Animal{

    public Primate(String name, int age){
	super(name, age);

    }

    /////////////////////////////////
    //  Métodos | comportamiento   //
    /////////////////////////////////
    public abstract String hello();

}
