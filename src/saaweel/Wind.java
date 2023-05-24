/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Saúl Díaz
 */
public class Wind extends Adverse {
    /**
     * @param name (String)
     * @param position (int)
     */
    public Wind(String name, int position) {
        super(name, position);
    }

    /**
     * Ejecuta la adversidad
     * @param harry (Harry)
     * @param m (Map)
     * @param log (FileWriter)
     * @param OutputTextArea (javax.swing.JTextArea)
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
        harry.resetPosition(m);
    }
}
