package zoosimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/*
* Clase que es el Panel donde se encontraran los animales
* @field Gorillas, Jirafas, arraylist que almacena los animales que se agregan a la Jaula
* @field imagen, representacion del objeto
* @field coordenadasx, coordenadasy, coordenadas que pasa el PanelDraggedAnimal
* @field dx, dy, coordenadas que varian en el tiempo
* @field rand, lo usamos para obtener valores de coordenadas aleatorias
*/
public class Jaula4 extends JLayeredPane {
    private ArrayList<Gorila> Gorilas;
    private ArrayList<Jirafa> Jirafas;
    private ImageIcon imagen;
    private int dx,dy;
    public int coordenadasx, coordenadasy;
    private Random rand = new Random();
    
    /*
    * Metodo constructor que inicializa los arraylist()
    */
    public Jaula4() {
        Gorilas = new ArrayList<>();
        Jirafas = new ArrayList<>();
        setLayout(null);
    }
    
    /*
    * Metodo que añade al animal a la Jaula y le da el movimiento
    */
    public void AñadirAnimal(int i) {
        if (i== 1 && Jirafas.isEmpty()) {
            Gorilas.add(new Gorila());
            imagen = Gorilas.get(Gorilas.size() - 1).getImagen();
            JLabel gorila = new JLabel(imagen);
            gorila.setBounds(coordenadasx, coordenadasy, imagen.getIconWidth(), imagen.getIconHeight());
            add(gorila, new Integer(1));

            dx = rand.nextInt(5) - 2; // -2 a 2
            dy = rand.nextInt(5) - 2;

            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (gorila.getX() + dx < 0 || gorila.getX() + gorila.getWidth() + dx > getWidth()) {
                        dx = -dx;
                    }
                    if (gorila.getY() + dy < 0 || gorila.getY() + gorila.getHeight() + dy > getHeight()) {
                        dy = -dy;
                    }
                    gorila.setLocation(gorila.getX() + dx, gorila.getY() + dy);
                }
            });
            timer.start();
        }
        else if(i==2 && Gorilas.isEmpty()){
            Jirafas.add(new Jirafa());
            imagen = Jirafas.get(Jirafas.size() - 1).getImagen();
            JLabel jirafa = new JLabel(imagen);
            jirafa.setBounds(coordenadasx, coordenadasy, imagen.getIconWidth(), imagen.getIconHeight());
            add(jirafa, new Integer(1));

            dx = rand.nextInt(5) - 2; // -2 a 2
            dy = rand.nextInt(5) - 2;

            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (jirafa.getX() + dx < 0 || jirafa.getX() + jirafa.getWidth() + dx > getWidth()) {
                        dx = -dx;
                    }
                    if (jirafa.getY() + dy < 0 || jirafa.getY() + jirafa.getHeight() + dy > getHeight()) {
                        dy = -dy;
                    }
                    jirafa.setLocation(jirafa.getX() + dx, jirafa.getY() + dy);
                }
            });
            timer.start();
        }
    }

    /*
    * Metodo que carga el Habitat y lo pone en una capa del JLayeredPane
    */

    @SuppressWarnings("deprecation")
    public void cargarHabitat(int num) {
        if (num == 1) {
            JLabel label = new JLabel(new ImageIcon("jungle.jpg"));
            label.setBounds(0, 0, this.getWidth(), this.getHeight());
            add(label, new Integer(0));
            repaint();
            revalidate();
        }
        else if (num == 2) {
            JLabel label = new JLabel(new ImageIcon("desert.jpg"));
            label.setBounds(0, 0, this.getWidth(), this.getHeight());
            add(label, new Integer(0));
            repaint();
            revalidate();
        }
    }
}
