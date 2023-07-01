package zoosimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBotonesAnimales extends JPanel {
    BotonGorilla botonGorilla;
    BotonJirafa botonJirafa;
    BotonLeon botonLeon;
    BotonCocodrilo botonCocodrilo;
    
    private JFrame ventanita;
    private PanelsubPrincipal panelSubPrincipal;
    private PanelDraggedAnimal panelon;
    public PanelBotonesAnimales(PanelsubPrincipal panelSubPrincipal,PanelDraggedAnimal panel) {
        this.panelSubPrincipal = panelSubPrincipal;
        this.panelon=panel;
        this.ventanita = panelSubPrincipal.getVentanita();
        setLayout(new GridLayout(2, 2));
        botonGorilla = new BotonGorilla(panelSubPrincipal);
        botonJirafa = new BotonJirafa(panelSubPrincipal);
        botonLeon = new BotonLeon(panelSubPrincipal);
        botonCocodrilo = new BotonCocodrilo(panelSubPrincipal);
        add(botonGorilla);
        add(botonJirafa);
        add(botonLeon);
        add(botonCocodrilo);

        oyenteDeCargaExtra();
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
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenGori();
                panelon.repaint();
                panelon.revalidate();
            }
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
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
                ventanita.revalidate();
                ventanita.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                panelon.cargarImagenJira();
                panelon.repaint();
                panelon.revalidate();}

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
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
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
                ventanita.getLayeredPane().remove(PanelBotonesAnimales.this);
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