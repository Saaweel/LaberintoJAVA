package com.saaweel;

public class Dementor extends Adverse {
    public Dementor(int position) {
        super("Dementor", position);
    }

    public void doAdverse(Harry harry, Map m) {
        System.out.println("¡Adversidad " + super.getName() + " atacando a Harry!");
        harry.setHealth(harry.getHealth() - 30);
    }
}