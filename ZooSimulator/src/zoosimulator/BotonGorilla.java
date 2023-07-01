package zoosimulator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class BotonGorilla extends BotonAnimal {
    private int numGorillas = 0;
    
    public BotonGorilla(JPanel panelPrincipal) {
        super(panelPrincipal, "Gorilla", "gorillaPerfil.jpg");
    }

    @Override
    protected void cargarAnimal() {
        ImageIcon image=new ImageIcon("gorilla.jpg");
        for(int i=-1;i< numGorillas;i++) {
            if(i==4) break;
            JLabel Gorilla = new JLabel(image);
            add(Gorilla);
        }
        numGorillas++;
        repaint();
    }
}