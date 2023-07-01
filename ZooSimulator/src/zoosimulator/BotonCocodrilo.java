package zoosimulator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BotonCocodrilo extends BotonAnimal {
    private int numCocodrilos = 0;
    
    public BotonCocodrilo(JPanel panelPrincipal) {
        super(panelPrincipal, "Cocodrilo", "cocodriloPerfil.jpg");
    }

    @Override
    protected void cargarAnimal() {
        ImageIcon image=new ImageIcon("cocodrilo.jpg");
        for(int i=-1;i< numCocodrilos;i++) {
            if(i==4) break;
            JLabel Gorilla = new JLabel(image);
            add(Gorilla);
        }
        numCocodrilos++;
        repaint();
    }
}