package com.saaweel;

import java.util.LinkedList;

public class Harry {
    private int position;
    private LinkedList<Directions> path;
    private LinkedList<Integer> visited;

    public Harry(int position) {
        this.position = position;
        this.path = new LinkedList<>();
        this.visited = new LinkedList<>();
    }

    public int getPosition() {
        return position;
    }

    public LinkedList<Directions> getPath() {
        return path;
    }

    public LinkedList<Integer> getVisited() {
        return visited;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPath(LinkedList<Directions> path) {
        this.path = path;
    }

    public void setVisited(LinkedList<Integer> visited) {
        this.visited = visited;
    }

    public void addVisited(int position) {
        this.visited.add(position);
    }

    public void addPath(Directions direction) {
        this.path.add(direction);
    }

    public void removeVisited(int position) {
        this.visited.remove(position);
    }

    public void removePath(Directions direction) {
        this.path.remove(direction);
    }

    public boolean isVisited(int position) {
        return this.visited.contains(position);
    }

    public boolean traceRoute(Map m) {
        if (this.position == m.getExit()) {
            this.position = 0;
            return true;
        } else {
            if (!m.isLastFloor(this.position) && !m.existWall(this.position, this.position + m.getWidth()) && !isVisited(this.position + m.getWidth())) {
                this.position += m.getWidth();
                addVisited(this.position);
                addPath(Directions.S);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Directions.S);
                    this.position -= m.getWidth();
                }
            }

            if (!m.isLastWall(this.position) && !m.existWall(this.position, this.position + 1) && !isVisited(this.position + 1)) {
                this.position += 1;
                addVisited(this.position);
                addPath(Directions.E);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Directions.E);
                    this.position -= 1;
                }
            }

            if (!m.isFirstWall(this.position) && !m.existWall(this.position, this.position - 1) && !isVisited(this.position - 1)) {
                this.position -= 1;
                addVisited(this.position);
                addPath(Directions.O);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Directions.O);
                    this.position += 1;
                }
            }

            if (!m.isFirstFloor(this.position) && !m.existWall(this.position, this.position - m.getWidth()) && !isVisited(this.position - m.getWidth())) {
                this.position -= m.getWidth();
                addVisited(this.position);
                addPath(Directions.N);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Directions.N);
                    this.position += m.getWidth();
                }
            }
            return false;
        }
    }
}
