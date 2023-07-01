package zoosimulator;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BotonAnimal extends JButton {
    protected JPanel panelPrincipal;
    protected ImageIcon imagen;
    
    public BotonAnimal(JPanel panelPrincipal, String nombre, String imagenPerfil) {
        super(nombre);
        this.panelPrincipal = panelPrincipal;
        setOpaque(true);
        setBackground(Color.WHITE);
        this.imagen = new ImageIcon(imagenPerfil);
        int imageWidth = 100;  // cambiar a lo que desees
        int imageHeight = 100;  // cambiar a lo que desees
        setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        addMouseListener(createMouseListener());
    }

    protected abstract void cargarAnimal();

    protected MouseListener createMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                doClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("se apreto");
                panelPrincipal.remove(BotonAnimal.this);
                cargarAnimal();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }
}
