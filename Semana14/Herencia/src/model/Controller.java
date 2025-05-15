package model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

import java.util.List; 
import java.util.ArrayList;
import exceptions.AnimalNotFoundException;
import exceptions.NoAnimalsInListException;

public class Controller {

    private ArrayList<Animal> collection;
    private Path dataAnimals; 

    public Controller(){
        collection = new ArrayList<Animal>();     

	//System.out.println("Controller::Constructor >> " + System.getProperty("user.dir"));
	this.dataAnimals = Paths.get(System.getProperty("user.dir"), "data", "animals.csv"); 
	// System.out.println(dataAnimals.getFileName());
	// System.out.println(dataAnimals.getNameCount());
	// System.out.println(dataAnimals.getFileSystem());

	initFiles();
        // testData();    
	// saveAnimalsInfile();
	readAnimalsFromFile();
    }

    public ArrayList<Animal> getCollection(){
	return collection;
    }

    public void initFiles(){
	try{
	    if(!Files.exists(dataAnimals)){
		Files.createFile(dataAnimals);
	    }
	}catch(IOException e){
	    e.printStackTrace();
	}
    }

    public void saveAnimalsInfile(){
	String data = "Nombre,Edad,id,Type\n"; 

	// Darle formato a la información 
	for(int i = 0; i < collection.size(); i++){
	    
	    if(collection.get(i) instanceof Human){
		data += collection.get(i).getName() + "," + 
		    collection.get(i).getAge() + "," +
		    ((Human)collection.get(i)).getCc() + "," +
		    "1\n"; 
	    }
	    else if (collection.get(i) instanceof Duck) {
		data += collection.get(i).getName() + "," + 
		    collection.get(i).getAge() + "," + "N/A," +
		    "2\n"; 
	    }
	    else if (collection.get(i) instanceof Chicken) {
		data += collection.get(i).getName() + "," + 
		    collection.get(i).getAge() + "," + "N/A," +
		    "3\n"; 
	    }
	    else if (collection.get(i) instanceof Monkey) {
		data += collection.get(i).getName() + "," + 
		    collection.get(i).getAge() + "," + "N/A," +
		    "4\n"; 
	    }

	}

	// Guardamos la información 
	try{
	    Files.writeString(dataAnimals, data); 
	}catch (IOException e){
	    e.printStackTrace();
	}
    }

    public void readAnimalsFromFile(){
	try{
	    // Leamos el contenido 
	    List<String> csvData = Files.readAllLines(dataAnimals); 

	    // interpretemos el formato 
	    // Guardamos la información en Java 
	    for(int i = 1; i < csvData.size(); i++){
		String[] line = csvData.get(i).split(","); 
		String name = line[0]; 
		int age = Integer.parseInt(line[1]);  
		String id = line[2]; 
		int type = Integer.parseInt(line[3]); 
		createAnimal(name, age, id, type);
	    }


	}catch(IOException e){
	    e.printStackTrace();
	}
    }

    public void testData(){
        collection.add(new Monkey("Mojo jojo", 4));
        collection.add(new Monkey("Juanito", 6));
        collection.add(new Human("Sandra", 18, "00000000009"));

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
	if(collection.size() > 0){
	    for(int i = 0; i <= collection.size() - 1 && !isDeleted; i++){
		if(collection.get(i).getName().equals(name)){
		    Animal deleted = collection.remove(i);  
		    isDeleted = true; 
		    System.out.println("Controller::delete >> for-loop >> deleted: " + deleted);
		}
	    }
	}
	else {
	    throw new NoAnimalsInListException("No hay animales en la lista ");
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
