package com.saaweel;

import java.util.LinkedList;

public class Harry {
    private int position;
    private LinkedList<Direction> path;
    private int health;

    public Harry(Map m) {
        this.position = 0;
        this.path = new LinkedList();
        this.health = 100;
        traceRoute(m, new LinkedList<Integer>());
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void resetPosition(Map m) {
        this.position = 0;
        this.path = new LinkedList();
        traceRoute(m, new LinkedList<Integer>());
    }

    public boolean traceRoute(Map m, LinkedList<Integer> visited) {
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

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
