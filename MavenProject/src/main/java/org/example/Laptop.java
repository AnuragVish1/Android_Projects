package org.example;

public class Laptop {
    private String charger;

    public Laptop(){
        System.out.println("Laptop Initializing");
    }

    public String getCharger(){
        return charger;
    }

    public void setCharger(String charger){
        this.charger = charger;
    }

    void code(){
        System.out.println("hello");
    }

}
