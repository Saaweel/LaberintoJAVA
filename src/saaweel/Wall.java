/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

/**
 * Clase que representa una pared en el mapa del juego, tiene una coordenada x y una coordenada y (x, y), la x siempre sera la coordenada menor
 * @author Saúl Díaz
 */
public class Wall {
    private int x;
    private int y;

    /**
     * @param x La posición X (int)
     * @param y La posición Y (int)
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return La coordenada x de la pared (int)
     */
    public int getX() {
        return x;
    }

    /**
     * @return La coordenada y de la pared (int)
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada x de la pared
     * @param x La coordenada X (int)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Establece la coordenada y de la pared
     * @param y La coordenada Y (int)
     */
    public void setY(int y) {
        this.y = y;
    }
}
