package com.saaweel;

import java.util.LinkedList;

public class Mapa {
    private int ancho;
    private int alto;
    private LinkedList<Pared> paredes;

    public Mapa(int alto, int ancho) {
        this.ancho = ancho;
        this.alto = alto;
        this.paredes = new LinkedList<Pared>();
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

        if (x >= 0 && x < this.ancho * this.alto && y >= 0 && y < this.ancho * this.alto && !existePared(x, y)) {
            Pared pared = new Pared(x, y);
            this.paredes.add(pared);
        }
    }

    public boolean existePared(int x, int y) {
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

                if (i == this.alto - 1) {
                    mapa += "_";
                } else {
                    if (existePared(pos, pos + this.ancho)) {
                        mapa += "_";
                    } else {
                        mapa += " ";
                    }
                }

                if (j != this.ancho - 1) {
                    if (existePared(pos, pos + 1)) {
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
