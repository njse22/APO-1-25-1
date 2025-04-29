package ui;

import java.util.InputMismatchException;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.AnimalNotFoundException;

import model.Animal; 
import model.Primate;
import model.Human;
import model.Monkey;
import model.Bird;
import model.Chicken;
import model.Duck;
import model.IFly; 
import model.IRun; 
import model.Airplane;
import model.Controller; 

public class Main {

    public static void main(String[] args){

	Scanner reader = new Scanner(System.in); 
	System.out.println("Type a number: "); 

	/////////////////////////////////////////
	//  BLOQUE DE CONTROL DE LA EXCEPCIÓN  //
	/////////////////////////////////////////
	try{
	    int a = reader.nextInt();
	}
	catch(InputMismatchException error){
	    System.out.println("El valor de entrada debe ser un número"); 
	}

	////////////////////////////////
	//  Primer Ejemplo Herencia   //
	////////////////////////////////
	Human primate1   = new Human("Name1", 10, "A10");
	Primate primate2 = new Human("Name2", 20, "A20");
	Primate primate3 = new Monkey("Name3", 5);
	Primate primate4 = new Human("Name4", 15);

	System.out.println( ((Human) primate4).screen());
	System.out.println( ((Human) primate4).screen("msj from main"));

	ArrayList<Primate> array = new ArrayList();
	array.add(primate2);
	array.add(primate3);
	array.add(primate4);

	array.add(primate1); 
	System.out.println(array); 

	for(int i = 0; i < array.size(); i++){
	    if(array.get(i) instanceof Monkey){
		System.out.println("This is a Monkey "+ 
			((Monkey) array.get(i)).jump());
	    }
	    else{
		System.out.println(array.get(i).hello());

	    }
	}

	///////////////////////////////////////////
	//  Segundo ejemplo | uso de interfaces  //
	///////////////////////////////////////////

        Bird bird1   = new Chicken("Bird1", 10);
        Bird bird2   = new Duck("Bird2", 20);

        IFly flayer1 = new Airplane("Model1", 4);
        IFly flayer2 = new Duck("Duck1", 6);

        Duck duck1   = new Duck("Duck", 7);

        IRun runner  = new Duck("Duck Runner", 9);

        System.out.println("************* FLY ************"); 
        
        System.out.println(duck1.fly());
        System.out.println(flayer2.fly());
        System.out.println( ( (Duck) bird2 ).fly());
        System.out.println( ( (Duck) runner ).fly());

        System.out.println("************* RUN ************");

        System.out.println(duck1.run());
        System.out.println( ((Duck) flayer2).run());
        System.out.println( ((Duck) bird2).run());
        System.out.println(runner.run());

        System.out.println("************* TALK ************");

        System.out.println( duck1.talk());
        System.out.println( ((Duck)flayer2).talk());
        System.out.println( ((Duck)bird2).talk());
        System.out.println( ((Duck)runner).talk());

	///////////////////////////
	//  Uso del controlador  //
	///////////////////////////
        Controller control = new Controller(); 
        
        control.createAnimal("Name1", 66, "6", 1); 

        System.out.println(control.filterPrimates());
	
        System.out.println("************* SEARCH ************");
	try{
	    System.out.println(control.search("Name1"));
	}
	catch(AnimalNotFoundException error){
	    error.printStackTrace(); 
	}

        System.out.println("************* DELETED ************");
	System.out.println(control.deleteV2("Name1"));

	
    }
    
}
