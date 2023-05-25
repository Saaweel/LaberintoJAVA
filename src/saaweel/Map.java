/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.io.FileWriter;
import java.util.LinkedList;

/**
 * Clase que representa el mapa del juego, contiene las paredes, adversidades y a Harry Potter
 * @author Saúl Díaz
 */
public class Map {
    private int width;
    private int height;
    private LinkedList<Wall> walls;
    private Harry harry;
    private LinkedList<Adverse> adverses;

    /**
     * @param height La altura del mapa (int)
     * @param width El ancho del mapa (int)
     */
    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        this.walls = new LinkedList<Wall>();
        this.adverses = new LinkedList<Adverse>();
    }


    /**
     * Devuelve el ancho del mapa
     * @return El ancho del mapa (int)
     */
    public int getWidth() {
        return width;
    }

    /**
     * Devuelve el alto del mapa
     * @return El alto del mapa (int)
     */
    public int getHeight() {
        return height;
    }

    /**
     * Establece el ancho del mapa
     * @param width Ancho del mapa (int)
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Establece el alto del mapa
     * @param height Alto del mapa (int)
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Añade una pared al mapa
     * @param x Posición X de la pared (int)
     * @param y Posición Y de la pared (int)
     */
    public void addWall(int x, int y) {
        if (x > y) {
            int aux = x;
            x = y;
            y = aux;
        }

        if (x >= 0 && x < this.width * this.height && y >= 0 && y < this.width * this.height && !existWall(x, y)) {
            Wall wall = new Wall(x, y);
            this.walls.add(wall);
        }
    }

    /**
     * Comprueba si existe una pared entre dos posiciones
     * @param x Posición X (int)
     * @param y Posición Y (int)
     * @return true si existe una pared entre las posiciones, false si no
     */
    public boolean existWall(int x, int y) {
        if (x > y) {
            int aux = x;
            x = y;
            y = aux;
        }

        for (Wall wall : this.walls) {
            if (wall.getX() == x && wall.getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve la posición de la salida
     * @return La posición de la salida (int)
     */
    public int getExit() {
        return this.width * this.height - 1;
    }

    /**
     * Comprueba si es el primer piso
     * @param position La posición a comprobar (int)
     * @return true si la posición es el primer piso, false si no
     */
    public boolean isFirstFloor(int position) {
        return position < this.width;
    }

    /**
     * Comprueba si es el último piso
     * @param position La posición a comprobar (int)
     * @return true si la posición es el último piso, false si no
     */
    public boolean isLastFloor(int position) {
        return position >= this.width * (this.height - 1);
    }

    /**
     * Comprueba si es la primera pared
     * @param position La posición a comprobar (int)
     * @return true si la posición es la primera pared, false si no
     */
    public boolean isFirstWall(int position) {
        return position % this.width == 0;
    }

    /**
     * Comprueba si es la última pared
     * @param position La posición a comprobar (int)
     * @return true si la posición es la última pared, false si no
     */
    public boolean isLastWall(int position) {
        return position % this.width == this.width - 1;
    }

    /**
     * Pone a Harry en el mapa
     * @param harry El personaje Harry Potter (Harry)
     */
    public void spawnHarry(Harry harry) {
        this.harry = harry;
    }

    /**
     * Añade una adversidad al mapa
     * @param adverse La adversidad a añadir (Adverse)
     */
    public void addAdverse(Adverse adverse) {
        this.adverses.add(adverse);
    }

    /**
     * Comprueba si hay una adversidad en la posición de Harry y la ejecuta
     * @param writer El archivo de registro (FileWriter)
     * @param OutputTextArea El área de texto de la interfaz (javax.swing.JTextArea)
     */
    public void doAdverses(FileWriter writer, javax.swing.JTextArea OutputTextArea) {
        for (int i = 0; i < this.adverses.size(); i++) {
            Adverse adverse = this.adverses.get(i);
            if (adverse.getPosition() == this.harry.getPosition()) {
                adverse.doAdverse(this.harry, this, writer, OutputTextArea);
                this.adverses.remove(i);
            }
        }
    }

    /**
     * Devuelve el mapa en forma de String
     * @return El mapa en forma de String (String)
     */
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < this.width; i++) {
            str += " _";
        }

        str += "\n";

        for (int i = 0; i < this.height; i++) {
            str += "|";

            for (int j = 0; j < this.width; j++) {
                int pos = i * this.width + j;

                if (this.harry != null && pos == this.harry.getPosition()) {
                    str += "H";
                } else {
                    if (i == this.height - 1) {
                        str += "_";
                    } else {
                        if (existWall(pos, pos + this.width)) {
                            str += "_";
                        } else {
                            str += " ";
                        }
                    }
                }
    
                if (j != this.width - 1) {
                    if (existWall(pos, pos + 1)) {
                        str += "|";
                    } else {
                        str += " ";
                    }
                }
            }
            str += "|\n";
        }
        return str;
    }
}
