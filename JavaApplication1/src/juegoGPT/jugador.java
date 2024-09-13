
package juegoGPT;

import java.awt.Color;
import java.awt.Graphics;

//CLASE PUBLICA JUGADOR
public class jugador {
    //ATRIBUTOS
    
    //posicion 
    private int x, y;
    //velocidad
    private int dx, dy;
    //tamaño
    private final int width = 20, height = 20;
    //constructor de la clase jugador 
    public jugador(int x, int y) {
        //se asignan los valores de los parametro x, y
        //se configuran las posiciones iniciales del jugador
        this.x = x;
        this.y = y;
    }
    //METODO PARA ACTUALIZAR LAS POSICIONES DE LOS ENEMIGOS
    public void update() {
        x += dx;
        y += dy;
    }
    //METODO PARA DIBUJAR EL JUGADOR
    public void draw(Graphics g) {
        //ATRIBUTOS
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
    //METODO PARA CAMBIAR LA VELOCIDAD HORIZONTAL DEL JUGADOR
    public void setDx(int dx) {
        this.dx = dx;
    }
    //METODO PARA CAMBIAR LA VELOCIDAD VERTICAL DEL JUGADOR
    public void setDy(int dy) {
        this.dy = dy;
    }
}

