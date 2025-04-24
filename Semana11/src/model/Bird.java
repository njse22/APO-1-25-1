package model;

public abstract class Bird extends Animal{
    protected String name;
    protected int age; 

    public Bird(String name, int age){
        this.name = name; 
        this.age = age; 
    }    
}
