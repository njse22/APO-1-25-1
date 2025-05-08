package model; 

public abstract class Animal {
    
    ///////////////////////////////////
    //  Atributos | caracteristicas  //
    ///////////////////////////////////
    private String name;
    protected int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    /////////////////////////////////
    //  Métodos | comportamiento   //
    /////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
} 
