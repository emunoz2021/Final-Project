
package zoosimulator;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSiguiente extends JPanel{
    private JButton BotonHabitat,BotonAnimal,BotonComida,BotonExit;
    ImageIcon Juego;
    
    PanelSiguiente(){
        Juego = new ImageIcon("prueba3.jpg");
        setLayout(null);
        CargaBotones();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Juego.getImage(), 160, 0, this.getWidth(), this.getHeight(), this);
    }


    private void CargaBotones(){
        BotonHabitat=new JButton("Habitat");
        BotonHabitat.setBounds(0,0,170,153);
        this.add(BotonHabitat);

        BotonAnimal=new JButton("Animales");
        BotonAnimal.setBounds(0,153,170,153);
        this.add(BotonAnimal);

        BotonComida=new JButton("Comida");
        BotonComida.setBounds(0,306,170,153);
        this.add(BotonComida);

        BotonExit=new JButton("Exit");
        BotonExit.setBounds(0,459,170,153);
        this.add(BotonExit);
        
    }
}