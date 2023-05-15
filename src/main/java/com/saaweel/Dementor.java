package com.saaweel;

public class Dementor extends Adverse {
    public Dementor(int position) {
        super("Dementor", position);
    }

    public void doAdverse(Harry harry, Map m) {
        harry.setHealth(harry.getHealth() - 30);
        System.out.println("Un Dementor ha atacado a Harry, su salud es: " + harry.getHealth() + "♥");
    }
}