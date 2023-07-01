package zoosimulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelsubPrincipal extends JPanel {

    private JButton BotonHabitat, BotonAnimal, BotonComida, BotonExit;
    
    BotonGorilla botonGorilla;
    BotonJirafa botonJirafa;
    BotonLeon botonLeon;
    BotonCocodrilo botonCocodrilo;
    
    public int num1 = 0, num2 = 0;
    ImageIcon path;
    JFrame ventanita;
    JPanel panelExtra;  // Nuevo panel que contiene los 4 botones

    public PanelsubPrincipal(JFrame vent1) {
        ventanita = vent1;
        setLayout(null);
        Entorno();
        CargaBotones();
        CargaPanelExtra();  // Método para cargar el nuevo panel
    }

    private void Entorno() {
        path = new ImageIcon("path.jpg");
        JLabel camino = new JLabel(path);
        camino.setBounds(173, 0, 609, 630);
        add(camino, 0);
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

    private void CargaPanelExtra() {
        panelExtra = new JPanel(new GridLayout(2, 2));
        
        botonGorilla = new BotonGorilla(this);
        botonJirafa = new BotonJirafa(this);
        botonLeon = new BotonLeon(this);
        botonCocodrilo = new BotonCocodrilo(this);
        panelExtra.add(botonGorilla);
        panelExtra.add(botonJirafa);
        panelExtra.add(botonLeon);
        panelExtra.add(botonCocodrilo);

        oyenteDeCargaExtra();
    }

    private void OyentesMouse() {
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
                // Agrega el panel extra al hacer clic en BotonAnimal
                panelExtra.setBounds(BotonAnimal.getX() +175 , BotonAnimal.getY(), 200, 200);////BotonAnimal.getWidth()
                ventanita.getLayeredPane().add(panelExtra, JLayeredPane.POPUP_LAYER);
                ventanita.revalidate();
                ventanita.repaint();
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
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Cerrar App");
                ventanita.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        BotonExit.addMouseListener(MouseExit);
    }
    
    private void oyenteDeCargaExtra(){
        oyenteBotonGorilla();
        oyenteBotonJirafa();
        oyenteBotonLeon();
        oyenteBotonCocodrilo();
    }
    
    private void oyenteBotonGorilla(){
        MouseListener listenerGorilla = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonGorilla.doClick();

                // Quitar el panel extra al hacer clic en cualquier botón
                ventanita.getLayeredPane().remove(panelExtra);
                ventanita.revalidate();
                ventanita.repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
        botonGorilla.addMouseListener(listenerGorilla);
    }
    
    private void oyenteBotonJirafa(){
        MouseListener listenerJirafa= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonJirafa.doClick();

                // Quitar el panel extra al hacer clic en cualquier botón
                ventanita.getLayeredPane().remove(panelExtra);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonJirafa.addMouseListener(listenerJirafa);
    }
    
    private void oyenteBotonLeon(){
        MouseListener listenerLeon = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonLeon.doClick();
                ventanita.getLayeredPane().remove(panelExtra);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonLeon.addMouseListener(listenerLeon);
    }
    
    private void oyenteBotonCocodrilo(){
        MouseListener listenerCocodrilo = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCocodrilo.doClick();
                ventanita.getLayeredPane().remove(panelExtra);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        botonCocodrilo.addMouseListener(listenerCocodrilo);
    }
}

