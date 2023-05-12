package com.saaweel;

import java.util.LinkedList;

public class Harry {
    private int position;
    private LinkedList<Direcciones> path;
    private LinkedList<Integer> visited;

    public Harry(int position) {
        this.position = position;
        this.path = new LinkedList<>();
        this.visited = new LinkedList<>();
    }

    public int getPosition() {
        return position;
    }

    public LinkedList<Direcciones> getPath() {
        return path;
    }

    public LinkedList<Integer> getVisited() {
        return visited;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPath(LinkedList<Direcciones> path) {
        this.path = path;
    }

    public void setVisited(LinkedList<Integer> visited) {
        this.visited = visited;
    }

    public void addVisited(int position) {
        this.visited.add(position);
    }

    public void addPath(Direcciones direction) {
        this.path.add(direction);
    }

    public void removeVisited(int position) {
        this.visited.remove(position);
    }

    public void removePath(Direcciones direction) {
        this.path.remove(direction);
    }

    public boolean isVisited(int position) {
        return this.visited.contains(position);
    }

    public boolean traceRoute(Mapa m) {
        if (this.position == m.getExit()) {
            this.position = 0;
            return true;
        } else {
            if (!m.isLastFloor(this.position) && !m.existWall(this.position, this.position + m.getAncho()) && !isVisited(this.position + m.getAncho())) {
                this.position += m.getAncho();
                addVisited(this.position);
                addPath(Direcciones.S);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direcciones.S);
                    this.position -= m.getAncho();
                }
            }

            if (!m.isLastWall(this.position) && !m.existWall(this.position, this.position + 1) && !isVisited(this.position + 1)) {
                this.position += 1;
                addVisited(this.position);
                addPath(Direcciones.E);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direcciones.E);
                    this.position -= 1;
                }
            }

            if (!m.isFirstWall(this.position) && !m.existWall(this.position, this.position - 1) && !isVisited(this.position - 1)) {
                this.position -= 1;
                addVisited(this.position);
                addPath(Direcciones.O);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direcciones.O);
                    this.position += 1;
                }
            }

            if (!m.isFirstFloor(this.position) && !m.existWall(this.position, this.position - m.getAncho()) && !isVisited(this.position - m.getAncho())) {
                this.position -= m.getAncho();
                addVisited(this.position);
                addPath(Direcciones.N);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direcciones.N);
                    this.position += m.getAncho();
                }
            }
            return false;
        }
    }
}
