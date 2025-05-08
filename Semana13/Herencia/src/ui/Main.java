package ui;

import java.util.InputMismatchException;
import exceptions.AnimalNotFoundException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Controller; 

public class Main {

    public static void main(String[] args) {


	BufferedReader reader = new BufferedReader( new InputStreamReader( System.in )); 

	/////////////////////////////////////////
	//  BLOQUE DE CONTROL DE LA EXCEPCIÓN  //
	/////////////////////////////////////////
	try{

	    Controller control = new Controller(); 
	    System.out.print("Type a number: "); 
	    int a = Integer.parseInt(reader.readLine()); 

	    //control.search("Human"); 
	    reader.close();

	    // Para systemas operativos windows 
	    // String filePath = "D:\\Users\\user123\\Documents\\Hola.txt";
	    //
	    // Para un sistema operativo tipo Unix/Linix 
	    // String filePath = "/Users/user123/Documents/Hola.txt;


	    String filePath = 
		"/home/i2t/Git/icesi/2025-1/apo1/APO-1-25-1/Semana13/Herencia/data/Hola.txt";

	    BufferedReader fileReader = new BufferedReader(
		    new InputStreamReader(
			new FileInputStream(filePath)));

	    String line = fileReader.readLine(); 
	    System.out.println(line);

	    fileReader.close();
	    
	}
	catch(FileNotFoundException e){

	}
	catch(  IOException /*| AnimalNotFoundException*/ e){
	    e.printStackTrace();
	    System.out.println("ERROR de lectura");
	}
	//catch(AnimalNotFoundException e){

	//}


	System.out.println("MENSAJE DESPUÉS DE LA EXCEPCIÓN");

    }
    
}
