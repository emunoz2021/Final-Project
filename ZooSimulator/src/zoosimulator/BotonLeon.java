package zoosimulator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BotonLeon extends BotonAnimal {
    private int numLeones = 0;
    
    public BotonLeon(JPanel panelPrincipal) {
        super(panelPrincipal, "Leon", "leonPerfil.jpg");
    }

    @Override
    protected void cargarAnimal() {
        ImageIcon image=new ImageIcon("leon.jpg");
        for(int i=-1;i< numLeones;i++) {
            if(i==4) break;
            JLabel Gorilla = new JLabel(image);
            add(Gorilla);
        }
        numLeones++;
        repaint();
    }
}