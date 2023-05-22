package com.saaweel;

import java.io.FileWriter;

public abstract class Adverse {
    private String name;
    private int position;

    public Adverse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public abstract void doAdverse(Harry harry, Map m, FileWriter writer);
}