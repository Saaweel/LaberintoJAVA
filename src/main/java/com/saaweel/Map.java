package com.saaweel;

import java.util.LinkedList;

public class Map {
    private int width;
    private int height;
    private LinkedList<Wall> walls;
    private Harry harry;

    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        this.walls = new LinkedList<Wall>();
        this.harry = new Harry(0);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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

    public int getExit() {
        return this.width * this.height - 1;
    }

    public boolean isFirstFloor(int position) {
        return position < this.width;
    }

    public boolean isLastFloor(int position) {
        return position >= this.width * (this.height - 1);
    }

    public boolean isFirstWall(int position) {
        return position % this.width == 0;
    }

    public boolean isLastWall(int position) {
        return position % this.width == this.width - 1;
    }

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

                if (pos == this.harry.getPosition()) {
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
