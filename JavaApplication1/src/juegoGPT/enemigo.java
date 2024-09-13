
package juegoGPT;
//se importa la clase "Color" para estilizar y 
//la clase "Graphics" para dibujar 
import java.awt.Color;
import java.awt.Graphics;

//CLASE ENEMIGO
public class enemigo {
    //ATRIBUTOS
    
    //posicion 
    private int x, y;
    //velocidad
    private int dx, dy;
    //tamaño
    private final int width = 20, height = 20;
    
    //Contructor de la clase Enemigo (sirve para inicializar)
    //recibe como parámetros las cordenadas x, y
    public enemigo(int x, int y) {
        //se asignan las coordenas
        this.x = x;
        this.y = y;
        //se asignan las velocidades 
        this.dx = 2;  // Velocidad en x
        this.dy = 2;  // Velocidad en y
    }
    //METODO PARA ACTUALIZAR LAS POSICIONES DE LOS ENEMIGOS
    public void update() {
        //se actualiza la posicion de enemigo sumando la velocidad horizontal y luego la vertical
        x += dx;
        y += dy;

        // Rebote simple en los bordes de la pantalla
        if (x < 0 || x > 780) {
            dx = -dx;  // Invierte la dirección horizontal
        }
        if (y < 0 || y > 580) {
            dy = -dy;  // Invierte la dirección vertical
        }
    }
    //METODO PARA DIBUJAR EL ENEMIGO
    public void draw(Graphics g) {
        //ATRIBUTOS 
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);  // Dibuja el enemigo como un cuadrado rojo
    }

    //METODO QUE DEVUELVE LA COORDENADA X DEL ENEMIGO
    public int getX() {
        return x;
    }
    //METODO QUE DEVUELVE LA COORDENADA Y DEL ENEMIGO
    public int getY() {
        return y;
    }
    //METODO QUE DEVUELVE LA ANCHO DEL ENEMIGO
    public int getWidth() {
        return width;
    }
    //METODOD QUE DEVUELVE EL ALTURA DEL ENEMIGO 
    public int getHeight() {
        return height;
    }
}
