package zoosimulator;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

public class PanelsubPrincipal extends JPanel {
    private JButton BotonHabitat, BotonAnimal, BotonComida, BotonExit;
    public int num1 = 0, num2 = 0;
    ImageIcon path;
    JFrame ventanita;
    private Image fondo;

    private JPanel panel1, panel2, panel3, panel4; //Paneles que usaremos para colocar los habitats

    public PanelsubPrincipal(JFrame vent1) {
        ventanita = vent1;
        setLayout(null);
        this.fondo = new ImageIcon("path.jpg").getImage(); 
        
        panel1 = new JPanel();
        panel1.setBounds(175, 5, 218, 226);
        configuraPanel(panel1);

        panel2 = new JPanel();
        panel2.setBounds(551, 5, 229, 215);
        configuraPanel(panel2);

        panel3 = new JPanel();
        panel3.setBounds(175, 381, 219, 226);
        configuraPanel(panel3);

        panel4 = new JPanel();
        panel4.setBounds(551, 378, 229, 230);
        configuraPanel(panel4);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        CargaBotones();
    }

    private void configuraPanel(JPanel panel) {
        panel.setOpaque(true);  // Panel opaco
        panel.setBackground(Color.BLACK);  // Fondo negro
        panel.setLayout(null);  // Sin layout
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

    private void OyenteAnimales() {
        MouseListener MouseAnimal = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                PanelExtraAnimales panelExtraAnimales = new PanelExtraAnimales(PanelsubPrincipal.this);
                panelExtraAnimales.setBounds(BotonAnimal.getX() + 175, BotonAnimal.getY(), 200, 200);
                ventanita.getLayeredPane().add(panelExtraAnimales, JLayeredPane.POPUP_LAYER);
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
                subPanelHabitats sub1=new subPanelHabitats();
                sub1.setBounds(0, 0, getWidth(), getHeight());
                add(sub1,0);
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
