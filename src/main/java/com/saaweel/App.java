package com.saaweel;

import java.io.FileWriter;

public class App {
    private static void executeGame(Harry harry, Map m) {
        try {
            FileWriter writer = new FileWriter("main/java/com/saaweel/registro.log");

            System.out.println("COMIENZA LA BATALLA");
            writer.write("COMIENZA LA BATALLA\n");
            System.out.println("Turno: 0, salud de Harry: " + harry.getHealth());
            writer.write("Turno: 0, salud de Harry: " + harry.getHealth() + "\n");
            System.out.println(m);
            writer.write(m.toString());

            for (int i = 1; harry.getPosition() != m.getExit(); i++) {
                if (i % 10 == 0) {
                    harry.setHealth(harry.getHealth() - 20);
                }

                if (harry.getHealth() <= 0) {
                    System.out.println("Harry no ha conseguido salir del laberinto :(");
                    writer.write("Harry no ha conseguido salir del laberinto :(");
                    writer.close();
                    return;
                }

                System.out.println("Turno: " + i + ", salud de Harry: " + harry.getHealth());
                writer.write("Turno: " + i + ", salud de Harry: " + harry.getHealth() + "\n");

                harry.move(m);

                m.doAdverses();
                
                System.out.println(m);
                writer.write(m.toString());
            }

            System.out.println("HARRY HA GANADO EL JUEGO :)");
            writer.write("HARRY HA GANADO EL JUEGO :)");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }

    public static void main( String[] args ) {
        Map m = new Map(4,4);
        m.addWall(0,4);
        m.addWall(3,7);
        m.addWall(5,6);
        m.addWall(5,9);
        m.addWall(8,9);
        m.addWall(8,12);
        m.addWall(10,11);
        m.addWall(10,14);
        m.addWall(11,15);

        m.addAdverse(new Wind("Viento Norte", 2));
        m.addAdverse(new Wind("Viento Sur", 13));
        m.addAdverse(new Dementor(6));
        m.addAdverse(new Dementor(10));


        Harry harry = new Harry(m);
        m.spawnHarry(harry);

        executeGame(harry, m);
        
        m = new Map(7,5);
        m.addWall(0,5);
        m.addWall(2,3);
        m.addWall(3,8);
        m.addWall(6,7);
        m.addWall(6,11);
        m.addWall(7,12);
        m.addWall(8,13);
        m.addWall(13,14);
        m.addWall(13,18);
        m.addWall(15,16);
        m.addWall(15,20);
        m.addWall(16,17);
        m.addWall(17,22);
        m.addWall(18,19);
        m.addWall(19,20);
        m.addWall(19,24);
        m.addWall(20,25);
        m.addWall(22,23);
        m.addWall(22,27);
        m.addWall(23,24);
        m.addWall(25,30); 
        m.addWall(26,27);
        m.addWall(27,32);
        m.addWall(28,29);
        m.addWall(28,33);

        m.addAdverse(new Wind("Viento Norte", 2));
        m.addAdverse(new Wind("Viento Sur", 32));
        m.addAdverse(new Dementor(10));
        m.addAdverse(new Dementor(21));
        m.addAdverse(new Dementor(26));
        m.addAdverse(new Dementor(19));

        harry = new Harry(m);
        m.spawnHarry(harry);

        executeGame(harry, m);
    }
}