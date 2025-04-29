package model;

public class Duck extends Bird implements IFly, IRun {

    public Duck(String name, int age){
        super(name, age); 
    }

    public String talk(){
        return "Quack"; 
    }
    
    @Override
    public String fly(){
        return "Fly as a Duck"; 
    }

    @Override
    public String run(){
        return "Run as a Duck"; 
    }


    
}
