package zoosimulator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class BotonJirafa extends BotonAnimal {
    private int numJirafas = 0;
    
    public BotonJirafa(JPanel panelPrincipal) {
        super(panelPrincipal, "Jirafa", "jirafaPerfil.jpg");
    }

    @Override
    protected void cargarAnimal() {
        /*ImageIcon image=new ImageIcon("jirafa.jpg");
        for(int i=-1; i < numJirafas;i++) {
            if(i==4) break;
            JLabel Jirafa = new JLabel(image);
            add(Jirafa);
        }*/
        numJirafas++;
        repaint();
    }
}