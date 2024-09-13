
package juegoGPT;

//clases con las que se trabajará
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
//para manejar un evento de acción
import java.awt.event.ActionEvent;
//para manejar eventos de accion
import java.awt.event.ActionListener;
//para representar eventos de teclado.
import java.awt.event.KeyEvent;
//para manejar eventos relacionados con el teclado.
import java.awt.event.KeyListener;
//permite programar la ejecución de tareas a intervalos regulares.
import javax.swing.Timer;
//para crear una lista dinámica donde se almacenarán los enemigos.
import java.util.ArrayList;


// La clase "escenario" extiende JPanel e implementa ActionListener y KeyListener
// para manejar los eventos del temporizador y las entradas del teclado
public class escenario extends JPanel implements ActionListener, KeyListener {
    //tiempo del juego
    private Timer timer;
    //Instancia del jugador en el juego
    private jugador player;
    //Lista de enemigos en el juego
    private ArrayList<enemigo> enemigos;

    //Constructor de la clase "escenario"
    public escenario() {
        //color de fondo
        this.setBackground(Color.BLACK);
        //se permite que el panel reciba eventos de teclado
        this.setFocusable(true);
        //agrega el panel como "escuchador" de eventos de teclado
        this.addKeyListener(this);
        
        // Posición inicial del jugador
        player = new jugador(50, 50); 

        // Crea la lista de enemigos
        enemigos = new ArrayList<>();
        enemigos.add(new enemigo(100, 100));  // Agrega un enemigo en la posición (100, 100)
        enemigos.add(new enemigo(300, 300));  // Agrega otro enemigo en la posición (300, 300)
        //temporizador para que actualice el juego cada 10 milisegundos
        timer = new Timer(10, this);
        timer.start();
    }
    // Sobrescribe el método paintComponent para dibujar el escenario
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Limpia el panel antes de dibujar
        player.draw(g);  // Dibuja al jugador en la pantalla

        // Dibuja a todos los enemigos
        for (enemigo e : enemigos) {
            e.draw(g);
        }
    }
    //Sobrescribe el método actionPerformed para actualizar el juego en cada "tic" del temporizador
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();  // Actualiza la posición del jugador

        // Actualiza la posición de todos los enemigos
        for (enemigo enemy : enemigos) {
            enemy.update();
        }

        repaint();  // Redibuja la pantalla
    }
    //Sobrescribe el método keyPressed para manejar eventos de teclas presionadas
    //es decir, para controlar los movimientos del jugador segun las teclas presionadas
    @Override
    public void keyPressed(KeyEvent e) {
        //Obtiene el código de la tecla presionada
        int key = e.getKeyCode();
        //Mueve al jugador según la tecla presionada
        if (key == KeyEvent.VK_LEFT) {
            player.setDx(-1); //izquierda
        } else if (key == KeyEvent.VK_RIGHT) {
            player.setDx(1); //derecha
        } else if (key == KeyEvent.VK_UP) {
            player.setDy(-1); //arriba
        } else if (key == KeyEvent.VK_DOWN) {
            player.setDy(1);    //abajo 
        }
    }
    //Sobrescribe el método keyReleased para manejar eventos de teclas soltadas
    @Override
    public void keyReleased(KeyEvent e) {
         //Detiene el movimiento horizontal o vertical del jugador cuando se suelta la tecla
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player.setDx(0);    //detener movimiento horizontal
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            player.setDy(0);    //detener movimiento vertical
        }
    }
    //Sobrescribe el método keyTyped (obligatorio pero no se utiliza en este caso)
    @Override
    public void keyTyped(KeyEvent e) {}
}
