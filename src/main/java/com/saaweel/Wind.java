package com.saaweel;

public class Wind extends Adverse {
    public Wind(String name, int position) {
        super(name, position);
    }

    public void doAdverse() {
        System.out.println("Wind is blowing");
    }
}
