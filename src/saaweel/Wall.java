/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

/**
 *
 * @author Saúl Díaz
 */
public class Wall {
    private int x;
    private int y;

    /**
     * @param x (int)
     * @param y (int)
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return La coordenada x de la pared
     */
    public int getX() {
        return x;
    }

    /**
     * @return La coordenada y de la pared
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada x de la pared
     * @param x (int)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Establece la coordenada y de la pared
     * @param y (int)
     */
    public void setY(int y) {
        this.y = y;
    }
}
