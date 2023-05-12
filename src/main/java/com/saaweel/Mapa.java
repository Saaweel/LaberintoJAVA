package com.saaweel;

import java.util.LinkedList;

public class Mapa {
    private int ancho;
    private int alto;
    private LinkedList<Pared> paredes;
    private Harry harry;

    public Mapa(int alto, int ancho) {
        this.ancho = ancho;
        this.alto = alto;
        this.paredes = new LinkedList<Pared>();
        this.harry = new Harry(0);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void aniadirPared(int x, int y) {
        if (x > y) {
            int aux = x;
            x = y;
            y = aux;
        }

        if (x >= 0 && x < this.ancho * this.alto && y >= 0 && y < this.ancho * this.alto && !existWall(x, y)) {
            Pared pared = new Pared(x, y);
            this.paredes.add(pared);
        }
    }

    public boolean existWall(int x, int y) {
        if (x > y) {
            int aux = x;
            x = y;
            y = aux;
        }
        
        for (Pared pared : this.paredes) {
            if (pared.getX() == x && pared.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public int getExit() {
        return this.ancho * this.alto - 1;
    }

    public boolean isFirstFloor(int position) {
        return position < this.ancho;
    }

    public boolean isLastFloor(int position) {
        return position >= this.ancho * (this.alto - 1);
    }

    public boolean isFirstWall(int position) {
        return position % this.ancho == 0;
    }

    public boolean isLastWall(int position) {
        return position % this.ancho == this.ancho - 1;
    }

    @Override
    public String toString() {
        String mapa = "";

        for (int i = 0; i < this.ancho; i++) {
            mapa += " _";
        }

        mapa += "\n";

        for (int i = 0; i < this.alto; i++) {
            mapa += "|";

            for (int j = 0; j < this.ancho; j++) {
                int pos = i * this.ancho + j;

                if (pos == this.harry.getPosition()) {
                    mapa += "H";
                } else {
                    if (i == this.alto - 1) {
                        mapa += "_";
                    } else {
                        if (existWall(pos, pos + this.ancho)) {
                            mapa += "_";
                        } else {
                            mapa += " ";
                        }
                    }
                }
    
                if (j != this.ancho - 1) {
                    if (existWall(pos, pos + 1)) {
                        mapa += "|";
                    } else {
                        mapa += " ";
                    }
                }
            }
            mapa += "|\n";
        }
        return mapa;
    }
}
