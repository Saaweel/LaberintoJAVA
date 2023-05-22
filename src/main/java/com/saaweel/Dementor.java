package com.saaweel;

import java.io.FileWriter;
import java.io.IOException;

public class Dementor extends Adverse {
    public Dementor(int position) {
        super("Dementor", position);
    }

    public void doAdverse(Harry harry, Map m, FileWriter log) {
        System.out.println("¡Adversidad " + super.getName() + " atacando a Harry!");
        try {
            log.write("¡Adversidad " + super.getName() + " atacando a Harry!\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        harry.setHealth(harry.getHealth() - 30);
    }
}