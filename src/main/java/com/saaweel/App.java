package com.saaweel;

public class App {
    public static void main( String[] args ) {
        Mapa m = new Mapa(4,4);
        System.out.println(m);
        m.aniadirPared(0,4);
        m.aniadirPared(3,7);
        m.aniadirPared(5,6);
        m.aniadirPared(5,9);
        m.aniadirPared(8,9);
        m.aniadirPared(8,12);
        m.aniadirPared(10,11);
        m.aniadirPared(10,14);
        m.aniadirPared(11,15);
        System.out.println(m);
        
        // m = new Mapa(7,5);
        // System.out.println(m);
        // m.aniadirPared(0,5);
        // m.aniadirPared(2,3);
        // m.aniadirPared(3,8);
        // m.aniadirPared(6,7);
        // m.aniadirPared(6,11);
        // m.aniadirPared(7,12);
        // m.aniadirPared(8,13);
        // m.aniadirPared(13,14);
        // m.aniadirPared(13,18);
        // m.aniadirPared(15,16);
        // m.aniadirPared(15,20);
        // m.aniadirPared(16,17);
        // m.aniadirPared(17,22);
        // m.aniadirPared(18,19);
        // m.aniadirPared(19,20);
        // m.aniadirPared(19,24);
        // m.aniadirPared(20,25);
        // m.aniadirPared(22,23);
        // m.aniadirPared(22,27);
        // m.aniadirPared(23,24);
        // m.aniadirPared(25,30); 
        // m.aniadirPared(26,27);
        // m.aniadirPared(27,32);
        // m.aniadirPared(28,29);
        // m.aniadirPared(28,33);
        // System.out.println(m);
    }
}