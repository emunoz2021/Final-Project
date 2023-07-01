package zoosimulator;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class PanelsubPrincipal extends JPanel {
    private JButton BotonHabitat, BotonAnimal, BotonComida, BotonExit;
    JFrame ventanita;
    private Image fondo;
    private Jaula1 panel1;
    private Jaula2 panel2;
    private Jaula3 panel3;
    private Jaula4 panel4;

    public PanelsubPrincipal(JFrame vent1) {
        ventanita = vent1;
        setLayout(null);
        this.fondo = new ImageIcon("path.jpg").getImage(); 
        
        panel1 = new Jaula1();
        panel1.setBounds(175, 5, 218, 220);


        panel2 = new Jaula2();
        panel2.setBounds(551, 5, 229, 215);

        panel3 = new Jaula3();
        panel3.setBounds(175, 381, 219, 226);

        panel4 = new Jaula4();
        panel4.setBounds(551, 378, 229, 230);


        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        CargaBotones();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private void CargaBotones() {
        BotonHabitat = new JButton();
        BotonHabitat.setBounds(0, 0, 170, 153);
        BotonHabitat.setOpaque(true);
        ImageIcon Hab = new ImageIcon("Habitat.jpg");
        BotonHabitat.setIcon(new ImageIcon(Hab.getImage().getScaledInstance(BotonHabitat.getWidth(), BotonHabitat.getHeight(), Image.SCALE_SMOOTH)));
        this.add(BotonHabitat, 0);

        BotonAnimal = new JButton();
        BotonAnimal.setBounds(0, 154, 170, 153);
        BotonAnimal.setOpaque(true);
        ImageIcon Anim = new ImageIcon("Animales.jpg");
        BotonAnimal.setIcon(new ImageIcon(Anim.getImage().getScaledInstance(BotonAnimal.getWidth(), BotonAnimal.getHeight(), Image.SCALE_SMOOTH)));
        this.add(BotonAnimal, 0);

        BotonComida = new JButton("Comida");
        BotonComida.setBounds(0, 308, 170, 153);
        BotonComida.setOpaque(true);
        BotonComida.setBackground(Color.DARK_GRAY);
        ImageIcon Com = new ImageIcon("Comida.jpg");
        BotonComida.setIcon(new ImageIcon(Com.getImage().getScaledInstance(BotonComida.getWidth(), BotonComida.getHeight(), Image.SCALE_SMOOTH)));
        this.add(BotonComida, 0);

        BotonExit = new JButton("Exit");
        BotonExit.setBounds(0, 462, 170, 153);
        BotonExit.setOpaque(true);
        BotonExit.setBackground(Color.DARK_GRAY);
        ImageIcon Ex = new ImageIcon("Exit2.jpg");
        BotonExit.setIcon(new ImageIcon(Ex.getImage().getScaledInstance(BotonExit.getWidth(), BotonExit.getHeight(), Image.SCALE_SMOOTH)));
        this.add(BotonExit, 0);

        OyentesMouse();
    }

    public JFrame getVentanita() {
        return this.ventanita;
    }

    private void OyentesMouse() {
        OyenteAnimales();
        OyenteHabitat();
        oyenteExit();
    }

    @SuppressWarnings("deprecation")
    private void OyenteAnimales() {
        MouseListener MouseAnimal = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                PanelDraggedAnimal panelAnimal=new PanelDraggedAnimal(panel1,panel2,panel3,panel4);
                panelAnimal.setBounds(0, 0, getWidth(), getHeight());
                ventanita.getLayeredPane().add(panelAnimal,new Integer(7));

                PanelBotonesAnimales panelExtraAnimales = new PanelBotonesAnimales(PanelsubPrincipal.this,panelAnimal);
                panelExtraAnimales.setBounds(BotonAnimal.getX() + 175, BotonAnimal.getY(), 200, 200);
                ventanita.getLayeredPane().add(panelExtraAnimales, new Integer(3));

                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
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

    @SuppressWarnings("deprecation")
    private void OyenteHabitat(){
        MouseListener MouseHabitat= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("habitat");
                PanelDraggedHabitats sub1=new PanelDraggedHabitats(panel1,panel2,panel3,panel4);
                sub1.setBounds(0, 0, getWidth(), getHeight());
                ventanita.getLayeredPane().add(sub1, new Integer(2));
                revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        BotonHabitat.addMouseListener(MouseHabitat);
    }
}
