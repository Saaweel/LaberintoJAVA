package com.saaweel;

public class App {
    private static void executeGame(Harry harry, Map m) {
        for (int i = 0; harry.getPosition() != m.getExit(); i++) {
            harry.move(m);

            m.doAdverses();

            if (harry.getHealth() <= 0) {
                System.out.println("Harry ha muerto");
                break;
            }
            
            System.out.println("Turno " + i);
            System.out.println(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
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
        System.out.println(m);

        executeGame(harry, m);
        
        // m = new Map(7,5);
        // m.addWall(0,5);
        // m.addWall(2,3);
        // m.addWall(3,8);
        // m.addWall(6,7);
        // m.addWall(6,11);
        // m.addWall(7,12);
        // m.addWall(8,13);
        // m.addWall(13,14);
        // m.addWall(13,18);
        // m.addWall(15,16);
        // m.addWall(15,20);
        // m.addWall(16,17);
        // m.addWall(17,22);
        // m.addWall(18,19);
        // m.addWall(19,20);
        // m.addWall(19,24);
        // m.addWall(20,25);
        // m.addWall(22,23);
        // m.addWall(22,27);
        // m.addWall(23,24);
        // m.addWall(25,30); 
        // m.addWall(26,27);
        // m.addWall(27,32);
        // m.addWall(28,29);
        // m.addWall(28,33);

        // m.addAdverse(new Wind("Viento Norte", 2));
        // m.addAdverse(new Wind("Viento Sur", 32));
        // m.addAdverse(new Dementor(10));
        // m.addAdverse(new Dementor(21));
        // m.addAdverse(new Dementor(26));
        // m.addAdverse(new Dementor(19));
    }
}