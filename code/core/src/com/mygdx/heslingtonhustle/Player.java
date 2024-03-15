package com.mygdx.heslingtonhustle;

public class Player {
    String name;
    int energy;
    int hunger;
    Movement move;

    public Player() {
        name = "TestPerson";
        energy = 10;
        hunger = 10;
        move = new Movement();
    }

    public Player(String Name, int Energy, int Hunger, int X, int Y) {
        name = Name;
        energy = Energy;
        hunger = Hunger;
    }

    public void interact(){
        
    }

    public void eat(){
        hunger += 10;
    }

    public void sleep() {
        energy += 10;
    }

    public void takeExam(){

    }

    public int energyCheck(){
        return energy;
    }

    public void energyDeplete(int x){
        energy -= x;
    }

    public void energyBoost(int x){
        energy += x;
    }

    public void energyChange(){

    }
}
