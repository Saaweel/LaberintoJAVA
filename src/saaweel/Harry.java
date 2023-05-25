/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saaweel;

import java.util.LinkedList;

/**
 * Clase que representa a Harry Potter, el personaje principal del juego
 * @author Saúl Díaz
 */
public class Harry {
    private int position;
    private LinkedList<Direction> path;
    private int health;

    /**
     * @param m El mapa que sigue Harry (Map)
     */
    public Harry(Map m) {
        this.position = 0;
        this.path = new LinkedList();
        this.health = 100;
        traceRoute(m, new LinkedList<Integer>());
    }

    /**
     * Devuelve la posicion de Harry
     * @return La posición de Harry (int)
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Establece la posición de Harry
     * @param position La posición de Harry (int)
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Reinicia la posición de Harry
     * @param m El mapa que sigue Harry (Map)
     */
    public void resetPosition(Map m) {
        this.position = 0;
        this.path = new LinkedList();
        traceRoute(m, new LinkedList<Integer>());
    }

    /**
     * Traza la ruta que sigue Harry
     * @param m El mapa que sigue Harry (Map)
     * @param visited Las casillas visitadas (LinkedList<Integer>)
     */
    private boolean traceRoute(Map m, LinkedList<Integer> visited) {
        if (this.position == m.getExit()) {
            this.position = 0;
            return true;
        } else {
            if (!m.isLastFloor(this.position) && !m.existWall(this.position, this.position + m.getWidth()) && !visited.contains(this.position + m.getWidth())) {
                this.position += m.getWidth();
                visited.add(this.position);
                this.path.add(Direction.S);
                if (traceRoute(m, visited)) {
                    return true;
                } else {
                    this.path.removeLast();
                    this.position -= m.getWidth();
                }
            }

            if (!m.isLastWall(this.position) && !m.existWall(this.position, this.position + 1) && !visited.contains(this.position + 1)) {
                this.position += 1;
                visited.add(this.position);
                this.path.add(Direction.E);
                if (traceRoute(m, visited)) {
                    return true;
                } else {
                    this.path.removeLast();
                    this.position -= 1;
                }
            }

            if (!m.isFirstWall(this.position) && !m.existWall(this.position, this.position - 1) && !visited.contains(this.position - 1)) {
                this.position -= 1;
                visited.add(this.position);
                this.path.add(Direction.O);
                if (traceRoute(m, visited)) {
                    return true;
                } else {
                    this.path.removeLast();
                    this.position += 1;
                }
            }

            if (!m.isFirstFloor(this.position) && !m.existWall(this.position, this.position - m.getWidth()) && !visited.contains(this.position - m.getWidth())) {
                this.position -= m.getWidth();
                visited.add(this.position);
                this.path.add(Direction.N);
                if (traceRoute(m, visited)) {
                    return true;
                } else {
                    this.path.removeLast();
                    this.position += m.getWidth();
                }
            }
            return false;
        }
    }

    /**
     * Mueve a Harry
     * @param m El mapa que sigue Harry (Map)
     */
    public void move(Map m) {
        if (!this.path.isEmpty()) {
            Direction direction = this.path.removeFirst();
            switch (direction) {
                case N:
                    this.position -= m.getWidth();
                    break;
                case S:
                    this.position += m.getWidth();
                    break;
                case E:
                    this.position += 1;
                    break;
                case O:
                    this.position -= 1;
                    break;
            }
        }
    }

    /**
     * Devuelve la salud de Harry
     * @return La salud de Harry (int)
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Establece la salud de Harry
     * @param health La salud de Harry (int)
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
