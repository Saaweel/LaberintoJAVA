package com.saaweel;

public class Wind extends Adverse {
    public Wind(String name, int position) {
        super(name, position);
    }

    public void doAdverse(Harry harry, Map m) {
        harry.resetPosition(m);
        System.out.println("Un viento ha empujado a Harry a la casilla 0");
    }
}
