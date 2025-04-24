package model;

public abstract class Primate extends Animal{

    ///////////////////////////////////
    //  Atributos | caracteristicas  //
    ///////////////////////////////////
    private String name;
    private int age;

    public Primate(String name, int age){

        this.name = name;
        this.age = age;

    }

    /////////////////////////////////
    //  Métodos | comportamiento   //
    /////////////////////////////////
    public abstract String hello();

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
