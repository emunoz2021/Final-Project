
package zoosimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelsubPrincipal extends JPanel{
    private JButton BotonHabitat,BotonAnimal,BotonComida,BotonExit;
    public int num1=0,num2=0;
    ImageIcon path;
    JFrame ventanita;
            
    public PanelsubPrincipal(JFrame vent1){
        ventanita= vent1;
        setLayout(null);
        Entorno();
        CargaBotones();
    }
    private void Entorno(){
        path = new ImageIcon("path.jpg");
        JLabel camino=new JLabel(path);
        camino.setBounds(173,0,609,630);
        add(camino,0);
    }
    
   
    private void CargaBotones(){
            BotonHabitat = new JButton();
            BotonHabitat.setBounds(0,0,170,153);
            BotonHabitat.setOpaque(true);
            ImageIcon Hab = new ImageIcon("Habitat.jpg");
            BotonHabitat.setIcon(new ImageIcon(Hab.getImage().getScaledInstance(BotonHabitat.getWidth(), BotonHabitat.getHeight(), Image.SCALE_SMOOTH)));
            this.add(BotonHabitat,0);
            
            BotonAnimal = new JButton();
            BotonAnimal.setBounds(0,154,170,153);
            BotonAnimal.setOpaque(true);
            ImageIcon Anim = new ImageIcon("Animales.jpg");
            BotonAnimal.setIcon(new ImageIcon(Anim.getImage().getScaledInstance(BotonAnimal.getWidth(), BotonAnimal.getHeight(), Image.SCALE_SMOOTH)));
            this.add(BotonAnimal,0);
                 
            BotonComida=new JButton("Comida");
            BotonComida.setBounds(0,308,170,153);
            BotonComida.setOpaque(true);
            BotonComida.setBackground(Color.DARK_GRAY);
            ImageIcon Com = new ImageIcon("Comida.jpg");
            BotonComida.setIcon(new ImageIcon(Com.getImage().getScaledInstance(BotonComida.getWidth(), BotonComida.getHeight(), Image.SCALE_SMOOTH)));
            this.add(BotonComida,0);

            BotonExit=new JButton("Exit");
            BotonExit.setBounds(0,462,170,153);
            BotonExit.setOpaque(true);
            BotonExit.setBackground(Color.DARK_GRAY);
            ImageIcon Ex = new ImageIcon("Exit2.jpg");
            BotonExit.setIcon(new ImageIcon(Ex.getImage().getScaledInstance(BotonExit.getWidth(), BotonExit.getHeight(), Image.SCALE_SMOOTH)));
            this.add(BotonExit,0);

            OyentesMouse();
    }
    private void OyentesMouse(){
        OyenteAnimales();
        oyenteExit();
    }
    private void OyenteAnimales() {
        MouseListener MouseAnimal = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                subBotonesAnimal sub = new subBotonesAnimal(PanelsubPrincipal.this);
                sub.setBounds(0, 0, getWidth(), getHeight());
                add(sub,1);
                revalidate();
                System.out.println("se apreta");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        BotonAnimal.addMouseListener(MouseAnimal);
    }
    private void oyenteExit() {
        MouseListener MouseExit = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Cerrar App");
                ventanita.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        BotonExit.addMouseListener(MouseExit);
    }
}