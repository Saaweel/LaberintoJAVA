package com.saaweel;

import java.util.LinkedList;

public class Harry {
    private int position;
    private LinkedList<Direction> path;
    private LinkedList<Integer> visited;

    public Harry(Map m) {
        this.position = 0;
        this.visited = new LinkedList<>();
        this.path = new LinkedList<>();
        this.traceRoute(m);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPath(LinkedList<Direction> path) {
        this.path = path;
    }

    public void setVisited(LinkedList<Integer> visited) {
        this.visited = visited;
    }

    public void addVisited(int position) {
        this.visited.add(position);
    }

    public void addPath(Direction direction) {
        this.path.add(direction);
    }

    public void removeVisited(int position) {
        this.visited.remove(position);
    }

    public void removePath(Direction direction) {
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
                addPath(Direction.S);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direction.S);
                    this.position -= m.getWidth();
                }
            }

            if (!m.isLastWall(this.position) && !m.existWall(this.position, this.position + 1) && !isVisited(this.position + 1)) {
                this.position += 1;
                addVisited(this.position);
                addPath(Direction.E);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direction.E);
                    this.position -= 1;
                }
            }

            if (!m.isFirstWall(this.position) && !m.existWall(this.position, this.position - 1) && !isVisited(this.position - 1)) {
                this.position -= 1;
                addVisited(this.position);
                addPath(Direction.O);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direction.O);
                    this.position += 1;
                }
            }

            if (!m.isFirstFloor(this.position) && !m.existWall(this.position, this.position - m.getWidth()) && !isVisited(this.position - m.getWidth())) {
                this.position -= m.getWidth();
                addVisited(this.position);
                addPath(Direction.N);
                if (traceRoute(m)) {
                    return true;
                } else {
                    removePath(Direction.N);
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
}
