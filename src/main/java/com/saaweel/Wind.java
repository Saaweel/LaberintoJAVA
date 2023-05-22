package com.saaweel;

import java.io.FileWriter;
import java.io.IOException;

public class Wind extends Adverse {
    public Wind(String name, int position) {
        super(name, position);
    }

    public void doAdverse(Harry harry, Map m, FileWriter log) {
        System.out.println("¡Adversidad " + super.getName() + " atacando a Harry!");
        try {
            log.write("¡Adversidad " + super.getName() + " atacando a Harry!\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        harry.resetPosition(m);
    }
}
