package model;

import java.util.ArrayList;

public class Controller {

    private ArrayList<Animal> collection;

    public Controller(){
        collection = new ArrayList<Animal>();     
        testData();    
    }

    public void testData(){
        collection.add(new Monkey("Mojo jojo", 4));
        collection.add(new Monkey("Juanito", 6));
        collection.add(new Human("Sandra", 18, "0000000"));

    }

    public void createAnimal(String name, int age, String id, int type){
        Animal animal = null; 

        // Human
        if(type == 1){
            animal = new Human(name, age, id); 
        }
        // Duck
        else if(type == 2){
            animal = new Duck(name, age); 
        }

        collection.add(animal); 
    }

    public String filterPrimates(){
	String msg = ""; 
        for(int i = 0; i < collection.size(); i++){
            if(collection.get(i) instanceof Primate){
               msg += ((Primate)collection.get(i)).getName() + " ";  
            }
        }
        return msg; 
    }
    
}
