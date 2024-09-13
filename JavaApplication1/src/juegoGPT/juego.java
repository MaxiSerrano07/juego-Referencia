
package juegoGPT;


//clase que representa una ventana en la que puedes añadir elementos
import javax.swing.JFrame;

public class juego {
    public static void main(String[] args) {
        //objeto que será la ventana que aparecerá cuando el programa se ejecute
        JFrame frame = new JFrame("JUEGO-IA");
        //se instancia la clase para que su objeto ejecute el escenario del juego
        escenario gamePanel = new escenario();
        //se añade el panel con el contenido del juego (será parte de la ventana)
        frame.add(gamePanel);
        //cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tamaño de la ventana
        frame.setSize(800, 600);
        //la ventana será visible
        frame.setVisible(true);
    }
}

