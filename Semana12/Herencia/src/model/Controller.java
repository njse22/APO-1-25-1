package model;

import java.util.ArrayList;
import exceptions.AnimalNotFoundException;

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

    // Todos los atributos para crear cualquier animal | type -> define 
    // que tipo de animal voy a crear 
    public void createAnimal(String name, int age, String id, int type){
        Animal animal = null; 

        // Human
        if(type == 1){ 
	    animal = createHuman(name, age, id);
        }
        // Duck
        else if(type == 2){
            animal = new Duck(name, age); 
        }
	// Chicken
	else if(type == 3){
	    animal = new Chicken(name, age); 
	}
	// Monkey
	else if(type == 4){
	    animal = new Monkey(name, age); 
	}

        collection.add(animal); 

    }

    public String search(String name) throws AnimalNotFoundException {
	String msg = "";
	boolean isFound = false; 

	// int i = 0; 
	// System.out.println( (i <= collection.size() - 1 && !isFound) );

	for(int i = 0; i <= collection.size() - 1 && !isFound; i++){
	    // System.out.println("Controller::search>> In for loop");
	    if(collection.get(i).getName().equals(name)){
		msg = collection.get(i).getName(); //+ " " + collection.get(i).screen(); 
		isFound = true;
	    }
	}
	if(!isFound){
	    throw new AnimalNotFoundException("El animal con el nombre " + name + " No ha sido encontrado");
	}
	return msg; 
    }

    public boolean delete(String name){
	boolean isDeleted = false;
	for(int i = 0; i <= collection.size() - 1 && !isDeleted; i++){
	    if(collection.get(i).getName().equals(name)){
		Animal deleted = collection.remove(i);  
		isDeleted = true; 
		System.out.println("Controller::delete >> for-loop >> deleted: " + deleted);
	    }
	}
	return isDeleted; 
    }

    public boolean deleteV2(String name){
	boolean isDeleted = false;
	for(int i = 0; i <= collection.size() - 1 && !isDeleted; i++){
	    if(collection.get(i).getName().equals(name)){
		isDeleted = collection.remove( collection.get(i) ); 
	    }
	}
	return isDeleted;
    }




    private Human createHuman(String name, int age, String id){
	Human human = new Human(name, age, id); 
	return human; 
    }

    public String filterPrimates(){
	String msg = ""; 
        for(int i = 0; i < collection.size(); i++){
	    // filtrar y decidir si el objeto animal 
	    // pertenece a primate 
            if(collection.get(i) instanceof Primate){
               msg += ((Primate)collection.get(i)).getName() + " ";  
            }
        }
        return msg; 
    }
    
}
