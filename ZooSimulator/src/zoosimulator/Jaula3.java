package zoosimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Jaula3 extends JLayeredPane {
    private ArrayList<Gorila> Gorilas;
    private ImageIcon imagen;
    private int dx,dy;
    public int coordenadasx, coordenadasy;
    private Random rand = new Random();

    public Jaula3() {
        Gorilas = new ArrayList<>();
        setLayout(null);
    }
    public void AñadirAnimal() {
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
