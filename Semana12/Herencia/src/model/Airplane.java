package model;

public class Airplane implements IFly {

    private String model; 
    private int numMotors; 

    public Airplane(String model, int numMotors){
        this.model = model; 
        this.numMotors = numMotors; 
    }

    @Override
    public String fly(){
        return "Fly a as Airplane"; 
    }
    
}
