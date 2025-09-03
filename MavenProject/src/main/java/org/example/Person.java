package org.example;

public class Person {
    private int age;
    private Laptop laptop;

    public Person(){
        System.out.println("This is message from the person class");
    }

    public Laptop getLaptop(){
        return laptop;
    }

    public void setLaptop(Laptop laptop){
        this.laptop = laptop;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int a){
        this.age = a;
    }

    void display(){
        System.out.println("The age of the person is " + age);
        System.out.println("The laptop charger is " + laptop.getCharger());
    }
}
