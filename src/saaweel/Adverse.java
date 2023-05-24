/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.io.FileWriter;

/**
 * Clase abstracta que representa una adversidad que puede atacar a Harry
 * @author Saúl Díaz
 */
public abstract class Adverse {
    private String name;
    private int position;

    /**
     * @param name El nombre de la adversidad (String)
     * @param position La posición en la que se encuentra la adversidad (int)
     */
    public Adverse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * @return El nombre de la adversidad (String)
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @return La posición de la adversidad (int)
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Establece el nombre de la adversidad
     * @param name El nombre de la adversidad (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Establece la posición de la adversidad
     * @param position La posición de la adversidad (int)
     */
    public void setPosition(int position) {
        this.position = position;
    }
    
    /**
     * Método abstracto que se encarga de realizar la adversidad
     * @param harry El personaje (Harry)
     * @param m El mapa (Map)
     * @param writer El archivo de registro (FileWriter)
     * @param OutputTextArea El área de texto de la interfaz (javax.swing.JTextArea)
     */
    public abstract void doAdverse(Harry harry, Map m, FileWriter writer, javax.swing.JTextArea OutputTextArea);
}