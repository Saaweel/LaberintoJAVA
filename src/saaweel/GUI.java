/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Programa principal ejecutable para la consola y la interfaz gráfica
 * @author Saúl Díaz
 */
public class GUI extends javax.swing.JFrame {
    private static FileWriter writer;
    private static Harry harry;
    private static Map map;
    private static int step;

    /**
     * Crea el formulario GUI
     */
    public GUI() {
        initComponents();     
        
        /*
        map = new Map(4,4);
        map.addWall(0,4);
        map.addWall(3,7);
        map.addWall(5,6);
        map.addWall(5,9);
        map.addWall(8,9);
        map.addWall(8,12);
        map.addWall(10,11);
        map.addWall(10,14);
        map.addWall(11,15);

        map.addAdverse(new Wind("Viento Norte", 2));
        map.addAdverse(new Wind("Viento Sur", 13));
        map.addAdverse(new Dementor(6));
        map.addAdverse(new Dementor(10));
        
        harry = new Harry(map);
        map.spawnHarry(harry);

        executeGame();
        */
        
        
        map = new Map(7,5);
        map.addWall(0,5);
        map.addWall(2,3);
        map.addWall(3,8);
        map.addWall(6,7);
        map.addWall(6,11);
        map.addWall(7,12);
        map.addWall(8,13);
        map.addWall(13,14);
        map.addWall(13,18);
        map.addWall(15,16);
        map.addWall(15,20);
        map.addWall(16,17);
        map.addWall(17,22);
        map.addWall(18,19);
        map.addWall(19,20);
        map.addWall(19,24);
        map.addWall(20,25);
        map.addWall(22,23);
        map.addWall(22,27);
        map.addWall(23,24);
        map.addWall(25,30); 
        map.addWall(26,27);
        map.addWall(27,32);
        map.addWall(28,29);
        map.addWall(28,33);

        map.addAdverse(new Wind("Viento Norte", 2));
        map.addAdverse(new Wind("Viento Sur", 32));
        map.addAdverse(new Dementor(10));
        map.addAdverse(new Dementor(21));
        map.addAdverse(new Dementor(26));
        map.addAdverse(new Dementor(19));

        harry = new Harry(map);
        map.spawnHarry(harry);

        executeGame();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OutputTextArea = new javax.swing.JTextArea();
        NextStep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OutputTextArea.setEditable(false);
        OutputTextArea.setColumns(20);
        OutputTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        OutputTextArea.setRows(5);
        jScrollPane1.setViewportView(OutputTextArea);

        NextStep.setText("Avanzar");
        NextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextStepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NextStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NextStep, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Pasa al siguiente turno
     * @param evt
     */
    private void NextStepActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            step += 1;
            if (harry.getPosition() != map.getExit() && harry.getHealth() > 0) {
                if (step % 10 == 0) {
                    harry.setHealth(harry.getHealth() - 20);
                }

                if (harry.getHealth() <= 0) {
                    System.out.println("Harry no ha conseguido salir del laberinto :(");
                    writer.write("Harry no ha conseguido salir del laberinto :(");
                    OutputTextArea.append("Harry no ha conseguido salir del laberinto :(");
                    NextStep.setText("Cerrar");
                    return;
                }

                System.out.println("Turno: " + step + ", salud de Harry: " + harry.getHealth());
                writer.write("Turno: " + step + ", salud de Harry: " + harry.getHealth() + "\n");
                OutputTextArea.append("Turno: " + step + ", salud de Harry: " + harry.getHealth() + "\n");

                harry.move(map);

                map.doAdverses(writer, OutputTextArea);
                
                System.out.println(map);
                writer.write(map.toString());
                OutputTextArea.append(map.toString() + "\n");
                
                if (harry.getPosition() == map.getExit()) {
                    System.out.println("HARRY HA GANADO EL JUEGO :)");
                    writer.write("HARRY HA GANADO EL JUEGO :)");
                    OutputTextArea.append("HARRY HA GANADO EL JUEGO :)");
                    NextStep.setText("Cerrar");
                }
            } else {
                writer.close();
                this.dispose();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage()); 
        }
    }

    /**
     * Ejecuta el juego
     */
    private static void executeGame() {
        try {
            step = 1;
            writer = new FileWriter("src/saaweel/registro.log");
            System.out.println("COMIENZA LA BATALLA");
            writer.write("COMIENZA LA BATALLA\n");
            OutputTextArea.append("COMIENZA LA BATALLA\n");
            System.out.println("Turno: 0, salud de Harry: " + harry.getHealth());
            writer.write("Turno: 0, salud de Harry: " + harry.getHealth() + "\n");
            OutputTextArea.append("Turno: 0, salud de Harry: " + harry.getHealth() + "\n");
            System.out.println(map);
            writer.write(map.toString());
            OutputTextArea.append(map.toString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());   
        }
    }
    
    /**
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private static javax.swing.JButton NextStep;
    private static javax.swing.JTextArea OutputTextArea;
    private javax.swing.JScrollPane jScrollPane1;
}