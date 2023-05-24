/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Un tipo de adversidad que ataca a Harry y le resta 30 puntos de vida (HP)
 * @author Saúl Díaz
 */
public class Dementor extends Adverse {
    /**
     * @param position La posición de la adversidad (int)
     */
    public Dementor(int position) {
        super("Dementor", position);
    }

    /**
     * Ejecuta la adversidad
     * @param harry El personaje (Harry)
     * @param m El mapa (Map)
     * @param log El archivo de registro (FileWriter)
     * @param OutputTextArea El área de texto de la interfaz (javax.swing.JTextArea)
     */
    public void doAdverse(Harry harry, Map m, FileWriter log, javax.swing.JTextArea OutputTextArea) {
        System.out.println("¡Adversidad " + super.getName() + " atacando a Harry!");
        try {
            log.write("¡Adversidad " + super.getName() + " atacando a Harry!\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (OutputTextArea != null) {
            OutputTextArea.append("¡Adversidad " + super.getName() + " atacando a Harry!\n");
        }
        harry.setHealth(harry.getHealth() - 30);
    }
}