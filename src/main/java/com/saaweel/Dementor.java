package com.saaweel;

public class Dementor extends Adverse {
    public Dementor(String name, int position) {
        super(name, position);
    }

    public void doAdverse() {
        System.out.println("Dementor is sucking your soul");
    }
}